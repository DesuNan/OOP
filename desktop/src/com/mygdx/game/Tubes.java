package com.mygdx.game;

import java.util.Random;

abstract public class Tubes extends Entities {
	private static final int FLUCTUATION = 130;
	private int TUBE_GAP = 100;
	private int LOWEST_OPENING = 120;
	private int RandY;
	private RandomGenerator rand;
    
    public Tubes(float x, RandomGenerator randGen) {
		
		this.rand =  randGen;
		this.setSpeed(3);
		this.setUserContolled(false);
		
	}
    
    public int getTubeGap() {
    	return this.TUBE_GAP;
    }
    
    public int getLowestOpening() {
    	return this.LOWEST_OPENING;
    }
    public int getRandomNumberParent() {
        return rand.generateRandomNumbers();
    }
    
 
}
