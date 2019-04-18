package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * The type Border wall.
 */
public class BorderWall {
    /**
     * The Game.
     */
    MyGame game;
    /**
     * The Base level.
     */
    BaseLevel baseLevel;
    /**
     * The Wall rect.
     */
    Rectangle wallRect;
    /**
     * The Batch.
     */
    SpriteBatch batch;
    /**
     * The Wall body.
     */
    Body wallBody;

    /**
     * Instantiates a new Border wall.
     *
     * @param g the g
     * @param b the b
     * @param x the x
     * @param y the y
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
     * Gets wall body def.
     *
     * @param x the x
     * @param y the y
     * @return the wall body def
     */
    public BodyDef getWallBodyDef(float x, float y) {
        BodyDef wallBodyDef = new BodyDef();
        wallBodyDef.type = BodyDef.BodyType.StaticBody;
        wallBodyDef.position.set(x, y);
        return wallBodyDef;
    }

    /**
     * Gets wall fixture def.
     *
     * @return the wall fixture def
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
