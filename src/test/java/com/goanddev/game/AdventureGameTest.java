package com.goanddev.game;

import com.goanddev.game.Entity.GameCharacter;
import com.goanddev.game.Entity.GameMap;
import com.goanddev.game.Entity.MovementDirection;
import com.goanddev.game.exceptions.MovementBlockedException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class AdventureGameTest {
    private GameMap map;

    @BeforeEach
    public void setUp() {
        char[][] mapData = {
                "###    ######    ###".toCharArray(),
                "###      ##      ###".toCharArray(),
                "##     ##  ##     ##".toCharArray(),
                "#      ##  ##      #".toCharArray(),
                "##                ##".toCharArray(),
                "#####          #####".toCharArray(),
                "###### ##  ##  #####".toCharArray(),
                " #     ######     # ".toCharArray(),
                "     ########       ".toCharArray(),
                "    ############    ".toCharArray(),
                "    ############    ".toCharArray(),
                "     ########      #".toCharArray(),
                " #     ######     ##".toCharArray(),
                "###### ##  ## ######".toCharArray(),
                "#####          #####".toCharArray(),
                "##                ##".toCharArray(),
                "#   ## #    # ##   #".toCharArray(),
                "##   ##      ##   ##".toCharArray(),
                "###    #    #    ###".toCharArray(),
                "###    ######    ###".toCharArray()
        };

    }

    @Test
    public void testPremierTest() {

        char[][] mapData = getMapData();
        GameMap map = new GameMap(mapData);

        GameCharacter character = new GameCharacter(3, 0, map);

        MovementDirection[] movements = {
                MovementDirection.S, MovementDirection.S, MovementDirection.S, MovementDirection.S,
                MovementDirection.E, MovementDirection.E, MovementDirection.E, MovementDirection.E,
                MovementDirection.E, MovementDirection.E, MovementDirection.E, MovementDirection.E,
                MovementDirection.N, MovementDirection.N
        };

        for (MovementDirection movement : movements) {
            try {
                character.move(movement);
            } catch (MovementBlockedException e) {
            }
        }

        assertEquals("(9,2)", character.getPosition());
    }

    @Test
    public void testDeuxiemeTest() {
        char[][] mapData = getMapData();
        GameMap map = new GameMap(mapData);
        GameCharacter character = new GameCharacter(6, 9, map);
        MovementDirection[] movements = {
                MovementDirection.O, MovementDirection.O, MovementDirection.N, MovementDirection.O, MovementDirection.O,
                MovementDirection.O, MovementDirection.S, MovementDirection.S, MovementDirection.O
        };

        for (MovementDirection movement : movements) {
            try {
                character.move(movement);
            } catch (MovementBlockedException e) {
                // Handle movement blocked exception if needed
            }
        }

        assertEquals("(7,5)", character.getPosition());
    }

    // function for Map is not initialized.
    private char[][] getMapData() {
        char[][] mapData = {
                "###    ######    ###".toCharArray(),
                "###      ##      ###".toCharArray(),
                "##     ##  ##     ##".toCharArray(),
                "#      ##  ##      #".toCharArray(),
                "##                ##".toCharArray(),
                "#####          #####".toCharArray(),
                "###### ##  ##  #####".toCharArray(),
                " #     ######     # ".toCharArray(),
                "     ########       ".toCharArray(),
                "    ############    ".toCharArray(),
                "    ############    ".toCharArray(),
                "     ########      #".toCharArray(),
                " #     ######     ##".toCharArray(),
                "###### ##  ## ######".toCharArray(),
                "#####          #####".toCharArray(),
                "##                ##".toCharArray(),
                "#   ## #    # ##   #".toCharArray(),
                "##   ##      ##   ##".toCharArray(),
                "###    #    #    ###".toCharArray(),
                "###    ######    ###".toCharArray()
        };
        return mapData;
    }
}

