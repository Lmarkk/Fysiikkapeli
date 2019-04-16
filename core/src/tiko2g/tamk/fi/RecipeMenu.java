package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RecipeMenu extends BaseMenu {

    private Button mainMenuButton;
    private Button firstRecipeButton;
    private Button secondRecipeButton;
    private Button thirdRecipeButton;
    private Button fourthRecipeButton;
    private Button fifthRecipeButton;

    private Rectangle recipeNameRect;
    private Rectangle recipesOpenRect;


    public RecipeMenu(MyGame g) {
        super(g);
        createButtons();
        recipeNameRect = new Rectangle(3, 7.5f, 10, 1);
        recipesOpenRect = new Rectangle(3, 0.6f, 10, 1);
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

        if(game.getPrefs().getRecipeOneOpen()) {
            firstRecipeButton = new Button(game, "button.png", "button-pressed.png",2.25f, 4.5f, 2, Button.BUTTONTYPE_FIRSTRECIPE);
        } else {
            firstRecipeButton = new Button(game, "button.png", "button-pressed.png",2.25f, 4.5f, 2, Button.BUTTONTYPE_LOCKED);
        }

        if(game.getPrefs().getRecipeTwoOpen()) {
            secondRecipeButton = new Button(game, "button.png", "button-pressed.png",6.25f, 4.5f, 2, Button.BUTTONTYPE_SECONDRECIPE);
        } else {
            secondRecipeButton = new Button(game, "button.png", "button-pressed.png",6.25f, 4.5f, 2, Button.BUTTONTYPE_LOCKED);
        }

        if(game.getPrefs().getRecipeThreeOpen()) {
            thirdRecipeButton = new Button(game, "button.png", "button-pressed.png",10.25f, 4.5f, 2, Button.BUTTONTYPE_THIRDRECIPE);
        } else {
            thirdRecipeButton = new Button(game, "button.png", "button-pressed.png",10.25f, 4.5f, 2, Button.BUTTONTYPE_LOCKED);
        }

        if(game.getPrefs().getRecipeFourOpen()) {
            fourthRecipeButton = new Button(game, "button.png", "button-pressed.png",4.25f, 2.5f, 2, Button.BUTTONTYPE_FOURTHRECIPE);
        } else {
            fourthRecipeButton = new Button(game, "button.png", "button-pressed.png",4.25f, 2.5f, 2, Button.BUTTONTYPE_LOCKED);
        }

        if(game.getPrefs().getRecipeFiveOpen()) {
            fifthRecipeButton = new Button(game, "button.png", "button-pressed.png",8.25f, 2.5f, 2, Button.BUTTONTYPE_FIFTHRECIPE);
        } else {
            fifthRecipeButton = new Button(game, "button.png", "button-pressed.png",8.25f, 2.5f, 2, Button.BUTTONTYPE_LOCKED);
        }

        mainMenuButton = new Button(game, "button-home.png", "button-home-pressed.png",1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);


        buttonList.add(mainMenuButton, firstRecipeButton, secondRecipeButton, thirdRecipeButton);
        buttonList.add(fourthRecipeButton, fifthRecipeButton);
    }

    private void renderText() {
        Vector2 rectCenter = new Vector2();
        recipeNameRect.getCenter(rectCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("recipes"), rectCenter.x * 100f, rectCenter.y * 100f, font64);
        recipesOpenRect.getCenter(rectCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("recipesunlocked") + " " + game.getPrefs().getRecipesOpen() + "/5",
                rectCenter.x * 100f, rectCenter.y * 100f, font42);

        if(game.getPrefs().getRecipeOneOpen()) {
            firstRecipeButton.getButtonRect().getCenter(rectCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("karelianhotpot"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
        }
        if(game.getPrefs().getRecipeTwoOpen()) {
            secondRecipeButton.getButtonRect().getCenter(rectCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("meatsoup"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
        }
        if(game.getPrefs().getRecipeThreeOpen()) {
            thirdRecipeButton.getButtonRect().getCenter(rectCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("chickensalad"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
        }
        if(game.getPrefs().getRecipeFourOpen()) {
            fourthRecipeButton.getButtonRect().getCenter(rectCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("filledbellpeppers"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
        }
        if(game.getPrefs().getRecipeFiveOpen()) {
            fifthRecipeButton.getButtonRect().getCenter(rectCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("vegetablestew"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
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
        super.dispose();
    }
}
