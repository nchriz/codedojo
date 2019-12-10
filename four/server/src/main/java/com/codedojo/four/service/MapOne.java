package com.codedojo.four.service;

import com.codedojo.four.model.Blindeer;
import com.codedojo.four.model.Move;
import com.codedojo.four.model.Obstacle;
import com.codedojo.four.model.WidthLine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapOne implements MapLevel {

    private List<Obstacle> obstacleList = new ArrayList<>();

    public MapOne(Graphics graphics) {
        Obstacle firstOb = new WidthLine(50, 50, 1150);
        obstacleList.add(firstOb);
        Obstacle secondOb = new WidthLine(50, 550, 1150);
        obstacleList.add(secondOb);
        for (Obstacle o : obstacleList)
            o.draw(graphics, Color.black);
    }

    @Override
    public boolean collision(Blindeer blindeer, Move move) {
        return obstacleList.stream()
                           .anyMatch(obstacle -> obstacle.withinX(blindeer.getX() + move.getX()) && obstacle.withinY(blindeer.getY() + move.getY()));
    }

    @Override
    public int environment(Blindeer blindeer, Move move) {
        return 1;
    }
}
