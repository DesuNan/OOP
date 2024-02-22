package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene {
	private GameState GameStatus;
	protected SceneManager sm;
	protected SpriteBatch batch;

    public Scene(SceneManager sm, SpriteBatch batch) {
    	this.sm = sm;
    	this.batch = batch;
    	
    }
    
    protected abstract void handleInput();
    
    public abstract void update(float dt);
    
    public abstract void render(SpriteBatch batch);
    
    public abstract void dispose(SpriteBatch batch);
	
	
	public GameState getGameStatus() {
		return this.GameStatus;
	}
	
	
	public void updateGameStatus (GameState Status) {
		this.GameStatus = Status;
	}
	
}