package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import Scene.*;
import com.badlogic.gdx.Input;


public class StartScene extends Scene {
	private Texture bg_texture;
	private Texture message_texture;
	
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
			dispose(sm);
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
		bg_texture = sm.getIOMan().getImage("bg.png");
		message_texture = sm.getIOMan().getImage("message.png");
		sm.getIOMan().getBatch().draw(bg_texture, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getIOMan().getBatch().draw(message_texture, (GameLifeCycle.WIDTH / 2) - (sm.getIOMan().getWidth("message.png") / 2), (GameLifeCycle.HEIGHT/2) - 100);
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
		bg_texture.dispose();
		message_texture.dispose();
//		this.sm.getIOMan().disposeBatch();
	}

	
	
}