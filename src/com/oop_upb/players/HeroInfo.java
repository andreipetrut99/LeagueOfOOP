package com.oop_upb.players;

public class HeroInfo {
    private int row;
    private int column;
    private String type;

    public HeroInfo() {
        row = -1;
        column = -1;
        type = null;
    }

    public HeroInfo(String t, int r, int c) {
        row = r;
        column = c;
        type = t;
    }

    @Override
    public String toString() {
        return type + " " + row + " " + column;
    }

    public String getType() {
        return type;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
