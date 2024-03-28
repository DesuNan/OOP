package GameEngine;
import java.util.ArrayList;
import Collision.*;
import GameLayer.Tube;

import java.util.List;

import com.mygdx.game.*;

public class EntitiesManager {
	
    private List<Entities> entityList;
    private List<Entities> deleteEntityList;
    private List<aiMoveable> aiMoveables;
    private InputOutputManager ioman;
    private CollisionManager cm;
    
    public EntitiesManager(InputOutputManager ioman, CollisionManager cm) {
        this.ioman = ioman;
        this.cm = cm;
    	entityList = new ArrayList<>();
    	this.aiMoveables = new ArrayList<>();
        
    }
    public void clearAll () {
    	this.getAllMoveables().clear();
    	this.getEntityList().clear();
    }
    
    public InputOutputManager getIOMan() {
    	return this.ioman;
    }

    public List<Entities> getEntityList() {
    	return this.entityList;
    }
    public List<aiMoveable> getAllMoveables() {
        return aiMoveables;
    }
    public void addEntity(Entities entity) {
        entityList.add(entity);
        
        if (entity instanceof aiMoveable) {
        	aiMoveables.add((aiMoveable) entity);
        }
        if(entity instanceof iCollision) {
        	cm.addCollidable((iCollision) entity);
        }
        
    }
    
    public void deleteEntity() {
    	for (Entities entity: entityList) {
    		
	   		
    		if (entity instanceof Tube) {
    			// Tube.reposition();
    		}
    		else {
    			if (entity.getX() + entity.getWidth(ioman) < 0) {
    				if (entity instanceof aiMoveable) {
    		    		aiMoveables.remove((aiMoveable) entity);
    		        }
    		    	if(entity instanceof iCollision) {
    		        	cm.deleteCollidable((iCollision) entity);
    		        }
    		    	entityList.remove(entity);
    			}
    		}
    		
    	}
    }
    
    public void draw() {
    	if (entityList.isEmpty()) {} 
    	 
    	else {
    		for (Entities entity: entityList) {
    			entity.draw(this);
    		}
    		this.handleMove();
    	}
    		
    	
    }
    
    public void handleMove() {
    	for (aiMoveable imove: aiMoveables) {
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
