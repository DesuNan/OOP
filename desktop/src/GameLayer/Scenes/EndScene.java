package GameLayer.Scenes;
import GameEngine.GameLifecycle.GameLifeCycle;
import GameEngine.GameLifecycle.GameState;
import GameEngine.InputOutput.InputOutputManager;
import GameEngine.Scene.Scene;
import GameEngine.Scene.SceneManager;

public class EndScene extends Scene {
	
	public EndScene (InputOutputManager ioman, GameLifeCycle gm, SceneManager sm) {
		super(sm);
		// Set game State, for synchronisation
		this.sm.getGameLifeCycle().updateStatus(GameState.End);
	}
	
	@Override
	public void handleInput(SceneManager sm) {
		if(sm.getIOMan().isTouched()) {
			System.exit(0);
		}
	}
	
	@Override
	public void update(float dt) {
		handleInput(this.sm);
	}
	
	@Override
	public void render(SceneManager sm) {
		
		sm.getIOMan().draw("bg.png", 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getIOMan().draw("gameover.png", (GameLifeCycle.WIDTH / 2) - (sm.getIOMan().getWidth("gameover.png") / 2), (GameLifeCycle.HEIGHT/2));
		sm.getIOMan().displayText("Score: " + String.valueOf(sm.getPlayerManager().getAllPlayers().get(0).getScore()), (float) (GameLifeCycle.WIDTH/2) - 50 ,(GameLifeCycle.HEIGHT/2) - (sm.getIOMan().getHeight("gameover.png"))/2);
		
		// Can do this because player is singleton design pattern
		System.out.println(sm.getPlayerManager().getAllPlayers().get(0).getScore());
	}
	
	@Override
	public void dispose(SceneManager sm) {
		sm.getIOMan().disposeBatch();
		sm.getPlayerManager().dispose();
		sm.getEntityManager().dispose();
		sm.getPlayerManager().clearAll();
		sm.getEntityManager().clearAll();
		sm.getCollisionManager().clearAll();
		sm.getIOMan().disposeText();
	}
	
}