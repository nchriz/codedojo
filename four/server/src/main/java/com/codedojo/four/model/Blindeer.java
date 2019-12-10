package com.codedojo.four.model;

import lombok.Data;

import java.awt.*;
import java.util.UUID;

@Data
public class Blindeer {

    private UUID id;
    private int x;
    private int y;
    private int oldX;
    private int oldY;
    private Color color;
    private int throttling;
    private long time;
    private long startTime;

    public Blindeer(UUID id, Color color, int x, int y, int throttling) {
        this.id = id;
        this.color = color;
        this.x = x;
        this.y = y;
        this.oldX = 50;
        this.oldY = y;
        this.throttling = throttling;
        time = System.currentTimeMillis();
    }

    public boolean move(Move move, int mult) {
        x += move.getX() * mult;
        y += move.getY() * mult;
        return true;
    }

    public boolean canMove() {
        if ((System.currentTimeMillis() - time) < throttling)
            return false;
        time = System.currentTimeMillis();
        oldX = x;
        oldY = y;
        return true;
    }

}
