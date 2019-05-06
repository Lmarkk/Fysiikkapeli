package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Arrow displays the angle and force of a throw.
 *
 * @author Arttu Knuutinen
 * @version 2.0
 */
public class Arrow {

    /**
     * The texture of the arrow.
     */
    private Texture texture;
    /**
     * The rectangle of the arrow.
     */
    private Rectangle rectangle;
    /**
     * The rotation of the arrow.
     */
    private float rotation;

    /**
     * Instantiates a new Arrow.
     */
    public Arrow(){
        texture = new Texture("arrow.png");
        rectangle = new Rectangle(3, 3, 2.56f, 1f);
    }

    /**
     * Gets texture.
     *
     * @return the texture
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * Draws the arrow.
     *
     * Draws the arrow starting from the start position and ending on the end position.
     * Arrow indicates the force and direction of a throw.
     *
     * @param batch    the SpriteBatch
     * @param startPos the start pos
     * @param endPos   the end pos
     */
    public void draw(SpriteBatch batch, Vector2 startPos, Vector2 endPos){
        Vector2 startPos2 = new Vector2(startPos.x, startPos.y);
        Vector2 endPos2 = new Vector2(endPos.x, endPos.y);
        float length = new Vector2(startPos2.sub(endPos2)).len();
        startPos2.y *= -1;
        float angle = startPos2.angle();
        rotation = angle;
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
}
