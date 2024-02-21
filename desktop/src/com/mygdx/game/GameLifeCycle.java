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


public class GameLifeCycle extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 600;
	private SceneManager sm;
	private SpriteBatch batch;
	private GameClock clock;
	private GameState GameStatus;
	
	public GameLifeCycle () {
		this.GameStatus = GameState.Start;
	}

	public GameState getStatus() {
		return this.GameStatus;
	}
	
	public void updateStatus (GameState status) {
		this.GameStatus = status;
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		sm = new SceneManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		sm.push(new StartScene(sm, batch));
		this.clock = new GameClock();	
		
	}

	@Override
	public void render() {
		this.updateStatus(sm.getCurrentGameStatus());
		// Clear screen each time before drawing
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(batch);
		this.clock.draw();
		
		
		
		if (this.GameStatus == GameState.Start) {
			this.clock.resetClock();
		}
		else if (this.GameStatus == GameState.Play) {
			this.clock.start();
		}
		else if (this.GameStatus == GameState.End) {
			this.clock.stop();
		}
		

	}

	@Override
	public void dispose() {
		this.clock.dispose();	
	}
}