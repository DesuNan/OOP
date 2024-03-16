package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import InputOutput.*;
import Scene.*;


public class GameLifeCycle extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 600;
	private SceneManager sm;
	private GameClock clock;
	private GameState GameStatus;
	private InputOutputManager ioman;
	
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
		this.ioman = new InputOutputManager();
		this.ioman.createBatch();
		sm = new SceneManager(ioman, this);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		sm.push(new StartScene(sm));
		this.clock = new GameClock();	
		
	}

	@Override
	public void render() {
		// update gamestate status according to scene
		this.ioman.startBatch();
		this.sm.render();
		this.sm.update(Gdx.graphics.getDeltaTime());
		this.ioman.stopBatch();
		
		/*
		this.updateStatus(sm.getCurrentGameStatus());
		
		// Clear screen each time before drawing
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(batch);
		this.clock.draw();
		
		
		// Check GameState and communicate with clock
		if (this.GameStatus == GameState.Start) {
			this.clock.resetClock();
		}
		else if (this.GameStatus == GameState.Play) {
			this.clock.start();
		}
		else if (this.GameStatus == GameState.End) {
			this.clock.stop();
		}
		*/

	}

	@Override
	public void dispose() {
		this.clock.dispose();	
		this.ioman.disposeBatch();
	}
}