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

public class TutorialScreen implements Screen {
    private Button mainMenuButton;
    private Button nextImageButton;
    private Button prevImageButton;
    private Array<Button> buttonList;
    private Texture background;
    private Texture tutorialImage;
    private BitmapFont font42;
    private BitmapFont font120;
    private OrthographicCamera camera;
    private MyGame game;
    private SpriteBatch batch;

    public TutorialScreen(MyGame g) {
        game = g;
        batch = g.getBatch();
        camera = g.getCamera();
        background = new Texture("phbackground.png");
        font42 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 42, Color.BLACK, 4);
        font120 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 120, Color.BLACK, 4);

        createButtons();
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
    private void createButtons(){
        mainMenuButton = new Button(game, "button.png", 1, 7.5f, 1.5f, 1, Button.BUTTONTYPE_MAINMENU);
        nextImageButton = new Button(game, "button.png", 13.5f, 3.5f, 1.5f, 1, Button.BUTTONTYPE_NEXTIMAGE);
        prevImageButton = new Button(game, "button.png", 1, 3.5f, 1.5f, 1, Button.BUTTONTYPE_PREVIMAGE);
        buttonList = new Array<Button>();
        buttonList.add(mainMenuButton, nextImageButton, prevImageButton);
    }
    private void renderButtons(){
        Vector2 buttonCenter = new Vector2();
        batch.begin();
        mainMenuButton.draw(batch);
        nextImageButton.draw(batch);
        prevImageButton.draw(batch);
        batch.end();
        mainMenuButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("MENU", buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        nextImageButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(">", buttonCenter.x * 100f, buttonCenter.y * 100f, font120);
        prevImageButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("<", buttonCenter.x * 100f, buttonCenter.y * 100f, font120);
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
    public void changeImage(boolean goForward) {

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

    }
}
