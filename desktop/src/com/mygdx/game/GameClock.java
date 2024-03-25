package com.mygdx.game;
import javax.swing.Timer;
import InputOutput.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClock {
	private int elapsedTime;
    private Timer timer;
    private String text;
    private SpriteBatch batch;
    private BitmapFont font;
    private InputOutputManager ioman;
    private GameLifeCycle gm;
    
    
    public GameClock(InputOutputManager ioman, GameLifeCycle gm) {
    	this.ioman=ioman;
    	this.gm=gm;
    	
        // Increases the timer by 1 every 1000 miliseconds.
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++; 
                
                
            }
        });
    }
    // Start Clock
    public void start() {
        timer.start();
    }
    // Stop Clock
    public void stop() {
        timer.stop();
    }

    public int getElapsedTime() {
        return elapsedTime;
    }
   
    public void reset () {
    	if (timer.isRunning()) {
    		timer.stop();
    	}
    	this.elapsedTime = 0;
    }
    // Draws the clock at position 10,20
    
    public void draw () {
    	this.text = "Game Time: " + this.elapsedTime;
    	this.ioman.displayText(text,10,20);
        // this.ioman.displayText(text,10,20);
    	// this.ioman.displayText("hello", 100, 100);
    	
    }
    
    public void dispose() {
        this.ioman.disposeText();
    	// this.ioman.disposeText(this.text);
    }


}
