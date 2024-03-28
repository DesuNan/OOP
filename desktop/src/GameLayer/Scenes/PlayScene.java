package GameLayer.Scenes;
import com.badlogic.gdx.Input;

import GameEngine.*;
import GameEngine.GameLifecycle.GameLifeCycle;
import GameEngine.GameLifecycle.GameState;
import GameEngine.InputOutput.InputOutputManager;
import GameEngine.Scene.Scene;
import GameEngine.Scene.SceneManager;
import GameEngine.Scene.SceneType;
import GameLayer.AIEntities.Tube;
import GameLayer.AIEntities.Factories.BadEntityFactory;
import GameLayer.AIEntities.Factories.GoodEntityFactory;
import GameLayer.Player.Bird;

public class PlayScene extends Scene {
	
	

	private GoodEntityFactory gf;
	private BadEntityFactory bf;

	public PlayScene (InputOutputManager ioman, GameLifeCycle gm, SceneManager sm) {
		super(sm);
		
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.Play);
		
		this.gf = new GoodEntityFactory(sm, 1);
		this.bf = new BadEntityFactory(sm, 1); 
		
		this.gf.drawEntities();
		this.bf.drawEntities();
		
		sm.getPlayerManager().addPlayer(Bird.getInstance(sm.getPlayerManager(), 100,250,12,"Player.png",Input.Keys.SPACE));
		sm.getEntityManager().addEntity(new Tube(800 ,-100 ,5 , "bottomtube.png"));
		sm.getIOMan().playMusic("01 game-game_0.ogg");
		
		
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		if(sm.getIOMan().isTouched()) {
			//sm.dispose();
			sm.set(SceneType.END_SCENE);
		}
	}
	
	@Override
	public void update(float dt) {
		handleInput(this.sm);
	}
	
	@Override
	public void render(SceneManager sm) {
		
		sm.getIOMan().draw("bg.png", 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getEntityManager().draw();
		sm.getPlayerManager().draw();
		sm.getCollisionManager().handleCollision();
	}
	 
	
	@Override
	public void dispose(SceneManager sm) {
	sm.getIOMan().disposeTexture("bg.png");
//sm.dispose();
	}
	
}