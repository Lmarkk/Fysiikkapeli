package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MainMenu implements Screen {

    private MyGame game;
    private SpriteBatch batch;
    Texture button;
    Rectangle playButtonRect;
    Rectangle tutorialButtonRect;
    Rectangle settingsButtonRect;
    OrthographicCamera camera;
    BitmapFont mainFont;
    Texture img;

    public MainMenu(MyGame game) {
        this.game = game;
        batch = game.getBatch();

        img = new Texture("badlogic.jpg");
        button = new Texture("button.png");

        float buttonHeight = button.getHeight()/60f;
        float buttonWidth = button.getWidth()/30f;

        camera = game.getCamera();



        playButtonRect = new Rectangle(4.5f, 3.2f, buttonWidth + 1f, buttonHeight + 0.5f);
        tutorialButtonRect = new Rectangle(1.5f, 1.3f, buttonWidth, buttonHeight);
        settingsButtonRect = new Rectangle(8.5f, 1.3f, buttonWidth, buttonHeight);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(button, playButtonRect.x, playButtonRect.y, playButtonRect.getWidth(), playButtonRect.getHeight());
        batch.draw(button, tutorialButtonRect.x, tutorialButtonRect.y, tutorialButtonRect.getWidth(), tutorialButtonRect.getHeight());
        batch.draw(button, settingsButtonRect.x, settingsButtonRect.y, settingsButtonRect.getWidth(), settingsButtonRect.getHeight());
        batch.end();
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
        img.dispose();
        button.dispose();

    }
}
