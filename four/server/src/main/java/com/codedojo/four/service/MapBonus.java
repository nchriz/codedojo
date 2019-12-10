package com.codedojo.four.service;

import com.codedojo.four.model.Blindeer;
import com.codedojo.four.model.Line;
import com.codedojo.four.model.Move;
import com.codedojo.four.model.Obstacle;
import com.codedojo.four.model.WidthLine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapBonus implements MapLevel {

    private List<Obstacle> obstacleList = new ArrayList<>();

    private static int width = 1;
    private static int height = 50;

    private static int randomHeight = 20;
    private static int randomWidth = 25;

    public MapBonus(Graphics graphics) {
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            int r = random.nextInt(randomHeight);
            obstacleList.add(new Line(100*i,r, height));
            r = random.nextInt(randomHeight);
            obstacleList.add(new Line(100*i,r, height));
            r = random.nextInt(randomHeight);
            obstacleList.add(new Line(100*i,r, height));
            r = random.nextInt(randomHeight);
            obstacleList.add(new Line(100*i,r, height));
        }
        for (int i = 1; i < 6; i++) {
            int r = random.nextInt(randomWidth);
            obstacleList.add(new WidthLine(10*r,i*100, width));
            r = random.nextInt(randomWidth);
            obstacleList.add(new WidthLine(20*r,i*100, width));
            r = random.nextInt(randomWidth);
            obstacleList.add(new WidthLine(30*r,i*100, width));
            r = random.nextInt(randomWidth);
            obstacleList.add(new WidthLine(40*r,i*100, width));
//            r = random.nextInt(randomWidth);
//            obstacleList.add(new WidthLine(100*r,i*50*5, width));
//            r = random.nextInt(randomWidth);
//            obstacleList.add(new WidthLine(100*r,i*50*6, width));
        }

        for (Obstacle o : obstacleList)
            o.draw(graphics, Color.BLACK);
    }

    @Override
    public boolean collision(Blindeer blindeer, Move move) {
        return false;
    }

    @Override
    public int environment(Blindeer blindeer, Move move) {
        return 0;
    }
}
