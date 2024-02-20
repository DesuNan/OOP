package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.iCollision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.EntityManager;

public class CollisionManager implements iCollision {
	protected SceneManager sm;
	protected SpriteBatch batch;
	
	public CollisionManager (SceneManager sm, SpriteBatch batch) {
		this.sm = sm;
		this.batch = batch;
	}
	
    @Override
    public boolean isCollided(Bird bird, Tubes tubes) {
        boolean collisionWithTopTube = bird.getX() < tubes.getPosTopTube().x + tubes.getTopTube().getWidth() &&
                                       bird.getX() + bird.getWidth() > tubes.getPosTopTube().x &&
                                       bird.getY() < tubes.getPosTopTube().y + tubes.getTopTube().getHeight() &&
                                       bird.getY() + bird.getHeight() > tubes.getPosTopTube().y;
                                       
        boolean collisionWithBottomTube = bird.getX() < tubes.getPosBottomTube().x + tubes.getBottomTube().getWidth() &&
                                          bird.getX() + bird.getWidth() > tubes.getPosBottomTube().x &&
                                          bird.getY() < tubes.getPosBottomTube().y + tubes.getBottomTube().getHeight() &&
                                          bird.getY() + bird.getHeight() > tubes.getPosBottomTube().y;

        return collisionWithTopTube || collisionWithBottomTube;
    }


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
        if (bird != null) {
            for (Tubes tubes : tubesList) {
                if (isCollided(bird, tubes)) {
                	System.out.println(bird.getX());
                	System.out.println(bird.getY());
                	System.out.println(tubes.getPosBottomTube().x);
                	sm.set(new EndScene(sm, batch));
                    
                }
            }
        }
    }

}

