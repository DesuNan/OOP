package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndScene extends Scene {
	private Texture background;
	private Texture gameover;
	
	public EndScene (SceneManager sm, SpriteBatch batch) {
		super(sm, batch);
		this.updateGameStatus(GameState.End);
		background = new Texture("bg.png");
		gameover = new Texture("gameover.png");
	}
	
	@Override
	public void handleInput() {
		if(Gdx.input.justTouched()) {
			sm.set(new PlayScene(sm, batch));
			dispose(batch);
		}
	}
	
	@Override
	public void update(float dt) {
		handleInput();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(background, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		batch.draw(gameover, (GameLifeCycle.WIDTH / 2) - (gameover.getWidth() / 2), (GameLifeCycle.HEIGHT/2));
		batch.end();
	}
	
	@Override
	public void dispose(SpriteBatch batch) {
		gameover.dispose();
	}
	
}