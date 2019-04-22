package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


/**
 * Class used for creating and handling pressable buttons in menus and levels in the game.
 * @author Lassi Markkinen, Arttu Knuutinen
 * @version 2019.0422
 */
public class Button {
    /**
     * The Buttontype playlevelone.
     */
    static final int BUTTONTYPE_PLAYLEVELONE = 1;
    /**
     * The Buttontype playleveltwo.
     */
    static final int BUTTONTYPE_PLAYLEVELTWO = 2;
    /**
     * The Buttontype playlevelthree.
     */
    static final int BUTTONTYPE_PLAYLEVELTHREE = 3;
    /**
     * The Buttontype playlevelfour.
     */
    static final int BUTTONTYPE_PLAYLEVELFOUR = 4;
    /**
     * The Buttontype playlevelfive.
     */
    static final int BUTTONTYPE_PLAYLEVELFIVE = 5;

    /**
     * The Buttontype playveganlevelone.
     */
    static final int BUTTONTYPE_PLAYVEGANLEVELONE = 6;
    /**
     * The Buttontype playveganleveltwo.
     */
    static final int BUTTONTYPE_PLAYVEGANLEVELTWO = 7;
    /**
     * The Buttontype playveganlevelthree.
     */
    static final int BUTTONTYPE_PLAYVEGANLEVELTHREE = 8;
    /**
     * The Buttontype playveganlevelfour.
     */
    static final int BUTTONTYPE_PLAYVEGANLEVELFOUR = 9;
    /**
     * The Buttontype playveganlevelfive.
     */
    static final int BUTTONTYPE_PLAYVEGANLEVELFIVE = 10;

    /**
     * The Buttontype mainmenu.
     */
    static final int BUTTONTYPE_MAINMENU = 11;
    /**
     * The Buttontype nextimage.
     */
    static final int BUTTONTYPE_NEXTIMAGE = 12;
    /**
     * The Buttontype previmage.
     */
    static final int BUTTONTYPE_PREVIMAGE = 13;

    /**
     * The Buttontype playendless.
     */
    static final int BUTTONTYPE_PLAYENDLESS = 14;
    /**
     * The Buttontype tutorial.
     */
    static final int BUTTONTYPE_TUTORIAL = 15;
    /**
     * The Buttontype recipes.
     */
    static final int BUTTONTYPE_RECIPES = 16;
    /**
     * The Buttontype sound.
     */
    static final int BUTTONTYPE_SOUND = 17;
    /**
     * The Buttontype music.
     */
    static final int BUTTONTYPE_MUSIC = 18;

    /**
     * The Buttontype playmodes.
     */
    static final int BUTTONTYPE_PLAYMODES = 19;

    /**
     * The Buttontype firstrecipe.
     */
    static final int BUTTONTYPE_FIRSTRECIPE = 20;
    /**
     * The Buttontype secondrecipe.
     */
    static final int BUTTONTYPE_SECONDRECIPE = 21;
    /**
     * The Buttontype thirdrecipe.
     */
    static final int BUTTONTYPE_THIRDRECIPE = 22;
    /**
     * The Buttontype fourthrecipe.
     */
    static final int BUTTONTYPE_FOURTHRECIPE = 23;
    /**
     * The Buttontype fifthrecipe.
     */
    static final int BUTTONTYPE_FIFTHRECIPE = 24;

    /**
     * The Buttontype veganfirstrecipe.
     */
    static final int BUTTONTYPE_VEGANFIRSTRECIPE = 25;
    /**
     * The Buttontype vegansecondrecipe.
     */
    static final int BUTTONTYPE_VEGANSECONDRECIPE = 26;
    /**
     * The Buttontype veganthirdrecipe.
     */
    static final int BUTTONTYPE_VEGANTHIRDRECIPE = 27;
    /**
     * The Buttontype veganfourthrecipe.
     */
    static final int BUTTONTYPE_VEGANFOURTHRECIPE = 28;
    /**
     * The Buttontype veganfifthrecipe.
     */
    static final int BUTTONTYPE_VEGANFIFTHRECIPE = 29;

    /**
     * The Buttontype language.
     */
    static final int BUTTONTYPE_LANGUAGE = 30;

    /**
     * The Buttontype locked.
     */
    static final int BUTTONTYPE_LOCKED = 31;
    /**
     * The Buttontype dietmode.
     */
    static final int BUTTONTYPE_DIETMODE = 32;

    /**
     * The Buttonsize verysmall.
     */
    static final float BUTTONSIZE_VERYSMALL = 1;
    /**
     * The Buttonsize small.
     */
    static final float BUTTONSIZE_SMALL = 2;
    /**
     * The Buttonsize medium.
     */
    static final float BUTTONSIZE_MEDIUM = 3;
    /**
     * The Buttonsize large.
     */
    static final float BUTTONSIZE_LARGE = 4;

    /**
     * MyGame instance received in the constructor.
     */
    private MyGame game;
    /**
     * Integer variable that determines a button's function.
     */
    private int buttonType;
    /**
     * Rectangle used for button texture and text rendering.
     */
    private Rectangle buttonRect;
    /**
     * Currently active texture of the button, changed depending on conditions.
     */
    private Texture buttonTexture;
    /**
     * Texture assigned to buttonTexture when the button is not pressed down.
     */
    private Texture buttonNotPressedTexture;
    /**
     * Texture assigned to buttonTexture when the button is pressed down.
     */
    private Texture buttonPressedTexture;
    /**
     * Texture that is drawn on top of buttonTexture for buttons whose type is "locked".
     */
    private Texture buttonLock;
    /**
     * Sound that plays whenever a button is pressed.
     */
    private Sound clickSound;

    /**
     * Instantiates a new Button. If-statements are used to handle toggling persistent texture states for audio buttons
     * as well as setting the button's dimensions based on the buttonSize variable.
     *
     * @param g                       the MyGame, used for getting audio files and prefs.
     * @param notPressedTextureSource the not pressed texture source.
     * @param pressedTextureSource    the pressed texture source.
     * @param x                       the x-position for the button.
     * @param y                       the y-position fot the button.
     * @param buttonSize              the button size.
     * @param bType                   the button type.
     */
    public Button(MyGame g, String notPressedTextureSource, String pressedTextureSource, float x, float y, float buttonSize, int bType) {
        game = g;
        buttonType = bType;
        buttonNotPressedTexture = new Texture(notPressedTextureSource);
        buttonPressedTexture = new Texture(pressedTextureSource);
        buttonTexture = buttonNotPressedTexture;
        clickSound = Gdx.audio.newSound(Gdx.files.internal("Klikkaus.ogg"));
        buttonLock = new Texture("lock.png");

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

        if(buttonSize == BUTTONSIZE_VERYSMALL) {
            buttonRect = new Rectangle(x, y, 1.5f, 1.5f);
        } else if(buttonSize == BUTTONSIZE_SMALL) {
            buttonRect = new Rectangle(x, y, 3.7f, 1.40f);
        } else if(buttonSize == BUTTONSIZE_MEDIUM) {
            buttonRect = new Rectangle(x, y, 6.7f, 1.7f);
        } else if(buttonSize == BUTTONSIZE_LARGE) {
            buttonRect = new Rectangle(x, y, 6.7f, 2.2f);
        }
    }

    /**
     * Draws the button.
     *
     * @param batch the batch
     */
    public void draw(SpriteBatch batch) {
        batch.draw(buttonTexture, buttonRect.getX(), buttonRect.getY(), buttonRect.getWidth(), buttonRect.getHeight());
        if(buttonType == BUTTONTYPE_LOCKED) {
            batch.draw(buttonLock, buttonRect.getX() + 1.1f, buttonRect.getY() + 0.05f, 1.2f, 1.2f);
        }
    }

    /**
     * Method used for retrieving a button if it can be found on the given x and y coordinates.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     * @return the button if it is within the x and y, null otherwise.
     */
    public Button getButton(int x, int y){
        Vector3 touch = new Vector3(x, y, 0);
        game.getCamera().unproject(touch);
        if(buttonRect.contains(touch.x, touch.y)) {
            return this;
        }
        return null;
    }

    /**
     * Method that checks whether a button was pressed and then uses a switch case to check the button's
     * buttonType and performs a function based on that variable.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     * @return True if the button was pressed and function performed, false otherwise.
     */
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
                    game.setScreen(new FirstLevel(game, false));
                    break;
                case BUTTONTYPE_PLAYLEVELTWO:
                    game.setScreen(new SecondLevel(game, false));
                    break;
                case BUTTONTYPE_PLAYLEVELTHREE:
                    game.setScreen(new ThirdLevel(game, false));
                    break;
                case BUTTONTYPE_PLAYLEVELFOUR:
                    game.setScreen(new FourthLevel(game, false));
                    break;
                case BUTTONTYPE_PLAYLEVELFIVE:
                    game.setScreen(new FifthLevel(game, false));
                    break;
                case BUTTONTYPE_PLAYVEGANLEVELONE:
                    game.setScreen(new FirstLevel(game, true));
                    break;
                case BUTTONTYPE_PLAYVEGANLEVELTWO:
                    game.setScreen(new SecondLevel(game, true));
                    break;
                case BUTTONTYPE_PLAYVEGANLEVELTHREE:
                    game.setScreen(new ThirdLevel(game, true));
                    break;
                case BUTTONTYPE_PLAYVEGANLEVELFOUR:
                    game.setScreen(new FourthLevel(game, true));
                    break;
                case BUTTONTYPE_PLAYVEGANLEVELFIVE:
                    game.setScreen(new FifthLevel(game, true));
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
                case BUTTONTYPE_THIRDRECIPE:
                    game.setScreen(new Recipe(game, recipeType.chickenSalad));
                    break;
                case BUTTONTYPE_FOURTHRECIPE:
                    game.setScreen(new Recipe(game, recipeType.filledBellPeppers));
                    break;
                case BUTTONTYPE_FIFTHRECIPE:
                    game.setScreen(new Recipe(game, recipeType.chickenRice));
                    break;
                case BUTTONTYPE_VEGANFIRSTRECIPE:
                    game.setScreen(new Recipe(game, recipeType.vegetableStew));
                    break;
                case BUTTONTYPE_VEGANSECONDRECIPE:
                    game.setScreen(new Recipe(game, recipeType.beanBolognese));
                    break;
                case BUTTONTYPE_VEGANTHIRDRECIPE:
                    game.setScreen(new Recipe(game, recipeType.vegetableCurry));
                    break;
                case BUTTONTYPE_VEGANFOURTHRECIPE:
                    game.setScreen(new Recipe(game, recipeType.chiliSinCarne));
                    break;
                case BUTTONTYPE_VEGANFIFTHRECIPE:
                    game.setScreen(new Recipe(game, recipeType.lentilSoup));
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

    /**
     * Method that handles button texture changing and toggling.
     *
     * @param x       the x-coordinate.
     * @param y       the y-coordinate.
     * @param pressed Whether the button has just been pressed.
     */
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

    /**
     * Sets the button's position on the x-axis.
     *
     * @param x the x-coordinate.
     */
    public void setX(float x) {
        buttonRect.setX(x);
    }

    /**
     * Sets button type.
     *
     * @param type the type
     */
    public void setButtonType(int type) {
        buttonType = type;
    }

    /**
     * Gets button texture.
     *
     * @return the button texture
     */
    public Texture getButtonTexture() {
        return buttonTexture;
    }

    /**
     * Gets button Rectangle.
     *
     * @return the button Rectangle.
     */
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
