package GameLayer;

import GameEngine.*;

public class PauseScene extends Scene {
	public PauseScene (InputOutputManager ioman, GameLifeCycle gm, SceneManager sm) {
		super(sm);
		
	}

	@Override
	public void handleInput(SceneManager sm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(SceneManager sm) {
		// TODO Auto-generated method stub
		sm.getIOMan().getBatch().draw(sm.getIOMan().getImage("bg-night.png"), 0, 0, GameLifeCycle.WIDTH, GameLifeCycle.HEIGHT);
		sm.getIOMan().getBatch().draw(sm.getIOMan().getImage("paused.png"), (GameLifeCycle.WIDTH / 2) - (sm.getIOMan().getWidth("paused.png") / 2), (GameLifeCycle.HEIGHT/2));
		
	}

	@Override
	public void dispose(SceneManager sm) {
		// TODO Auto-generated method stub
		
	}
}
