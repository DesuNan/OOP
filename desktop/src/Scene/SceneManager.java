package Scene;

import java.util.*;
import Collision.*;
import InputOutput.*;
import Player.*;
import com.mygdx.game.*;
import Entity.*;

public class SceneManager {
	private Stack<Scene> scenes; 
	private Stack<iSwapScene> iSwapScene;
	private EntitiesManager entityManager;
	private InputOutputManager ioman;
	private PlayersManager playerManager;
	private CollisionManager collisionManager;
	private GameLifeCycle gm;
	
	// Saves Scenes in a stack, reading the top of the stack.
	public SceneManager(InputOutputManager ioman, GameLifeCycle gm){
		this.ioman = ioman;
		this.gm = gm;
		scenes = new Stack<Scene>();
		this.iSwapScene = new Stack<iSwapScene>();
		this.collisionManager = new CollisionManager(this);
		this.entityManager = new EntitiesManager(ioman, collisionManager);
		this.playerManager = new PlayersManager(ioman, collisionManager, this);
	
	}
	public GameLifeCycle getGameLifeCycle() {
		return this.gm;
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
	
	public EntitiesManager getEntityManager() {
		return this.entityManager;
	}
	
	public void setEntityManager(EntitiesManager em) {
		this.entityManager = em;
	}
	
	public void push(Scene scene) {
		scenes.push(scene);
		if (scene instanceof iSwapScene) {
			iSwapScene.push((iSwapScene) scene);
        }
	}
	
	public void pop() {
		scenes.pop();
		iSwapScene.pop();
	}
	
	public void set(Scene scene) {
		this.pop();
		this.push(scene);
		
	}
	
	public void update(float dt) {
		scenes.peek().update(dt);
	}
	
	public void render() {
		scenes.peek().render(this);
	}
	
	public void dispose() {
		scenes.peek().dispose(this);
	}
}
