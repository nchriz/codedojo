package com.codedojo.four;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication sp = new SpringApplication(ServerApplication.class);
		sp.setHeadless(false);
		sp.run(args);

		log.info("Endpoint for test map: localhost:8080/drawMap");
		log.info("Endpoint for start test race: localhost:8080/startRace");

		System.out.println(Inet4Address.getLocalHost().getHostAddress());
	}

}
