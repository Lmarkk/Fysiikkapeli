package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class RecipeMenu implements Screen {
    private Button mainMenuButton;
    private Array<Button> buttonList;
    private Texture background;
    private OrthographicCamera camera;
    private MyGame game;
    private SpriteBatch batch;

    public RecipeMenu(MyGame g) {
        game = g;
        batch = g.getBatch();
        camera = g.getCamera();
        background = new Texture("phbackground.png");
        mainMenuButton = new Button(game, "button.png", 1, 7, 1.5f, 1.5f, Button.BUTTONTYPE_MAINMENU);
        buttonList = new Array<Button>();
        buttonList.add(mainMenuButton);
        Gdx.input.setInputProcessor(new MyInputProcessor() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                for(Button b: buttonList) {
                    b.setTexture(screenX, screenY, true);
                }
                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                for(Button b: buttonList) {
                    b.pressFunction(screenX, screenY);
                    b.setTexture(screenX, screenY, false);
                }
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });
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
        mainMenuButton.draw(batch);
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
        background.dispose();
    }
}
