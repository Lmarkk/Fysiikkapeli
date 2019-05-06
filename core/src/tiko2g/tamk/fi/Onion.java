package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * ThrownObject type of Onion.
 *
 * @author Arttu Knuutinen
 * @version 2.0
 */
public class Onion extends ThrownObject {
    /**
     * Scale affects the "physical" size of the object.
     */
    private float scale = 0.45f;

    /**
     * Instantiates a new Onion.
     *
     * @param g the MyGame instance
     * @param b the BaseLevel reference
     */
    public Onion(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.65f);
        setTexture(new Texture("object-onion.png"));
        setBody(getBodyDef(), getFixtureDef(1f, 0, 1f, getVertices()));
    }

    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0.83f, 0.5f);
        vertices[1] = new Vector2(1.74f, 2.5f);
        vertices[2] = new Vector2(2.34f, 2.5f);
        vertices[3] = new Vector2(2.73f, 1f);
        vertices[4] = new Vector2(2.61f, 0.36f);
        vertices[5] = new Vector2(1.04f, 0.05f);
        vertices[6] = new Vector2(0.11f, 0.38f);
        vertices[7] = new Vector2(0.09f, 1.58f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }


    @Override
    public ThrownObject cloneObject() {
        return new Onion(getGame(), getBaseLevel());
    }
}