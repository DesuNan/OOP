package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tubes extends Entities {
	private static final int FLUCTUATION = 130;
	private static final int TUBE_GAP = 100;
	private static final int LOWEST_OPENING = 120;
	
	private Texture topTube, bottomTube;
	private Vector2 posTopTube, posBotTube;
	private Random rand;
    
    
    private SpriteBatch batch = new SpriteBatch();
    
    public Tubes(float x) {
		this.topTube = new Texture("toptube.png");
		this.bottomTube = new Texture("bottomtube.png");
		this.rand = new Random();
		this.setSpeed(3);
		this.setUserContolled(false);
		this.posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
		this.posBotTube = new Vector2(x, this.posTopTube.y - TUBE_GAP - this.bottomTube.getHeight());
	}
    
    public Texture getBottomTube() {
		return this.bottomTube;
	}
	public Texture getTopTube() {
		return this.topTube;
	}
	public Vector2 getPosTopTube() {
		return this.posTopTube;
	}
	public Vector2 getPosBottomTube() {
		return this.posBotTube;
	}
	
	public void setXPosTopTube(float position) {
		this.posTopTube.x = position;
	}
	
	public void setXPosBottomTube(float position) {
		this.posBotTube.x = position;
	}
	
	@Override
	public float getWidth() {
	    return topTube.getWidth(); // or bottomTube.getWidth(), assuming they are the same
	}

	@Override
	public float getHeight() {
	    return topTube.getHeight(); // Assuming you're checking collisions with one tube at a time
	}	

	
	@Override
	public void draw() {
		
		this.batch.begin();
		this.batch.draw(this.getTopTube(), this.getPosTopTube().x, this.getPosTopTube().y);
        this.batch.draw(this.getBottomTube(), this.getPosBottomTube().x, this.getPosBottomTube().y);
        this.batch.end();
        
	}
	
	@Override
	public void move() {
		System.out.println("x: "+ this.getX());
		System.out.println("speed: "+  this.getSpeed());
		this.setXPosBottomTube(this.getPosBottomTube().x - this.getSpeed());
		this.setXPosTopTube(this.getPosTopTube().x - this.getSpeed());
	}
	
	@Override
	public void dispose() {
		this.batch.dispose();
	}
}
