package com.mygdx.game;
import Scene.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class PlayScene extends Scene {
	
	private int screenWidth;
	private int screenHeight;
	private Texture bg_texture;

	public PlayScene (SceneManager sm) {
		super(sm);
		final int screenWidth = 0;
		final int screenHeight = 0;
		
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.Play);
		
		// sm.getPlayerManager().addPlayer(new Bird(100,100,12,"bird.png", sm.getPlayerManager()));
		// Bird is singleton
		
		sm.getPlayerManager().addPlayer(Bird.getInstance(sm.getPlayerManager(), 100,250,12,"Player.png",Input.Keys.SPACE));
		sm.getEntityManager().addEntity(new Tube(800 ,-100 ,5 , "bottomtube.png"));
		sm.getEntityManager().addEntity(new Tube(800 ,500,5, "toptube.png"));
		
		spawnDanger(5);
		spawnGood(5);
		spawnHealth(3);
	}
	
	public void spawnGood(int count) {
		Random random = new Random();
		int startY = 0;

	    int x = 800;
	    int spaceX = 50;
	    
		for (int i = 0; i < count; i++) {
			x = x + i * spaceX;
		    int Posy = random.nextInt(600);
		    int speed = random.nextInt(9)+2;
			sm.getEntityManager().addEntity(new Danger(x ,Posy , speed, "Apple.png"));
		}
		
		for (int i = 0; i < count; i++) {
			x = x + i * spaceX;
		    int Posy = random.nextInt(600);
		    int speed = random.nextInt(9)+2;
			sm.getEntityManager().addEntity(new Danger(x ,Posy , speed, "Brocolli.png"));
		}
	}
	
	
	public void spawnDanger(int count) {
		Random random = new Random();
		int startY = 0;

	    int x = 800;
	    int spaceX = 50;
	    
		for (int i = 0; i < count; i++) {
			x = x + i * spaceX;
		    int Posy = random.nextInt(600);
		    int speed = random.nextInt(9)+2;
			sm.getEntityManager().addEntity(new Danger(x ,Posy , speed, "Burger.png"));
		}
		
		for (int i = 0; i < count; i++) {
			x = x + i * spaceX;
		    int Posy = random.nextInt(600);
		    int speed = random.nextInt(9)+2;
			sm.getEntityManager().addEntity(new Danger(x ,Posy , speed, "Fries.png"));
		}
	}
	
	public void spawnHealth(int count) {
		int starX = 300;
		int spaceX = 50;
		int y = 0;
		
		for (int i = 0; i < count; i++) {
			int x = starX + i * spaceX;
			sm.getEntityManager().addEntity(new Danger(x ,y , 0, "Heart.png"));
		}
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		if(sm.getIOMan().isTouched()) {
			sm.set(new EndScene(sm));
			dispose(sm);
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
		bg_texture = sm.getIOMan().getImage("bg.png");
		sm.getIOMan().getBatch().draw(bg_texture, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getEntityManager().draw();
		sm.getPlayerManager().draw();
		sm.getCollisionManager().handleCollisions();
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
//		sm.getIOMan().disposeBatch();
		bg_texture.dispose();
		sm.getPlayerManager().dispose();
		sm.getEntityManager().dispose();
	}
	
}