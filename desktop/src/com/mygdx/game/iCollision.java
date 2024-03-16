package com.mygdx.game;

import java.util.List;

import InputOutput.*;
import com.mygdx.game.Entities;

// Collsion interface between entities.
public interface iCollision {
   /* boolean isCollided(Entities entity1, Entities entity2);
    void handleCollisions(List<Entities> entities);*/
	public float getX();
    public float getY();
    public float getWidth(InputOutputManager ioman);
    public float getHeight(InputOutputManager ioman);
}
