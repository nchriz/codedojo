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

public class MapTwo implements MapLevel {

    private List<Obstacle> obstacleList = new ArrayList<>();
    private List<Environment> environmentList = new ArrayList<>();

    public MapTwo(Graphics graphics) {
        Obstacle firstWidth = new WidthLine(50, 50, 1150);
        obstacleList.add(firstWidth);
        Obstacle secondWidth = new WidthLine(50, 550, 1150);
        obstacleList.add(secondWidth);

        Obstacle firstLine = new Line(275, 50, 400);
        obstacleList.add(firstLine);
        Obstacle secondLine = new Line(550, 300, 550);
        obstacleList.add(secondLine);
        Obstacle thirdLine = new Line(825, 50, 400);
        obstacleList.add(thirdLine);
        Obstacle fourthLine = new Line(1050, 300, 550);
        obstacleList.add(fourthLine);
        for (Obstacle o : obstacleList) {
            o.draw(graphics, Color.black);
        }
        Obstacle finishTop = new Line(1100, 0, 48);
        finishTop.draw(graphics, Color.white);
        obstacleList.add(finishTop);
        Obstacle finishDwon = new Line(1100, 552, 600);
        finishDwon.draw(graphics, Color.white);
        obstacleList.add(finishDwon);


        Environment firstEnv = new Ice(175, 50, 100, 350);
        environmentList.add(firstEnv);
        Environment secondEnv = new Ice(450, 300, 100, 250);
        environmentList.add(secondEnv);
        Environment thirdEnv = new Ice(725, 50, 100, 350);
        environmentList.add(thirdEnv);
        Environment fourthEnv = new Ice(950, 300, 100, 250);
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
