package com.mygdx.game;
import Scene.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class PlayScene extends Scene {
	
	private int screenWidth;
	private int screenHeight;
	private Texture bg_texture;
	private GoodEntityFactory gf;
	private BadEntityFactory bf;

	public PlayScene (SceneManager sm) {
		super(sm);
		final int screenWidth = 0;
		final int screenHeight = 0;
		
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.Play);
		
		this.gf = new GoodEntityFactory(sm, 1);
		this.bf = new BadEntityFactory(sm, 1); 
		
		this.gf.drawEntities();
		this.bf.drawEntities();
		
		sm.getPlayerManager().addPlayer(Bird.getInstance(sm.getPlayerManager(), 100,250,12,"Player.png",Input.Keys.SPACE));
		sm.getEntityManager().addEntity(new Tube(800 ,-100 ,5 , "bottomtube.png"));
		sm.getIOMan().playMusic("01 game-game_0.ogg");
//sm.getEntityManager().addEntity(new Tube(800 ,500,5, "toptube.png"));
		
		
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		if(sm.getIOMan().isTouched()) {
			//sm.dispose();
			sm.set(new EndScene(sm));
		}
		if(sm.getIOMan().keyPressOnce(Input.Keys.UP)) {
			this.sm.getGameLifeCycle().updateStatus(GameState.Pause);
		};
	}
	
	@Override
	public void update(float dt) {
		handleInput(this.sm);
	}
	
	@Override
	public void render(SceneManager sm) {
		
		sm.getIOMan().draw("bg.png", 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getEntityManager().draw();
		sm.getPlayerManager().draw();
		sm.getCollisionManager().handleCollisions();
	}
	 
	
	@Override
	public void dispose(SceneManager sm) {
	sm.getIOMan().disposeTexture("bg.png");
//sm.dispose();
	}
	
}