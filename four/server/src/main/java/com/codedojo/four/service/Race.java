package com.codedojo.four.service;

import com.codedojo.four.model.Blindeer;
import com.codedojo.four.model.Move;
import com.codedojo.four.model.Moved;
import com.codedojo.four.model.dto.CreateDeerDto;
import com.codedojo.four.model.dto.MovedDeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class Race {

    @Autowired
    private Draw draw;
    @Autowired
    private Level level;

    private int startY = 100;
    private int startX = 70;

    private boolean startRace = false;

    private Map<UUID, Blindeer> blindeerMap = new HashMap<>();

    public void start() {
        startRace = true;
        for (Blindeer blindeer : blindeerMap.values()) {
            blindeer.setStartTime(System.currentTimeMillis());
        }
    }

    public void clear() {
        startRace = false;
        blindeerMap.clear();
    }

    public CreateDeerDto createBlinddeer(String color) throws NoSuchFieldException, IllegalAccessException {
        startY += 4;
        startX -= 4;
        Blindeer blindeer = new Blindeer(UUID.randomUUID(), (Color)Color.class.getField(color).get(null), startX, startY, 30);
        blindeerMap.put(blindeer.getId(), blindeer);
        log.info("Created blindeer {}", blindeer.toString());
        return new CreateDeerDto(blindeer.getId(), blindeer.getX(), blindeer.getY());
    }

    public MovedDeerDto moveBlindeer(UUID id, Move move) {
        if (!startRace)
            return null;
        Blindeer blindeer = blindeerMap.get(id);
        if (!blindeer.canMove())
            return new MovedDeerDto(Moved.Success, blindeer.getX(), blindeer.getY());
        if (!level.move(blindeer, move))
            return new MovedDeerDto(Moved.Failed, blindeer.getX(), blindeer.getY());
        draw.move(blindeer.getColor(), blindeer.getOldX(), blindeer.getOldY(), blindeer.getX(), blindeer.getY());
        isFinish(blindeer);
        return new MovedDeerDto(Moved.Success, blindeer.getX(), blindeer.getY());
    }

    private void isFinish(Blindeer blindeer) {
        if (blindeer.getX() > 1150) {
            log.info("Blindeer {} won. Did it in {} s", blindeer.getId(), (System.currentTimeMillis() - blindeer.getStartTime())/ 1000L);
            blindeerMap.remove(blindeer.getId());
        }
    }

}
