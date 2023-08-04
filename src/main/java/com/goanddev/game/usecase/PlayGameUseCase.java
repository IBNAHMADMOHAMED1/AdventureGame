package com.goanddev.game.usecase;

import com.goanddev.game.Entity.GameCharacter;
import com.goanddev.game.Entity.MovementDirection;
import com.goanddev.game.exceptions.MovementBlockedException;
import com.goanddev.game.gateways.CharacterGateway;

public class PlayGameUseCase {
    private final CharacterGateway characterGateway;

    public PlayGameUseCase(CharacterGateway characterGateway) {
        this.characterGateway = characterGateway;
    }

    public void execute(MovementDirection[] movements) {
        GameCharacter character = characterGateway.loadCharacter();

        for (MovementDirection direction : movements) {
            try {
                character.move(direction);
            } catch (IllegalArgumentException ex) {
                // Handle blocked movement (e.g., show error message, log, etc.)
            }
        }

        characterGateway.saveCharacter(character);
    }
}
