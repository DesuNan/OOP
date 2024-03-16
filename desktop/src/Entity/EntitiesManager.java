package Entity;
import java.util.ArrayList;
import Collision.*;
import java.util.List;
import InputOutput.InputOutputManager;

public class EntitiesManager {
	
    private List<Entities> entityList;
    private List<aiMoveable> aiMoveables;
    private InputOutputManager ioman;
    private CollisionManager cm;
    
    public EntitiesManager(InputOutputManager ioman, CollisionManager cm) {
        this.ioman = ioman;
        this.cm = cm;
    	entityList = new ArrayList<>();
    	this.aiMoveables = new ArrayList<>();
        
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
    
    public void deleteEntity(Entities entity) {
    	entityList.remove(entity);
    	if (entity instanceof aiMoveable) {
    		aiMoveables.remove((aiMoveable) entity);
        }
    	if(entity instanceof iCollision) {
        	cm.deleteCollidable((iCollision) entity);
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
