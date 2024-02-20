package com.mygdx.game;

abstract public class Entities {
	private float x;
    private float y;
    private float speed;
    
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
    abstract public void draw();
    abstract public void dispose();
   
}
