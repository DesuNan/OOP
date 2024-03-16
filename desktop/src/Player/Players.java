package Player;

import java.util.ArrayList;
import java.util.List;


import com.badlogic.gdx.Input;

import InputOutput.InputOutputManager;
import com.mygdx.game.*;

abstract public class Players implements playerMoveable, iCollision {
	protected PlayersManager pm;
	private float x;
    private float y;
    private float speed;
    private String imagePath;
    private float score;
    private List<Integer> keyBinds = new ArrayList<>();
    
    /*
    private int keyBindUp;
    private int keyBindDown;
    private int keyBindLeft;
    private int keyBindRight;
    */
    
    
    /*
    public Players (float x,float y,float speed, String img) {
    	this.x=x;
    	this.y=y;
    	this.speed=speed;
    	this.imagePath=img;
    	this.score = 0;
    	this.keyBindUp = Input.Keys.UP;
    	this.keyBindDown = Input.Keys.DOWN;
    	this.keyBindLeft = Input.Keys.LEFT;
    	this.keyBindRight = Input.Keys.RIGHT;
    	
    	}*/
    public List<Integer> getKeyBinds () {
    	return this.keyBinds;
    }
    public void addKeyBinds(int keyBind) {
    	this.keyBinds.add(keyBind);
    }
    public void deleteKeyBinds(int keyBind) {
    	this.keyBinds.remove(keyBind);
    }
    
    public float getScore() {
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
    public void setScore(float score) {
    	this.score = score;
    }
    public void setX(float x) {
    	this.x = x;
    }
    public void setY(float y) {
    	this.y = y;
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
	
	/*{
		// TODO Auto-generated method stub
		
		if (ioman.isKeyPressed(keyBindUp)) {
			this.setY(this.getY() + this.getSpeed());
		}
		else if (ioman.isKeyPressed(keyBindDown)) {
			
			this.setY(this.getY() - this.getSpeed());
		}
		
	}*/
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
