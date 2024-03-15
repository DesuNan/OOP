package Player;

import java.util.*;

import com.mygdx.game.CollisionManager;
import com.mygdx.game.iCollision;

import InputOutput.InputOutputManager;

public class PlayersManager{
	private InputOutputManager ioman;
	private CollisionManager cm;
	private List<Players> players;
	private List<playerMoveable> imovables;
	
	public PlayersManager (InputOutputManager ioman, CollisionManager cm) {
		this.ioman = ioman;
		this.cm = cm;
		this.players = new ArrayList<>();
		this.imovables = new ArrayList<>();
		this.ioman.setPlayerManager(this);
	}
	
	public InputOutputManager getIOManager() {
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

    // Method to get all players
    public List<Players> getAllPlayers() {
        return players;
    }
	
    public List<playerMoveable> getAllMoveables() {
        return imovables;
    }
    
    public void draw() {
    	for (Players players: players) {
    		this.ioman.getBatch().draw(this.ioman.getImage(players.getImage()),players.getX(),players.getY());
    	}
    	this.handleInput(ioman);
    }
    
    public void handleInput(InputOutputManager ioman) {
    	for (playerMoveable imove: imovables) {
    		imove.handleMovement(ioman);
    	}
    }
   
}
