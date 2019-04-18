package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * The type Obstacle.
 */
public class Obstacle {
    /**
     * The Game.
     */
    MyGame game;
    /**
     * The Batch.
     */
    SpriteBatch batch;
    private BaseLevel baseLevel;
    private Texture texture;
    private Rectangle obstacleRect;
    private Body obstacleBody;
    private float obstacleWidth;
    private float obstacleHeight;


    /**
     * Instantiates a new Obstacle.
     *
     * @param g      the g
     * @param b      the b
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
    public Obstacle(MyGame g, BaseLevel b, float x, float y, float width, float height) {
        game = g;
        baseLevel = b;
        batch = game.getBatch();
        texture = new Texture("ground.png");
        obstacleRect = new Rectangle(x,y,width,height);
        obstacleHeight = height;
        obstacleWidth = width;
        obstacleBody = baseLevel.getGameWorld().createBody(getObstacleBodyDef());
        obstacleBody.createFixture(getObstacleFixtureDef());

    }

    /**
     * Draw.
     */
    public void draw() {
        batch.draw(texture, obstacleRect.x, obstacleRect.y, obstacleRect.getWidth(), obstacleRect.getHeight());

    }

    /**
     * Gets obstacle body def.
     *
     * @return the obstacle body def
     */
    public BodyDef getObstacleBodyDef() {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyDef.BodyType.StaticBody;
        groundBodyDef.position.set(obstacleRect.x + obstacleWidth / 2, obstacleRect.y + obstacleHeight/2);
        return groundBodyDef;
    }

    /**
     * Gets obstacle fixture def.
     *
     * @return the obstacle fixture def
     */
    public FixtureDef getObstacleFixtureDef() {
        FixtureDef groundFixtureDef = new FixtureDef();
        groundFixtureDef.density = 1.0f;
        groundFixtureDef.restitution = 0.2f;
        groundFixtureDef.friction = 0.5f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(obstacleWidth/2, obstacleHeight/2);
        groundFixtureDef.shape = polygonShape;
        return groundFixtureDef;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public Body getBody() {
        return obstacleBody;
    }
}
