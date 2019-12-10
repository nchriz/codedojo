package com.codedojo.four.model;

import lombok.Data;

import java.awt.*;

@Data
public class Line implements Obstacle {

    private int x;
    private int y;
    private int height;

    public Line(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics, Color color) {
        graphics.setColor(color);
        graphics.drawLine(x, y, x, height);
    }

    @Override
    public boolean withinX(int x) {
        return (this.x - 4) < x && (this.x + 10) > x;
    }

    @Override
    public boolean withinY(int y) {
        return height > y && y > this.y;
    }
}
