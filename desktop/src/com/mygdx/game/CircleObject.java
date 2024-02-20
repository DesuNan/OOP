package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

//CircleObject class
public class CircleObject extends Entity {
    private float radius;
    private Color color;

    public CircleObject(float radius, Color color, float x, float y, float speed) {
        super(x, y, speed, true);
        this.radius = radius;
        this.color = color;
        this.userControlled = true;
    }

    @Override
    public void draw() {
        
    }
    
    @Override
    public void moveUserControlled() {
        // Implement user-controlled movement logic for CircleObject
        // Example: Move up when up arrow key is pressed
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            y += Gdx.graphics.getDeltaTime() * speed;
        }
        // Example: Move down when down arrow key is pressed
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            y -= Gdx.graphics.getDeltaTime() * speed;
        }
    }
}

