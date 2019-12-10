package com.codedojo.four.model;

import java.awt.*;

public interface Obstacle {

    void draw(Graphics graphics, Color color);

    boolean withinX(int x);

    boolean withinY(int y);

}
