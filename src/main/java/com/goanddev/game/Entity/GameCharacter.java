package com.goanddev.game.Entity;

import com.goanddev.game.exceptions.MovementBlockedException;
import com.goanddev.game.gateways.MapGateway;

public class GameCharacter {
    private int x;
    private int y;
    private final GameMap gameMap;

    public GameCharacter(int initialX, int initialY, GameMap gameMap) {
        this.x = initialX;
        this.y = initialY;
        this.gameMap = gameMap;
    }


        public void move(MovementDirection direction) {
            int newX = x;
            int newY = y;

            if (direction == MovementDirection.N) {
                newX--;
            } else if (direction == MovementDirection.S) {
                newX++;
            } else if (direction == MovementDirection.E) {
                newY++;
            } else if (direction == MovementDirection.O) {
                newY--;
            }

            if (gameMap.isAccessible(newX, newY)) {
                x = newX;
                y = newY;
            } else {
                throw new MovementBlockedException("Movement blocked.");
            }
        }

    public String getPosition() {
        return "(" + x + "," + y + ")";
    }

}
