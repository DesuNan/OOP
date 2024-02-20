package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import java.util.ArrayList;
import java.util.List;

public class GameMaster extends ApplicationAdapter {

    private SpriteBatch batch;
    private Tube tube;
    private Bird bird;
    private Texture topTube;
    private Texture bottomTube;

    private ShapeRenderer shapeRenderer;
    private EntityManager entityManager;
    private Tubes tubes;
    
    /*
    public class TextureObject extends Entities {

        private Texture texture;
        private boolean aiControlled;
        private float startY;

        public TextureObject(String filename, float[] properties, boolean aiControlled) {
            super(properties[0], properties[1], properties[2], true);
            this.texture = new Texture(Gdx.files.internal(filename));
            this.aiControlled = aiControlled;
            this.startY = properties[1];
        }
        
        public TextureObject(String string, int i) {
			// TODO Auto-generated constructor stub
		}

		@Override
        public void move() {
            if (aiControlled) {
                moveAIControlled();
            } else {
                moveUserControlled();
            }
        }
        
        @Override
        public void moveAIControlled() {
            // Implement the AI-controlled movement logic for the droplet

            // Example: Move downward
            x -= Gdx.graphics.getDeltaTime() * speed;

            // Optional: Adjust the logic based on your requirements
            if (x <= 0) {
                // Reset to the top when reaching the bottom edge
                x = Gdx.graphics.getHeight();
            }
        }
        

       @Override
        public void draw(ShapeRenderer shapeRenderer) {
            shapeRenderer.setColor(Color.WHITE);
            shapeRenderer.rect(x, y, texture.getWidth(), texture.getHeight());
        }
       
       @Override
       public void draw() {
           
       }

        public void dispose() {
            texture.dispose();
        }
    }
    */

    @Override
    public void create() {
        
        entityManager = new EntityManager();
        entityManager.addEntity(new Bird(100,100));
        entityManager.addEntity(new Tubes(500));
    }

    @Override
    public void render() {
       ScreenUtils.clear(0, 1, 0.2f, 1);
       entityManager.draw();
       entityManager.moveAIControlled();
       entityManager.moveUserControlled();
    }

    @Override
    public void dispose() {
    	entityManager.dispose();
    }
}