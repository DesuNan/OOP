package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.iCollision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.EntityManager;
import Player.*;


public class CollisionManager {
	private SceneManager sm;
	private List<iCollision> collidables;
	
	public CollisionManager (SceneManager sm) {
		this.sm = sm;
		this.collidables = new ArrayList<>();
		
	}
	
	public List<iCollision> getCollidablesList () {
		return this.collidables;
	}
	
	public void addCollidable(iCollision collidable) {
        collidables.add(collidable);
    }
	public void deleteCollidable(iCollision collidable) {
        collidables.remove(collidable);
    }
	
    public boolean isCollided(iCollision entity1, iCollision entity2) {
    	return entity1.getX() < entity2.getX() + entity2.getWidth(sm.getIOMan()) &&
    			entity1.getX() + entity1.getWidth(sm.getIOMan()) > entity2.getX() &&
    			entity1.getY() < entity2.getY() + entity2.getHeight(sm.getIOMan()) &&
    			entity1.getY() + entity1.getHeight(sm.getIOMan()) > entity2.getY();
    }
    

    public void handleCollisions() {
        Players player = null;
        List<Entities> entityList = new ArrayList<>();
        for (iCollision collidable: this.collidables) {
        	if (collidable instanceof Players) {
        		player = (Players) collidable;
        	}
        	else if (collidable instanceof Entities) {
        		entityList.add((Entities) collidable);
        	}
        }
     // Check collisions between bird and each tube
     // If Collided, scenemanager change scene.
        if (player != null) {
        	for (Entities entity: entityList) {
        		if (isCollided(entity,player)) {
        			sm.set(new EndScene(sm));
        		}
        	}
        }
    }

}

