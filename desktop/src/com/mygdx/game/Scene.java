package com.mygdx.game;



public class Scene {
	private String Name;
	private String AudioPath;
	private GameState GameStatus;

	
    public Scene(String Name) {
    	this.Name = Name;
    }
	
	public String getName () {
		return this.Name;
	}
	
	public String getAudio() {
		return this.AudioPath;
	}
	
	public GameState getGameStatus() {
		return this.GameStatus;
	}
	
	public void updateName (String Name) {
		this.Name = Name;
	}
	
	public void updateAudio (String Audio) {
		this.AudioPath = Audio;
	}
	
	public void updateGameStatus (GameState Status) {
		this.GameStatus = Status;
	}
	
	public void draw() {
		
	}
	
	
	
}
