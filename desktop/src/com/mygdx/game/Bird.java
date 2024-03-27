package com.mygdx.game;
import java.util.Map;
import Player.*;

public class Bird extends Players {
	private float velocity = 0; // Bird's vertical velocity
	private float GRAVITY = -0.5f; // Gravity effect on the bird, allowing for adjustment
	private final float JUMP_FORCE = 8f; // The upward force applied when jumping
	private static Bird instance;
	private int maxhealth = 3;
	private int minhealth = 1;
	private Bird(PlayersManager pm, float x, float y, float speed, String imagePath,  int jumpKeyBind) {
		// super(pm);
		this.pm = pm;
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setImage(imagePath);
		this.setHealth(3);
		
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
	
	public void setHealth(int health) {
    // Ensure the health value is within the allowed range
    if (health > maxhealth) {
        health = maxhealth;
    } else if (health < minhealth) {
        health = minhealth;
    }
    super.setHealth(health); // Call to the superclass method to actually set the health
    
    // Adjust gravity based on the current health
    adjustGravityBasedOnHealth();
    // Adjust image based on the current health
	}
	
	private void adjustGravityBasedOnHealth() {
	    // Adjust the gravity based on the bird's current health
	    switch (this.getHealth()) {
	        case 3:
	            this.GRAVITY = -0.5f; // Normal gravity
	            break;
	        case 2:
	            this.GRAVITY = -0.7f; // Increased gravity
	            break;
	        case 1:
	            this.GRAVITY = -0.9f; // Further increased gravity
	            break;
	        default:
	            this.GRAVITY = -0.5f; // Default case to handle unexpected values
	    }
	}
	private void updateImageBasedOnHealth() {
	      // Update the bird's sprite image based on its current health
	      switch (this.getHealth()) {
	          case 3:
	        	  pm.getIOMan().disposeTexture(this.getImage());
	              this.setImage("Player.png"); // Bird with 3 health
	              break;
	          case 2:
	        	  pm.getIOMan().disposeTexture(this.getImage());
	              this.setImage("Player2.png"); // Bird with 2 health
	              break;
	          case 1:
	        	  pm.getIOMan().disposeTexture(this.getImage());
	              this.setImage("Player3.png"); // Bird with 1 health
	              break;
	          default:
	              this.setImage("Player.png"); 
	      }
	  }


	
	public int getJumpKeyBind () {
		return this.getJumpKeyBind();
	}

	public void setJumpKeyBind (int keyBind) {
		this.deleteActions(this.getJumpKeyBind());
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
	    
	    if (this.getY() > 560) {
	        this.setY(560);
	        velocity = 0; // Stop moving once hitting the roof
	    }
	}
	
	@Override
	public void draw(PlayersManager pm) {
		this.drawHealth(this.getHealth(), pm);
		System.out.println(this.getHealth());
		if (pm.getSceneManager().getGameLifeCycle().getStatus() == GameState.Play) {
		pm.getIOMan().draw(this.getImage(), this.getX(), this.getY());
	    this.updateImageBasedOnHealth();

		// draw player score
		pm.getIOMan().displayText("Score: " + this.getScore(),400,550);
		}
		else if(pm.getSceneManager().getGameLifeCycle().getStatus() == GameState.End) {
	
			// pm.getIOMan().displayText("Score: " + this.getScore(), (GameLifeCycle.WIDTH/2) - 50 ,(GameLifeCycle.HEIGHT/2) - (pm.getIOMan().getHeight("gameover.png"))/2);
		}
	}
	
	public void drawHealth(int count, PlayersManager pm) {
		int starX = 300;
		int spaceX = 50;
		int y = 0;
		
		for (int i = 0; i < count; i++) {
			int x = starX + i * spaceX;
			pm.getIOMan().draw("Heart.png",x,y);
			//sm.getEntityManager().addEntity(new Danger(x ,y , 0, "Heart.png"));
		}
	}
	
	
	@Override
	public void dispose(PlayersManager pm) {
		pm.getIOMan().disposeTexture("Heart.png");
		// pm.disposeText();
		pm.getIOMan().disposeTexture(this.getImage());
	}
}
