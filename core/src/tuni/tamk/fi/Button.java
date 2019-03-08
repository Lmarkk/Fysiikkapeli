package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Button {
    static  final int BUTTONTYPE_PLAY = 1;
    static final int BUTTONTYPE_TUTORIAL = 2;
    static  final int BUTTONTYPE_SETTINGS = 3;

    MyGame game;
    int buttonType;
    Rectangle buttonRect;
    Texture buttonTexture;

    public Button(MyGame g, String textureSource, float x, float y, float width, float height, int bType) {
        game = g;
        buttonType = bType;
        buttonTexture = new Texture(textureSource);
        buttonRect = new Rectangle(x, y, width, height);
    }
    public void draw(SpriteBatch batch) {
        batch.draw(buttonTexture, buttonRect.getX(), buttonRect.getY(), buttonRect.getWidth(), buttonRect.getHeight());
    }
    public void pressFunction() {
        if(Gdx.input.justTouched()) {
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.getCamera().unproject(touch);
            if(buttonRect.contains(touch.x, touch.y)) {
                switch(buttonType){
                    case BUTTONTYPE_PLAY:
                        game.setScreen(new EndlessLevel(game));
                        break;
                    case BUTTONTYPE_TUTORIAL:
                        break;
                    case BUTTONTYPE_SETTINGS:
                        break;
                }
            }
        }
    }

    public Texture getButtonTexture() {
        return buttonTexture;
    }
}
