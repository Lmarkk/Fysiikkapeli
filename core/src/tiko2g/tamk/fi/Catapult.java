package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Catapult {
    private Texture texture;
    private TextureRegion currentFrame;
    private Animation<TextureRegion> shootAnimaton;
    private float stateTime;
    private float flipFrame;
    private float originX;
    private float originY;

    public Catapult() {
        texture = new Texture("object-animated-catapult");
        TextureRegion[][] temp = TextureRegion.split(texture, texture.getWidth() /8, texture.getHeight());
        TextureRegion[] frames = new TextureRegion[8];

        frames[0] =  temp[0][0];
        frames[1] =  temp[0][1];
        frames[2] =  temp[0][2];
        frames[3] =  temp[0][3];
        frames[4] =  temp[0][4];
        frames[5] =  temp[0][5];
        frames[6] =  temp[0][6];
        frames[7] =  temp[0][7];

        shootAnimaton = new Animation<TextureRegion>(4 / 40f, frames);
        stateTime = 0.0f;
    }

}
