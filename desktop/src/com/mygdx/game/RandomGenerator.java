package com.mygdx.game;
import java.util.Random;

public class RandomGenerator implements iRandomGenerator {
	private static final int FLUCTUATION = 130;
	
	private Random random;
	public RandomGenerator () {
		this.random = new Random();
	}
	
	@Override 
	public int generateRandomNumbers() {
		return random.nextInt(FLUCTUATION);
	}
}
