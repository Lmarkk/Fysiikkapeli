package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Class used to create obstacles in game levels.
 *
 * @author Lassi Markkinen
 * @version 2.0
 */
public class Obstacle {
    /**
     * The MyGame, received in constructor.
     */
    MyGame game;
    /**
     * The SpriteBatch, received from game.
     */
    SpriteBatch batch;
    /**
     * The BaseLevel, received in the constructor.
     */
    private BaseLevel baseLevel;
    /**
     * Texture for drawing the Obstacle.
     */
    private Texture texture;
    /**
     * Rectangle used when rendering the texture.
     */
    private Rectangle obstacleRect;
    /**
     * Body used for Obstacle physics.
     */
    private Body obstacleBody;
    /**
     * Float value that determines the width of an Obstacle.
     */
    private float obstacleWidth;
    /**
     * Float value that determines the height of an Obstacle.
     */
    private float obstacleHeight;


    /**
     * Instantiates a new Obstacle.
     *
     * @param g      the MyGame, used to get SpriteBatch.
     * @param b      the BaseLevel, used to get World for Body/Fixture creation.
     * @param x      the position of the Obstacle on the x-axis.
     * @param y      the position of the Obstacle on the y-axis.
     * @param width  the width of the Obstacle.
     * @param height the height of the Obstacle.
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
     * Draws the Obstacle using batch.
     */
    public void draw() {
        batch.draw(texture, obstacleRect.x, obstacleRect.y, obstacleRect.getWidth(), obstacleRect.getHeight());

    }

    /**
     * Creates a new BodyDef for the Obstacle.
     *
     * @return the created BodyDef.
     */
    public BodyDef getObstacleBodyDef() {
        BodyDef obstacleBodyDef = new BodyDef();
        obstacleBodyDef.type = BodyDef.BodyType.StaticBody;
        obstacleBodyDef.position.set(obstacleRect.x + obstacleWidth / 2, obstacleRect.y + obstacleHeight/2);
        return obstacleBodyDef;
    }

    /**
     * Creates a new FixtureDef for the Obstacle.
     *
     * @return the created FixtureDef.
     */
    public FixtureDef getObstacleFixtureDef() {
        FixtureDef obstacleFixtureDef = new FixtureDef();
        obstacleFixtureDef.density = 1.0f;
        obstacleFixtureDef.restitution = 0.2f;
        obstacleFixtureDef.friction = 0.5f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(obstacleWidth/2, obstacleHeight/2);
        obstacleFixtureDef.shape = polygonShape;
        return obstacleFixtureDef;
    }

    /**
     * Getter for the Obstacle's Body.
     *
     * @return the Body.
     */
    public Body getBody() {
        return obstacleBody;
    }
}
