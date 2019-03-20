package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Button {
    static final int BUTTONTYPE_PLAY = 1;
    static final int BUTTONTYPE_TUTORIAL = 2;
    static final int BUTTONTYPE_RECIPES = 3;
    static final int BUTTONTYPE_SOUND = 4;
    static final int BUTTONTYPE_MUSIC = 5;
    static final int BUTTONTYPE_MAINMENU = 6;
    static final int BUTTONTYPE_NEXTIMAGE = 7;
    static final int BUTTONTYPE_PREVIMAGE = 8;

    private MyGame game;
    private int buttonType;
    private Rectangle buttonRect;
    private Texture buttonTexture;
    private TutorialScreen tutorialScreen;
    private RecipeMenu recipeMenu;

    public Button(MyGame g, String textureSource, float x, float y, float width, float height, int bType) {
        game = g;
        buttonType = bType;
        buttonTexture = new Texture(textureSource);
        buttonRect = new Rectangle(x, y, width, height);
    }
    public void draw(SpriteBatch batch) {
        batch.draw(buttonTexture, buttonRect.getX(), buttonRect.getY(), buttonRect.getWidth(), buttonRect.getHeight());
    }
    public boolean pressFunction(int x, int y) {
        Vector3 touch = new Vector3(x, y, 0);
        game.getCamera().unproject(touch);
        if(buttonRect.contains(touch.x, touch.y)) {
            switch(buttonType){
                case BUTTONTYPE_PLAY:
                    game.setScreen(new EndlessLevel(game));
                    break;
                case BUTTONTYPE_TUTORIAL:
                    tutorialScreen = new TutorialScreen(game);
                    game.setScreen(tutorialScreen);
                    break;
                case BUTTONTYPE_RECIPES:
                    recipeMenu = new RecipeMenu(game);
                    game.setScreen(recipeMenu);
                    break;
                case BUTTONTYPE_MAINMENU:
                    game.setScreen(new MainMenu(game));
                    break;
                case BUTTONTYPE_NEXTIMAGE:
                    break;
                case BUTTONTYPE_PREVIMAGE:
                    break;
            }
            return true;
        }
        return false;
    }
    public void setTexture(int x, int y, boolean pressed) {
        if(pressed) {
            Vector3 touch = new Vector3(x, y, 0);
            game.getCamera().unproject(touch);
            if(buttonRect.contains(touch.x, touch.y)) {
                buttonTexture = new Texture("button-pressed.png");
            }
        } else {
            buttonTexture = new Texture("button.png");
        }

    }
    public void setX(float x) {
        buttonRect.setX(x);
    }
    public Texture getButtonTexture() {
        return buttonTexture;
    }

    public Rectangle getButtonRect() {
        return buttonRect;
    }
}
