package GameEngine.Collision;

import GameEngine.InputOutput.InputOutputManager;	

// Collision interface between entities.
public interface iCollision {
	public float getX();
    public float getY();
    public float getWidth(InputOutputManager ioman);
    public float getHeight(InputOutputManager ioman);
    public void handleCollisions(InputOutputManager ioman, iCollision icollidable);
    public void reposition(InputOutputManager ioman);
    
}
