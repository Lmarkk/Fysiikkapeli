package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Catapult {
    private Texture textureSheet;
    private TextureRegion currentFrame;
    private Animation<TextureRegion> shootAnimation;
    Rectangle rectangle;
    boolean shoot;
    private float stateTime;
    private float originX;
    private float originY;

    public Catapult(float x, float y) {
        textureSheet = new Texture("object-catapult-animated.png");
        TextureRegion[][] temp = TextureRegion.split(textureSheet, textureSheet.getWidth() /9, textureSheet.getHeight());
        TextureRegion[] frames = new TextureRegion[9];

        frames[0] = temp[0][0];
        frames[1] = temp[0][1];
        frames[2] = temp[0][2];
        frames[3] = temp[0][3];
        frames[4] = temp[0][4];
        frames[5] = temp[0][5];
        frames[6] = temp[0][6];
        frames[7] = temp[0][7];
        frames[8] = temp[0][8];

        shootAnimation = new Animation<TextureRegion>(1 / 100f, frames);
        stateTime = 0.0f;

        float width = (textureSheet.getWidth()/9) / 100f;
        float height = textureSheet.getHeight() / 100f;
        rectangle = new Rectangle(x, y, width, height);

        originX = rectangle.getWidth() / 2f;
        originY = rectangle.getHeight() /2f;

        shoot = false;
    }

    public void draw(SpriteBatch a) {

        currentFrame = shootAnimation.getKeyFrame(stateTime, false);
        if(shoot) {
            stateTime += Gdx.graphics.getDeltaTime();
        } else {
            stateTime = 0;
        }
        a.draw(currentFrame, getX(), getY(), originX, originY, rectangle.getWidth(), rectangle.getHeight(), 1.5f, 1.5f, 0);

    }

    public Texture getTexture() {
        return textureSheet;
    }
    public float getX() {
        return rectangle.x;
    }
    public float getY() {
        return rectangle.y;
    }
    public Rectangle getRect() {
        return rectangle;
    }
    public void setX(float newX) {
        rectangle.x = newX;
    }
    public void setY(float newY) {
        rectangle.y = newY;
    }
    public void setShoot(boolean value) {
        shoot = value;
    }

}
