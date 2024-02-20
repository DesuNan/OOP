package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Bird extends Entities{
	private static final int GRAVITY = -15;
	private Vector3 position;
	private Vector3 velocity;
	private Texture bird;
	private SpriteBatch batch = new SpriteBatch();
	
	public Bird(int x, int y) {
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0,0,0);
		
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
	public void draw() {
		this.batch.begin();
		this.batch.draw(this.getBird(), this.getPosition().x, this.getPosition().y);
		this.batch.end();
	}
	
	@Override
	public void dispose() {
		this.batch.dispose();
	}
}