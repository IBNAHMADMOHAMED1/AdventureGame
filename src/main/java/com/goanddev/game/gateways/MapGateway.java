package com.goanddev.game.gateways;

import com.goanddev.game.Entity.GameMap;

public interface MapGateway {
    //  to load the map data and check accessibility.
    GameMap loadMap();
    boolean isAccessible(int x, int y);

}
