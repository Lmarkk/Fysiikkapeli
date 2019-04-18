package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * The type Bell pepper.
 */
public class BellPepper extends ThrownObject {

    private float scale = 0.17f;

    /**
     * Instantiates a new Bell pepper.
     *
     * @param g the g
     * @param b the b
     */
    public BellPepper(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.67f);
        setTexture(new Texture("object-bellpepper.png"));
        setBody(getBodyDef(), getFixtureDef(1f, 0, 1f, getVertices()));
    }


    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(1.72f, 7.27f);
        vertices[1] = new Vector2(5.29f, 8.62f);
        vertices[2] = new Vector2(6.10f, 7.78f);
        vertices[3] = new Vector2(7.14f, 4.78f);
        vertices[4] = new Vector2(4.25f, 0.12f);
        vertices[5] = new Vector2(1.09f, 0.68f);
        vertices[6] = new Vector2(0.22f, 2.93f);
        vertices[7] = new Vector2(1.02f, 6.30f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public ThrownObject cloneObject() {
        return new BellPepper(game, baseLevel);
    }
}
