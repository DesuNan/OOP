package Collision;

import InputOutput.*;

// Collision interface between entities.
public interface iCollision {
	public float getX();
    public float getY();
    public float getWidth(InputOutputManager ioman);
    public float getHeight(InputOutputManager ioman);
    
}
