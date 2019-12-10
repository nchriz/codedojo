package com.codedojo.four.model;

import java.awt.*;

public interface Environment {

    void draw(Graphics graphics);

    boolean withinX(int x);

    boolean withinY(int y);
}
