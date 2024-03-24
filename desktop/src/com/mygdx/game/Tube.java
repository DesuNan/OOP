package com.mygdx.game;

import Entity.*;

public class Tube extends Entities {
	
	public Tube(float x, float y, float speed, String imgPath) {
		
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setImagePath(imgPath);
		
	}
	
	@Override
	public void draw(EntitiesManager em) {
		em.getIOMan().getBatch().draw(em.getIOMan().getImage(this.getImagePath()), this.getX(), this.getY());
	}
	
	@Override
	public void dispose(EntitiesManager em) {
		em.getIOMan().disposeBatch();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.setX(this.getX() - this.getSpeed());
	}

	
}
