package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;


public class EndLevelScreen extends BaseMenu {
    private Button replayButton;
    private Button mainMenuButton;
    int currentLevel;
    int currentScore;

    public EndLevelScreen(MyGame g, int currLvl, int currScore) {
        super(g);
        currentLevel = currLvl;
        currentScore = currScore;

        switch(currentLevel) {
            case 1:
                if(currentScore >= 400) {
                    game.getPrefs().setRecipeOneOpen(true);
                }
                break;
            case 2:
                if(currentScore >= 400) {
                    game.getPrefs().setRecipeTwoOpen(true);
                }
                break;
            case 3:
                if(currentScore >= 400) {
                    game.getPrefs().setRecipeThreeOpen(true);
                }
                break;
            case 4:
                if(currentScore >= 400) {
                    game.getPrefs().setRecipeFourOpen(true);
                }
                break;
            case 5:
                if(currScore >= 400) {
                    game.getPrefs().setRecipeFiveOpen(true);
                }
                break;
        }
        createButtons();

    }
    public void renderButtons(){
        super.renderButtons();
        Vector2 buttonCenter = new Vector2();
        replayButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("playagain"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        mainMenuButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("levelselect"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("score") + " " + currentScore, 8 * 100f, 7 * 100f, font42);

    }
    public void createButtons(){
        super.createButtons();
        replayButton = new Button(game, "button.png", "button-pressed.png",4.5f, 3.2f, 3, currentLevel);
        mainMenuButton = new Button(game, "button.png", "button-pressed.png",4.5f, 1.3f, 3, Button.BUTTONTYPE_PLAYMODES);
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
