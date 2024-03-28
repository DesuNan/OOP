package GameLayer;
import GameEngine.*;

public class Danger extends Entities {
	
	private boolean hasCollidedWithPlayer = false;
	
	public Danger(float x, float y, float speed, String imgPath) {
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setImagePath(imgPath);
	}
	
	@Override
	public void draw(EntitiesManager em) {
		em.getIOMan().draw(this.getImagePath(), this.getX(), this.getY());
	}
	
	@Override
	public void dispose(EntitiesManager em) {
//		em.getIOMan().disposeBatch();
		em.getIOMan().disposeTexture(this.getImagePath());
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.setX(this.getX() - this.getSpeed());
	}

	public static float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean hasCollidedWithPlayer() {
	    return this.hasCollidedWithPlayer;
	}

	public void setCollidedWithPlayer(boolean collided) {
	    this.hasCollidedWithPlayer = collided;
	}

	
}
