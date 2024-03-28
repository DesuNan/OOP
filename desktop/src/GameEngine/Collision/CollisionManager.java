package GameEngine.Collision;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import GameEngine.AIEntities.Entities;
import GameEngine.Player.Players;
import GameEngine.Scene.SceneManager;
import GameEngine.Scene.SceneType;
import GameLayer.AIEntities.Danger;
import GameLayer.AIEntities.Good;
import GameLayer.AIEntities.Tube;


public class CollisionManager {
	protected SceneManager sm;
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
	
	public boolean isPassed(iCollision entity1, iCollision entity2) {
		return entity1.getX() < entity2.getX() && entity1.getX() > 0; 
	}
	
	public boolean isBeyond(iCollision entity) {
		return (entity.getX() + entity.getWidth(sm.getIOMan())) < 0;
		
	}

	
	public void handleCollision() {
		// iterate through all icollisions and get type
		for(iCollision player: this.getCollidablesList()) {
			if (player instanceof Players) {
				for (iCollision entity: this.getCollidablesList()) {
					if (entity instanceof Entities) {
						// bird collides with collidable
						if (isCollided(entity, player)) {
							entity.handleCollisions(sm.getIOMan(),player);
						}
						// tube passes bird
						if (isPassed(entity,player)) {
							player.handleCollisions(sm.getIOMan(), entity);
						}
						// beyond border/screen
						if (isBeyond(entity)) {
							entity.reposition(sm.getIOMan());
						}
					}
				}
			}
		}
	}
	
}
