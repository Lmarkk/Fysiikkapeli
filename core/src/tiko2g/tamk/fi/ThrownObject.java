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

public class ThrownObject {
    private Texture texture;
    private Body body;
    private boolean thrown;
    private Rectangle rect;
    MyGame game;
    BaseLevel baseLevel;
    private SpriteBatch batch;
    private float radius;
    private float textureScale;

    public ThrownObject(MyGame g, BaseLevel b, float radius, float textureScale){
        game = g;
        baseLevel = b;
        this.textureScale = textureScale;
        batch = g.getBatch();
        this.radius = radius;

    }
    public void setBody(BodyDef bodyDef, FixtureDef fixtureDef){
        this.body = baseLevel.getGameWorld().createBody(bodyDef);
        body.createFixture(fixtureDef);
        rect = new Rectangle( body.getPosition().x, body.getPosition().y,0.3f, 0.3f);
    }
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

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

        // Placeholder used to visualize the overlap check rectangle
//        batch.draw(new Texture("badlogic.jpg"), rect.x, rect.y, rect.width, rect.height);
    }
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

    public BodyDef getBodyDef() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(-4, 1);
        return bodyDef;
    }
    public Texture getTexture(){
        return texture;
    }

    public Body getBody(){
        return body;
    }

    boolean isThrown(){
        return thrown;
    }

    void setThrown(boolean thrown){
        this.thrown = thrown;
    }

    public Rectangle getRect(){
        return rect;
    }

    // Override these
    public ThrownObject cloneObject(){
        return null;
    }

    public Vector2[] getVertices(){
        return null;
    }
}
