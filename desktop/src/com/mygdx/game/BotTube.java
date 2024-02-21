package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BotTube extends Tubes {
	private Texture BotTubePic;
	private SpriteBatch batch = new SpriteBatch();
	
	
	public BotTube(float x, RandomGenerator rand) {
		super(x, rand);
		this.BotTubePic = new Texture("bottomtube.png");
		
		this.setX(x);
		this.setY(this.getRandomNumberParent() + this.getLowestOpening() - this.getHeight());
		System.out.println("RandomNumber btm :" + this.getRandomNumberParent());
		
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
	public void draw(SpriteBatch batch) {
		
		this.batch.begin();
        this.batch.draw(this.getBotTube(), this.getX(), this.getY());
        this.batch.end();
        
	}
	
	@Override
	public void move() {
		this.setX(this.getX() - this.getSpeed());
	}
	
	@Override
	public void dispose(SpriteBatch batch) {
		this.batch.dispose();
	}
}
