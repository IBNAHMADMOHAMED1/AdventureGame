package com.goanddev.game.gateways;

import com.goanddev.game.Entity.GameCharacter;

public interface CharacterGateway {

    GameCharacter loadCharacter();
    void saveCharacter(GameCharacter character);
}
