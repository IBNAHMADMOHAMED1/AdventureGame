package com.goanddev.game.Entity;

public class GameMap {
    private final char[][] mapData;

    public GameMap(char[][] mapData) {
        this.mapData = mapData;
    }

    public boolean isAccessible(int x, int y) {
        if (x < 0 || y < 0 || x >= mapData[0].length || y >= mapData.length) {
            return false;
        }
        return true;
    }
}
