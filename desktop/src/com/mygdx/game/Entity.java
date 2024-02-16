package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

//Abstract Entity class implementing iMovable
public abstract class Entity implements iMovable {
    protected float x;
    protected float y;
    protected float speed;
    protected boolean userControlled;

    public Entity() {
        this(0, 0, 500, true);
    }

    public Entity(float x, float y, float speed, boolean userControlled) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.userControlled = userControlled;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    @Override
    public void move() {
        if (userControlled) {
            moveUserControlled();
        } else {
            moveAIControlled();
        }
    }

    @Override
    public void moveAIControlled() {
    	// Implement AI-controlled movement logic for TextureObject
        // Update the x and y positions based on AI-controlled movement
        x += Gdx.graphics.getDeltaTime() * speed;
    }

    @Override
    public void moveUserControlled() {
    	// Implement user-controlled movement logic for TextureObject
        // Example: Move left when left arrow key is pressed
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= Gdx.graphics.getDeltaTime() * speed;
        }
        // Example: Move right when right arrow key is pressed
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += Gdx.graphics.getDeltaTime() * speed;
        }
    }

    public abstract void draw(ShapeRenderer shapeRenderer);
}