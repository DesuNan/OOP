package GameLayer.AIEntities;
import java.util.Random;

import GameEngine.AIEntities.Entities;
import GameEngine.AIEntities.EntitiesManager;
import GameEngine.Collision.iCollision;
import GameEngine.InputOutput.InputOutputManager;
import GameLayer.Player.*;

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

	@Override
	public void handleCollisions(InputOutputManager ioman, iCollision player) {
		// TODO Auto-generated method stub
		Bird bird = (Bird) player;
		if (bird.getHealth()>1 && bird.getHealth()<=3 && !this.hasCollidedWithPlayer) {
		bird.setHealth(bird.getHealth() - 1);
		this.hasCollidedWithPlayer = true;
		ioman.playSound("hit.ogg");
		}
	}

	@Override
	public void reposition(InputOutputManager ioman) {
		// TODO Auto-generated method stub
		Random random = new Random();
		this.setX(800);
		this.setY(random.nextInt(600));
		this.setSpeed(random.nextInt(9) + 2);
		this.hasCollidedWithPlayer = false;
	}

	
}
