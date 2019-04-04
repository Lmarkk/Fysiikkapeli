package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;

public class LevelSelectScreen extends BaseMenu {
    Button levelOneButton;
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
        endlessButton = new Button(game, "button.png", "button-pressed.png", 4.4f, 2, 3, Button.BUTTONTYPE_PLAYENDLESS);
        levelOneButton = new Button(game, "button.png", "button-pressed.png", 2.5f, 6, 2, Button.BUTTONTYPE_PLAYLEVELONE);
        buttonList.add(menuButton, endlessButton, levelOneButton);
    }
    public void renderButtons(){
        super.renderButtons();
        Vector2 buttonCenter = new Vector2();
        endlessButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("endless"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        levelOneButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("levelone"), buttonCenter.x * 100f, buttonCenter.y * 100f, font42);

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
