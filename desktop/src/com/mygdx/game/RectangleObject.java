package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class RectangleObject extends Entity {
	private Color color;
	private Rectangle rectangle;
	
	
	public RectangleObject(int height, int width, Color color, float x, float y, float speed) {
		super(x, y, speed, false);
		this.rectangle = new Rectangle(x, y, height, width);
		this.color = color;
	}
	
	@Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
	
	@Override
    public void moveAIControlled() {
    	// Implement AI-controlled movement logic for TextureObject
        // Update the x and y positions based on AI-controlled movement
        y += Gdx.graphics.getDeltaTime() * speed;
    }
}