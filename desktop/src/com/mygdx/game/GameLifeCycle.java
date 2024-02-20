package com.mygdx.game;

import java.util.Random;
import java.util.List;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.mygdx.game.CollisionManager;
import com.mygdx.game.Entities;
import com.mygdx.game.EntityManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import java.util.ArrayList;
import java.util.List;

public class GameLifeCycle extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 600;
	private SceneManager sm;
	private SpriteBatch batch;
	
	private Bird bird;
	private Texture topTube;
	private Texture bottomTube;

	private ShapeRenderer shapeRenderer;
	private EntityManager entityManager;
	private Tubes tubes;

	

	
	/*
	 * public class TextureObject extends Entities {
	 * 
	 * private Texture texture; private boolean aiControlled; private float startY;
	 * 
	 * public TextureObject(String filename, float[] properties, boolean
	 * aiControlled) { super(properties[0], properties[1], properties[2], true);
	 * this.texture = new Texture(Gdx.files.internal(filename)); this.aiControlled =
	 * aiControlled; this.startY = properties[1]; }
	 * 
	 * public TextureObject(String string, int i) { // TODO Auto-generated
	 * constructor stub }
	 * 
	 * @Override public void move() { if (aiControlled) { moveAIControlled(); } else
	 * { moveUserControlled(); } }
	 * 
	 * @Override public void moveAIControlled() { // Implement the AI-controlled
	 * movement logic for the droplet
	 * 
	 * // Example: Move downward x -= Gdx.graphics.getDeltaTime() * speed;
	 * 
	 * // Optional: Adjust the logic based on your requirements if (x <= 0) { //
	 * Reset to the top when reaching the bottom edge x = Gdx.graphics.getHeight();
	 * } }
	 * 
	 * 
	 * @Override public void draw(ShapeRenderer shapeRenderer) {
	 * shapeRenderer.setColor(Color.WHITE); shapeRenderer.rect(x, y,
	 * texture.getWidth(), texture.getHeight()); }
	 * 
	 * @Override public void draw() {
	 * 
	 * }
	 * 
	 * public void dispose() { texture.dispose(); } }
	 */

	@Override
	public void create() {
		batch = new SpriteBatch();
		sm = new SceneManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		sm.push(new StartScene(sm, batch));
	}

	@Override
	public void render() {
		// Clear screen each time before drawing
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(batch);
		

	}

	@Override
	public void dispose() {
		
	}
}