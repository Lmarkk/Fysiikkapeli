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
    private Texture potBottomTexture;
    private Texture potTopTexture;
    private Texture debugTexture;
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
        potBottomTexture = new Texture("kattila_bottom.png");
        potTopTexture = new Texture("kattila_top.png");
        debugTexture = new Texture("badlogic.jpg");
        createPot(10, 1, 0.33f);

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
    public void createPot(float x, float y, float scale) {
        float sideRectWidth = 0.2f;
        float sideRectHeight = 2.5f;
        float bottomRectHeight = 0.5f;
        float potWidth = potBottomTexture.getWidth() / 100f * scale;
        leftSide = baseLevel.getGameWorld().createBody(getPotBodyDef(x - sideRectWidth / 2f, y + sideRectHeight / 2f));
        rightSide = baseLevel.getGameWorld().createBody(getPotBodyDef(x + (potWidth + sideRectWidth / 2f), y + sideRectHeight / 2f));
        bottom = baseLevel.getGameWorld().createBody(getPotBodyDef(x + potWidth / 2f, y + bottomRectHeight / 2f));

        leftSide.createFixture(getPotFixtureDef(sideRectWidth / 2f, sideRectHeight / 2f));
        rightSide.createFixture(getPotFixtureDef(sideRectWidth / 2f,sideRectHeight / 2f));
        bottom.createFixture(getPotFixtureDef(potWidth / 2f,bottomRectHeight / 2f));

        leftSideRect = new Rectangle(x - sideRectWidth, y, sideRectWidth, sideRectHeight);
        rightSideRect = new Rectangle(x + potWidth, y, sideRectWidth, sideRectHeight);
        bottomRect = new Rectangle(x, y, potWidth, bottomRectHeight);
    }

    public void draw() {
        batch.draw(potBottomTexture, bottomRect.x, bottomRect.y - 0.75f, bottomRect.getWidth(), bottomRect.getHeight() * 6);
        batch.draw(potTopTexture, bottomRect.x, bottomRect.y - 0.75f, bottomRect.getWidth(), bottomRect.getHeight() * 6);
        batch.draw(debugTexture, leftSideRect.x, leftSideRect.y, leftSideRect.getWidth(), leftSideRect.getHeight());
        batch.draw(debugTexture, rightSideRect.x, rightSideRect.y, rightSideRect.getWidth(), rightSideRect.getHeight());
        batch.draw(debugTexture, bottomRect.x, bottomRect.y, bottomRect.getWidth(), bottomRect.getHeight());
    }
}
