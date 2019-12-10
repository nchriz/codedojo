package com.codedojo.four.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateDeerDto {

    private UUID id;
    private int x;
    private int y;

    public CreateDeerDto(UUID id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

}
