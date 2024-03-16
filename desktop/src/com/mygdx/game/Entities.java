package com.mygdx.game;
import InputOutput.*;

abstract public class Entities implements iMovable, iCollision {
	protected EntityManager em;
	private float x;
    private float y;
    private float speed;
    private String imagePath;

    public String getImagePath () {
    	return this.imagePath;
    }
    
    public void setImagePath(String imagePath) {
    	this.imagePath = imagePath;
    }
    
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
    
    @Override
	public float getWidth(InputOutputManager ioman) {
		// TODO Auto-generated method stub
		return ioman.getWidth(this.getImagePath());
	}

	@Override
	public float getHeight(InputOutputManager ioman) {
		// TODO Auto-generated method stub
		return ioman.getHeight(this.getImagePath());
	}
	
    abstract public void draw(EntityManager em);
    abstract public void dispose(EntityManager em);

   
}
