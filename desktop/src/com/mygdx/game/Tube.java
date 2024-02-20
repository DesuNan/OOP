package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Tube extends Entity{
	private static final int FLUCTUATION = 130;
	private static final int TUBE_GAP = 100;
	private static final int LOWEST_OPENING = 120;
	private Texture topTube, bottomTube;
	private Vector2 posTopTube, posBotTube;
	private Random rand;
    private Tube tube;
    private SpriteBatch batch = new SpriteBatch();

	
	public Tube(float x) {
		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");
		rand = new Random();
		
		posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
		posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
	}
	public Texture getBottomTube() {
		return bottomTube;
	}
	public Texture getTopTube() {
		return topTube;
	}
	public Vector2 getPosTopTube() {
		return posTopTube;
	}
	public Vector2 getPosBottomTube() {
		return posBotTube;
	}
	/*@Override
	public void draw(ShapeRenderer shapeRenderer) {
		// TODO Auto-generated method stub
	}
	*/
	@Override
	public void draw() {
       System.out.println("Hello123:" );
/*
		batch.begin();
		batch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        batch.draw(tube.getBottomTube(), tube.getPosBottomTube().x, tube.getPosBottomTube().y);
        batch.end();
  */
		//this.batch.begin();
		//this.batch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        //this.batch.draw(tube.getBottomTube(), tube.getPosBottomTube().x, tube.getPosBottomTube().y);
        //this.batch.end();
	}
	
	@Override
    public void moveAIControlled() {
    	// Implement AI-controlled movement logic for TextureObject
        // Update the x and y positions based on AI-controlled movement
        y += Gdx.graphics.getDeltaTime() * speed;
    }
}
