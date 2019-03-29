package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

interface ThrownObject {

    void draw();

    BodyDef getBodyDef();

    FixtureDef getFixtureDef();

    Texture getTexture();

    Body getBody();

    boolean isThrown();

    void setThrown(boolean thrown);

    Rectangle getRect();

    ThrownObject clone();

}
