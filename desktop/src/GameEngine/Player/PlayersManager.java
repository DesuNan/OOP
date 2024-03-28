package GameEngine.Player;

import java.util.*;
import GameEngine.Collision.CollisionManager;
import GameEngine.Collision.iCollision;
import GameEngine.InputOutput.InputOutputManager;
import GameEngine.Scene.SceneManager;

public class PlayersManager {
	private InputOutputManager ioman;
	private CollisionManager cm;
	private SceneManager sm;
	private List<Players> players;
	private List<playerMoveable> imovables;
	
	public PlayersManager (InputOutputManager ioman, CollisionManager cm, SceneManager sm) {
		this.ioman = ioman;
		this.cm = cm;
		this.sm = sm;
		this.players = new ArrayList<>();
		this.imovables = new ArrayList<>();
		this.ioman.setPlayerManager(this);
	}
	public SceneManager getSceneManager () {
		return this.sm;
	}
	
	public InputOutputManager getIOMan() {
		return this.ioman;
	}
	
	// Method to add a player to the list
    public void addPlayer(Players player) {
        players.add(player);
        if (player instanceof playerMoveable) {
            imovables.add((playerMoveable) player);
        }
        if(player instanceof iCollision) {
        	cm.addCollidable((iCollision) player);
        }
    }

    // Method to remove a player from the list
    public void removePlayer(Players player) {
        players.remove(player);
        if (player instanceof playerMoveable) {
            imovables.remove((playerMoveable) player);
        }
    }
    
    public void clearAll () {
    	this.getAllMoveables().clear();
    	this.getAllPlayers().clear();
    }

    // Method to get all players
    public List<Players> getAllPlayers() {
        return players;
    }
	
    public List<playerMoveable> getAllMoveables() {
        return imovables;
    }
    
    public void draw() {
    	for (Players players: players) {
    		players.draw(this);
    	}
    	
    	this.handleInput(this);
    	this.handleGravity(this);
    }
    
    public void handleInput(PlayersManager pm) {
    	
    	
    	for (playerMoveable imove: imovables) {
    		imove.handleMovement(pm);
    	}
    }
    
    public void handleGravity (PlayersManager pm) {
    	for (playerMoveable imove: imovables) {
    		imove.handleGravity(pm);
    	}
    }
    
    public void dispose() {
    	for (Players players: players) {
    		players.dispose(this);
    	}
    }
   
}
