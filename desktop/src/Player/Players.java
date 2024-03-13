package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import InputOutput.InputOutputManager;

public class Players implements playerMoveable {
	private float x;
    private float y;
    private float speed;
    private String imagePath;
    
    private int keyBindUp;
    private int keyBindDown;
    private int keyBindLeft;
    private int keyBindRight;
    
    public Players (float x,float y,float speed, String img) {
    	this.x=x;
    	this.y=y;
    	this.speed=speed;
    	this.imagePath=img;
    	
    	this.keyBindUp = Input.Keys.UP;
    	this.keyBindDown = Input.Keys.DOWN;
    	this.keyBindLeft = Input.Keys.LEFT;
    	this.keyBindRight = Input.Keys.RIGHT;
    	
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
	public void handleMovement(InputOutputManager ioman, float dt) {
		// TODO Auto-generated method stub
		
		if (ioman.isKeyPressed(keyBindUp)) {
			System.out.println("HELLOOOOO" + this.getY());
			this.setY(this.getY() + this.getSpeed());
		}
		else if (ioman.isKeyPressed(keyBindDown)) {
			System.out.println("BYEEE" +this.getY());
			this.setY(this.getY() - this.getSpeed());
		}
		
		
		
	}


	

}
