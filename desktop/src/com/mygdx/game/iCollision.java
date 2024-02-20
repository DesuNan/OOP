package com.mygdx.game;

import java.util.List;

import com.mygdx.game.Entities;

public interface iCollision {
    boolean isCollided(Bird bird, Tubes tubes);
    void handleCollisions(List<Entities> entities);
}
