package com.mygdx.game;
import java.util.ArrayList;
import Collision.*;
import Scene.*;
import java.util.List;
import Entity.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import Player.Players;
import com.badlogic.gdx.Input;
public class PlayScene extends Scene {
	private int TUBE_SPACING = 200;
	private int TUBE_COUNT = 5;
	private int TUBE_START = 500;
	private int TUBE_END;
	
	private Texture background;
	// private EntityManager entityManager;
	// private CollisionManager collisionManager;
	private SceneManager sm;
	
	public PlayScene (SceneManager sm) {
		super(sm);
		this.sm = sm;
		background = this.sm.getIOMan().getImage("bg.png");
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.Play);
		
		sm.getPlayerManager().addPlayer(new Bird(100,100,12,"bird.png", new ArrayList<>(List.of(Input.Keys.UP))));
	
		sm.getEntityManager().addEntity(new Tube(800 ,50,5, "bottomtube.png"));

		sm.getEntityManager().addEntity(new Tube(800 ,500,5, "toptube.png"));		/*

		sm.getEntityManager().addEntity(new Tube(800 ,500,5, "toptube.png"));
		// sm.getIOMan().playMusic("tic-toc-suspenso-7312.mp3");
		/*

		entityManager = sm.getEntityManager();
		entityManager.addEntity(new Bird(100, 100));
		
		collisionManager = new CollisionManager(sm, batch);
		this.updateGameStatus(GameState.Play);

		TUBE_END = TUBE_START + (TUBE_COUNT - 1) * TUBE_SPACING;

		for (int i = 1; i < TUBE_COUNT; i++) {
			
			RandomGenerator rand = new RandomGenerator();
			entityManager.addEntity(new TopTube(TUBE_START + i * TUBE_SPACING, rand));
			entityManager.addEntity(new BotTube(TUBE_START + i * TUBE_SPACING, rand));
		}
		*/
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
		sm.getIOMan().getBatch().draw(background, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		
		sm.getEntityManager().draw();
		sm.getPlayerManager().draw();
		sm.getCollisionManager().handleCollisions();
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeBatch();
	}
	
}