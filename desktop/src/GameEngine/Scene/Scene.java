package GameEngine.Scene;
import GameEngine.GameLifecycle.GameState;

public abstract class Scene implements iSwapScene {
	private GameState GameStatus;
	protected SceneManager sm;

    public Scene(SceneManager sm) {
    	this.sm = sm;    	
    }
    
    // public abstract void handleInput(SceneManager sm);
    
    public abstract void update(float dt);
    
    public abstract void render(SceneManager sm);
    
    public abstract void dispose(SceneManager sm);
	
	public GameState getGameStatus() {
		return this.GameStatus;
	}
	
	public void updateGameStatus (GameState Status) {
		this.GameStatus = Status;
	}
	
}