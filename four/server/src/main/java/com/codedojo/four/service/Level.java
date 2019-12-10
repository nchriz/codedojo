package com.codedojo.four.service;

import com.codedojo.four.model.Blindeer;
import com.codedojo.four.model.Move;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class Level {

    private MapLevel mapLevel;

    public boolean move(Blindeer blindeer, Move move) {
        if (mapLevel.collision(blindeer, move))
            return false;
        blindeer.move(move, mapLevel.environment(blindeer, move));
        return true;
    }

    public void drawOne(Graphics graphics) {
        mapLevel = new MapOne(graphics);
    }

    public void drawTwo(Graphics graphics) {
        mapLevel = new MapTwo(graphics);
    }

    public void drawThree(Graphics graphics) {
        mapLevel = new MapThree(graphics);
    }

    public void drawBonus(Graphics graphics) {
        mapLevel = new MapBonus(graphics);
    }
}
