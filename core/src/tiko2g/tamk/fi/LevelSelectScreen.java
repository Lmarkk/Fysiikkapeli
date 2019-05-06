package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Menu that represents the different level options of the game to the player.
 *
 * @author Lassi Markkinen
 * @version 2.0
 */
public class LevelSelectScreen extends BaseMenu {
    /**
     * Button that changes the screen to level one.
     */
    private Button levelOneButton;
    /**
     * Button that changes the screen to level two.
     */
    private Button levelTwoButton;
    /**
     * Button that changes the screen to level three.
     */
    private Button levelThreeButton;
    /**
     * Button that changes the screen to level four.
     */
    private Button levelFourButton;
    /**
     * Button that changes the screen to level five.
     */
    private Button levelFiveButton;

    /**
     * Button that toggles the button of every level between normal and vegan mode levels.
     */
    private Button dietToggleButton;

    /**
     * Button that changes the screen to an endless level.
     */
    private Button endlessButton;
    /**
     * Button for returning to the main menu.
     */
    private Button menuButton;

    private Array<Button> veganButtonList;
    private Array<Button> normalButtonList;

    /**
     * Instantiates a new Level select screen.
     *
     * @param g the MyGame, used to access prefs.
     */
    public LevelSelectScreen(MyGame g) {
        super(g);
        createButtons();
        if(game.getPrefs().getMusicStatus()) {
            if(!game.getMenuTheme().isPlaying()) {
                super.stopMusic();
                game.getMenuTheme().play();
            }
        }

    }
    @Override
    public void render(float delta) {
        super.render(delta);
    }

    /**
     * Calls the superclass method which creates an array for holding all buttons.
     * Creates every button on the screen and adds them to the array.
     */
    public void createButtons(){
        super.createButtons();

        menuButton = new Button(game, "button-home.png", "button-home-pressed.png", 1, 7f, 1, Button.BUTTONTYPE_MAINMENU);
        dietToggleButton = new Button(game, "button.png", "button-pressed.png", 6.15f, 6.3f, 2, Button.BUTTONTYPE_DIETMODE);
        endlessButton = new Button(game, "button.png", "button-pressed.png", 10.15f, 2.3f, 2, Button.BUTTONTYPE_PLAYENDLESS);

        levelOneButton = new Button(game, "button.png", "button-pressed.png", 2.15f, 4.3f, 2, Button.BUTTONTYPE_PLAYLEVELONE);
        levelTwoButton = new Button(game, "button.png", "button-pressed.png", 6.15f, 4.3f, 2, Button.BUTTONTYPE_PLAYLEVELTWO);
        levelThreeButton = new Button(game, "button.png", "button-pressed.png", 10.15f, 4.3f, 2, Button.BUTTONTYPE_PLAYLEVELTHREE);
        levelFourButton = new Button(game, "button.png", "button-pressed.png", 2.15f, 2.3f, 2, Button.BUTTONTYPE_PLAYLEVELFOUR);
        levelFiveButton = new Button(game, "button.png", "button-pressed.png", 6.15f, 2.3f, 2, Button.BUTTONTYPE_PLAYLEVELFIVE);

        buttonList.add(menuButton, endlessButton, dietToggleButton, levelOneButton);
        buttonList.add(levelTwoButton, levelThreeButton, levelFourButton, levelFiveButton);

    }

    /**
     * Calls the superclass method which calls draw on every button on the list of buttons.
     * Checks for the gamemode(vegan/normal) and changes button types based on those if-statements.
     * Renders text for every button, again checking for unlock status when determining whether to render text.
     */
    public void renderButtons(){
        super.renderButtons();

        if(game.getPrefs().getDisplayGameModeVegan()) {
            if(game.getPrefs().getVeganLevelOneOpen()) {
                levelOneButton.setButtonType(Button.BUTTONTYPE_PLAYVEGANLEVELONE);
            } else {
                levelOneButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelTwoOpen()) {
                levelTwoButton.setButtonType(Button.BUTTONTYPE_PLAYVEGANLEVELTWO);
            } else {
                levelTwoButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelThreeOpen()) {
                levelThreeButton.setButtonType(Button.BUTTONTYPE_PLAYVEGANLEVELTHREE);
            } else {
                levelThreeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelFourOpen()) {
                levelFourButton.setButtonType(Button.BUTTONTYPE_PLAYVEGANLEVELFOUR);
            } else {
                levelFourButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelFiveOpen()) {
                levelFiveButton.setButtonType(Button.BUTTONTYPE_PLAYVEGANLEVELFIVE);
            } else {
                levelFiveButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }

        } else {
            if(game.getPrefs().getLevelOneOpen()) {
                levelOneButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELONE);
            } else {
                levelOneButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getLevelTwoOpen()) {
                levelTwoButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELTWO);
            } else {
                levelTwoButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getLevelThreeOpen()) {
                levelThreeButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELTHREE);
            } else {
                levelThreeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getLevelFourOpen()) {
                levelFourButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELFOUR);
            } else {
                levelFourButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getLevelFiveOpen()) {
                levelFiveButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELFIVE);
            } else {
                levelFiveButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }

        }
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("diet") + " ", 8f * 100f, 8.2f * 100f, font42);

        Vector2 buttonCenter = new Vector2();
        endlessButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("endless"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);

        dietToggleButton.getButtonRect().getCenter(buttonCenter);
        if(game.getPrefs().getDisplayGameModeVegan()) {
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("vegan"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        } else {
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("normal"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }

        if((game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getVeganLevelOneOpen()) ||
        !game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getLevelOneOpen()) {
            levelOneButton.getButtonRect().getCenter(buttonCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("levelone"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }
        if((game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getVeganLevelTwoOpen()) ||
                !game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getLevelTwoOpen()) {
            levelTwoButton.getButtonRect().getCenter(buttonCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("leveltwo"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }
        if((game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getVeganLevelThreeOpen()) ||
                !game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getLevelThreeOpen()) {
            levelThreeButton.getButtonRect().getCenter(buttonCenter);
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("levelthree"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }
        if((game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getVeganLevelFourOpen()) ||
                !game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getLevelFourOpen()) {
            levelFourButton.getButtonRect().getCenter((buttonCenter));
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("levelfour"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }
        if((game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getVeganLevelFiveOpen()) ||
                !game.getPrefs().getDisplayGameModeVegan() && game.getPrefs().getLevelFiveOpen()) {
            levelFiveButton.getButtonRect().getCenter((buttonCenter));
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("levelfive"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
