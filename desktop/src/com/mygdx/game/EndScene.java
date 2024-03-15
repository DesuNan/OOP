package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;


public class EndScene extends Scene {
	private Texture background;
	private Texture gameover;
	
	public EndScene (SceneManager sm) {
		super(sm);
		// this.updateGameStatus(GameState.End);
		background = sm.getIOMan().getImage("bg.png");
		gameover = sm.getIOMan().getImage("gameover.png");
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
		sm.getIOMan().getBatch().draw(background, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getIOMan().getBatch().draw(gameover, (GameLifeCycle.WIDTH / 2) - (gameover.getWidth() / 2), (GameLifeCycle.HEIGHT/2));
		
	}
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeBatch();
	}
	
}