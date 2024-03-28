package GameEngine.GameLifecycle;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import GameEngine.InputOutput.InputOutputManager;
import GameEngine.NonScene.GameClock;
import GameEngine.Scene.SceneManager;
import GameEngine.Scene.SceneType;


public class GameLifeCycle extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	private SceneManager sm;
	private GameClock clock;
	private GameState GameStatus;
	private InputOutputManager ioman;
	
	public GameLifeCycle () {
		this.GameStatus = GameState.Start;
	}

	public GameState getStatus() {
		return this.GameStatus;
	}
	
	public void updateStatus (GameState status) {
		this.GameStatus = status;
	}

	@Override
	public void create() {
		this.ioman = new InputOutputManager();
		this.ioman.createBatch();
		sm = new SceneManager(ioman, this);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		sm.push(SceneType.START_SCENE);
		this.clock = new GameClock(ioman);	
		
	}

	@Override
	public void render() {
		// update gamestate status according to scene
		this.ioman.startBatch();
		this.sm.render();
		this.sm.update(Gdx.graphics.getDeltaTime());
		
		if(this.getStatus() == GameState.Start) {
			this.clock.reset();
		}
		else if (this.getStatus()==GameState.Play) {
			this.clock.start();
			this.clock.draw();
		}
		else if (this.getStatus() == GameState.Pause ){
			this.clock.stop();
			this.clock.draw();
			this.sm.set(SceneType.PAUSE_SCENE);
			
		}
		else if (this.getStatus() == GameState.End){
			this.clock.stop();
			this.clock.draw();
			
		}
	
		this.ioman.stopBatch();

	}

	@Override
	public void dispose() {
		this.clock.dispose();
		this.ioman.disposeBatch();
		this.sm.dispose();
	}
}