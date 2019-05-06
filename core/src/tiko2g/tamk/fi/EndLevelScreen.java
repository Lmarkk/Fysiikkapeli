package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


/**
 * The type End level screen.
 *
 * @author Lassi Markkinen
 * @version 2.0
 */
public class EndLevelScreen extends BaseMenu {
    private Button replayButton;
    private Button levelSelectButton;
    private Button nextLevelButton;
    private Rectangle unlockMessageRect;
    /**
     * The First unlock.
     */
    boolean firstUnlock;
    /**
     * The Display next level button.
     */
    boolean displayNextLevelButton;
    /**
     * The Current level.
     */
    int currentLevel;
    /**
     * The Current score.
     */
    int currentScore;
    /**
     * The Vegan mode on.
     */
    boolean veganModeOn;

    /**
     * Instantiates a new End level screen.
     *
     * @param g           the g
     * @param currLvl     the curr lvl
     * @param currScore   the curr score
     * @param veganStatus the vegan status
     */
    public EndLevelScreen(MyGame g, int currLvl, int currScore, boolean veganStatus) {
        super(g);
        veganModeOn = veganStatus;
        currentLevel = currLvl;
        currentScore = currScore;
        firstUnlock = false;
        displayNextLevelButton = false;
        unlockMessageRect = new Rectangle(4, 4, 4, 1);
        if(game.getPrefs().getMusicStatus()) {
            super.stopMusic();
            game.getMenuTheme().play();
        }
        if(veganModeOn) {
            switch(currentLevel) {
                case 1:
                    if(currentScore >= 300) {
                        if(!game.getPrefs().getVeganRecipeOneOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setVeganRecipeOneOpen(true);
                        game.getPrefs().setVeganLevelTwoOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToVeganRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getVeganLevelTwoOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 2:
                    if(currentScore >= 300) {
                        if(!game.getPrefs().getVeganRecipeTwoOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setVeganRecipeTwoOpen(true);
                        game.getPrefs().setVeganLevelThreeOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToVeganRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getVeganLevelThreeOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 3:
                    if(currentScore >= 400) {
                        if(!game.getPrefs().getVeganRecipeThreeOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setVeganRecipeThreeOpen(true);
                        game.getPrefs().setVeganLevelFourOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToVeganRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getVeganLevelFourOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 4:
                    if(currentScore >= 400) {
                        if(!game.getPrefs().getVeganRecipeFourOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setVeganRecipeFourOpen(true);
                        game.getPrefs().setVeganLevelFiveOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToVeganRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getVeganLevelFiveOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 5:
                    if(currScore >= 500) {
                        if(!game.getPrefs().getVeganRecipeFiveOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setVeganRecipeFiveOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToVeganRecipesOpen();
                        }
                    }
                    break;
            }
        } else {
            switch (currentLevel) {
                case 1:
                    if (currentScore >= 300) {
                        if (!game.getPrefs().getRecipeOneOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setRecipeOneOpen(true);
                        game.getPrefs().setLevelTwoOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToNormalRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getLevelTwoOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 2:
                    if (currentScore >= 300) {
                        if (!game.getPrefs().getRecipeTwoOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setRecipeTwoOpen(true);
                        game.getPrefs().setLevelThreeOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToNormalRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getLevelThreeOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 3:
                    if (currentScore >= 400) {
                        if (!game.getPrefs().getRecipeThreeOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setRecipeThreeOpen(true);
                        game.getPrefs().setLevelFourOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToNormalRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getLevelFourOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 4:
                    if (currentScore >= 400) {
                        if (!game.getPrefs().getRecipeFourOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setRecipeFourOpen(true);
                        game.getPrefs().setLevelFiveOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToNormalRecipesOpen();
                        }
                    }
                    if(game.getPrefs().getLevelFiveOpen()) {
                        displayNextLevelButton = true;
                    }
                    break;
                case 5:
                    if (currScore >= 500) {
                        if (!game.getPrefs().getRecipeFiveOpen()) {
                            firstUnlock = true;
                        }
                        game.getPrefs().setRecipeFiveOpen(true);
                        if(firstUnlock) {
                            game.getPrefs().addToNormalRecipesOpen();
                        }
                    }
                    break;
            }
        }
        createButtons();

    }
    public void renderButtons(){
        super.renderButtons();
        Vector2 buttonCenter = new Vector2();
        replayButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("playagain"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        levelSelectButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("levelselect"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        if(displayNextLevelButton) {
            nextLevelButton.getButtonRect().getCenter(buttonCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("nextlevel"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        }
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("score") + " " + currentScore, 8 * 100f, 7 * 100f, font42);

    }
    public void createButtons(){
        super.createButtons();
        if(!veganModeOn) {
            replayButton = new Button(game, "button.png", "button-pressed.png",1f, 3.2f, 3, currentLevel);
            if(currentLevel < 5 && displayNextLevelButton) {
                nextLevelButton = new Button(game, "button.png", "button-pressed.png", 8.4f, 3.2f, 3, currentLevel + 1);
            } else {
                replayButton.setX(4.7f);
            }
        } else {
            replayButton = new Button(game, "button.png", "button-pressed.png",1f, 3.2f, 3, currentLevel + 5);
            if(currentLevel < 5 && displayNextLevelButton) {
                nextLevelButton = new Button(game, "button.png", "button-pressed.png", 8.4f, 3.2f, 3, currentLevel + 6);
            } else {
                replayButton.setX(4.7f);
            }
        }


        levelSelectButton = new Button(game, "button.png", "button-pressed.png",4.7f, 1.3f, 3, Button.BUTTONTYPE_PLAYMODES);
        buttonList.add(replayButton, levelSelectButton);
        if(displayNextLevelButton) {
            buttonList.add(nextLevelButton);
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        switch(currentLevel) {
            case 1:
                if(currentScore >= 300) {
                    if(firstUnlock) {
                        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("unlocked"), 8 * 100f, 6 * 100f, font42);
                    }
                } else if(veganModeOn && !game.getPrefs().getVeganRecipeOneOpen() && !game.getPrefs().getVeganLevelTwoOpen()) {
                    game.getTextRenderer().renderTextCenter("300 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                } else if(!veganModeOn && !game.getPrefs().getRecipeOneOpen() && !game.getPrefs().getLevelTwoOpen()) {
                    game.getTextRenderer().renderTextCenter("300 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                }
                break;
            case 2:
                if(currentScore >= 300) {
                    if(firstUnlock) {
                        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("unlocked"), 8 * 100f, 6 * 100f, font42);
                    }
                } else if(veganModeOn && !game.getPrefs().getVeganRecipeTwoOpen() && !game.getPrefs().getVeganLevelThreeOpen()) {
                    game.getTextRenderer().renderTextCenter("300 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                } else if(!veganModeOn && !game.getPrefs().getRecipeTwoOpen() && !game.getPrefs().getLevelThreeOpen()) {
                    game.getTextRenderer().renderTextCenter("300 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                }
                break;
            case 3:
                if(currentScore >= 400) {
                    if(firstUnlock) {
                        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("unlocked"), 8 * 100f, 6 * 100f, font42);
                    }
                } else if(veganModeOn && !game.getPrefs().getVeganRecipeThreeOpen() && !game.getPrefs().getVeganLevelFourOpen()) {
                    game.getTextRenderer().renderTextCenter("400 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                } else if(!veganModeOn && !game.getPrefs().getRecipeThreeOpen() && !game.getPrefs().getLevelFourOpen()) {
                    game.getTextRenderer().renderTextCenter("400 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                }
                break;
            case 4:
                if(currentScore >= 400) {
                    if(firstUnlock) {
                        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("unlocked"), 8 * 100f, 6 * 100f, font42);
                    }
                } else if(veganModeOn && !game.getPrefs().getVeganRecipeFourOpen() && !game.getPrefs().getVeganLevelFiveOpen()) {
                    game.getTextRenderer().renderTextCenter("400 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                } else if(!veganModeOn && !game.getPrefs().getRecipeFourOpen() && !game.getPrefs().getLevelFiveOpen()) {
                    game.getTextRenderer().renderTextCenter("400 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                }
                break;
            case 5:
                if(currentScore >= 500) {
                    if(firstUnlock) {
                        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("unlocked"), 8 * 100f, 6 * 100f, font42);
                    }
                } else if(veganModeOn && !game.getPrefs().getVeganRecipeFiveOpen()) {
                    game.getTextRenderer().renderTextCenter("500 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                } else if(!veganModeOn && !game.getPrefs().getRecipeFiveOpen()) {
                    game.getTextRenderer().renderTextCenter("500 " + game.getPrefs().getCurrentLanguage().get("pointsneeded"), 8 * 100f, 8 * 100f, font42);
                }
                break;
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
