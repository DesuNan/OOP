package com.mygdx.game;

import java.util.*;

public class SceneManager {
	private List<Scene> SceneList = new ArrayList<Scene>();
	private Scene CurrentScene;
	
	public SceneManager () {
		this.addScene(new Scene("Start"));
		this.updateCurrentScene(this.getSceneList().get(0));
	}
	public List<Scene> getSceneList () {
		return SceneList;
	}
	
	public Scene getCurrentScene() {
		return this.CurrentScene;
	}

	public void addScene(Scene scene) {
		SceneList.add(scene);
		
	}
	
	public void deleteScene(Scene scene) {
		SceneList.remove(scene);
	}
	
	public void updateCurrentScene(Scene scene) {
		this.CurrentScene = scene;
	}
	
	
}
