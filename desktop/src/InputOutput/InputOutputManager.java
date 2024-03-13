package InputOutput;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Player.*;
import com.badlogic.gdx.InputAdapter;



public class InputOutputManager extends InputAdapter{
	private SpriteBatch batch;
	private PlayersManager pm;
	private Set<Integer> keysPressed;
	
	public InputOutputManager () {
		Gdx.input.setInputProcessor(this);
		keysPressed = new HashSet<>();
		Gdx.gl.glClearColor(256, 256, 100, 100);
		
	}
	public PlayersManager getPLayerManager() {
		return this.pm;
	}
	public void setPlayerManager(PlayersManager pm) {
		
		this.pm = pm;
	}
	  
	  
	  public void createBatch() {
	    this.batch = new SpriteBatch();
	  }
	  public void startBatch() {
	    this.batch.begin();
	  }
	  public void stopBatch() {
	    this.batch.end();
	  }
	  public void disposeBatch() {
	    this.batch.dispose();
	  }
	  
	  public SpriteBatch getBatch() {
	    return this.batch;
	  }
	  
	  public Texture getImage(String path) {
	    return new Texture(path);
	  }
	 
	 public boolean isKeyPressed(int keycode) {
	        return keysPressed.contains(keycode);
	   }
	 
	 public void clearKeys() {
	        keysPressed.clear();
	    }
	 
	
	
	@Override
	public boolean keyDown(int keycode) {
		
		keysPressed.add(keycode);
		System.out.println("Key typed: Listen "+keycode);
		return false;
		/*
		if(isKeyPressed(keycode)) { // Change this to the key you want to listen for
            c
            return true; // Return true to indicate the event has been handled
        }
		return false;
		*/
		// TODO Auto-generated method stub
		/*
		keyHeldDown = true;
		System.out.println("Key typed: Listen");
		keysPressed.add(keycode);
		for (playerMoveable imoveable: pm.getAllMoveables()) {
			imoveable.handleMovement(keycode, isKeyPressed(keycode));
			
		}
        return false;
        
        */
		/*float deltaTime = Gdx.graphics.getDeltaTime();
		for (playerMoveable imoveable: pm.getAllMoveables()) {
			imoveable.handleMovement(keycode, deltaTime);
			
		}
		return false;*/
	}
	@Override
	public boolean keyUp(int keycode) {
		
		keysPressed.remove(keycode);
		
        return false;
		// TODO Auto-generated method stub
		/*
		System.out.println("Key up: " + (keycode));
		return false;*/
	}
	/*
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		System.out.println("Key typed: Listen");
		System.out.println("Key typed: " + character);
		return false;
	}
	*/

	  
}
