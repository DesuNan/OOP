package com.mygdx.game;
import java.util.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import InputOutput.*;
import Player.*;

public class SceneManager {
	private Stack<Scene> scenes; 
	private Stack<iInput> iInputs;
	private GameState currentStatus;
	private EntityManager entityManager;
	private InputOutputManager ioman;
	private PlayersManager playerManager;
	private CollisionManager collisionManager;
	
	// Saves Scenes in a stack, reading the top of the stack.
	public SceneManager(InputOutputManager ioman){
		this.ioman = ioman;
		scenes = new Stack<Scene>();
		this.iInputs = new Stack<iInput>();
		this.collisionManager = new CollisionManager(this);
		this.entityManager = new EntityManager(ioman, collisionManager);
		this.playerManager = new PlayersManager(ioman, collisionManager);
		
		
	
	}
	public CollisionManager getCollisionManager() {
		return this.collisionManager;
	}
	public InputOutputManager getIOMan() {
		return this.ioman;
	}
	
	public PlayersManager getPlayerManager() {
		return this.playerManager;
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}
	
	public GameState getCurrentGameStatus() {
		return this.currentStatus;
	}
	
	public void updateCurrentGameStatus(GameState gameStatus) {
		this.currentStatus = gameStatus;
	}
	
	public void push(Scene scene) {
		scenes.push(scene);
		if (scene instanceof iInput) {
        	iInputs.push((iInput) scene);
        }
	}
	
	public void pop() {
		scenes.pop();
		iInputs.pop();
	}
	
	public void set(Scene scene) {
		this.pop();
		this.push(scene);
		this.currentStatus = scene.getGameStatus();
	}
	
	public void update(float dt) {
		scenes.peek().update(dt);
	}
	
	public void render() {
		scenes.peek().render(this);
	}
}
