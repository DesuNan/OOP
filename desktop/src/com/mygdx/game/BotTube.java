package com.mygdx.game;
import InputOutput.InputOutputManager;

public class BotTube extends Entities {
	
	
	public BotTube(float x, float y, float speed, String imgPath) {
		
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setImagePath(imgPath);
		
	}
	
	@Override
	public void draw(EntityManager em) {
		em.getIOMan().getBatch().draw(em.getIOMan().getImage(this.getImagePath()), this.getX(), this.getY());
	}
	
	@Override
	public void dispose(EntityManager em) {
		// this.batch.dispose();
		em.getIOMan().disposeBatch();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.setX(this.getX() - this.getSpeed());
	}

	
}
