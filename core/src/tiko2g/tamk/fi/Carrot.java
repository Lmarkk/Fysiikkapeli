package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Carrot extends ThrownObject {
    private float scale = 0.45f;

    public Carrot(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.65f);
        setTexture(new Texture("object-carrot.png"));
        setBody(getBodyDef(), getFixtureDef(1f, 0, 1f, getVertices()));
    }
    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(0, 3);
        vertices[1] = new Vector2(1.17f, 2.32f);
        vertices[2] = new Vector2(2.32f, 1.27f);
        vertices[3] = new Vector2(2.95f, 0.55f);
        vertices[4] = new Vector2(2.63f, 0.18f);
        vertices[5] = new Vector2(1.37f, 1.15f);
        vertices[6] = new Vector2(0.49f, 1.89f);
        vertices[7] = new Vector2(0.06f, 2.64f);

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
