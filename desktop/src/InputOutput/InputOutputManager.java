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
	  
	  public float getWidth(String path) {
		  return this.getImage(path).getWidth();
	  }
	  
	  public float getHeight(String path) {
		  return this.getImage(path).getHeight();
	  }
	  
	  public boolean isTouched() {
		  return Gdx.input.justTouched();
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
		// System.out.println("Key typed: Listen "+keycode);
		return false;
		
	}
	@Override
	public boolean keyUp(int keycode) {
		
		keysPressed.remove(keycode);
		
        return false;
		
	}
	

	  
}
