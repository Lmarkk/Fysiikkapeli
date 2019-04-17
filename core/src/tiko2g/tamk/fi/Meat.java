package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Meat extends ThrownObject {
    private float scale = 0.5f;

    public Meat(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.6f);
        setTexture(new Texture("meat.png"));
        setBody(getBodyDef(), getFixtureDef(1.3f, 0, 1f, getVertices()));
    }
    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0, 1);
        vertices[1] = new Vector2(0, 1.9f);
        vertices[2] = new Vector2(0.53f, 2.15f);
        vertices[3] = new Vector2(1.53f, 1.9f);
        vertices[4] = new Vector2(2.37f, 0.47f);
        vertices[5] = new Vector2(2.24f, 0f);
        vertices[6] = new Vector2(1.55f, 0.13f);
        vertices[7] = new Vector2(0.44f, 0.49f);
        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public ThrownObject cloneObject() {
        return new Meat(game, baseLevel);
    }
}
