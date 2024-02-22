package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.iCollision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.EntityManager;

public class CollisionManager implements iCollision {
	private SceneManager sm;
	private SpriteBatch batch;
	
	public CollisionManager (SceneManager sm, SpriteBatch batch) {
		this.sm = sm;
		this.batch = batch;
	}
	
    @Override
    public boolean isCollided(Entities entity1, Entities entity2) {
    	return entity1.getX() < entity2.getX() + entity2.getWidth() &&
    			entity1.getX() + entity1.getWidth() > entity2.getX() &&
    			entity1.getY() < entity2.getY() + entity2.getHeight() &&
    			entity1.getY() + entity1.getHeight() > entity2.getY();
    }

    @Override
    public void handleCollisions(List<Entities> entities) {
        Bird bird = null;
        List<Tubes> tubesList = new ArrayList<>();

        for (Entities entity : entities) {
            if (entity instanceof Bird) {
                bird = (Bird) entity;
            } else if (entity instanceof Tubes) {
                tubesList.add((Tubes) entity);
            }
        }

        // Check collisions between bird and each tube
        // If Collided, scenemanager change scene.
        if (bird != null) {
            for (Tubes tubes : tubesList) {
                if (isCollided(bird, tubes)) {
                	sm.set(new EndScene(sm, batch));
                }
            }
        }
    }

}

