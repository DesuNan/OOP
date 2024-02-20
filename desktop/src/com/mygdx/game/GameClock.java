package com.mygdx.game;
import javax.swing.Timer;
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
    
    public GameClock() {
    	batch = new SpriteBatch();
        font = new BitmapFont();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++; 
            }
        });
    }
    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public int getElapsedTime() {
        return elapsedTime;
    }
    
    public void resetClock () {
    	this.elapsedTime = 0;
    	if (timer.isRunning()) {
    		timer.stop();
    	}
    }
    
    public void draw () {
    	text = "Game Time: " + this.elapsedTime;
    	this.batch.begin();
    	this.font.draw(batch, text, 10, 20);
    	this.batch.end();
    	
    }
    
    public void dispose() {
    	this.font.dispose();
    	this.batch.dispose();
    }


}
