package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Bird extends Entities{
	private static final int GRAVITY = -15;
	private Vector3 position;
	private Vector3 velocity;
	private Texture bird;
	private SpriteBatch batch = new SpriteBatch();
	
	public Bird(int x, int y) {
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0,0,0);
		this.setUserContolled(true);
		this.setSpeed(250);
		bird = new Texture("bucket.png");
	}
	
	public void update(float dt) {
		velocity.add(0, GRAVITY, 0);
		velocity.scl(dt);
		position.add(0, velocity.y, 0);
		velocity.scl(1/dt);
	}
	public Vector3 getPosition() {
		return position;
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
	public void move() {
		
		if (Gdx.input.isKeyPressed(Keys.UP)) {
        	this.setY(this.getY() + Gdx.graphics.getDeltaTime() * this.getSpeed());
        }
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
        	this.setY(this.getY() - Gdx.graphics.getDeltaTime() * this.getSpeed());
        }
    }
	@Override
	public void draw() {
		this.batch.begin();
		this.batch.draw(this.getBird(), this.getX(), this.getY());
		this.batch.end();
	}
	
	
	@Override
	public void dispose() {
		this.batch.dispose();
	}
}
