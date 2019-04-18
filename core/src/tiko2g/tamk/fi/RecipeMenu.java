package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RecipeMenu extends BaseMenu {

    private Button mainMenuButton;
    private Button dietToggleButton;
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
        recipeNameRect = new Rectangle(1, 7.7f, 6, 1);
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

        if(game.getPrefs().getDisplayGameModeVegan()) {
            if(game.getPrefs().getVeganRecipeOneOpen()) {
                firstRecipeButton.setButtonType(Button.BUTTONTYPE_VEGANFIRSTRECIPE);
            } else {
                firstRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganRecipeTwoOpen()) {
                secondRecipeButton.setButtonType(Button.BUTTONTYPE_VEGANSECONDRECIPE);
            } else {
                secondRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganRecipeThreeOpen()) {
                thirdRecipeButton.setButtonType(Button.BUTTONTYPE_VEGANTHIRDRECIPE);
            } else {
                thirdRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganRecipeFourOpen()) {
                fourthRecipeButton.setButtonType(Button.BUTTONTYPE_VEGANFOURTHRECIPE);
            } else {
                fourthRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganRecipeFiveOpen()) {
                fifthRecipeButton.setButtonType(Button.BUTTONTYPE_VEGANFIFTHRECIPE);
            } else {
                fifthRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
        } else {
            if(game.getPrefs().getRecipeOneOpen()) {
                firstRecipeButton.setButtonType(Button.BUTTONTYPE_FIRSTRECIPE);
            } else {
                firstRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getRecipeTwoOpen()) {
                secondRecipeButton.setButtonType(Button.BUTTONTYPE_SECONDRECIPE);
            } else {
                secondRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getRecipeThreeOpen()) {
                thirdRecipeButton.setButtonType(Button.BUTTONTYPE_THIRDRECIPE);
            } else {
                thirdRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getRecipeFourOpen()) {
                fourthRecipeButton.setButtonType(Button.BUTTONTYPE_FOURTHRECIPE);
            } else {
                fourthRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getRecipeFiveOpen()) {
                fifthRecipeButton.setButtonType(Button.BUTTONTYPE_FIFTHRECIPE);
            } else {
                fifthRecipeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }

        }
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

        dietToggleButton = new Button(game, "button.png", "button-pressed.png", 6.25f, 6.5f, 2, Button.BUTTONTYPE_DIETMODE);
        mainMenuButton = new Button(game, "button-home.png", "button-home-pressed.png",1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);


        buttonList.add(mainMenuButton, firstRecipeButton, secondRecipeButton, thirdRecipeButton);
        buttonList.add(fourthRecipeButton, fifthRecipeButton, dietToggleButton);
    }

    private void renderText() {
        Vector2 rectCenter = new Vector2();
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("diet") + " ", 8f * 100f, 8.2f * 100f, font42);
        recipeNameRect.getCenter(rectCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("recipes"), rectCenter.x * 100f, rectCenter.y * 100f, font64);
        Vector2 buttonCenter = new Vector2();
        dietToggleButton.getButtonRect().getCenter(buttonCenter);
        if(game.getPrefs().getDisplayGameModeVegan()) {
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("vegan"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        } else {
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("normal"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }

        if(game.getPrefs().getDisplayGameModeVegan()) {

            recipesOpenRect.getCenter(rectCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("recipesunlocked") + " " + game.getPrefs().getVeganRecipesOpen() + "/5",
                    rectCenter.x * 100f, rectCenter.y * 100f, font42);

            if(game.getPrefs().getVeganRecipeOneOpen()) {
                firstRecipeButton.getButtonRect().getCenter(rectCenter);
                game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("vegetablestew"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
            }
            if(game.getPrefs().getVeganRecipeTwoOpen()) {
                secondRecipeButton.getButtonRect().getCenter(rectCenter);
                game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("beanBolognese"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
            }
            if(game.getPrefs().getVeganRecipeThreeOpen()) {
                thirdRecipeButton.getButtonRect().getCenter(rectCenter);
                game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("vegetableCurry"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
            }
            if(game.getPrefs().getVeganRecipeFourOpen()) {
                fourthRecipeButton.getButtonRect().getCenter(rectCenter);
                game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("chiliSinCarne"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
            }
            if(game.getPrefs().getVeganRecipeFiveOpen()) {
                fifthRecipeButton.getButtonRect().getCenter(rectCenter);
                game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("lentilSoup"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
            }
        } else {
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
                game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("chickenRice"), rectCenter.x * 100f, rectCenter.y * 100f, font30);
            }
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
