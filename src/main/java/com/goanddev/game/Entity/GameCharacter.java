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

        public void move(MovementDirection direction)  {
            int newX = x;
            int newY = y;

            // given (6,9)
            //: Expected :(7,5)
            //Actual   :(0,10) and we have OONOOOSSO , so should x add 1 and y reduce 4 for being (7,5)
            if (direction == MovementDirection.N) {
                newY--;
            } else if (direction == MovementDirection.S) {
                newY++;
            } else if (direction == MovementDirection.E) {
                newX++;
            } else if (direction == MovementDirection.O) {
                newX--;
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
