package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class Button {
    static final int BUTTONTYPE_PLAYLEVELONE = 1;
    static final int BUTTONTYPE_PLAYLEVELTWO = 2;
    static final int BUTTONTYPE_PLAYLEVELTHREE = 3;
    static final int BUTTONTYPE_PLAYLEVELFOUR = 4;
    static final int BUTTONTYPE_PLAYLEVELFIVE = 5;

    static final int BUTTONTYPE_MAINMENU = 6;
    static final int BUTTONTYPE_NEXTIMAGE = 7;
    static final int BUTTONTYPE_PREVIMAGE = 8;

    static final int BUTTONTYPE_PLAYENDLESS = 9;
    static final int BUTTONTYPE_TUTORIAL = 10;
    static final int BUTTONTYPE_RECIPES = 11;
    static final int BUTTONTYPE_SOUND = 12;
    static final int BUTTONTYPE_MUSIC = 13;

    static final int BUTTONTYPE_PLAYMODES = 14;

    static final int BUTTONTYPE_FIRSTRECIPE = 15;
    static final int BUTTONTYPE_SECONDRECIPE = 16;

    static final int BUTTONTYPE_LANGUAGE = 17;

    static final int BUTTONTYPE_LOCKED = 18;
    static final int BUTTONTYPE_DIETMODE = 19;

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
    private Sound clickSound;

    public Button(MyGame g, String notPressedTextureSource, String pressedTextureSource, float x, float y, float buttonSize, int bType) {
        game = g;
        buttonType = bType;
        buttonNotPressedTexture = new Texture(notPressedTextureSource);
        buttonPressedTexture = new Texture(pressedTextureSource);
        buttonTexture = buttonNotPressedTexture;
        clickSound = Gdx.audio.newSound(Gdx.files.internal("Klikkaus.ogg"));

        if(buttonType == BUTTONTYPE_SOUND) {
            if(game.getPrefs().getSoundStatus()) {
                buttonTexture = buttonNotPressedTexture;
            } else {
                buttonTexture = buttonPressedTexture;
            }
        }
        if(buttonType == BUTTONTYPE_MUSIC) {
            if(game.getPrefs().getMusicStatus()) {
                buttonTexture = buttonNotPressedTexture;
            } else {
                buttonTexture = buttonPressedTexture;
            }
        }
        if(buttonType == BUTTONTYPE_LANGUAGE) {
            if(game.getPrefs().getCurrentLanguage() == game.getFinBundle()) {
                buttonTexture = buttonNotPressedTexture;
            } else {
                buttonTexture = buttonPressedTexture;
            }
        }

        if(buttonSize == 1) {
            buttonRect = new Rectangle(x, y, 1.2f, 1.2f);
        } else if(buttonSize == 2) {
            buttonRect = new Rectangle(x, y, 3.5f, 1.2f);
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
            if(game.getPrefs().getSoundStatus()) {
                clickSound.play();
            }
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
                case BUTTONTYPE_PLAYLEVELTWO:
                    game.setScreen(new SecondLevel(game));
                    break;
                case BUTTONTYPE_PLAYLEVELTHREE:
                    game.setScreen(new ThirdLevel(game));
                    break;
                case BUTTONTYPE_TUTORIAL:
                    game.setScreen(new TutorialScreen(game));
                    break;
                case BUTTONTYPE_RECIPES:
                    game.setScreen((new RecipeMenu(game)));
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
                    game.getPrefs().toggleMusic();
                    if(game.getPrefs().getMusicStatus()) {
                        game.getMenuTheme().play();
                    } else {
                        game.getMenuTheme().stop();
                    }
                    break;
                case BUTTONTYPE_SOUND:
                    game.getPrefs().toggleSound();
                    break;
                case BUTTONTYPE_FIRSTRECIPE:
                    game.setScreen(new Recipe(game, recipeType.hotPot));
                    break;
                case BUTTONTYPE_SECONDRECIPE:
                    game.setScreen(new Recipe(game, recipeType.meatSoup));
                    break;
                case BUTTONTYPE_LANGUAGE:
                    game.getPrefs().toggleLanguage();
                    break;
                case BUTTONTYPE_DIETMODE:
                    game.getPrefs().toggleDisplayGameMode();
                    break;
                case BUTTONTYPE_LOCKED:
                    break;
            }
            return true;
        }
        return false;
    }
    public void setTexture(int x, int y, boolean pressed) {
        Vector3 touch = new Vector3(x, y, 0);
        game.getCamera().unproject(touch);

        if (buttonType != BUTTONTYPE_MUSIC &&
                buttonType != BUTTONTYPE_SOUND &&
                buttonType != BUTTONTYPE_LANGUAGE) {
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
    public void setButtonType(int type) {
        buttonType = type;
    }
    public Texture getButtonTexture() {
        return buttonTexture;
    }

    public Rectangle getButtonRect() {
        return buttonRect;
    }

    public void dispose() {
        buttonTexture.dispose();
        buttonPressedTexture.dispose();
        buttonNotPressedTexture.dispose();
        clickSound.dispose();
    }
}
