package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Potato extends ThrownObject {
    private float scale = 0.37f;

    public Potato(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.6f);
        setTexture(new Texture("object-potato.png"));
        setBody(getBodyDef(), getFixtureDef(1f, 0, 1f, getVertices()));
    }
    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0.31f, 1.93f);
        vertices[1] = new Vector2(1.18f, 2.56f);
        vertices[2] = new Vector2(2.50f, 2.71f);
        vertices[3] = new Vector2(3.58f, 1.89f);
        vertices[4] = new Vector2(3.15f, 0.55f);
        vertices[5] = new Vector2(1.69f, 0.01f);
        vertices[6] = new Vector2(0.41f, 0.31f);
        vertices[7] = new Vector2(0.01f, 1.23f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public ThrownObject cloneObject() {
        return new Potato(game, baseLevel);
    }
}
