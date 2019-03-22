package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Pot {
    private MyGame game;
    private SpriteBatch batch;
    private BaseLevel baseLevel;
    private Texture potBottomTexture;
    private Texture potTopTexture;
    private Texture debugTexture;
    private Body potBody;
    private Rectangle potRect;
    private Rectangle leftSideRect;
    private Rectangle rightSideRect;
    private Rectangle bottomRect;
    private float potWidth;
    private float potHeight;
    private float potScale = 1.3f;
    private float potTextureScale = 1.2f;
    private float potYOffset = 0.5f;

    public Pot(BaseLevel b, MyGame g) {
        game = g;
        batch = g.getBatch();
        baseLevel = b;
        potBottomTexture = new Texture("cauldron-bottom.png");
        potTopTexture = new Texture("cauldron-top.png");
        debugTexture = new Texture("badlogic.jpg");
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
        potFixtureDef.restitution = 0f;
        potFixtureDef.friction = 1f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(hX, hY);
        potFixtureDef.shape = polygonShape;
        return potFixtureDef;
    }
    private FixtureDef getPotFixtureDef(Vector2 v1, Vector2 v2){
        FixtureDef potFixtureDef = new FixtureDef();
        potFixtureDef.density = 1.0f;
        potFixtureDef.restitution = 0f;
        potFixtureDef.friction = 1f;
        EdgeShape edgeShape = new EdgeShape();
        edgeShape.set(v1, v2);
        potFixtureDef.shape = edgeShape;
        return potFixtureDef;
    }
    public void createPot(float x, float y) {
        potBody = baseLevel.getGameWorld().createBody(getPotBodyDef(x, y));
        potBody.createFixture(getPotFixtureDef(new Vector2(0, 1.8f * potScale), new Vector2(0f, 0.55f * potScale)));
        potBody.createFixture(getPotFixtureDef(new Vector2(0, 0.55f * potScale), new Vector2(0.5f * potScale, 0.1f * potScale)));
        potBody.createFixture(getPotFixtureDef(new Vector2(0.5f * potScale, 0.1f * potScale), new Vector2(2f * potScale, 0.1f * potScale)));
        potBody.createFixture(getPotFixtureDef(new Vector2(2f * potScale, 0.1f * potScale), new Vector2(2.6f * potScale, 0.55f * potScale)));
        potBody.createFixture(getPotFixtureDef( new Vector2(2.6f * potScale, 0.55f * potScale), new Vector2(2.6f * potScale, 1.8f * potScale)));
        float sideRectWidth = 0.2f;
        float sideRectHeight = (potBottomTexture.getHeight() / 100f * potScale) - potYOffset / 2f;
        float bottomRectHeight = 0.5f;
        potWidth = potBottomTexture.getWidth() / 100f * potScale;
        potHeight = potBottomTexture.getHeight() / 100f * potScale;
//        leftSide = baseLevel.getGameWorld().createBody(getPotBodyDef(x - sideRectWidth / 2f, y + sideRectHeight / 2f));
//        rightSide = baseLevel.getGameWorld().createBody(getPotBodyDef(x + (potWidth + sideRectWidth / 2f), y + sideRectHeight / 2f));
//        bottom = baseLevel.getGameWorld().createBody(getPotBodyDef(x + potWidth / 2f, y + bottomRectHeight / 2f));
//
////        leftSide.setTransform(leftSide.getPosition(), 45f);
//
//        leftSide.createFixture(getPotFixtureDef(sideRectWidth / 2f, sideRectHeight / 2f));
//        rightSide.createFixture(getPotFixtureDef(sideRectWidth / 2f,sideRectHeight / 2f));
//        bottom.createFixture(getPotFixtureDef(potWidth / 2f,bottomRectHeight / 2f));
//
        leftSideRect = new Rectangle(x - sideRectWidth, y, sideRectWidth, sideRectHeight);
//        rightSideRect = new Rectangle(x + potWidth, y, sideRectWidth, sideRectHeight);
        bottomRect = new Rectangle(x, y, potWidth, bottomRectHeight);
        potRect = new Rectangle(x + 0.35f * potScale, y + 0.2f * potScale, 2f * potScale, 1 * potScale);
    }
    public void drawTop(){
        Vector2 bottomRectCenter = new Vector2();
        bottomRectCenter = bottomRect.getCenter(bottomRectCenter);
        batch.draw(potTopTexture, bottomRectCenter.x - (bottomRect.width * potTextureScale) / 2f,
                leftSideRect.y - potYOffset, potWidth * potTextureScale, potHeight * potTextureScale);
    }
    public void draw() {
        Vector2 bottomRectCenter = new Vector2();
        bottomRectCenter = bottomRect.getCenter(bottomRectCenter);
        batch.draw(potBottomTexture, bottomRectCenter.x - (bottomRect.width * potTextureScale) / 2f,
                leftSideRect.y - potYOffset, potWidth * potTextureScale, potHeight * potTextureScale);
    }

    public Rectangle getPotRect() {
        return potRect;
    }
}
