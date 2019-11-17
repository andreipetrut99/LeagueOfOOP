package com.oop_upb.players;

public class Player {
    private int row;
    private int column;
    private String type;

    public Player() {
        row = -1;
        column = -1;
        type = null;
    }

    public Player(String t, int r, int c) {
        row = r;
        column = c;
        type = t;
    }

    @Override
    public String toString() {
        return type + " " + row + " " + column;
    }
}
