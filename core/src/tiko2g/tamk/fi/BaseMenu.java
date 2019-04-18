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
 * The type Base menu.
 */
public class BaseMenu implements Screen {
    /**
     * The Game.
     */
    MyGame game;
    /**
     * The Batch.
     */
    SpriteBatch batch;
    /**
     * The Button list.
     */
    Array<Button> buttonList;
    /**
     * The Camera.
     */
    OrthographicCamera camera;
    /**
     * The Background.
     */
    Texture background;
    /**
     * The Kreon font.
     */
    String kreonFont = "Kreon-Regular.ttf";
    /**
     * The Font 64.
     */
    BitmapFont font64;
    /**
     * The Font 100.
     */
    BitmapFont font100;
    /**
     * The Font 42.
     */
    BitmapFont font42;
    /**
     * The Font 120.
     */
    BitmapFont font120;
    /**
     * The Font 30.
     */
    BitmapFont font30;


    /**
     * Instantiates a new Base menu.
     *
     * @param g the g
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
     * Create buttons.
     */
    public void createButtons() {
        buttonList = new Array<Button>();
    }

    /**
     * Render buttons.
     */
    public void renderButtons() {
        batch.begin();
        for(Button button: buttonList) {
            button.draw(batch);
        }
        batch.end();
    }

    /**
     * Stop music.
     */
    public void stopMusic() {
        game.getMenuTheme().stop();
        game.getWheatFieldsTheme().stop();
        game.getGreenHillsTheme().stop();
        game.getShadyWoodsTheme().stop();
    }

    /**
     * Change image.
     *
     * @param goForward the go forward
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
        font64.dispose();
        font100.dispose();
        font42.dispose();
        font120.dispose();
        font30.dispose();
    }
}
