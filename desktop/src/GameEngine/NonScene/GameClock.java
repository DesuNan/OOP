package GameEngine.NonScene;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GameEngine.InputOutput.InputOutputManager;

public class GameClock {
	private int elapsedTime;
    private Timer timer;
    private String text;
    
    private InputOutputManager ioman;
   
    
    
    public GameClock(InputOutputManager ioman) {
    	this.ioman=ioman;
  
    	
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
