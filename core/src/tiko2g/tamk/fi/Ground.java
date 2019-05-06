package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Class used to  create a static body serving as a ground for collisions on levels.
 *
 * @author Lassi Markkinen
 * @version 2.0
 */
public class Ground {
    /**
     * MyGame instance received in the constructor.
     */
    MyGame game;
    /**
     * SpriteBatch received from MyGame.
     */
    SpriteBatch batch;
    /**
     * BaseLevel instance received in the constructor.
     */
    private BaseLevel baseLevel;
    /**
     * Texture for the ground rendering.
     */
    private Texture groundTexture;
    /**
     * Rectangle used for drawing the texture.
     */
    private Rectangle groundRect;
    /**
     * Box2d Body used for physics.
     */
    private Body groundBody;
    /**
     * Float value that determines the width of the ground.
     */
    private float groundWidth = 120;


    /**
     * Instantiates a new Ground.
     *
     * @param g             the MyGame, used for getting the SpriteBatch.
     * @param b             the BaseLevel, used for accessing the Box2d World.
     * @param textureSource the source path for the texture.
     */
    public Ground(MyGame g, BaseLevel b, String textureSource) {
        game = g;
        baseLevel = b;
        batch = game.getBatch();
        groundTexture = new Texture(textureSource);
        groundRect = new Rectangle(0,-4,groundWidth,4);
        groundBody = baseLevel.getGameWorld().createBody(getGroundBodyDef());
        groundBody.createFixture(getGroundFixtureDef());

    }

    /**
     * Draws the part of the ground that is visible to the player.
     */
    public void draw() {
        batch.draw(groundTexture, groundRect.x, groundRect.y, 16, 4);
        batch.draw(groundTexture, 16, groundRect.y, 16, 4);
        batch.draw(groundTexture, 32, groundRect.y, 16, 4);
    }

    /**
     * Creates a new BodyDef for the Ground instance.
     *
     * @return the created BodyDef.
     */
    public BodyDef getGroundBodyDef() {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyDef.BodyType.StaticBody;
        groundBodyDef.position.set(groundWidth/2, -2);
        return groundBodyDef;
    }

    /**
     * Creates a new FixtureDef for the Ground instance.
     *
     * @return the created FixtureDef.
     */
    public FixtureDef getGroundFixtureDef() {
        FixtureDef groundFixtureDef = new FixtureDef();
        groundFixtureDef.density = 1.0f;
        groundFixtureDef.restitution = 0.2f;
        groundFixtureDef.friction = 0.5f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(groundWidth/2, 2);
        groundFixtureDef.shape = polygonShape;
        return groundFixtureDef;
    }

    /**
     * Getter for ground Body.
     *
     * @return groundBody.
     */
    public Body getGroundBody() {
        return groundBody;
    }

    public void dispose(){
        baseLevel.getGameWorld().destroyBody(groundBody);
        groundTexture.dispose();
    }
}

