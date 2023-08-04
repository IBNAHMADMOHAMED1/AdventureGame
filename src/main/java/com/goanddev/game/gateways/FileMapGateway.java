package com.goanddev.game.gateways;

import com.goanddev.game.Entity.GameMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMapGateway implements MapGateway {
    private final String filePath;
    private GameMap map;

    public FileMapGateway(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public GameMap loadMap() {
        if (map == null) {
            map = loadMapFromFile();
        }
        return map;
    }
    private char[][] parseMapData(List<String> lines) {
        int numRows = lines.size();
        int numCols = lines.get(0).length();
        char[][] mapData = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            mapData[i] = lines.get(i).toCharArray();
        }

        return mapData;
    }
    @Override
    public boolean isAccessible(int x, int y) {
        GameMap loadedMap = loadMap();
        return loadedMap.isAccessible(x, y);
    }
    private GameMap loadMapFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = readLines(reader);
            char[][] mapData = parseMapData(lines);
            return new GameMap(mapData);
        } catch (IOException e) {
            throw new RuntimeException("Error from file: " + e.getMessage());
        }
    }
    private List<String> readLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

}
