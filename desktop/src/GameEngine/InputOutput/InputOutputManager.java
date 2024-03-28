package GameEngine.InputOutput;

import com.badlogic.gdx.graphics.Texture;
import java.util.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import GameEngine.Player.PlayersManager;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Sound;  
import com.badlogic.gdx.audio.Music;



public class InputOutputManager extends InputAdapter{
	private SpriteBatch batch;
	private PlayersManager pm;
	private Set<Integer> keysPressed;
	private Sound sound;
	private Music music ;//= Gdx.audio.newMusic(Gdx.files.internal("arcade.mp3"));
	// private BitmapFont font;
	private Map<String, Integer> textureCount;
	private List<Texture> textureList;
	private BitmapFont font;
	
	public InputOutputManager () {
		Gdx.input.setInputProcessor(this);
		keysPressed = new HashSet<>();
		Gdx.gl.glClearColor(256, 256, 100, 100);
		this.font = new BitmapFont();
		this.textureCount = new HashMap<>();
	    this.textureList = new ArrayList<>(); 
		
	}
	public PlayersManager getPlayerManager() {
		return this.pm;
	}
	
	public void setPlayerManager(PlayersManager pm) {
		
		this.pm = pm;
	}
	
	public void draw(String imgPath, float x, float y) {
			int count = textureCount.getOrDefault(imgPath,0);
			Texture texture = null;
			if (count == 0) {
				texture = this.getImage(imgPath);
				textureList.add(texture);
			}
			else {
				for (Texture pic : textureList) {
					if (pic.toString() == imgPath) {
						texture = pic;
					}
				}
			}
			
		    textureCount.put(imgPath, textureCount.getOrDefault(imgPath,0) +1);
		    this.getBatch().draw(texture, x, y);
		  }

		  public void disposeTexture (String imgPath) {
		    int count = textureCount.getOrDefault(imgPath,0);
		    if (count > 0) {
		      count --;
		      textureCount.put(imgPath, count);
		    }
		    else if (count == 0) {
		      // dispose all textures
		      for (Texture texture: textureList) {
		        if (texture.toString() == imgPath) {
		          texture.dispose();
		          textureList.remove(texture);
		        }
		      }
		    }

		  }
	  
		  public void draw(String imgPath, float x, float y, float width, float height) {
				int count = textureCount.getOrDefault(imgPath,0);
				Texture texture = null;
				if (count == 0) {
					texture = this.getImage(imgPath);
					textureList.add(texture);
				}
				else {
					for (Texture pic : textureList) {
						if (pic.toString() == imgPath) {
							texture = pic;
						}
					}
				}
				
			    textureCount.put(imgPath, textureCount.getOrDefault(imgPath,0) +1);
			    this.getBatch().draw(texture, x, y, width, height);
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
	    this.disposeSound();
	    this.disposeMusic();
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
	 
	 public boolean keyPressOnce (int keycode) {
	     if (keysPressed.contains(keycode)) {
	       keysPressed.remove(keycode);
	       return true;
	     }
	     else return false;
	   }
	 
	 public void clearKeys() {
	        keysPressed.clear();
	    }
	 
	@Override
	public boolean keyDown(int keycode) {
		keysPressed.add(keycode);
		
		return false;


	}
	@Override
	public boolean keyUp(int keycode) {
		keysPressed.remove(keycode);
        return false;
	}
	
	public void playSound(String path) {
        if (sound != null) {
            sound.dispose(); // Dispose of any previously playing music
        }
       
        sound = Gdx.audio.newSound(Gdx.files.internal(path));
        sound.play(1.0f);
    }
	
	public void disposeSound() {
        if (sound != null) {
            sound.dispose();
        }
    }
	 public void playMusic (String path) {
		 
	        System.out.println(Gdx.files.internal(path));
	        music = Gdx.audio.newMusic(Gdx.files.internal(path));
	        music.play();
	        
	 }
	 
	 public void disposeMusic() {
	        if (this.music != null) {
	            this.music.dispose();
	        }
	    }

	public void displayText (String text, float x, float y) {
		 this.font.draw(this.getBatch(), text, x, y);
	 }
	
	 public void disposeText() {
		 this.font.dispose();
	 }
	 
	
	  
}
