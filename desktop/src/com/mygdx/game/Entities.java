package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

abstract public class Entities {
	private float x;
    private float y;
    private float speed;
    private float velocityY;
    private boolean userControlled;
    

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public boolean isUserControlled() {
        return this.userControlled;
    }
    public void setUserContolled(boolean userControlled) {
         this.userControlled = userControlled;
    }
    /*
    public void move() {
        if (userControlled) {
            moveUserControlled();
        } else {
            moveAIControlled();
        }
    }*/
    
    abstract public void move();
    /*
    public void moveAIControlled() {
    	// Implement AI-controlled movement logic for TextureObject
        // Update the x and y positions based on AI-controlled movement
        y += Gdx.graphics.getDeltaTime() * speed;
    }
*/
    abstract public void draw();
    abstract public void dispose();
   
}
