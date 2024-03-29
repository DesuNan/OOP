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
		this.sm.getIOMan().playMusic("one.mp3");
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		if(sm.getIOMan().isTouched()) {
			sm.dispose();
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
		sm.getIOMan().draw("bg.png", 0, 0, (float) GameLifeCycle.WIDTH, (float)GameLifeCycle.HEIGHT);
		sm.getIOMan().draw("message.png", (GameLifeCycle.WIDTH / 2) - (sm.getIOMan().getWidth("message.png") / 2),(float) (GameLifeCycle.HEIGHT/2) - 100);
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeTexture("bg.png");
		sm.getIOMan().disposeTexture("message.png");
	}
	
	
}