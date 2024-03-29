package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * ThrownObject is a superclass for objects that are thrown in game.
 *
 * @author Arttu Knuutinen
 * @version 2.0
 */
public class ThrownObject {
    /**
     * Texture of the object.
     */
    private Texture texture;
    /**
     * Box2D Body of the object.
     */
    private Body body;
    /**
     * Value to check if the object has been thrown.
     */
    private boolean thrown;
    /**
     * Math Rectangle of the object, used to check overlapping with goal-object "Pot".
     */
    private Rectangle rect;
    /**
     * Instance of MyGame received as a parameter in constructor.
     */
    private MyGame game;
    /**
     * The Base level reference used for Body creation.
     */
    private BaseLevel baseLevel;
    /**
     * SpriteBatch used for rendering.
     */
    private SpriteBatch batch;
    /**
     *
     */
    private float radius;
    /**
     * Affects the visual size of the object.
     */
    private float textureScale;

    /**
     * Instantiates a new Thrown object.
     *
     * @param g            the g
     * @param b            the b
     * @param radius       the radius
     * @param textureScale the texture scale
     */
    public ThrownObject(MyGame g, BaseLevel b, float radius, float textureScale){
        game = g;
        baseLevel = b;
        this.textureScale = textureScale;
        batch = g.getBatch();
        this.radius = radius;

    }

    /**
     * Set body.
     *
     * @param bodyDef    the body def
     * @param fixtureDef the fixture def
     */
    public void setBody(BodyDef bodyDef, FixtureDef fixtureDef){
        this.body = baseLevel.getGameWorld().createBody(bodyDef);
        body.createFixture(fixtureDef);
        rect = new Rectangle( body.getPosition().x, body.getPosition().y,0.3f, 0.3f);
    }

    /**
     * Sets the object texture.
     *
     * @param texture the texture
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    /**
     * Draw method of the object.
     */
    public void draw(){
        Vector2 center = body.getWorldCenter();
        batch.draw(texture,
                center.x - radius,
                center.y - radius,
                radius,
                radius,
                radius * 2,
                radius * 2,
                textureScale,
                textureScale,
                body.getTransform().getRotation() * MathUtils.radiansToDegrees,
                0,
                0,
                texture.getWidth(),
                texture.getHeight(),
                false,
                false);
        rect.setPosition(center.x, center.y);
    }

    /**
     * Gets fixture def.
     *
     * @param density     the density
     * @param restitution the restitution
     * @param friction    the friction
     * @param vertices    the vertices used to form a polygon shape
     * @return the fixture def
     */
    public FixtureDef getFixtureDef(float density, float restitution, float friction, Vector2[] vertices) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = density;
        fixtureDef.restitution = restitution;
        fixtureDef.friction = friction;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.set(vertices);
        fixtureDef.shape = polygonShape;
        return fixtureDef;
    }

    /**
     * Gets body def.
     *
     * @return the body def
     */
    public BodyDef getBodyDef() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(-4, 1);
        return bodyDef;
    }

    /**
     * Get texture texture.
     *
     * @return the texture
     */
    public Texture getTexture(){
        return texture;
    }

    /**
     * Get body body.
     *
     * @return the body
     */
    public Body getBody(){
        return body;
    }

    /**
     * Is thrown boolean.
     *
     * @return the boolean
     */
    boolean isThrown(){
        return thrown;
    }

    /**
     * Set thrown.
     *
     * @param thrown the thrown
     */
    void setThrown(boolean thrown){
        this.thrown = thrown;
    }

    /**
     * Get rect rectangle.
     *
     * @return the rectangle
     */
    public Rectangle getRect(){
        return rect;
    }

    /**
     * Clone object thrown object.
     *
     * @return the thrown object
     */
    public ThrownObject cloneObject(){
        return null;
    }

    /**
     * Get vertices vector 2 [ ].
     *
     * @return the vector 2 [ ]
     */
    public Vector2[] getVertices(){
        return null;
    }

    /**
     * Gets the MyGame instance.
     *
     * @return the game
     */
    public MyGame getGame() {
        return game;
    }

    /**
     * Gets base level reference.
     *
     * @return the base level
     */
    public BaseLevel getBaseLevel() {
        return baseLevel;
    }

    public void dispose(){
        texture.dispose();
        baseLevel.getGameWorld().destroyBody(body);
    }
}
