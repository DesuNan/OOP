package Player;

import java.util.*;

import InputOutput.InputOutputManager;

public class PlayersManager{
	private InputOutputManager ioman;
	private List<Players> players;
	private List<playerMoveable> imovables;
	
	public PlayersManager (InputOutputManager ioman) {
		this.ioman = ioman;
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
    
    public void draw(InputOutputManager ioman) {
    	for (Players players: players) {
    		ioman.getBatch().draw(ioman.getImage(players.getImage()),players.getX(),players.getY());
    	}
    }
    
    public void handleInput(InputOutputManager ioman, float dt) {
    	
    	for (playerMoveable imove: imovables) {
    		imove.handleMovement(ioman, dt);
    	}
    }
    
	
	
}
