package com.mygdx.game;


import Scene.*;

public class EndScene extends Scene {
	
	
	
	public EndScene (SceneManager sm) {
		super(sm);
		// Set game State, for synchronisation
		this.updateGameStatus(GameState.End);
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		if(sm.getIOMan().isTouched()) {
			System.exit(0);
		}
	}
	
	@Override
	public void update(float dt) {
		handleInput(this.sm);
	}
	
	@Override
	public void render(SceneManager sm) {
		sm.getIOMan().getBatch().draw(sm.getIOMan().getImage("bg.png"), 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getIOMan().getBatch().draw(sm.getIOMan().getImage("gameover.png"), (GameLifeCycle.WIDTH / 2) - (sm.getIOMan().getWidth("gameover.png") / 2), (GameLifeCycle.HEIGHT/2));
		
	}
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeBatch();
	}
	
}