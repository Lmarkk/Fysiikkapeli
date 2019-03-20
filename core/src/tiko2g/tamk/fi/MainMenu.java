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

public class MainMenu implements Screen {

    private MyGame game;
    private SpriteBatch batch;
    private Button playEndlessButton;
    private Button playLevelsButton;
    private Button tutorialButton;
    private Button musicButton;
    private Button soundButton;
    private Button recipeButton;
    private Array<Button> buttonList;
    private OrthographicCamera camera;
    private Texture background;
    private BitmapFont font64;
    private BitmapFont font100;

    public MainMenu(MyGame game) {
        this.game = game;
        batch = game.getBatch();
        camera = game.getCamera();
        camera.setToOrtho(false, 16, 9);

        createButtons();
        font64 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 64, Color.BLACK, 4);
        font100 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 100, Color.BLACK, 4);
        background = new Texture("phbackground.png");

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
    private void renderButtons(){
        Vector2 buttonCenter = new Vector2();
        batch.begin();
        for(Button button: buttonList) {
            button.draw(batch);
        }
        batch.end();
        playEndlessButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("ENDLESS", buttonCenter.x * 100f, buttonCenter.y * 100f, font100);
        playLevelsButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("LEVELS", buttonCenter.x * 100f, buttonCenter.y * 100f, font100);
        recipeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("RECIPES", buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        tutorialButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("TUTORIAL", buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
    }
    private void createButtons(){
        soundButton = new Button(game, "button.png", 1.5f , 7, 1.2f, 1.2f, Button.BUTTONTYPE_SOUND);
        musicButton = new Button(game, "button.png", 3.3f, 7, 1.2f, 1.2f, Button.BUTTONTYPE_MUSIC);
        playEndlessButton = new Button(game, "button.png", 1.5f, 3.2f, 6.6f, 2.1f, Button.BUTTONTYPE_PLAY);
        playLevelsButton = new Button(game, "button.png", 8.5f, 3.2f, 6.6f, 2.1f, Button.BUTTONTYPE_PLAY);
        tutorialButton = new Button(game, "button.png", 1.5f, 1.3f, 6.6f, 1.6f, Button.BUTTONTYPE_TUTORIAL);
        recipeButton = new Button(game, "button.png", 8.5f, 1.3f, 6.6f, 1.6f, Button.BUTTONTYPE_RECIPES);
        buttonList = new Array<Button>();
        buttonList.add(playEndlessButton,playLevelsButton, tutorialButton, recipeButton);
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
