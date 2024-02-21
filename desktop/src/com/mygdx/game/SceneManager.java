package com.mygdx.game;
import java.util.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SceneManager {
	private Stack<Scene> scenes; 
	private GameState currentStatus;
	
	
	// Saves Scenes in a stack, reading the top of the stack.
	public SceneManager(){
		scenes = new Stack<Scene>();
		
	}
	
	public GameState getCurrentGameStatus() {
		return this.currentStatus;
	}
	
	public void updateCurrentGameStatus(GameState gameStatus) {
		this.currentStatus = gameStatus;
	}
	
	public void push(Scene scene) {
		scenes.push(scene);
	}
	
	public void pop() {
		scenes.pop();
	}
	
	public void set(Scene scene) {
		scenes.pop();
		scenes.push(scene);
		this.currentStatus = scene.getGameStatus();
	}
	
	public void update(float dt) {
		scenes.peek().update(dt);
	}
	
	public void render(SpriteBatch batch) {
		scenes.peek().render(batch);
	}
}
