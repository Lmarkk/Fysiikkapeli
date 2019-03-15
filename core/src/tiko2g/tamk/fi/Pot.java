package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Pot {
    private MyGame game;
    private SpriteBatch batch;
    private BaseLevel baseLevel;
    private Texture potTexture;
    private Body leftSide;
    private Body rightSide;
    private Body bottom;
    private Rectangle leftSideRect;
    private Rectangle rightSideRect;
    private Rectangle bottomRect;

    public Pot(BaseLevel b, MyGame g) {
        game = g;
        batch = g.getBatch();
        baseLevel = b;
        potTexture = new Texture("groundtexture.png");
        createPot(10, 1);

    }
    public BodyDef getPotBodyDef(float x, float y) {
        BodyDef potBodyDef = new BodyDef();
        potBodyDef.type = BodyDef.BodyType.StaticBody;
        potBodyDef.position.set(x, y);
        return potBodyDef;
    }

    public FixtureDef getPotFixtureDef(float hX, float hY) {
        FixtureDef potFixtureDef = new FixtureDef();
        potFixtureDef.density = 1.0f;
        potFixtureDef.restitution = 0.2f;
        potFixtureDef.friction = 0.5f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(hX, hY);
        potFixtureDef.shape = polygonShape;
        return potFixtureDef;
    }
    public void createPot(float x, float y) {

        leftSide = baseLevel.getGameWorld().createBody(getPotBodyDef(x+0.25f, y+1.75f));
        rightSide = baseLevel.getGameWorld().createBody(getPotBodyDef(x+2.75f, y+1.75f));
        bottom = baseLevel.getGameWorld().createBody(getPotBodyDef(x+1.5f, y+0.25f));

        leftSide.createFixture(getPotFixtureDef(0.25f,1.25f));
        rightSide.createFixture(getPotFixtureDef(0.25f,1.25f));
        bottom.createFixture(getPotFixtureDef(1.5f,0.25f));

        leftSideRect = new Rectangle(x, y+0.5f, 0.5f, 2.5f);
        rightSideRect = new Rectangle(x+2.5f, y+0.5f, 0.5f, 2.5f);
        bottomRect = new Rectangle(x, y, 3, 0.5f);
    }

    public void draw() {
        batch.draw(potTexture, leftSideRect.x, leftSideRect.y, leftSideRect.getWidth(), leftSideRect.getHeight());
        batch.draw(potTexture, rightSideRect.x, rightSideRect.y, rightSideRect.getWidth(), rightSideRect.getHeight());
        batch.draw(potTexture, bottomRect.x, bottomRect.y, bottomRect.getWidth(), bottomRect.getHeight());
    }
}
