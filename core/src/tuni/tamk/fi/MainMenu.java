package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class MainMenu implements Screen {

    private MyGame game;
    private SpriteBatch batch;
    Button playButton;
    Button tutorialButton;
    Button settingsButton;
    Array<Button> buttonList;
    OrthographicCamera meterCamera;
    BitmapFont mainFont;

    public MainMenu(MyGame game) {
        this.game = game;
        batch = game.getBatch();

        playButton = new Button(game, "button.png", 4.5f, 3.2f, 7.6f, 2.1f, Button.BUTTONTYPE_PLAY);
        tutorialButton = new Button(game, "button.png", 1.5f, 1.3f, 6.6f, 1.6f, Button.BUTTONTYPE_TUTORIAL);
        settingsButton = new Button(game, "button.png", 8.5f, 1.3f, 6.6f, 1.6f, Button.BUTTONTYPE_SETTINGS);
        buttonList = new Array<Button>();
        buttonList.add(playButton, tutorialButton, settingsButton);

        meterCamera = game.getCamera();

        mainFont = new BitmapFont();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.setProjectionMatrix(meterCamera.combined);
        playButton.draw(batch);
        tutorialButton.draw(batch);
        settingsButton.draw(batch);

        batch.end();
        game.getTextRenderer().renderText("PLAY", 800f, 450f, game.getTextRenderer().getTitleFont());

        for(Button button: buttonList) {
            button.pressFunction();
        }
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
        for(Button button: buttonList) {
            button.getButtonTexture().dispose();
        }
        mainFont.dispose();

    }
}
