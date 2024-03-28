package GameEngine.Player;

import java.util.HashMap;
import GameEngine.Collision.iCollision;
import GameEngine.InputOutput.InputOutputManager;
import java.util.Map;

abstract public class Players implements playerMoveable, iCollision {
	protected PlayersManager pm;
	private float x;
    private float y;
    private float speed;
    private String imagePath;
    private double score = 0;
    private Map<Integer, Runnable> actionsMap = new HashMap<>();
	private int health;
    
    public Players () {
    	
    }
    
    public Players (PlayersManager pm) {
		this.pm = pm;
	}
    
    public Map<Integer, Runnable> getActionsMap() {
    	return this.actionsMap;
    }
    
    public void addActions(int keyBind, Runnable actions) {
    	this.actionsMap.put(keyBind, actions);
    }
    
    public void deleteActions(int keyBind) {
        actionsMap.remove(keyBind);
    }
 
    
    public double getScore() {
    	return this.score;
    }
  
    public float getX() {
    	return this.x;
    }
    public float getY() {
    	return this.y;
    }
    public float getSpeed() {
    	return this.speed;
    }
    
    public String getImage() {
    	return this.imagePath;
    }
    public void setScore(double score) {
    	this.score = score;
    }
    public void setX(float x) {
    	this.x = x;
    }
    public void setY(float y) {
    	this.y = y;
    }
    
    public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

    public void setSpeed(float speed) {
    	this.speed = speed;
    }
    public void setImage(String imagePath) {
    	this.imagePath = imagePath;
    }
    
    abstract public void draw(PlayersManager pm);
    abstract public void dispose(PlayersManager pm);
	
	@Override
	abstract public void handleMovement(PlayersManager pm);
	
	@Override
	abstract public void handleGravity(PlayersManager pm);
	
	@Override
	public float getWidth(InputOutputManager ioman) {
		// TODO Auto-generated method stub
		return ioman.getWidth(this.imagePath);
	}
	@Override
	public float getHeight(InputOutputManager ioman) {
		// TODO Auto-generated method stub
		return ioman.getHeight(this.imagePath);
	}


	

}
