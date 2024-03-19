package com.mygdx.game;
import java.util.Map;

import Player.*;

public class Bird extends Players {
	private float velocity = 0; // Bird's vertical velocity
	private final float GRAVITY = -0.5f; // Gravity effect on the bird
	private final float JUMP_FORCE = 8f; // The upward force applied when jumping
	private static Bird instance;
	private Bird(PlayersManager pm, float x, float y, float speed, String imagePath,  int jumpKeyBind) {
		// super(pm);
		this.pm = pm;
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setImage(imagePath);
		
		this.addActions(jumpKeyBind, () -> {
		           	// Apply jump force
		            this.velocity = JUMP_FORCE;
		            //Play jump sound
		            pm.getIOMan().playSound("jump.mp3");
		});
		
	}
	public static Bird getInstance(PlayersManager pm, float x, float y, float speed, String imagePath, int jumpKeyBind) {
	    if (instance == null) {
	        instance = new Bird(pm, x, y, speed, imagePath, jumpKeyBind);
	    }
	    return instance;
	}
	
	public int getJumpKeyBind () {
		return this.getJumpKeyBind();
	}
	
	public void setJumpKeyBind (int keyBind) {
		this.deleteActions(this.getJumpKeyBind());
		this.addActions(keyBind, () -> {
		           	// Apply jump force
		            this.velocity = JUMP_FORCE;
		            //Play jump sound
		            pm.getIOMan().playSound("jump.mp3");
		});
	}
	
	
	@Override
	public void handleMovement(PlayersManager pm) {
		for (Map.Entry<Integer, Runnable> entry : this.getActionsMap().entrySet()) {
			if (pm.getIOMan().keyPressOnce(entry.getKey())) {
				entry.getValue().run();
			}
		}
		
	}
	
	@Override
	public void handleGravity(PlayersManager pm) {
	    // Apply gravity to velocity
	    velocity += GRAVITY;

	    // Update the bird's Y position based on the velocity
	    this.setY(this.getY() + velocity);

	    // Prevent the bird from falling below a certain point (e.g., the ground)
	    if (this.getY() < 0) {
	        this.setY(0);
	        velocity = 0; // Stop moving once hitting the ground
	    }
	}
	
	@Override
	public void draw(PlayersManager pm) {
		
		if (pm.getSceneManager().getGameLifeCycle().getStatus() == GameState.Play) {
		pm.getIOMan().getBatch().draw(pm.getIOMan().getImage(this.getImage()), this.getX(), this.getY());
		// draw player score
		pm.getIOMan().displayText("Score: " + this.getScore(),400,550);
		}
		else if(pm.getSceneManager().getGameLifeCycle().getStatus() == GameState.End) {
	
			pm.getIOMan().displayText("Score: " + this.getScore(), (GameLifeCycle.WIDTH/2) - 50 ,(GameLifeCycle.HEIGHT/2) - (pm.getIOMan().getHeight("gameover.png"))/2);
		}
	}
	
	
	@Override
	public void dispose(PlayersManager pm) {
		pm.getIOMan().disposeBatch();
	}
}
