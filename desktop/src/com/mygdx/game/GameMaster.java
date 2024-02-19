package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class GameMaster extends ApplicationAdapter {

	// Daniel Test Git Push
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private EntityManager entityManager;
    private List<CircleObject> circles;
    private List<TriangleObject> triangles;
    private List<RectangleObject> rectangles;
    private List<Entity> entityList;

    float dropSpeed = 200;
  
    public class TextureObject extends Entity {

        private Texture texture;
        private boolean aiControlled;
        private float startY;

        public TextureObject(String filename, float[] properties, boolean aiControlled) {
            super(properties[0], properties[1], properties[2], true);
            this.texture = new Texture(Gdx.files.internal(filename));
            this.aiControlled = aiControlled;
            this.startY = properties[1];
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

        public void dispose() {
            texture.dispose();
        }
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        entityManager = new EntityManager();
        entityList = new ArrayList<>();

        // Example: Adding a TextureObject to the entity manager
        TextureObject droplet = new TextureObject("droplet.png", new float[]{200.0f, 200.0f, 200}, true);
        entityList.add(droplet);
        entityManager.addEntity(droplet);
        TextureObject bucket = new TextureObject("bucket.png", new float[]{50.0f, 100.0f, 500}, false);
        entityList.add(bucket);
        entityManager.addEntity(bucket);
        
        // Create Rectangle
        rectangles = new ArrayList<>();
        RectangleObject rectangle = new RectangleObject(100, 200, Color.WHITE, 500, 290, 100);
        rectangles.add(rectangle);
        entityManager.addEntity(rectangle);

        // Create circles
        circles = new ArrayList<>();
        CircleObject circle = new CircleObject(25, Color.RED, 500, 400, 500);
        circles.add(circle);
        entityManager.addEntity(circle);

        triangles = new ArrayList<>();
        TriangleObject triangle = new TriangleObject(
                new Vector2(100, 100),
                new Vector2(200, 100),
                new Vector2(150, 200),
                Color.BLUE,
                0, 0, 500
        );
        triangles.add(triangle);
        entityManager.addEntity(triangle);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 1, 0.2f, 1);

        // Update and draw entities
        entityManager.updateEntities();

        batch.begin();
        
        // Draw droplets
        for (Entity entity : entityList) {
            if (entity instanceof TextureObject) {
                TextureObject textureObject = (TextureObject) entity;
                batch.draw(textureObject.texture, entity.getX(), entity.getY());
            }
        }

        batch.end();

        // Draw shapes
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw circles
        for (CircleObject circle : circles) {
            circle.draw(shapeRenderer);
        }
        // Draw triangles
        for (TriangleObject triangle : triangles) {
            triangle.draw(shapeRenderer);
        }
        // Draw rectangle
        for (RectangleObject rectangle : rectangles) {
        	rectangle.draw(shapeRenderer);
        }

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        for (Entity entity : entityList) {
            if (entity instanceof TextureObject) {
                ((TextureObject) entity).dispose();
            }
        }
    }
}