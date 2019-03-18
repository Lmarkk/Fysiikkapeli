package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EndLevelScreen implements Screen {

    private MyGame game;
    private SpriteBatch batch;
    private Button replayButton;
    private Button mainMenuButton;
    private Array<Button> buttonList;
    private OrthographicCamera camera;
    private Texture background;
    private BitmapFont font64;
    private BitmapFont font100;

    public EndLevelScreen(MyGame game) {
        this.game = game;
        batch = game.getBatch();
        camera = game.getCamera();

        createButtons();
        font64 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 64, Color.BLACK, 4);
        font100 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 100, Color.BLACK, 4);
        background = new Texture("phbackground.png");
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
                    if(b.pressFunction(screenX, screenY)){
                        break;
                    }
                    b.setTexture(screenX, screenY, false);
                }
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });
    }
    private void renderButtons(){
        Vector2 buttonCenter = new Vector2();
        batch.begin();
        replayButton.draw(batch);
        mainMenuButton.draw(batch);
        batch.end();
        replayButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("PLAY AGAIN", buttonCenter.x * 100f, buttonCenter.y * 100f, font100);
        mainMenuButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("MAIN MENU", buttonCenter.x * 100f, buttonCenter.y * 100f, font64);

    }
    private void createButtons(){
        replayButton = new Button(game, "button.png", 4.5f, 3.2f, 7.6f, 2.1f, Button.BUTTONTYPE_PLAY);
        mainMenuButton = new Button(game, "button.png", 4.5f, 1.3f, 6.6f, 1.6f, Button.BUTTONTYPE_MAINMENU);
        buttonList = new Array<Button>();
        buttonList.add(replayButton, mainMenuButton);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        camera.setToOrtho(false, 16,9);

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
        for(Button button: buttonList) {
            button.getButtonTexture().dispose();
        }
        font64.dispose();
        font100.dispose();
    }
}
