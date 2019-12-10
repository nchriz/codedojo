package com.codedojo.four.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.awt.*;
import javax.swing.*;

@Service
public class Draw {

    @Autowired
    private Level level;

    private JFrame jFrame;

    @EventListener(ApplicationReadyEvent.class)
    public void createFrame() {
        jFrame = new JFrame();
        jFrame.setTitle("Blindeer race");
        jFrame.setSize(1200, 600);
        jFrame.setVisible(true);
    }

    public void drawMap(String map) {
        Graphics graphics = jFrame.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 1200, 600);
        switch (map) {
            case "1":
                level.drawOne(graphics);
                break;
            case "2":
                level.drawTwo(graphics);
                break;
            case "3":
                level.drawThree(graphics);
                break;
            case "bonus":
                level.drawBonus(graphics);
                break;
            default:
                break;
        }
        graphics.dispose();
    }

    public void move(Color color, int oldX, int oldY, int x, int y) {
        Graphics graphics = jFrame.getGraphics();
        graphics.setColor(color);
        graphics.drawLine(oldX, oldY, x, y);
        graphics.dispose();
    }

    public void clearMap() {
        Graphics graphics = jFrame.getGraphics();
        graphics.clearRect(0, 0, jFrame.getWidth(), jFrame.getHeight());
        graphics.dispose();
    }

}
