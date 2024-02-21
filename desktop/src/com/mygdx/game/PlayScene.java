package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayScene extends Scene {
	private int TUBE_SPACING = 200;
	private int TUBE_COUNT = 5;
	private int TUBE_START = 500;
	private int TUBE_END;
	
	private Texture background;
	private EntityManager entityManager;
	private CollisionManager collisionManager;
	
	
	public PlayScene (SceneManager sm, SpriteBatch batch) {
		super(sm, batch);
		background = new Texture("bg.png");
		entityManager = new EntityManager();
		entityManager.addEntity(new Bird(100, 100));
		collisionManager = new CollisionManager(sm, batch);

		TUBE_END = TUBE_START + (TUBE_COUNT - 1) * TUBE_SPACING;

		for (int i = 1; i < TUBE_COUNT; i++) {
			
			RandomGenerator rand = new RandomGenerator(123);
			entityManager.addEntity(new TopTube(TUBE_START + i * TUBE_SPACING, rand));
			entityManager.addEntity(new BotTube(TUBE_START + i * TUBE_SPACING, rand));
		}
	}
	
	@Override
	public void handleInput() {
		
	}
	
	@Override
	public void update(float dt) {
		handleInput();

	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(background, 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		entityManager.draw(batch);
		entityManager.moveAIControlled();
		entityManager.moveUserControlled();
		collisionManager.handleCollisions(entityManager.getEntityList());
		batch.end();
	}
	
	@Override
	public void dispose(SpriteBatch batch) {
		entityManager.dispose(batch);
	}
	
}