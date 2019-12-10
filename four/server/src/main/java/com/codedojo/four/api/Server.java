package com.codedojo.four.api;

import com.codedojo.four.model.Move;
import com.codedojo.four.model.dto.CreateDeerDto;
import com.codedojo.four.model.dto.MovedDeerDto;
import com.codedojo.four.service.Draw;
import com.codedojo.four.service.Race;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class Server {

    @Autowired
    private Draw draw;
    @Autowired
    private Race race;

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/drawMap/{map}")
    public ResponseEntity drawMap(@PathVariable(value = "id") UUID id, @PathVariable(value = "map") String map) {
        if (!id.equals(UUID.fromString("0ef506e8-5f6b-45ed-a81a-53eab6d7eb6b")))
            return ResponseEntity.badRequest().build();
        draw.drawMap(map);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/clear")
    public ResponseEntity clearMap(@PathVariable(value = "id") UUID id) {
        if (!id.equals(UUID.fromString("0ef506e8-5f6b-45ed-a81a-53eab6d7eb6b")))
            return ResponseEntity.badRequest().build();
        draw.clearMap();
        race.clear();
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/startRace")
    public ResponseEntity startRace(@PathVariable(value = "id") UUID id) {
        if (!id.equals(UUID.fromString("0ef506e8-5f6b-45ed-a81a-53eab6d7eb6b")))
            return ResponseEntity.badRequest().build();
        race.start();
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createBlindeer/{color}")
    public ResponseEntity<CreateDeerDto> createBlindeer(@PathVariable(value = "color") String color)
                    throws NoSuchFieldException, IllegalAccessException {
        CreateDeerDto deerDto = race.createBlinddeer(color);
        return ResponseEntity.ok(deerDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/move/{move}")
    public ResponseEntity<MovedDeerDto> moveRaindeer(@PathVariable(value = "id") UUID id, @PathVariable(value = "move") Move move) {
        log.info("{} moving {}", id, move.name());
        MovedDeerDto movedDeerDto = race.moveBlindeer(id, move);
        if (movedDeerDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(movedDeerDto);
    }


}
