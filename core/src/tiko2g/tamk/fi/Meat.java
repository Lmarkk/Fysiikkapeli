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

public class Meat implements ThrownObject {
    private SpriteBatch batch;
    private Texture texture;
    private Body body;
    private float radius;
    private boolean thrown = false;
    private float scale = 0.5f;
    private float textureScale = 0.6f;
    private Rectangle rect;

    public Meat(MyGame g, BaseLevel b){
        batch = g.getBatch();
        texture = new Texture("meat.png");
        body = b.getGameWorld().createBody(getBodyDef());
        body.createFixture(getFixtureDef());
//        radius = (body.getFixtureList().get(0).getShape()).getRadius();
        radius = 1f;
        rect = new Rectangle( body.getPosition().x, body.getPosition().y,0.3f, 0.3f);
    }
    @Override
    public void draw() {
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
//        batch.draw(new Texture("badlogic.jpg"), rect.x, rect.y, rect.width, rect.height);
    }

    @Override
    public BodyDef getBodyDef() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(-4, 2);
        return bodyDef;
    }

    @Override
    public FixtureDef getFixtureDef() {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 1f;
        fixtureDef.restitution = 0f;
        fixtureDef.friction = 1f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.set(getVertices());
        fixtureDef.shape = polygonShape;
        return fixtureDef;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public boolean isThrown() {
        return thrown;
    }

    @Override
    public void setThrown(boolean thrown) {
        this.thrown = thrown;
    }
    private Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0, 1);
        vertices[1] = new Vector2(0, 1.9f);
        vertices[2] = new Vector2(0.53f, 2.15f);
//        vertices[3] = new Vector2(1.02f, 2.15f);
        vertices[3] = new Vector2(1.53f, 1.9f);
        vertices[4] = new Vector2(2.37f, 0.47f);
//        vertices[6] = new Vector2(2.37f, 0.13f);
        vertices[5] = new Vector2(2.24f, 0f);
        vertices[6] = new Vector2(1.55f, 0.13f);
//        vertices[9] = new Vector2(1.02f, 0.13f);
        vertices[7] = new Vector2(0.44f, 0.49f);
//        Vector2[] vertices = new Vector2[4];
//        vertices[0] = new Vector2(1, 1);
//        vertices[1] = new Vector2(1, 0);
//        vertices[2] = new Vector2(0, 0);
//        vertices[3] = new Vector2(0, 1);
        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }
}
