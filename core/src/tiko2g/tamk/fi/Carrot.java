package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Carrot extends ThrownObject {
    private float scale = 0.24f;

    public Carrot(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.65f);
        setTexture(new Texture("object-carrot.png"));
        setBody(getBodyDef(), getFixtureDef(1.5f, 0, 1f, getVertices()));
    }
    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(1.22f, 6.46f);
        vertices[1] = new Vector2(3.65f, 2.75f);
        vertices[2] = new Vector2(5.00f, 0.55f);
        vertices[3] = new Vector2(4.45f, 0.03f);
        vertices[4] = new Vector2(1.85f, 2.62f);
        vertices[5] = new Vector2(0.01f, 5.83f);
        vertices[6] = new Vector2(0.04f, 6.64f);
        vertices[7] = new Vector2(0.70f, 6.72f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public ThrownObject cloneObject() {
        return new Carrot(game, baseLevel);
    }
}
