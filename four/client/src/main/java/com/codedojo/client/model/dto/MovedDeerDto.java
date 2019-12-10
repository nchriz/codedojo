package com.codedojo.client.model.dto;

import com.codedojo.client.model.Moved;
import lombok.Data;

@Data
public class MovedDeerDto {

    private Moved moved;
    private int x;
    private int y;

    public MovedDeerDto(Moved moved, int x, int y) {
        this.moved = moved;
        this.x = x;
        this.y = y;
    }

}
