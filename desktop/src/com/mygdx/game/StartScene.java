package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartScene extends Scene {
	private Texture background;
	private Texture startMessage;
	
	public StartScene (SceneManager sm, SpriteBatch batch) {
		super(sm, batch);
		background = new Texture("bg.png");
		startMessage = new Texture("message.png");
	}
	
	
	
	@Override
	public void update(float dt) {
		handleInput();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(background, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		batch.draw(startMessage, (GameLifeCycle.WIDTH / 2) - (startMessage.getWidth() / 2), (GameLifeCycle.HEIGHT/2) - 100);
		batch.end();
	}
	
	@Override
	public void handleInput() {
		if(Gdx.input.justTouched()) {
			sm.set(new PlayScene(sm, batch));
			dispose(batch);
		}
	}
	
	@Override
	public void dispose(SpriteBatch batch) {
		startMessage.dispose();
	}
	
}