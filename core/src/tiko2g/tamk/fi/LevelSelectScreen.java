package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class LevelSelectScreen extends BaseMenu {
    private Button levelOneButton;
    private Button levelTwoButton;
    private Button levelThreeButton;
    private Button levelFourButton;
    private Button levelFiveButton;

    private Button dietToggleButton;

    private Button endlessButton;
    private Button menuButton;

    private Array<Button> veganButtonList;
    private Array<Button> normalButtonList;

    public LevelSelectScreen(MyGame g) {
        super(g);
        createButtons();
    }
    @Override
    public void render(float delta) {
        super.render(delta);
    }

    public void createButtons(){
        super.createButtons();

        menuButton = new Button(game, "button-home.png", "button-home-pressed.png", 1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);
        dietToggleButton = new Button(game, "button.png", "button-pressed.png", 6.25f, 6.9f, 2, Button.BUTTONTYPE_DIETMODE);
        endlessButton = new Button(game, "button.png", "button-pressed.png", 10.25f, 2.5f, 2, Button.BUTTONTYPE_PLAYENDLESS);

        levelOneButton = new Button(game, "button.png", "button-pressed.png", 2.25f, 4.5f, 2, Button.BUTTONTYPE_PLAYLEVELONE);
        levelTwoButton = new Button(game, "button.png", "button-pressed.png", 6.25f, 4.5f, 2, Button.BUTTONTYPE_PLAYLEVELTWO);
        levelThreeButton = new Button(game, "button.png", "button-pressed.png", 10.25f, 4.5f, 2, Button.BUTTONTYPE_PLAYLEVELTHREE);
        levelFourButton = new Button(game, "button.png", "button-pressed.png", 2.25f, 2.5f, 2, Button.BUTTONTYPE_PLAYLEVELFOUR);
        levelFiveButton = new Button(game, "button.png", "button-pressed.png", 6.25f, 2.5f, 2, Button.BUTTONTYPE_PLAYLEVELFIVE);

        buttonList.add(menuButton, endlessButton, dietToggleButton, levelOneButton);
        buttonList.add(levelTwoButton, levelThreeButton, levelFourButton, levelFiveButton);

    }
    public void renderButtons(){
        super.renderButtons();

        if(game.getPrefs().getDisplayGameModeVegan()) {
            if(game.getPrefs().getVeganLevelOneOpen()) {
                levelOneButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            } else {
                levelOneButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelTwoOpen()) {
                levelTwoButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            } else {
                levelTwoButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelThreeOpen()) {
                levelThreeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            } else {
                levelThreeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelFourOpen()) {
                levelFourButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            } else {
                levelFourButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            }
            if(game.getPrefs().getVeganLevelFiveOpen()) {
                levelFiveButton.setButtonType(Button.BUTTONTYPE_LOCKED);
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

        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("diet") + " ", 4.6f * 100f, 7.5f * 100f, font42);

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
