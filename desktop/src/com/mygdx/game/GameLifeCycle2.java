package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import InputOutput.*;
import Player.PlayersManager;
import Player.Players;


public class GameLifeCycle2 extends ApplicationAdapter {
	private InputOutputManager ioman;
	private PlayersManager pm;
	
	@Override
	public void create() {
		this.ioman = new InputOutputManager();
		this.pm = new PlayersManager(ioman);
		ioman.createBatch();
		
		pm.addPlayer(new Players(100,100,2,"bucket.png"));
		
	}
	
	@Override
	public void render() {
		
		ioman.startBatch();
		Gdx.gl.glClearColor(256, 256, 100, 100);
		pm.draw(ioman);
		pm.handleInput(ioman, Gdx.graphics.getDeltaTime());
		ioman.stopBatch();
	}
	
	@Override
	public void dispose() {
		ioman.disposeBatch();
	}
		

}
