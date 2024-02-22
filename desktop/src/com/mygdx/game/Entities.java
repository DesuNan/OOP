package com.mygdx.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract public class Entities {
	private float x;
    private float y;
    private float speed;
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
    
    abstract public void move();
    abstract public void draw(SpriteBatch batch);
    abstract public void dispose(SpriteBatch batch);
    public abstract float getWidth();
    public abstract float getHeight();
   
}
