package Collision;

import java.util.ArrayList;

import java.util.List;
import Scene.*;
import Player.*;
import com.mygdx.game.*;
import Collision.iCollision;
import Entity.*;

public class CollisionManager {
	private SceneManager sm;
	private List<iCollision> collidables;

	public CollisionManager(SceneManager sm) {
		this.sm = sm;
		this.collidables = new ArrayList<>();

	}

	public void clearAll() {
		this.getCollidablesList().clear();
	}

	public List<iCollision> getCollidablesList() {
		return this.collidables;
	}

	public void addCollidable(iCollision collidable) {
		collidables.add(collidable);
	}

	public void deleteCollidable(iCollision collidable) {
		collidables.remove(collidable);
	}

	public boolean isCollided(iCollision entity1, iCollision entity2) {
		return entity1.getX() < entity2.getX() + entity2.getWidth(sm.getIOMan())
				&& entity1.getX() + entity1.getWidth(sm.getIOMan()) > entity2.getX()
				&& entity1.getY() < entity2.getY() + entity2.getHeight(sm.getIOMan())
				&& entity1.getY() + entity1.getHeight(sm.getIOMan()) > entity2.getY();
	}

	public void handleCollisions() {
		Players player = null;
		List<Entities> entityList = new ArrayList<>();
		for (iCollision collidable : this.collidables) {
			if (collidable instanceof Players) {
				player = (Players) collidable;
			} else if (collidable instanceof Entities) {
				entityList.add((Entities) collidable);
			}
		}
		// Check collisions between bird and each tube
		// If Collided, scenemanager change scene.
		if (player != null) {
			for (Entities entity : entityList) {
				// If player and entity collide
				if (isCollided(entity, player)) {
					sm.getIOMan().playSound("hit.ogg");
					sm.dispose();
					sm.set(new EndScene(sm));
				}

				// Endless loop of tubes.
				if (entity.getX() + entity.getWidth(sm.getIOMan()) < 0 && entity instanceof Tube) {
					entity.setX(800);
				}
				
				if (entity.getX() + entity.getWidth(sm.getIOMan()) < 0 && entity instanceof Danger) {
					entity.setX(800);
				}

				// Add points for player passing Tube
				if (entity.getX() + entity.getWidth(sm.getIOMan()) < player.getX() && entity instanceof Tube) {
					// 10 points per tube set
					// 0.25 because it takes 40 miliseconds to pass the tube.
					player.setScore(player.getScore() + (0.25));
					System.out.println("Player Score: " + player.getScore());
					sm.getIOMan().playSound("point.ogg");

				}
			}
		}
	}

}
