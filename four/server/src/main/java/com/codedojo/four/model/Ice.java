package com.codedojo.four.model;

import lombok.Data;

import java.awt.*;

@Data
public class Ice implements Environment {

    private int x;
    private int y;
    private int width;
    private int height;

    public Ice(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(x, y, width, height);
    }

    @Override
    public boolean withinX(int x) {
        return x > this.x && x < (this.x + width);
    }

    @Override
    public boolean withinY(int y) {
        return y > this.y && y < (this.y + height);
    }
}
