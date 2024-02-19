package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameLifeCycle extends ApplicationAdapter{
private int GameStatus;
private Timer GameTime;
private EntityManager EntityManager;
private SceneManager SceneManager;

// Constructor
public GameLifeCycle () {
	
}


//Getters 
public int getStatus() {
	return this.GameStatus;
}


//Setters
public void updateStatus (int status) {
	this.GameStatus = status;
}


@Override
public void create() {
	
}

@Override
public void render() {
	ScreenUtils.clear(3, 3, 0.2f, 1);
}

@Override 
public void dispose() {
	
}

}
