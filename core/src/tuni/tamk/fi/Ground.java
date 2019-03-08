package tuni.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Ground {
    MyGame game;
    BaseLevel baseLevel;
    Texture groundTexture;
    Rectangle groundRect;
    SpriteBatch batch;
    Body groundBody;


    public Ground(MyGame g, BaseLevel b, String textureSource) {
        game = g;
        baseLevel = b;
        batch = game.getBatch();
        groundTexture = new Texture(textureSource);
        groundRect = new Rectangle(0,-3,64,4);
        groundBody = baseLevel.getGameWorld().createBody(getGroundBodyDef());
        groundBody.createFixture(getGroundFixtureDef());

    }
    public void draw() {
        batch.draw(groundTexture, groundRect.x, groundRect.y, groundRect.getWidth(), groundRect.getHeight());
    }

    public BodyDef getGroundBodyDef() {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyDef.BodyType.StaticBody;
        groundBodyDef.position.set(32, -1);
        return groundBodyDef;
    }

    public FixtureDef getGroundFixtureDef() {
        FixtureDef groundFixtureDef = new FixtureDef();
        groundFixtureDef.density = 1.0f;
        groundFixtureDef.restitution = 0.2f;
        groundFixtureDef.friction = 0.5f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(32, 2);
        groundFixtureDef.shape = polygonShape;
        return groundFixtureDef;
    }
}

