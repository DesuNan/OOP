package Player;

import com.badlogic.gdx.Input;

import InputOutput.InputOutputManager;
import com.mygdx.game.*;

public class Players implements playerMoveable, iCollision {
	protected PlayersManager pm;
	private float x;
    private float y;
    private float speed;
    private String imagePath;
    private float score;
    
    private int keyBindUp;
    private int keyBindDown;
    private int keyBindLeft;
    private int keyBindRight;
    
    
    private InputOutputManager ioman = new InputOutputManager();
    
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
	
	@Override
	public void handleMovement(InputOutputManager ioman) {
		// TODO Auto-generated method stub
		
		if (ioman.isKeyPressed(keyBindUp)) {
			
			this.setY(this.getY() + this.getSpeed());
		}
		else if (ioman.isKeyPressed(keyBindDown)) {
			
			this.setY(this.getY() - this.getSpeed());
		}
		
	}
	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return ioman.getWidth(this.imagePath);
	}
	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return ioman.getHeight(this.imagePath);
	}


	

}
