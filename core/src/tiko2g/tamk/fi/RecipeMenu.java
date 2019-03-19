package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class RecipeMenu implements Screen {
    private Button mainMenuButton;
    private Button nextRecipeButton;
    private Button prevRecipeButton;
    private Rectangle recipeNameRect;
    private Rectangle recipeNumberRect;
    private Array<Button> buttonList;
    private Texture recipeTextBackground;
    private Texture background;
    private OrthographicCamera camera;
    private MyGame game;
    private SpriteBatch batch;
    private BitmapFont font42;
    private BitmapFont font120;

    public RecipeMenu(MyGame g) {
        game = g;
        batch = g.getBatch();
        camera = g.getCamera();
        background = new Texture("phbackground.png");
        recipeTextBackground = new Texture("groundtexture.png");
        recipeNameRect = new Rectangle(3, 7.5f, 10, 1);
        recipeNumberRect = new Rectangle(6, 0.5f, 4, 1);
        font42 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 42, Color.BLACK, 4);
        font120 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 120, Color.BLACK, 4);
        createButtons();

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
        batch.draw(recipeTextBackground, recipeNameRect.x, recipeNameRect.y, recipeNameRect.getWidth(), recipeNameRect.getHeight());
        batch.draw(recipeTextBackground, recipeNumberRect.x, recipeNumberRect.y, recipeNumberRect.getWidth(), recipeNumberRect.getHeight());
        batch.end();

        renderButtons();
        renderText();
    }
    private void renderButtons(){
        Vector2 buttonCenter = new Vector2();
        batch.begin();
        for(Button button: buttonList) {
            button.draw(batch);
        }
        batch.end();
        mainMenuButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("MENU", buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        prevRecipeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("<", buttonCenter.x * 100f, buttonCenter.y * 100f, font120);
        nextRecipeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(">", buttonCenter.x * 100f, buttonCenter.y * 100f, font120);
    }

    private void createButtons(){

        mainMenuButton = new Button(game, "button.png", 1, 7.5f, 1.5f, 1, Button.BUTTONTYPE_MAINMENU);
        prevRecipeButton = new Button(game, "button.png", 1, 3.5f, 1.5f, 1, Button.BUTTONTYPE_PREVIMAGE);
        nextRecipeButton = new Button(game, "button.png", 13.5f, 3.5f, 1.5f, 1, Button.BUTTONTYPE_NEXTIMAGE);

        buttonList = new Array<Button>();
        buttonList.add(mainMenuButton, prevRecipeButton, nextRecipeButton);
    }

    private void renderText() {
        Vector2 rectCenter = new Vector2();
        recipeNameRect.getCenter(rectCenter);
        game.getTextRenderer().renderText("RECIPE NAME HERE", rectCenter.x * 100f, rectCenter.y * 100f, font42);
        recipeNumberRect.getCenter(rectCenter);
        game.getTextRenderer().renderText("???/???", rectCenter.x * 100f, rectCenter.y * 100f, font42);
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
