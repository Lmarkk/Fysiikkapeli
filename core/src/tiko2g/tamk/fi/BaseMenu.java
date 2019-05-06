package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * BaseMenu is the superclass for all menu classes such as MainMenu and RecipeMenu.
 *
 * @author Lassi Markkinen, Arttu Knuutinen
 * @version 2.0
 */
public class BaseMenu implements Screen {
    /**
     * Instance of MyGame received as a parameter in constructor.
     */
    MyGame game;
    /**
     * SpriteBatch used for rendering.
     */
    SpriteBatch batch;
    /**
     * Array containing every button on the menu screen.
     */
    Array<Button> buttonList;
    /**
     * OrthographicCamera used to set viewport for rendering.
     */
    OrthographicCamera camera;
    /**
     * Background texture for all menus.
     */
    Texture background;
    /**
     * The BitmapFont with size 64.
     */
    BitmapFont font64;
    /**
     * The BitmapFont with size 100.
     */
    BitmapFont font100;
    /**
     * The BitmapFont with size 42.
     */
    BitmapFont font42;
    /**
     * The BitmapFont with size 120.
     */
    BitmapFont font120;
    /**
     * The BitmapFont with size 30.
     */
    BitmapFont font30;
    /**
     * The BitmapFont with size 32.
     */
    BitmapFont font32;
    /**
     * The BitmapFont with size 35.
     */
    BitmapFont font35;

    /**
     * Instantiates a new Base menu.
     *
     * @param g the MyGame used for retrieving fonts, prefs, music, etc.
     */
    public BaseMenu(MyGame g) {
        game = g;
        batch = g.getBatch();
        camera = g.getCamera();
        camera.setToOrtho(false, 16,9);
        background = new Texture("menu-bg.png");
        font64 = game.getFont64();
        font100 = game.getFont100();
        font42 = game.getFont42();
        font120 = game.getFont120();
        font30 = game.getFont30();
        font32 = game.getFont32();
        font35 = game.getFont35();
        //createButtons();

        Gdx.input.setInputProcessor(new MyInputProcessor() {
            Button pressedButton;
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                pressedButton = null;
                for(Button b: buttonList) {
                    if(pressedButton == null){
                        pressedButton = b.getButton(screenX, screenY);
                        if(pressedButton != null){
                            pressedButton.setTexture(screenX, screenY, true);
                        }
                    }
                }
                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(pressedButton != null){
                    pressedButton.pressFunction(screenX, screenY);
                    pressedButton.setTexture(screenX, screenY, false);
                }
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });
    }

    /**
     * Creates the Array that holds all buttons.
     */
    public void createButtons() {
        buttonList = new Array<Button>();
    }

    /**
     * Calls draw method for every button on the Array.
     */
    public void renderButtons() {
        batch.begin();
        for(Button button: buttonList) {
            button.draw(batch);
        }
        batch.end();
    }

    /**
     * Stops all music.
     */
    public void stopMusic() {
        game.getMenuTheme().stop();
        game.getWheatFieldsTheme().stop();
        game.getGreenHillsTheme().stop();
        game.getShadyWoodsTheme().stop();
    }

    /**
     * Used for changing images in TutorialScreen.
     *
     * @param goForward Whether the replacing image should be the next one or the previous one.
     */
    public void changeImage(boolean goForward){

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, 16, 9);
        batch.end();

        renderButtons();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        for(Button button: buttonList) {
            button.dispose();
        }
    }
}
