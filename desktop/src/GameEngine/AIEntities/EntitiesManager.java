package GameEngine.AIEntities;
import java.util.ArrayList;
import GameEngine.Collision.CollisionManager;
import GameEngine.Collision.iCollision;
import GameEngine.InputOutput.InputOutputManager;
import GameLayer.AIEntities.Tube;
import java.util.List;

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
    
    public void clearAll () {
    	this.getAllMoveables().clear();
    	this.getEntityList().clear();
    }
    
    public void handleMove() {
    	for (aiMoveable imove: aiMoveables) {
    		imove.move();
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
    
    public void dispose() {
    	for (Entities entity: entityList) {
    		entity.dispose(this);
    	}
    }

}
