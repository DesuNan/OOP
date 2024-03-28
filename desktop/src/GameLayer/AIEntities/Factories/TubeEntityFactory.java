package GameLayer.AIEntities.Factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import GameEngine.Scene.SceneManager;
import GameLayer.AIEntities.Tube;

public class TubeEntityFactory implements AIFactory {
	private SceneManager sm;
	private int count;
	private List<String> pictures;
	public TubeEntityFactory (SceneManager sm, int maxCount) {
		this.sm = sm;
		this.count = maxCount;
		this.pictures = new ArrayList<>();
		this.pictures.add("bottomtube.png");
	}
	
	@Override
	public void createEntity() {
		// TODO Auto-generated method stub
		int x = 800;
		int spaceX = 50;
		x = x + count * spaceX;
		Random random = new Random();
		int Posy = 0;// random.nextInt(600);
		int speed = random.nextInt(9)+2;
		String pic = this.pictures.get(random.nextInt(this.pictures.size()));
		
		this.sm.getEntityManager().addEntity(new Tube(800 ,Posy , speed, pic ));
		this.count = this.count - 1;
	}
	
	public void drawEntities() {
		while (count > 0) {
			this.createEntity();
		}
	}
}
