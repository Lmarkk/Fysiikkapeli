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

public class RecipeMenu extends BaseMenu {
    private Button mainMenuButton;
    private Button nextRecipeButton;
    private Button prevRecipeButton;
    private Rectangle recipeNameRect;
    private Rectangle recipeNumberRect;
    private Texture recipeTextBackground;

    public RecipeMenu(MyGame g) {
        super(g);
        createButtons();
        recipeTextBackground = new Texture("groundtexture.png");
        recipeNameRect = new Rectangle(3, 7.5f, 10, 1);
        recipeNumberRect = new Rectangle(6, 0.5f, 4, 1);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(recipeTextBackground, recipeNameRect.x, recipeNameRect.y, recipeNameRect.getWidth(), recipeNameRect.getHeight());
        batch.draw(recipeTextBackground, recipeNumberRect.x, recipeNumberRect.y, recipeNumberRect.getWidth(), recipeNumberRect.getHeight());
        batch.end();

        renderText();
    }
    public void renderButtons(){
        super.renderButtons();
    }

    public void createButtons(){
        super.createButtons();
        mainMenuButton = new Button(game, "button-home.png", "button-home-pressed.png",1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);
        prevRecipeButton = new Button(game, "button-left.png", "button-left-pressed.png",1, 3.5f, 1, Button.BUTTONTYPE_PREVIMAGE);
        nextRecipeButton = new Button(game, "button-right.png", "button-right-pressed.png",13.5f, 3.5f, 1, Button.BUTTONTYPE_NEXTIMAGE);

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
        super.dispose();
        recipeTextBackground.dispose();
    }
}
