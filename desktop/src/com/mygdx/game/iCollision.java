package com.mygdx.game;

import java.util.List;

import com.mygdx.game.Entities;

// Collsion interface between entities.
public interface iCollision {
    boolean isCollided(Entities entity1, Entities entity2);
    void handleCollisions(List<Entities> entities);
}
