package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Bird extends Entities{

	private Texture bird;
	
	public Bird(float x, float y) {
		this.setX(x);
		this.setY(y);
		
		this.setSpeed(250);
		bird = new Texture("bird.png");
	}
	
	public Texture getBird() {
		return bird;
	}
	
	@Override
	public float getWidth() {
	    return bird.getWidth();
	}

	@Override
	public float getHeight() {
	    return bird.getHeight();
	}
	
	@Override
	public void draw(EntityManager em) {
		em.getIOMan().getBatch().draw(this.getBird(), this.getX(), this.getY());
	}
	
	
	@Override
	public void dispose(EntityManager em) {
		em.getIOMan().disposeBatch();
	}
}
