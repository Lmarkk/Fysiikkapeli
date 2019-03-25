package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;

public class MainMenu extends BaseMenu {

    private Button playButton;
    private Button tutorialButton;
    private Button musicButton;
    private Button soundButton;
    private Button recipeButton;


    public MainMenu(MyGame g) {
        super(g);
        createButtons();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

    }
    public void renderButtons(){
        super.renderButtons();
        Vector2 buttonCenter = new Vector2();
        playButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("PLAY", buttonCenter.x * 100f, buttonCenter.y * 100f, font100);
        recipeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("RECIPES", buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        tutorialButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText("TUTORIAL", buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
    }
    public void createButtons(){
        super.createButtons();
        soundButton = new Button(game, "audio-button-on.png","audio-button-off.png", 1.5f , 7, 1,  Button.BUTTONTYPE_SOUND);
        musicButton = new Button(game, "music-button-on.png", "button-music-off.png",3.3f, 7, 1,  Button.BUTTONTYPE_MUSIC);
        playButton = new Button(game, "button.png", "button-pressed.png", 4.7f, 3.5f, 2, Button.BUTTONTYPE_PLAYMODES);
        tutorialButton = new Button(game, "button.png", "button-pressed.png",1.3f, 1.3f, 2, Button.BUTTONTYPE_TUTORIAL);
        recipeButton = new Button(game, "button.png", "button-pressed.png",8.1f, 1.3f, 2, Button.BUTTONTYPE_RECIPES);
        buttonList.add(playButton, tutorialButton, recipeButton);
        buttonList.add(soundButton, musicButton);
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
