package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * ThrownObject type of Tomato.
 *
 * @author Arttu Knuutinen
 * @version 2.0
 */
public class Tomato extends ThrownObject {
    /**
     * Scale affects the "physical" size of the object.
     */
    private float scale = 0.35f;

    /**
     * Instantiates a new Tomato.
     *
     * @param g the MyGame instance
     * @param b the BaseLevel reference
     */
    public Tomato(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.65f);
        setTexture(new Texture("object-tomato.png"));
        setBody(getBodyDef(), getFixtureDef(1f, 0, 1f, getVertices()));
    }
    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0.59f, 3.1f);
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
        return new Tomato(getGame(), getBaseLevel());
    }
}
