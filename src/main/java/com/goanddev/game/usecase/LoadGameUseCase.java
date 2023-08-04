package com.goanddev.game.usecase;

import com.goanddev.game.Entity.GameCharacter;
import com.goanddev.game.Entity.GameMap;
import com.goanddev.game.Entity.MovementDirection;
import com.goanddev.game.exceptions.InvalidInputException;
import com.goanddev.game.gateways.CharacterGateway;
import com.goanddev.game.gateways.MapGateway;

public class LoadGameUseCase {


    private final MapGateway mapGateway;
    private final CharacterGateway characterGateway;

    public LoadGameUseCase(MapGateway mapGateway, CharacterGateway characterGateway) {
        this.mapGateway = mapGateway;
        this.characterGateway = characterGateway;
    }

    public void execute(int initialX, int initialY) {
        // Validate input coordinates
        if (!isValidCoordinate(initialX) || !isValidCoordinate(initialY)) {
            throw new InvalidInputException("Invalid initial coordinates.");
        }

        // Load map and character data
        GameMap map = mapGateway.loadMap();
        GameCharacter character = characterGateway.loadCharacter();

        // Initialize character position
        if (map.isAccessible(initialX, initialY)) {
            characterGateway.saveCharacter(new GameCharacter(initialX, initialY, map));
        } else {
            throw new InvalidInputException("Initial position is blocked.");
        }
    }

    private boolean isValidCoordinate(int coordinate) {
        return coordinate >= 0; // Add more validation as needed
    }
}
