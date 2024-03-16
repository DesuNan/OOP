package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import InputOutput.InputOutputManager;

import java.util.List;
import Collision.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import Player.*;

public class Bird extends Players {
	private float velocity = 0; // Bird's vertical velocity
	private final float GRAVITY = -0.5f; // Gravity effect on the bird
	private final float JUMP_FORCE = 8f; // The upward force applied when jumping
	public Bird(float x, float y, float speed, String imagePath, List<Integer> keyBinds) {
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setImage(imagePath);
		for (int keyBind: keyBinds) {
			
			this.addKeyBinds(keyBind);
		}
	}
	
	@Override
	public void handleMovement(PlayersManager pm) {
		// TODO Auto-generated method stub
        this.setY(this.getY() + GRAVITY);
        if (pm.getIOMan().isKeyPressed(Keys.UP)) { // cheat way first
            // Apply jump force
            this.velocity = JUMP_FORCE;
            //Play jump sound
            pm.getIOMan().playSound("jump.mp3");
        }
        /*
        // Jump Movement
        if (this.getKeyBinds() != null) {
        for (int keyBind: this.getKeyBinds()) {
          if (pm.getIOMan().isKeyPressed(keyBind)) {
            // play sound whenever player move
            pm.getIOMan().playSound("point.ogg");
            this.setY(this.getY() + this.getSpeed());
          }
        }
        }
        */
		
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
		pm.getIOMan().getBatch().draw(pm.getIOMan().getImage(this.getImage()), this.getX(), this.getY());
	}
	
	
	@Override
	public void dispose(PlayersManager pm) {
		pm.getIOMan().disposeBatch();
	}
}
