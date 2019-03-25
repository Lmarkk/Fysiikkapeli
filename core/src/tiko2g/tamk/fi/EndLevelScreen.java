package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;


public class EndLevelScreen extends BaseMenu {
    private Button replayButton;
    private Button mainMenuButton;
    int currentLevel;

    public EndLevelScreen(MyGame g, int currLvl) {
        super(g);
        currentLevel = currLvl;
        createButtons();

    }
    public void renderButtons(){
        super.renderButtons();
        Vector2 buttonCenter = new Vector2();
        replayButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("PLAY AGAIN", buttonCenter.x * 100f, buttonCenter.y * 100f, font100);
        mainMenuButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("MAIN MENU", buttonCenter.x * 100f, buttonCenter.y * 100f, font64);

    }
    public void createButtons(){
        super.createButtons();
        replayButton = new Button(game, "button.png", "button-pressed.png",4.5f, 3.2f, 3, currentLevel);
        mainMenuButton = new Button(game, "button.png", "button-pressed.png",4.5f, 1.3f, 2, Button.BUTTONTYPE_MAINMENU);
        buttonList.add(replayButton, mainMenuButton);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
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
