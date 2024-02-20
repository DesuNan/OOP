package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

// TriangleObject class
public class TriangleObject extends Entity {
    private Vector2 p1;
    private Vector2 p2;
    private Vector2 p3;
    private Color color;

    public TriangleObject(Vector2 p1, Vector2 p2, Vector2 p3, Color color, float x, float y, float speed) {
        super(x, y, speed, true);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = color;
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.triangle(p1.x + x, p1.y + y, p2.x + x, p2.y + y, p3.x + x, p3.y +y);
    }
    @Override
    public void draw() {
        
    }

    public void moveUserControlled() {
        // Implement user-controlled movement logic for TriangleObject
        // Example: Move left when A key is pressed
        if (Gdx.input.isKeyPressed(Keys.A)) {
            x -= Gdx.graphics.getDeltaTime() * speed;
        }
        // Example: Move right when D key is pressed
        if (Gdx.input.isKeyPressed(Keys.D)) {
            x += Gdx.graphics.getDeltaTime() * speed;
        }
    }
}
