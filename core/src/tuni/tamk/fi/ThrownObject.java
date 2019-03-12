package tuni.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class ThrownObject {
    static final int OBJECTSHAPE_CIRCLE = 1;
    static final int OBJECTSHAPE_POLYGON = 2;

    private SpriteBatch batch;
    private Texture texture;
    private Body body;
    private float radius;
    private int objectShape;

    public ThrownObject(MyGame g, BaseLevel b, String textureSource, int shape) {
        objectShape = shape;
        batch = g.getBatch();
        texture = new Texture(textureSource);
        body = b.getGameWorld().createBody(getBodyDef());
        if(objectShape == OBJECTSHAPE_CIRCLE) {
            body.createFixture(getFixtureDef());
            radius = (body.getFixtureList().get(0).getShape()).getRadius();
        }
    }
    public void draw() {
        if(objectShape == OBJECTSHAPE_CIRCLE) {
            batch.draw(texture,
                    body.getPosition().x - radius,
                    body.getPosition().y - radius,
                    radius,
                    radius,
                    radius * 2,
                    radius * 2,
                    1.0f,
                    1.0f,
                    body.getTransform().getRotation() * MathUtils.radiansToDegrees,
                    0,
                    0,
                    texture.getWidth(),
                    texture.getHeight(),
                    false,
                    false);
        }
    }
    public BodyDef getBodyDef() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(0, 0);
        return bodyDef;
    }
    public FixtureDef getFixtureDef() {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 1.0f;
        fixtureDef.restitution = 0.3f;
        fixtureDef.friction = 0.3f;
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.5f);
        fixtureDef.shape = circleShape;
        return fixtureDef;
    }

    public Body getBody() {
        return body;
    }
}
