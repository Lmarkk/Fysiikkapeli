package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * The type Ground.
 */
public class Ground {
    /**
     * The Game.
     */
    MyGame game;
    /**
     * The Batch.
     */
    SpriteBatch batch;
    private BaseLevel baseLevel;
    private Texture groundTexture;
    private Rectangle groundRect;
    private Body groundBody;
    private float groundWidth = 48;


    /**
     * Instantiates a new Ground.
     *
     * @param g             the g
     * @param b             the b
     * @param textureSource the texture source
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
     * Draw.
     */
    public void draw() {
        batch.draw(groundTexture, groundRect.x, groundRect.y, 16, 4);
        batch.draw(groundTexture, 16, groundRect.y, 16, 4);
        batch.draw(groundTexture, 32, groundRect.y, 16, 4);
    }

    /**
     * Gets ground body def.
     *
     * @return the ground body def
     */
    public BodyDef getGroundBodyDef() {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyDef.BodyType.StaticBody;
        groundBodyDef.position.set(groundWidth/2, -2);
        return groundBodyDef;
    }

    /**
     * Gets ground fixture def.
     *
     * @return the ground fixture def
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
     * Gets ground body.
     *
     * @return the ground body
     */
    public Body getGroundBody() {
        return groundBody;
    }
}

