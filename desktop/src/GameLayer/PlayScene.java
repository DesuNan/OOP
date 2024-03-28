package GameLayer;
import com.badlogic.gdx.Input;

import GameEngine.*;

public class PlayScene extends Scene {
	
	

	private GoodEntityFactory gf;
	private BadEntityFactory bf;

	public PlayScene (SceneManager sm) {
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
			sm.set(new EndScene(sm));
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
		sm.getCollisionManager().handleCollisions();
	}
	 
	
	@Override
	public void dispose(SceneManager sm) {
	sm.getIOMan().disposeTexture("bg.png");
//sm.dispose();
	}
	
}