package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class BorderWall {
    MyGame game;
    BaseLevel baseLevel;
    Rectangle wallRect;
    SpriteBatch batch;
    Body wallBody;

    public BorderWall(MyGame g, BaseLevel b, float x, float y) {
        game = g;
        baseLevel = b;
        batch = game.getBatch();
        wallRect = new Rectangle(x, y, 1, 9);
        wallBody = baseLevel.getGameWorld().createBody(getWallBodyDef(x, y));
        wallBody.createFixture(getWallFixtureDef());
    }
    public BodyDef getWallBodyDef(float x, float y) {
        BodyDef wallBodyDef = new BodyDef();
        wallBodyDef.type = BodyDef.BodyType.StaticBody;
        wallBodyDef.position.set(x, y);
        return wallBodyDef;
    }

    public FixtureDef getWallFixtureDef() {
        FixtureDef wallFixtureDef = new FixtureDef();
        wallFixtureDef.density = 1.0f;
        wallFixtureDef.restitution = 0.2f;
        wallFixtureDef.friction = 0.5f;
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(0.2f, 25);
        wallFixtureDef.shape = polygonShape;
        return wallFixtureDef;
    }
}
