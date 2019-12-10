package com.codedojo.four.service;

import com.codedojo.four.model.Blindeer;
import com.codedojo.four.model.Environment;
import com.codedojo.four.model.Ice;
import com.codedojo.four.model.Line;
import com.codedojo.four.model.Move;
import com.codedojo.four.model.Obstacle;
import com.codedojo.four.model.WidthLine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapThree implements MapLevel {

    private List<Obstacle> obstacleList = new ArrayList<>();
    private List<Environment> environmentList = new ArrayList<>();

    public MapThree(Graphics graphics) {
        Obstacle firstOb = new WidthLine(50, 50, 1150);
        obstacleList.add(firstOb);
        Obstacle secondOb = new WidthLine(50, 550, 1150);
        obstacleList.add(secondOb);

        Obstacle firstLine = new Line(175, 50, 450);
        obstacleList.add(firstLine);
        Obstacle secondLine = new Line(175, 500, 550);
        obstacleList.add(secondLine);

        Obstacle line3 = new Line(450, 50, 260);
        obstacleList.add(line3);
        Obstacle line4 = new Line(450, 300, 550);
        obstacleList.add(line4);

        Obstacle line5 = new Line(725, 50, 100);
        obstacleList.add(line5);
        Obstacle line6 = new Line(725, 130, 550);
        obstacleList.add(line6);

        Obstacle line7 = new Line(950, 50, 475);
        obstacleList.add(line7);
        Obstacle line8 = new Line(950, 500, 550);
        obstacleList.add(line8);

        for (Obstacle o : obstacleList)
            o.draw(graphics, Color.black);

        Environment firstEnv = new Ice(176, 51, 273, 498);
        environmentList.add(firstEnv);
        Environment secondEnv = new Ice(451, 51, 273, 498);
        environmentList.add(secondEnv);
        Environment thirdEnv = new Ice(726, 51, 223, 498);
        environmentList.add(thirdEnv);
        Environment fourthEnv = new Ice(951, 51, 200, 498);
        environmentList.add(fourthEnv);
        for (Environment o : environmentList)
            o.draw(graphics);
    }

    @Override
    public boolean collision(Blindeer blindeer, Move move) {
        return obstacleList.stream()
                           .anyMatch(obstacle -> obstacle.withinX(blindeer.getX() + move.getX()) && obstacle.withinY(blindeer.getY() + move.getY()));
    }

    @Override
    public int environment(Blindeer blindeer, Move move) {
        if (environmentList.stream()
                           .anyMatch(environment -> environment.withinX(blindeer.getX() + move.getX()) && environment.withinY(blindeer.getY() + move.getY())))
            return 2;
        return 1;
    }
}
