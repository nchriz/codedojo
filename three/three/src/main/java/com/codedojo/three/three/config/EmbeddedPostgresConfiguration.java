package com.codedojo.three.three.config;

import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ru.yandex.qatools.embed.postgresql.PostgresProcess;
import ru.yandex.qatools.embed.postgresql.PostgresStarter;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

@Configuration
public class EmbeddedPostgresConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedPostgresConfiguration.class);

    private static final String DB_NAME = "payments";

    private static final String DB_ADMIN_USERNAME = "postgres";

    private static final String DB_ADMIN_PASSWORD = "postgres";

    private static final Version POSTGRES_VERSION = Version.V9_6_8;

    @Value("${spring.application.name}")
    private String serviceName;

    /**
     * process for running embedded postgres.
     * @return postgres process
     * @throws IOException exception
     */
    @Bean(destroyMethod = "stop")
    public PostgresProcess postgresProcess() throws IOException {

        PostgresConfig postgresConfig = new PostgresConfig(POSTGRES_VERSION,
                                                           new AbstractPostgresConfig.Net("localhost",5444),
                                                           new AbstractPostgresConfig.Storage(DB_NAME),
                                                           new AbstractPostgresConfig.Timeout(),
                                                           new AbstractPostgresConfig.Credentials(DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD));

        return PostgresStarter.getDefaultInstance().prepare(postgresConfig).start();
    }

    /**
     * data source for embedded postgres.
     * @param postgresProcess postgres process
     * @return data source
     */
    @Bean(destroyMethod = "close")
    @DependsOn("postgresProcess")
    public DataSource dataSource(PostgresProcess postgresProcess) {
        LOGGER.info("Creating Embedded Postgres");
        PGPoolingDataSource dataSource = new PGPoolingDataSource();

        PostgresConfig postgresConfig = postgresProcess.getConfig();

        dataSource.setUser(postgresConfig.credentials().username());
        dataSource.setPassword(postgresConfig.credentials().password());
        dataSource.setPortNumber(postgresConfig.net().port());
        dataSource.setServerName(postgresConfig.net().host());
        dataSource.setDatabaseName(postgresConfig.storage().dbName());

        final String findUserSql = String.format("SELECT FROM pg_catalog.pg_user WHERE usename = '%s'", serviceName);
        try (Connection connection = dataSource.getConnection();
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(findUserSql)) {
            if (!resultSet.next()) {
                statement.execute("CREATE USER " + serviceName + " WITH SUPERUSER PASSWORD 'test'");
                statement.execute("CREATE SCHEMA " + serviceName + " AUTHORIZATION " + serviceName + "");
                statement.execute("CREATE ROLE analytics;");
            } else {
                statement.execute("ALTER USER " + serviceName + " WITH SUPERUSER");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception setting up Embedded db: {}", e);
        }

        dataSource = new PGPoolingDataSource();
        dataSource.setUser(serviceName);
        dataSource.setPassword("test");
        dataSource.setPortNumber(postgresConfig.net().port());
        dataSource.setServerName(postgresConfig.net().host());
        dataSource.setDatabaseName(postgresConfig.storage().dbName());
        return dataSource;
    }

}
