package com.mygdx.game;
import java.util.Random;

public class RandomGenerator implements iRandomGenerator {
	private static final int FLUCTUATION = 130;
	
	private Random random;
	public RandomGenerator (long x) {
		this.random = new Random(x);
	}
	
	@Override 
	public int generateRandomNumbers() {
		return random.nextInt(FLUCTUATION);
	}
}
