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

public class Carrot implements ThrownObject {
    private SpriteBatch batch;
    private Texture texture;
    private Body body;
    private float radius;
    private boolean thrown = false;
    private float scale = 0.45f;
    private float textureScale = 0.65f;
    private Rectangle rect;
    private MyGame game;
    private BaseLevel baseLevel;

    public Carrot(MyGame g, BaseLevel b){
        game = g;
        baseLevel = b;
        batch = g.getBatch();
        texture = new Texture("object-carrot.png");
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
        bodyDef.position.set(-4, 1);
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
        vertices[0] = new Vector2(0, 3);
        vertices[1] = new Vector2(1.17f, 2.32f);
        vertices[2] = new Vector2(2.32f, 1.27f);
        vertices[3] = new Vector2(2.95f, 0.55f);
        vertices[4] = new Vector2(2.63f, 0.18f);
        vertices[5] = new Vector2(1.37f, 1.15f);
        vertices[6] = new Vector2(0.49f, 1.89f);
        vertices[7] = new Vector2(0.06f, 2.64f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

    @Override
    public ThrownObject clone() {
        return new Carrot(game, baseLevel);
    }
}
