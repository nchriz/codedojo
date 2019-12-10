package com.codedojo.client.model;

public enum Moved {

    Success(true),
    Failed(false);

    private final boolean moved;

    Moved(boolean moved) {
        this.moved = moved;
    }

}
