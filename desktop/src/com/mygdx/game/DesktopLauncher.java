package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

import GameEngine.GameLifecycle.GameLifeCycle;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		config.setForegroundFPS(60);
		config.setTitle("My Flappy Game");
		new Lwjgl3Application(new GameLifeCycle(), config);
	}
}
