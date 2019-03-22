package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Blueberry implements ThrownObject {
    private SpriteBatch batch;
    private Texture texture;
    private Body body;
    private float radius;
    private boolean thrown = false;

    public Blueberry(MyGame g, BaseLevel b) {
        batch = g.getBatch();
        texture = new Texture("blueberry.png");
        body = b.getGameWorld().createBody(getBodyDef());
        body.createFixture(getFixtureDef());
        radius = (body.getFixtureList().get(0).getShape()).getRadius();
    }
    public void draw() {
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
    public BodyDef getBodyDef() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(0, 0);
        return bodyDef;
    }
    public FixtureDef getFixtureDef() {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 0.8f;
        fixtureDef.restitution = 0.3f;
        fixtureDef.friction = 0.3f;
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.5f);
        fixtureDef.shape = circleShape;
        return fixtureDef;
    }

    public Texture getTexture() {
        return texture;
    }

    public Body getBody() {
        return body;
    }

    public boolean isThrown() {
        return thrown;
    }

    public void setThrown(boolean thrown) {
        this.thrown = thrown;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }
}
