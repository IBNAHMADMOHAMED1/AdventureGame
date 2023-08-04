package com.goanddev.game;

import com.goanddev.game.Entity.GameCharacter;
import com.goanddev.game.Entity.GameMap;
import com.goanddev.game.Entity.MovementDirection;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AdventureGameTest {

    private char[][] getMapData() {
        String mapString = "###    ######    ###\n" +
                "###      ##      ###\n" +
                "##     ##  ##     ##\n" +
                "#      ##  ##      #\n" +
                "##                ##\n" +
                "#####          #####\n" +
                "###### ##  ##  #####\n" +
                " #     ######     # \n" +
                "     ########       \n" +
                "    ############    \n" +
                "    ############    \n" +
                "     ########      #\n" +
                " #     ######     ##\n" +
                "###### ##  ## ######\n" +
                "#####          #####\n" +
                "##                ##\n" +
                "#   ## #    # ##   #\n" +
                "##   ##      ##   ##\n" +
                "###    #    #    ###\n" +
                "###    ######    ###";

        String[] lines = mapString.split("\n");
        char[][] mapData = new char[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            mapData[i] = lines[i].toCharArray();
        }

        return mapData;
    }

    @Test
    public void shouldEndAt_9_2WhenStartingAt_3_0() {
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
            character.move(movement);
        }

        assertEquals("(9,2)", character.getPosition());
    }

    @Test
    public void shouldEndAt_7_5WhenStartingAt_6_9() {
        char[][] mapData = getMapData();
        GameMap map = new GameMap(mapData);

        GameCharacter character = new GameCharacter(6, 9, map);

        MovementDirection[] movements = {
                MovementDirection.O, MovementDirection.O, MovementDirection.N, MovementDirection.O, MovementDirection.O,
                MovementDirection.O, MovementDirection.S, MovementDirection.S, MovementDirection.O
        };

        for (MovementDirection movement : movements) {
            character.move(movement);
        }

        assertEquals("(7,5)", character.getPosition());
    }


}

