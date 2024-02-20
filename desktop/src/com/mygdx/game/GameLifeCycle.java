package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
public class GameLifeCycle extends ApplicationAdapter{

private GameState GameStatus;
private EntityManager EntityManager;
private SceneManager SceneManager;
private GameClock clock;

private SpriteBatch batch;
private BitmapFont font;

private Stage stage;
private Skin skin;
// Constructor
public GameLifeCycle () {
	this.GameStatus = GameState.Start;
	this.SceneManager = new SceneManager();
}


//Getters 
public GameState getStatus() {
	return this.GameStatus;
}


//Setters
public void updateStatus (GameState status) {
	this.GameStatus = status;
}


@Override
public void create() {

	this.clock = new GameClock();	
	batch = new SpriteBatch();
	font = new BitmapFont();
  
	this.clock = new GameClock();
}

@Override
public void render() {
	ScreenUtils.clear(3, 3, 0.2f, 1);
	this.clock.draw();
	if (this.GameStatus == GameState.Play) {
		this.clock.start();
	}
	
	
	// draw scene
	this.batch.begin();
	this.font.draw(this.batch, SceneManager.getCurrentScene().getName(), 20,100);
	this.batch.end();

	
}

@Override 
public void dispose() {
	this.clock.dispose();	
	this.batch.dispose();
	this.font.dispose();

}

}
