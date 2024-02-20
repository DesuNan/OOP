package com.mygdx.game;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// EntityManager class
public class EntityManager implements iMovable {
	
	
    private List<Entities> entityList;
    private CollisionManager CollisionManager;
    private Bird bird;
    

    public EntityManager() {
        entityList = new ArrayList<>();
    }

    public List<Entities> getEntityList() {
    	return this.entityList;
    }
    public void addEntity(Entities entity) {
        entityList.add(entity);
    }
    
    public void draw(SpriteBatch batch) {
    	for (Entities entity: entityList) {
    		entity.draw(batch);
    	
    	}
    }
    
    public void dispose(SpriteBatch batch) {
    	for (Entities entity: entityList) {
    		entity.dispose(batch);
    	}
    }

	@Override
	public void moveAIControlled() {
		// TODO Auto-generated method stub
		for (Entities entity: entityList) {
    		// if ai controlled
			if(entity.isUserControlled() == false) {
				entity.move();
			}
    	}
		
	}

	@Override
	public void moveUserControlled() {
		// TODO Auto-generated method stub'
		for (Entities entity: entityList) {
    		// if not ai controlled
			if(entity.isUserControlled() == true) {
				entity.move();
			}
    	}
		
	}
}
