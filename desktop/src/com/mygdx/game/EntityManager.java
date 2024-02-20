package com.mygdx.game;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

// EntityManager class
public class EntityManager implements iMovable {
	
	
    private List<Entities> entityList;
    private CollisionManager CollisionManager;
    private Bird bird;
    private Tube tube;

    public EntityManager() {
        entityList = new ArrayList<>();
    }

    public List<Entities> getEntityList() {
    	return this.entityList;
    }
    public void addEntity(Entities entity) {
        entityList.add(entity);
    }
    
    public void draw() {
    	for (Entities entity: entityList) {
    		entity.draw();
    	}
    }
    
    public void dispose() {
    	for (Entities entity: entityList) {
    		entity.dispose();
    	}
    }
    
  
    
 
}
