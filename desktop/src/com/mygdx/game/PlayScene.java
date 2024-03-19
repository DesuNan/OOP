package com.mygdx.game;
import Scene.*;
import com.badlogic.gdx.Input;

public class PlayScene extends Scene {
	
	
	
	private SceneManager sm;
	
	public PlayScene (SceneManager sm) {
		super(sm);
		this.sm = sm;
		
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.Play);
		
		// sm.getPlayerManager().addPlayer(new Bird(100,100,12,"bird.png", sm.getPlayerManager()));
		// Bird is singleton
		
		sm.getPlayerManager().addPlayer(Bird.getInstance(sm.getPlayerManager(), 100,100,12,"bird.png",Input.Keys.SPACE));
		sm.getEntityManager().addEntity(new Tube(800 ,50,5, "bottomtube.png"));
		sm.getEntityManager().addEntity(new Tube(800 ,500,5, "toptube.png"));		

	}
	
	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		if(sm.getIOMan().isTouched()) {
			sm.set(new EndScene(sm));
		}
	}
	
	@Override
	public void update(float dt) {
		handleInput(this.sm);
	}
	
	@Override
	public void render(SceneManager sm) {
		sm.getIOMan().getBatch().draw(this.sm.getIOMan().getImage("bg.png"), 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		
		sm.getEntityManager().draw();
		sm.getPlayerManager().draw();
		sm.getCollisionManager().handleCollisions();
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeBatch();
	}
	
}