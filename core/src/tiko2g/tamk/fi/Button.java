package tiko2g.tamk.fi;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import static tiko2g.tamk.fi.MyGame.playSounds;

public class Button {
    static final int BUTTONTYPE_PLAYENDLESS = 1;
    static final int BUTTONTYPE_TUTORIAL = 2;
    static final int BUTTONTYPE_RECIPES = 3;
    static final int BUTTONTYPE_SOUND = 4;
    static final int BUTTONTYPE_MUSIC = 5;
    static final int BUTTONTYPE_MAINMENU = 6;
    static final int BUTTONTYPE_NEXTIMAGE = 7;
    static final int BUTTONTYPE_PREVIMAGE = 8;
    static final int BUTTONTYPE_PLAYLEVELONE = 9;
    static final int BUTTONTYPE_PLAYMODES = 10;

    static final float BUTTONSIZE_VERYSMALL = 1;
    static final float BUTTONSIZE_SMALL = 2;
    static final float BUTTONSIZE_MEDIUM = 3;
    static final float BUTTONSIZE_LARGE = 4;

    private MyGame game;
    private int buttonType;
    private Rectangle buttonRect;
    private Texture buttonTexture;
    private Texture buttonNotPressedTexture;
    private Texture buttonPressedTexture;
    private TutorialScreen tutorialScreen;
    private RecipeMenu recipeMenu;

    public Button(MyGame g, String notPressedTextureSource, String pressedTextureSource, float x, float y, float buttonSize, int bType) {
        game = g;
        buttonType = bType;
        buttonNotPressedTexture = new Texture(notPressedTextureSource);
        buttonPressedTexture = new Texture(pressedTextureSource);
        buttonTexture = buttonNotPressedTexture;

        if(buttonType == BUTTONTYPE_SOUND) {
            if(playSounds) {
                buttonTexture = buttonNotPressedTexture;
            } else {
                buttonTexture = buttonPressedTexture;
            }
        }

        if(buttonSize == 1) {
            buttonRect = new Rectangle(x, y, 1.2f, 1.2f);
        } else if(buttonSize == 2) {
            buttonRect = new Rectangle(x, y, 2.5f, 1.2f);
        } else if(buttonSize == 3) {
            buttonRect = new Rectangle(x, y, 6.6f, 1.6f);
        } else if(buttonSize == 4) {
            buttonRect = new Rectangle(x, y, 6.6f, 2.1f);
        }
    }
    public void draw(SpriteBatch batch) {
        batch.draw(buttonTexture, buttonRect.getX(), buttonRect.getY(), buttonRect.getWidth(), buttonRect.getHeight());
    }
    public Button getButton(int x, int y){
        Vector3 touch = new Vector3(x, y, 0);
        game.getCamera().unproject(touch);
        if(buttonRect.contains(touch.x, touch.y)) {
            return this;
        }
        return null;
    }
    public boolean pressFunction(int x, int y) {
        Vector3 touch = new Vector3(x, y, 0);
        game.getCamera().unproject(touch);
        Screen currentScreen = game.getScreen();
        if(buttonRect.contains(touch.x, touch.y)) {
            switch(buttonType){
                case BUTTONTYPE_PLAYENDLESS:
                    game.setScreen(new EndlessLevel(game));
                    break;
                case BUTTONTYPE_PLAYMODES:
                    game.setScreen(new LevelSelectScreen(game));
                    break;
                case BUTTONTYPE_PLAYLEVELONE:
                    game.setScreen(new FirstLevel(game));
                    break;
                case BUTTONTYPE_TUTORIAL:
                    game.createTutorialScreen();
                    break;
                case BUTTONTYPE_RECIPES:
                    game.createRecipeMenu();
                    break;
                case BUTTONTYPE_MAINMENU:
                    game.setScreen(new MainMenu(game));
                    break;
                case BUTTONTYPE_NEXTIMAGE:
                    ((BaseMenu)currentScreen).changeImage(true);
                    break;
                case BUTTONTYPE_PREVIMAGE:
                    ((BaseMenu)currentScreen).changeImage(false);
                    break;
                case BUTTONTYPE_MUSIC:
                    break;
                case BUTTONTYPE_SOUND:
                    playSounds = !playSounds;
                    System.out.println(playSounds);
                    break;
            }
            return true;
        }
        return false;
    }
    public void setTexture(int x, int y, boolean pressed) {
        Vector3 touch = new Vector3(x, y, 0);
        game.getCamera().unproject(touch);

        if (buttonType != BUTTONTYPE_MUSIC && buttonType != BUTTONTYPE_SOUND) {
            if (pressed) {
                if (buttonRect.contains(touch.x, touch.y)) {
                    buttonTexture = buttonPressedTexture;
                }
            } else {
                buttonTexture = buttonNotPressedTexture;
            }
        } else {
            if (pressed) {
                if (buttonRect.contains(touch.x, touch.y)) {
                    if(buttonTexture == buttonNotPressedTexture) {
                        buttonTexture = buttonPressedTexture;
                    } else {
                        buttonTexture = buttonNotPressedTexture;
                    }
                }
            }
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
