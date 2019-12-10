package com.codedojo.four.model;

import lombok.Data;

import java.awt.*;

@Data
public class WidthLine implements Obstacle {

    private int x;
    private int y;
    private int width;

    public WidthLine(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    @Override
    public void draw(Graphics graphics, Color color) {
        graphics.setColor(color);
        graphics.drawLine(x, y, width, y);
    }

    @Override
    public boolean withinX(int x) {
        return width > x && x > this.x;
    }

    @Override
    public boolean withinY(int y) {
        return (this.y - 4) < y && (this.y + 6) > y;
    }
}
