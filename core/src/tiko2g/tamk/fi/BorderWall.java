package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Class used to create invisible static Bodies in game levels to prevent projectiles from flying
 * too far.
 *
 * @author Lassi Markkinen
 * @version 2.0
 */
public class BorderWall {
    /**
     * The MyGame instance received as a parameter for the contructor.
     */
    MyGame game;
    /**
     * The BaseLevel instance received as a parameter for the contructor.
     */
    BaseLevel baseLevel;
    /**
     * Rectangle for wall texture drawing.
     */
    Rectangle wallRect;
    /**
     * The SpriteBatch used for drawing the wall.
     */
    SpriteBatch batch;
    /**
     * The wall body.
     */
    Body wallBody;

    /**
     * Instantiates a new BorderWall.
     *
     * @param g the MyGame, used to get the SpriteBatch.
     * @param b the BaseLevel, used to create the body with World.
     * @param x the x-coordinate for wall creation.
     * @param y the y-coordinate for wall creation.
     */
    public BorderWall(MyGame g, BaseLevel b, float x, float y) {
        game = g;
        baseLevel = b;
        batch = game.getBatch();
        wallRect = new Rectangle(x, y, 1, 20);
        wallBody = baseLevel.getGameWorld().createBody(getWallBodyDef(x, y));
        wallBody.createFixture(getWallFixtureDef());
    }

    /**
     * Creates and returns a new BodyDef with static BodyType for the wall's Body.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     * @return the created BodyDef.
     */
    public BodyDef getWallBodyDef(float x, float y) {
        BodyDef wallBodyDef = new BodyDef();
        wallBodyDef.type = BodyDef.BodyType.StaticBody;
        wallBodyDef.position.set(x, y);
        return wallBodyDef;
    }

    /**
     * Creates and returns a FixtureDef for the wall's body.
     *
     * @return the created FixtureDef.
     */
    public FixtureDef getWallFixtureDef() {
        FixtureDef wallFixtureDef = new FixtureDef();
        wallFixtureDef.density = 1.0f;
        wallFixtureDef.restitution = 0.2f;
        wallFixtureDef.friction = 0.5f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(0.2f, 20);
        wallFixtureDef.shape = polygonShape;
        return wallFixtureDef;
    }
}
