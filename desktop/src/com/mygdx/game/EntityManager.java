package com.mygdx.game;
import java.util.ArrayList;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import InputOutput.InputOutputManager;
import Player.playerMoveable;

// EntityManager class
// public class EntityManager implements iMovable {
public class EntityManager {
	
    private List<Entities> entityList;
    private List<iMovable> imovables;
    private InputOutputManager ioman;
    private CollisionManager cm;
    
    public EntityManager(InputOutputManager ioman, CollisionManager cm) {
        this.ioman = ioman;
        this.cm = cm;
    	entityList = new ArrayList<>();
    	this.imovables = new ArrayList<>();
        
    }
    
    public InputOutputManager getIOMan() {
    	return this.ioman;
    }

    public List<Entities> getEntityList() {
    	return this.entityList;
    }
    public List<iMovable> getAllMoveables() {
        return imovables;
    }
    public void addEntity(Entities entity) {
        entityList.add(entity);
        if (entity instanceof iMovable) {
        	imovables.add((iMovable) entity);
        }
        if(entity instanceof iCollision) {
        	cm.addCollidable((iCollision) entity);
        }
    }
    
    public void deleteEntity(Entities entity) {
    	entityList.remove(entity);
    	if (entity instanceof iMovable) {
        	imovables.remove((iMovable) entity);
        }
    	if(entity instanceof iCollision) {
        	cm.deleteCollidable((iCollision) entity);
        }
    }
    
    public void draw() {
    	for (Entities entity: entityList) {
    		entity.draw(this);
    	
    	}
    	
    	this.handleMove();
    }
    
    public void handleMove() {
    	for (iMovable imove: imovables) {
    		imove.move();
    	}
    }
    
    public void dispose() {
    	for (Entities entity: entityList) {
    		entity.dispose(this);
    	}
    }
    
    
/*
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
	*/
}
