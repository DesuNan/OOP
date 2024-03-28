package GameLayer.AIEntities;
import java.util.Random;

import GameEngine.AIEntities.Entities;
import GameEngine.AIEntities.EntitiesManager;
import GameEngine.Collision.iCollision;
import GameEngine.InputOutput.InputOutputManager;
import GameEngine.Scene.SceneType;
import GameLayer.Player.Bird;

public class Tube extends Entities {
	
	public Tube(float x, float y, float speed, String imgPath) {
		
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
		em.getIOMan().disposeTexture(this.getImagePath());
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.setX(this.getX() - this.getSpeed());
	}


	@Override
	public void handleCollisions(InputOutputManager ioman, iCollision player) {
		// TODO Auto-generated method stub
		ioman.playSound("hit.ogg");
		ioman.getPlayerManager().getSceneManager().set(SceneType.END_SCENE);
		
	}

	@Override
	public void reposition(InputOutputManager ioman) {
		// TODO Auto-generated method stub
		Random random = new Random();
		this.setX(800);
		this.setY(-random.nextInt(251));
		this.setSpeed(random.nextInt(9) + 2);
		Bird bird = (Bird) ioman.getPlayerManager().getAllPlayers().get(0);
		bird.setPassed(false);
	}
	
}
