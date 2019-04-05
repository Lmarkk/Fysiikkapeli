package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;

public class MainMenu extends BaseMenu {

    private Button playButton;
    private Button tutorialButton;
    private Button musicButton;
    private Button soundButton;
    private Button recipeButton;
    private Button languageButton;


    public MainMenu(MyGame g) {
        super(g);
        createButtons();
        if(game.getPrefs().getMusicStatus()) {
            if (!game.getMenuTheme().isPlaying()) {
                super.stopMusic();
                game.getMenuTheme().play();
            }
        }
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
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("play"), buttonCenter.x * 100f, buttonCenter.y * 100f, font100);
        recipeButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("recipes"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
        tutorialButton.getButtonRect().getCenter(buttonCenter);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("tutorial"), buttonCenter.x * 100f, buttonCenter.y * 100f, font64);
    }
    public void createButtons(){
        super.createButtons();
        soundButton = new Button(game, "button-audio-on.png","button-audio-off.png", 1.5f , 7, 1,  Button.BUTTONTYPE_SOUND);
        musicButton = new Button(game, "button-music-on.png", "button-music-off.png",3.3f, 7, 1,  Button.BUTTONTYPE_MUSIC);
        languageButton = new Button(game, "button.png", "button-pressed.png", 14, 7, 1, Button.BUTTONTYPE_LANGUAGE);
        playButton = new Button(game, "button.png", "button-pressed.png", 4.7f, 3.5f, 3, Button.BUTTONTYPE_PLAYMODES);
        tutorialButton = new Button(game, "button.png", "button-pressed.png",1.3f, 1.3f, 3, Button.BUTTONTYPE_TUTORIAL);
        recipeButton = new Button(game, "button.png", "button-pressed.png",8.1f, 1.3f, 3, Button.BUTTONTYPE_RECIPES);
        buttonList.add(playButton, tutorialButton, recipeButton);
        buttonList.add(soundButton, musicButton, languageButton);
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
