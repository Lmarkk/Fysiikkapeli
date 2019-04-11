package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class LevelSelectScreen extends BaseMenu {
    private Button levelOneButton;
    private Button levelTwoButton;
    private Button levelThreeButton;
    private Button levelFourButton;
    private Button levelFiveButton;

    private Button veganLevelOneButton;
    private Button veganLevelTwoButton;
    private Button veganLevelThreeButton;
    private Button veganLevelFourButton;
    private Button veganLevelFiveButton;

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
        endlessButton = new Button(game, "button.png", "button-pressed.png", 9.8f, 3.6f, 2, Button.BUTTONTYPE_PLAYENDLESS);

        levelOneButton = new Button(game, "button.png", "button-pressed.png", 2.7f, 5f, 2, Button.BUTTONTYPE_PLAYLEVELONE);
        levelTwoButton = new Button(game, "button.png", "button-pressed.png", 6.25f, 5f, 2, Button.BUTTONTYPE_PLAYLEVELTWO);
        levelThreeButton = new Button(game, "button.png", "button-pressed.png", 9.8f, 5f, 2, Button.BUTTONTYPE_PLAYLEVELTHREE);
        levelFourButton = new Button(game, "button.png", "button-pressed.png", 2.7f, 3.6f, 2, Button.BUTTONTYPE_LOCKED);
        levelFiveButton = new Button(game, "button.png", "button-pressed.png", 6.25f, 3.6f, 2, Button.BUTTONTYPE_LOCKED);

        buttonList.add(menuButton, endlessButton, dietToggleButton, levelOneButton);
        buttonList.add(levelTwoButton, levelThreeButton, levelFourButton, levelFiveButton);

    }
    public void renderButtons(){
        super.renderButtons();

        if(game.getPrefs().getDisplayGameModeVegan()) {
            levelOneButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            levelTwoButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            levelThreeButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            levelFourButton.setButtonType(Button.BUTTONTYPE_LOCKED);
            levelFiveButton.setButtonType(Button.BUTTONTYPE_LOCKED);
        } else {
            levelOneButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELONE);
            levelTwoButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELTWO);
            levelThreeButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELTHREE);
            levelFourButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELFOUR);
            levelFiveButton.setButtonType(Button.BUTTONTYPE_PLAYLEVELFIVE);
        }

        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("diet") + " ", 4.6f * 100f, 7.5f * 100f, font42);

        Vector2 buttonCenter = new Vector2();
        endlessButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("endless"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);

        dietToggleButton.getButtonRect().getCenter(buttonCenter);
        if(game.getPrefs().getDisplayGameModeVegan()) {
            game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("vegan"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        } else {
            game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("normal"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        }
        levelOneButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelone"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        levelTwoButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("leveltwo"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        levelThreeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelthree"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        levelFourButton.getButtonRect().getCenter((buttonCenter));
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelfour"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        levelFiveButton.getButtonRect().getCenter((buttonCenter));
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelfive"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
