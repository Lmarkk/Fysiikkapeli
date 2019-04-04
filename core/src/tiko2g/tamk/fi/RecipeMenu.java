package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RecipeMenu extends BaseMenu {

    private Button mainMenuButton;
    private Button firstRecipeButton;
    private Button secondRecipeButton;
    private Rectangle recipeNameRect;


    public RecipeMenu(MyGame g) {
        super(g);
        createButtons();
        recipeNameRect = new Rectangle(3, 7.5f, 10, 1);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.setProjectionMatrix(camera.combined);

        renderText();
    }
    public void renderButtons(){
        super.renderButtons();
    }

    public void createButtons(){
        super.createButtons();
        mainMenuButton = new Button(game, "button-home.png", "button-home-pressed.png",1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);
        firstRecipeButton = new Button(game, "button.png", "button-pressed.png",3, 4.5f, 2, Button.BUTTONTYPE_FIRSTRECIPE);
        secondRecipeButton = new Button(game, "button.png", "button-pressed.png",7, 4.5f, 2, Button.BUTTONTYPE_SECONDRECIPE);

        buttonList.add(mainMenuButton, firstRecipeButton, secondRecipeButton);
    }

    private void renderText() {
        Vector2 rectCenter = new Vector2();
        recipeNameRect.getCenter(rectCenter);
        game.getTextRenderer().renderText(game.getMyBundle().get("recipes"), rectCenter.x * 100f, rectCenter.y * 100f, font64);
        firstRecipeButton.getButtonRect().getCenter(rectCenter);
        game.getTextRenderer().renderText(game.getMyBundle().get("karelianhotpot"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
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
    }
}
