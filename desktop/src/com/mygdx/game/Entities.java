package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract public class Entities implements iMovable, iCollision {
	protected EntityManager em;
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
    
    abstract public void draw(EntityManager em);
    abstract public void dispose(EntityManager em);

   
}
