package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * The type Lettuce.
 */
public class Lettuce extends ThrownObject {
    private float scale = 0.4f;

    /**
     * Instantiates a new Lettuce.
     *
     * @param g the g
     * @param b the b
     */
    public Lettuce(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.67f);
        setTexture(new Texture("Object-Lettuce.png"));
        setBody(getBodyDef(), getFixtureDef(0.87f, 0, 1f, getVertices()));
    }


    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0.59f, 3.10f);
        vertices[1] = new Vector2(1.88f, 3.46f);
        vertices[2] = new Vector2(3.27f, 2.97f);
        vertices[3] = new Vector2(3.69f, 1.88f);
        vertices[4] = new Vector2(3.15f, 0.54f);
        vertices[5] = new Vector2(1.89f, 0.01f);
        vertices[6] = new Vector2(0.59f, 0.53f);
        vertices[7] = new Vector2(0.01f, 1.88f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public ThrownObject cloneObject() {
        return new Lettuce(game, baseLevel);
    }
}
