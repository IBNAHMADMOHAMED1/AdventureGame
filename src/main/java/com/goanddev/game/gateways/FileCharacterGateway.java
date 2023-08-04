package com.goanddev.game.gateways;

import com.goanddev.game.Entity.GameCharacter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharacterGateway implements CharacterGateway{
    private final String filePath;

    public FileCharacterGateway(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public GameCharacter loadCharacter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String position = reader.readLine();
            return parseCharacterPosition(position);
        } catch (IOException e) {
            throw new RuntimeException("Error loading character from file: " + e.getMessage());
        }
    }

    @Override
    public void saveCharacter(GameCharacter character) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(character.getPosition() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Error saving character to file: " + e.getMessage());
        }
    }

    private GameCharacter parseCharacterPosition(String position) {
        String[] coordinates = position.split(",");
        int x = Integer.parseInt(coordinates[0].trim());
        int y = Integer.parseInt(coordinates[1].trim());

        // Create and return a Character instance
        return new GameCharacter(x, y, null); // You should pass the map instance here
    }

}
