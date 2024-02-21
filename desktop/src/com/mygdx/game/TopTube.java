package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TopTube extends Tubes {
	private Texture TopTubePic;
	private SpriteBatch batch = new SpriteBatch();
	
	public TopTube(float x, RandomGenerator rand) {
		super(x, rand);
		this.TopTubePic = new Texture("toptube.png");
		
		this.setX(x);
		this.setY(this.getRandomNumberParent() + this.getTubeGap() + this.getLowestOpening());
		System.out.println("RandomNumber top:" + this.getRandomNumberParent());
		
	}
	
	
	public Texture getTopTube() {
		return this.TopTubePic;
	}
	public void setTopTube(Texture pic) {
		this.TopTubePic = pic;
	}
	@Override
	public float getWidth() {
	    return TopTubePic.getWidth(); // or bottomTube.getWidth(), assuming they are the same
	}

	@Override
	public float getHeight() {
	    return TopTubePic.getHeight(); // Assuming you're checking collisions with one tube at a time
	}	
	
	@Override
	public void draw(SpriteBatch batch) {
		
		this.batch.begin();
		this.batch.draw(this.getTopTube(), this.getX(), this.getY());
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
