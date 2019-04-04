package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class BaseMenu implements Screen {
    MyGame game;
    SpriteBatch batch;
    Array<Button> buttonList;
    OrthographicCamera camera;
    Texture background;
    BitmapFont font64;
    BitmapFont font100;
    BitmapFont font42;
    BitmapFont font120;
    String kreonFont = "Kreon-Regular.ttf";

    public BaseMenu(MyGame g) {
        game = g;
        batch = g.getBatch();
        camera = g.getCamera();
        camera.setToOrtho(false, 16,9);
        background = new Texture("menu-bg.png");
        font64 = game.getTextRenderer().createFont(kreonFont, 64, Color.BLACK, 4);
        font100 = game.getTextRenderer().createFont(kreonFont, 100, Color.BLACK, 4);
        font42 = game.getTextRenderer().createFont(kreonFont, 42, Color.BLACK, 4);
        font120 = game.getTextRenderer().createFont(kreonFont, 120, Color.BLACK, 4);
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
    public void createButtons() {
        buttonList = new Array<Button>();
    }
    public void renderButtons() {
        batch.begin();
        for(Button button: buttonList) {
            button.draw(batch);
        }
        batch.end();
    }

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
    }
}
