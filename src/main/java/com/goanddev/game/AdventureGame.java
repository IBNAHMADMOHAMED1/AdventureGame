package com.goanddev.game;

import com.goanddev.game.Entity.MovementDirection;
import com.goanddev.game.exceptions.InvalidInputException;
import com.goanddev.game.gateways.CharacterGateway;
import com.goanddev.game.gateways.FileCharacterGateway;
import com.goanddev.game.gateways.FileMapGateway;
import com.goanddev.game.gateways.MapGateway;
import com.goanddev.game.usecase.LoadGameUseCase;
import com.goanddev.game.usecase.PlayGameUseCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AdventureGame {
    public static void main(String[] args) {
        MapGateway mapGateway = new FileMapGateway("cart.txt");
        CharacterGateway characterGateway = new FileCharacterGateway("character.txt");

        LoadGameUseCase loadGameUseCase = new LoadGameUseCase(mapGateway, characterGateway);
        PlayGameUseCase playGameUseCase = new PlayGameUseCase(characterGateway);

        try {
            int initialX = 3;
            int initialY = 0;
            loadGameUseCase.execute(initialX, initialY);
            MovementDirection[] directions = readDirectionsFromFile("cart.txt");
            playGameUseCase.execute(directions);

            System.out.println("Final position: " + characterGateway.loadCharacter().getPosition());

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

        private static MovementDirection[] readDirectionsFromFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    break;
                }
            }

            String directions = reader.readLine();
            reader.close();

            return parseDirections(directions);
        } catch (IOException e) {
            throw new RuntimeException("Error reading directions from file: " + e.getMessage());
        }
    }

    private static MovementDirection[] parseDirections(String directions) {
        return Arrays.stream(directions.split(""))
                .map(MovementDirection::valueOf)
                .toArray(MovementDirection[]::new);
    }
}
