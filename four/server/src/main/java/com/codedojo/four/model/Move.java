package com.codedojo.four.model;

public enum Move {
    Up(0, -2),
    Down(0, 2),
    Left(-2, 0),
    Right(2, 0),
    IceUp(0, 4),
    IceDown(0, -4),
    IceLeft(-4, 0),
    IceRight(4, 0);

    private final int x;
    private final int y;

    Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
