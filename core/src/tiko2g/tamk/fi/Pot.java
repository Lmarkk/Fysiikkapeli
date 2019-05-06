package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 * Pot is the "goal" object inside the game.
 *
 * @author Arttu Knuutinen
 * @version 2.0
 */
public class Pot {
    private MyGame game;
    private SpriteBatch batch;
    private BaseLevel baseLevel;
    private Texture potBottomTexture;
    private Texture potTopTexture;
    private Body potBody;
    private Rectangle potRect;
    private Rectangle leftSideRect;
    private Rectangle bottomRect;
    private float potWidth;
    private float potHeight;
    private float potScale = 1.3f;
    private float potTextureScale = 1.2f;
    private float potYOffset = 0.5f;

    /**
     * Instantiates a new Pot.
     *
     * @param b the BaseLevel reference
     * @param g the MyGame instance
     * @param x the x position of the Pot
     * @param y the y position of the Pot
     */
    public Pot(BaseLevel b, MyGame g, float x, float y) {
        game = g;
        batch = g.getBatch();
        baseLevel = b;
        potBottomTexture = new Texture("cauldron-bottom.png");
        potTopTexture = new Texture("cauldron-top.png");
        createPot(x, y);

    }

    /**
     * Gets pot body def.
     *
     * @param x the x position
     * @param y the y position
     * @return the pot body def
     */
    public BodyDef getPotBodyDef(float x, float y) {
        BodyDef potBodyDef = new BodyDef();
        potBodyDef.type = BodyDef.BodyType.StaticBody;
        potBodyDef.position.set(x, y);
        return potBodyDef;
    }

    /**
     * Gets the FixtureDef of the pot and creates an edgeshape in given coordinates.
     *
     * @param v1 the start position for edgeshape
     * @param v2 the end position for edgeshape
     * @return the fixture def in the shape of an "edge"
     */
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

    /**
     * Creates the pot and its colliders in given coordinates.
     *
     * @param x the x position
     * @param y the y position
     */
    public void createPot(float x, float y) {
        potBody = baseLevel.getGameWorld().createBody(getPotBodyDef(x, y));
        potBody.createFixture(getPotFixtureDef(new Vector2(0, 1.8f * potScale), new Vector2(0f, 0.55f * potScale)));
        potBody.createFixture(getPotFixtureDef(new Vector2(0, 0.55f * potScale), new Vector2(0.5f * potScale, 0.1f * potScale)));
        potBody.createFixture(getPotFixtureDef(new Vector2(0.5f * potScale, 0.1f * potScale), new Vector2(2f * potScale, 0.1f * potScale)));
        potBody.createFixture(getPotFixtureDef(new Vector2(2f * potScale, 0.1f * potScale), new Vector2(2.6f * potScale, 0.55f * potScale)));
        potBody.createFixture(getPotFixtureDef(new Vector2(2.6f * potScale, 0.55f * potScale), new Vector2(2.6f * potScale, 1.8f * potScale)));

        float sideRectWidth = 0.2f;
        float sideRectHeight = (potBottomTexture.getHeight() / 100f * potScale) - potYOffset / 2f;
        float bottomRectHeight = 0.5f;
        potWidth = potBottomTexture.getWidth() / 100f * potScale;
        potHeight = potBottomTexture.getHeight() / 100f * potScale;

        leftSideRect = new Rectangle(x - sideRectWidth, y, sideRectWidth, sideRectHeight);
        bottomRect = new Rectangle(x, y, potWidth, bottomRectHeight);
        potRect = new Rectangle(x + 0.35f * potScale, y + 0.2f * potScale, 2f * potScale, 1 * potScale);
    }

    /**
     * Draws the top part of Pot texture.
     */
    public void drawTop(){
        Vector2 bottomRectCenter = new Vector2();
        bottomRectCenter = bottomRect.getCenter(bottomRectCenter);
        batch.draw(potTopTexture, bottomRectCenter.x - (bottomRect.width * potTextureScale) / 2f,
                leftSideRect.y - potYOffset, potWidth * potTextureScale, potHeight * potTextureScale);
    }

    /**
     * Draws the bottom part of Pot texture.
     */
    public void draw() {
        Vector2 bottomRectCenter = new Vector2();
        bottomRectCenter = bottomRect.getCenter(bottomRectCenter);
        batch.draw(potBottomTexture, bottomRectCenter.x - (bottomRect.width * potTextureScale) / 2f,
                leftSideRect.y - potYOffset, potWidth * potTextureScale, potHeight * potTextureScale);
    }

    /**
     * Gets pot rect.
     *
     * @return the pot rect
     */
    public Rectangle getPotRect() {
        return potRect;
    }
}
