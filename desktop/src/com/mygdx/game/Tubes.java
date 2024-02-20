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
	@Override
	public void draw() {
		
		this.batch.begin();
		this.batch.draw(this.getTopTube(), this.getPosTopTube().x, this.getPosTopTube().y);
        this.batch.draw(this.getBottomTube(), this.getPosBottomTube().x, this.getPosBottomTube().y);
        this.batch.end();
        
	}
	
	@Override
	public void dispose() {
		this.batch.dispose();
	}
}
