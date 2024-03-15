package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;


public class StartScene extends Scene {
	private Texture background;
	private Texture startMessage;
	
	
	public StartScene (SceneManager sm) {
		super(sm);
		background = this.sm.getIOMan().getImage("bg.png");
		startMessage = this.sm.getIOMan().getImage("message.png");
		this.updateGameStatus(GameState.Start);
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		if(sm.getIOMan().isTouched()) {
			sm.set(new PlayScene(sm));
		}
	}
	
	@Override
	public void update(float dt) {
		this.handleInput(this.sm);
	}
	
	@Override
	public void render(SceneManager sm) {
		sm.getIOMan().getBatch().draw(background, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getIOMan().getBatch().draw(startMessage, (GameLifeCycle.WIDTH / 2) - (startMessage.getWidth() / 2), (GameLifeCycle.HEIGHT/2) - 100);
		
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
		this.sm.getIOMan().disposeBatch();
	}

	
	
}