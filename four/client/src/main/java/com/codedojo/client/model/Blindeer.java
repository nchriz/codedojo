package com.codedojo.client.model;

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

    public Blindeer(UUID id, Color color, int x, int y, int throttling) {
        this.id = id;
        this.color = color;
        this.x = x;
        this.y = y;
        this.oldX = 50;
        this.oldY = y;
    }
}
