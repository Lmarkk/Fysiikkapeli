package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;

public class LevelSelectScreen extends BaseMenu {
    Button levelOneButton;
    Button levelTwoButton;
    Button levelThreeButton;
    Button veganLevelOneButton;
    Button veganLevelTwoButton;
    Button veganLevelThreeButton;
    Button glutenLevelOneButton;
    Button glutenLevelTwoButton;
    Button glutenLevelThreeButton;
    Button endlessButton;
    Button menuButton;

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
        endlessButton = new Button(game, "button.png", "button-pressed.png", 4.4f, 0.6f, 3, Button.BUTTONTYPE_PLAYENDLESS);

        levelOneButton = new Button(game, "button.png", "button-pressed.png", 2.8f, 5.8f, 2, Button.BUTTONTYPE_PLAYLEVELONE);
        levelTwoButton = new Button(game, "button.png", "button-pressed.png", 2.8f, 4.3f, 2, Button.BUTTONTYPE_PLAYLEVELTWO);
        levelThreeButton = new Button(game, "button.png", "button-pressed.png", 2.8f, 2.8f, 2, Button.BUTTONTYPE_PLAYLEVELTHREE);

        veganLevelOneButton = new Button(game, "button.png", "button-pressed.png", 6.3f, 5.8f, 2, Button.BUTTONTYPE_PLAYLEVELONE);
        veganLevelTwoButton = new Button(game, "button.png", "button-pressed.png", 6.3f, 4.3f, 2, Button.BUTTONTYPE_PLAYLEVELTWO);
        veganLevelThreeButton = new Button(game, "button.png", "button-pressed.png", 6.3f, 2.8f, 2, Button.BUTTONTYPE_PLAYLEVELTHREE);

        glutenLevelOneButton = new Button(game, "button.png", "button-pressed.png", 9.8f, 5.8f, 2, Button.BUTTONTYPE_PLAYLEVELONE);
        glutenLevelTwoButton = new Button(game, "button.png", "button-pressed.png", 9.8f, 4.3f, 2, Button.BUTTONTYPE_PLAYLEVELTWO);
        glutenLevelThreeButton = new Button(game, "button.png", "button-pressed.png", 9.8f, 2.8f, 2, Button.BUTTONTYPE_PLAYLEVELTHREE);

        buttonList.add(menuButton, endlessButton, levelOneButton, levelTwoButton);
        buttonList.add(levelThreeButton, veganLevelOneButton, veganLevelTwoButton, veganLevelThreeButton);
        buttonList.add(glutenLevelOneButton, glutenLevelTwoButton, glutenLevelThreeButton);
    }
    public void renderButtons(){
        super.renderButtons();
        Vector2 buttonCenter = new Vector2();
        endlessButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("endless"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);

        levelOneButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("normal"), buttonCenter.x * 100f, 7.7f * 100f, font42);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelone"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        levelTwoButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("leveltwo"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        levelThreeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelthree"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);

        veganLevelOneButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("vegan"), buttonCenter.x * 100f, 7.7f * 100f, font42);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelone"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        veganLevelTwoButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("leveltwo"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        veganLevelThreeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelthree"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);

        glutenLevelOneButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("glutenfree"), buttonCenter.x * 100f, 7.7f * 100f, font42);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelone"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        glutenLevelTwoButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("leveltwo"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);
        glutenLevelThreeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelthree"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);



    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
