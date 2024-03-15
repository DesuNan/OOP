package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BotTube extends Entities {
	private Texture BotTubePic;
	
	public BotTube(float x, float y, float speed) {
		
		this.BotTubePic = new Texture("bottomtube.png");
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		
	}
	
	public Texture getBotTube() {
		return this.BotTubePic;
	}
	public void setopTube(Texture pic) {
		this.BotTubePic = pic;
	}
	
	@Override
	public float getWidth() {
	    return BotTubePic.getWidth(); // or bottomTube.getWidth(), assuming they are the same
	}

	@Override
	public float getHeight() {
	    return BotTubePic.getHeight(); // Assuming you're checking collisions with one tube at a time
	}	
	
	@Override
	public void draw(EntityManager em) {
		
		em.getIOMan().getBatch().draw(this.getBotTube(), this.getX(), this.getY());
        
	}
	/*
	@Override
	public void move() {
		this.setX(this.getX() - this.getSpeed());
	}
	*/
	@Override
	public void dispose(EntityManager em) {
		// this.batch.dispose();
		em.getIOMan().disposeBatch();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.setX(this.getX() - this.getSpeed());
	}
}
