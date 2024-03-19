package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import Scene.*;
import com.badlogic.gdx.Input;


public class StartScene extends Scene {
	
	public StartScene (SceneManager sm) {
		super(sm);
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.Start);
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		if(sm.getIOMan().isTouched()) {
			sm.set(new PlayScene(sm));
		}
		if(sm.getIOMan().keyPressOnce(Input.Keys.UP)) {
			this.sm.getGameLifeCycle().updateStatus(GameState.Pause);
		};
	}
	
	@Override
	public void update(float dt) {
		this.handleInput(this.sm);
	}
	
	@Override
	public void render(SceneManager sm) {
		sm.getIOMan().getBatch().draw(sm.getIOMan().getImage("bg.png"), 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getIOMan().getBatch().draw(sm.getIOMan().getImage("message.png"), (GameLifeCycle.WIDTH / 2) - (sm.getIOMan().getWidth("message.png") / 2), (GameLifeCycle.HEIGHT/2) - 100);
		
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
		this.sm.getIOMan().disposeBatch();
	}

	
	
}