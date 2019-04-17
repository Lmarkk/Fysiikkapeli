package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Onion extends ThrownObject {
    private float scale = 0.45f;

    public Onion(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.65f);
        setTexture(new Texture("object-onion.png"));
        setBody(getBodyDef(), getFixtureDef(0.8f, 0, 1f, getVertices()));
    }

    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0.83f, 2.56f);
        vertices[1] = new Vector2(1.74f, 3.2f);
        vertices[2] = new Vector2(2.34f, 3.2f);
        vertices[3] = new Vector2(2.73f, 1.97f);
        vertices[4] = new Vector2(2.61f, 0.56f);
        vertices[5] = new Vector2(1.04f, 0.05f);
        vertices[6] = new Vector2(0.11f, 0.78f);
        vertices[7] = new Vector2(0.09f, 2.08f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }


    @Override
    public ThrownObject cloneObject() {
        return new Onion(game, baseLevel);
    }
}
