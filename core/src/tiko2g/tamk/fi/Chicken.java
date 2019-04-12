package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


public class Chicken extends ThrownObject{

    private float scale = 0.42f;

    public Chicken(MyGame g, BaseLevel b){
        super(g, b, 1f, 0.56f);
        setTexture(new Texture("object-chicken.png"));
        setBody(getBodyDef(), getFixtureDef(1f, 0, 1f, getVertices()));
    }


    @Override
    public Vector2[] getVertices(){
        Vector2[] vertices = new Vector2[8];
        vertices[0] = new Vector2(1.41f, 2.65f);
        vertices[1] = new Vector2(2.55f, 2f);
        vertices[2] = new Vector2(2.88f, 0.74f);
        vertices[3] = new Vector2(2.54f, 0.26f);
        vertices[4] = new Vector2(1.57f, 0.42f);
        vertices[5] = new Vector2(0.61f, 1f);
        vertices[6] = new Vector2(0.07f, 2f);
        vertices[7] = new Vector2(0.15f, 2.76f);

        for (Vector2 v2: vertices) {
            v2.scl(scale);
        }
        return vertices;
    }

    @Override
    public ThrownObject cloneObject() {
        return new Chicken(game, baseLevel);
    }
}
