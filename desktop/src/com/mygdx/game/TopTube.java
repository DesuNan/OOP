package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TopTube  extends Entities {
	private Texture TopTubePic;
	
	public TopTube(float x, float y, float speed) {
		
		this.TopTubePic = new Texture("toptube.png");
		
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		
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
	public void draw(EntityManager em) {
		em.getIOMan().getBatch().draw(this.getTopTube(), this.getX(), this.getY());
	}
	
	@Override
	public void move() {
		this.setX(this.getX() - this.getSpeed());
	}
	
	
	@Override
	public void dispose(EntityManaager em) {
		em.getIOMan().disposeBatch();
	}
}

