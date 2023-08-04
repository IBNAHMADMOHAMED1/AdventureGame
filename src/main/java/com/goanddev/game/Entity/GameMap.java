package com.goanddev.game.Entity;

public class GameMap {
    private final char[][] mapData;

    public GameMap(char[][] mapData) {
        this.mapData = mapData;
    }

    public boolean isAccessible(int x, int y) {
        System.out.println("x: " + x + " y: " + y + " mapData.length: " + mapData.length + " mapData[0].length: " + mapData[0].length);

        if (x < 0 || y < 0 || x >= mapData.length || y >= mapData[0].length) {
            System.out.println("false");
            return false; // Outside of map bounds
        }
        return true;
    }
}
