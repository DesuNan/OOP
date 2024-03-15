package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene implements iInput {
	private GameState GameStatus;
	protected SceneManager sm;

    public Scene(SceneManager sm) {
    	this.sm = sm;    	
    }
    
    // public abstract void handleInput(SceneManager sm);
    
    public abstract void update(float dt);
    
    public abstract void render(SceneManager sm);
    
    public abstract void dispose(SceneManager sm);
	
	
	public GameState getGameStatus() {
		return this.GameStatus;
	}
	
	
	public void updateGameStatus (GameState Status) {
		this.GameStatus = Status;
	}
	
}