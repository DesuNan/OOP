package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Player.Players;

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
		
		
		sm.getEntityManager().addEntity(new BotTube(800,25,5));
		sm.getEntityManager().addEntity(new TopTube(800,225,5));
		sm.getPlayerManager().addPlayer(new Players(100,100,12,"bird.png"));
		
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
			System.out.println("By, world!");
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
		
		
		/*
		batch.begin();
		batch.draw(background, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		entityManager.draw(batch);
		entityManager.moveAIControlled();
		entityManager.moveUserControlled();
		collisionManager.handleCollisions(entityManager.getEntityList());
		batch.end();
		*/
	}
	
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeBatch();
	}
	
}