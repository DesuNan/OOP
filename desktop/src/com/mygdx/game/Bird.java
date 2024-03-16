package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import InputOutput.InputOutputManager;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import Player.*;

public class Bird extends Players {

	
	
	public Bird(float x, float y, float speed, String imagePath, List<Integer> keyBinds) {
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setImage(imagePath);
		for (int keyBind: keyBinds) {
			
			this.addKeyBinds(keyBind);
		}
	}
	
	@Override
	public void handleMovement(PlayersManager pm) {
		// TODO Auto-generated method stub
		// Jump Movement
		if (this.getKeyBinds() != null) {
		for (int keyBind: this.getKeyBinds()) {
			if (pm.getIOMan().isKeyPressed(keyBind)) {
				this.setY(this.getY() + this.getSpeed());
			}
		}
		}
		
		/*
		else if (pm.getIOMan().isKeyPressed(keyBindDown)) {
			
			this.setY(this.getY() - this.getSpeed());
		}
		*/
		
	}
	@Override
	public void handleGravity(PlayersManager pm) {
		if (this.getY() > 0) {
			// Need to fine tune the gravity amount.
			this.setY(this.getY() - (this.getSpeed()/8));
		}
	}
	
	@Override
	public void draw(PlayersManager pm) {
		pm.getIOMan().getBatch().draw(pm.getIOMan().getImage(this.getImage()), this.getX(), this.getY());
	}
	
	
	@Override
	public void dispose(PlayersManager pm) {
		pm.getIOMan().disposeBatch();
	}
}
