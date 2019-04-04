package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Arrow {

    private Texture texture;
    private Rectangle rectangle;
    private float rotation;
//
    public Arrow(){
        texture = new Texture("arrow.png");
        rectangle = new Rectangle(3, 3, 2.56f, 1f);
    }

    public Texture getTexture() {
        return texture;
    }
    public void draw(SpriteBatch batch, Vector2 startPos, Vector2 endPos){
        Vector2 startPos2 = new Vector2(startPos.x, startPos.y);
        Vector2 endPos2 = new Vector2(endPos.x, endPos.y);
        float length = getMagnitude(startPos2.sub(endPos2));
        startPos2.y *= -1;
        float angle = startPos2.angle();
        rotation = angle;
//        float length = startPos2.sub(endPos2).len();
//        System.out.println(length);
        batch.draw(texture,
                rectangle.x,
                rectangle.y,
                0,
                rectangle.getHeight() / 2f,
                length,
                rectangle.getHeight(),
                1,
                1,
                rotation,
                0,
                0,
                texture.getWidth(),
                texture.getHeight(),
                false,
                false);
    }

    private void setRotation(){

    }
    private float getMagnitude(Vector2 v){
        return (float)Math.sqrt((double)(v.x * v.x + v.y * v.y));
    }
}
