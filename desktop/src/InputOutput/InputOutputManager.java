package InputOutput;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InputOutputManager {
	private SpriteBatch batch;
	  
	  public InputOutputManager () {
	  }
	  public void createBatch() {
	    this.batch = new SpriteBatch();
	  }
	  public void startBatch() {
	    this.batch.begin();
	  }
	  public void stopBatch() {
	    this.batch.end();
	  }
	  public void disposeBatch() {
	    this.batch.dispose();
	  }
	  
	  public SpriteBatch getBatch() {
	    return this.batch;
	  }
	  
	  public Texture getImage(String path) {
	    return new Texture(path);
	  }
	  
}
