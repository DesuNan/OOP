package com.mygdx.game;


import Scene.*;

public class EndScene extends Scene {
	
	public EndScene (SceneManager sm) {
		super(sm);
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.End);
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
		//sm.getIOMan().displayText("Score: ", (GameLifeCycle.WIDTH/2) - 50 ,(GameLifeCycle.HEIGHT/2) - (sm.getIOMan().getHeight("gameover.png"))/2);
		sm.getPlayerManager().draw();
	}
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeBatch();
		sm.getPlayerManager().clearAll();
		sm.getEntityManager().clearAll();
		sm.getCollisionManager().clearAll();
		
	}
	
}