package tiko2g.tamk.fi;

import com.badlogic.gdx.math.Vector2;

public class TutorialScreen extends BaseMenu {
    private Button mainMenuButton;
    private Button nextImageButton;
    private Button prevImageButton;

    public TutorialScreen(MyGame g) {
        super(g);
    }
    @Override
    public void show() {

    }
    public void createButtons(){
        super.createButtons();
        mainMenuButton = new Button(game, "button-home.png", "button-home.png",1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);
        nextImageButton = new Button(game, "button-right.png", "button-right.png",13.5f, 3.5f, 1, Button.BUTTONTYPE_NEXTIMAGE);
        prevImageButton = new Button(game, "button-left.png", "button-left.png",1, 3.5f, 1, Button.BUTTONTYPE_PREVIMAGE);
        buttonList.add(mainMenuButton, nextImageButton, prevImageButton);
    }
    public void renderButtons(){
        super.renderButtons();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

    }
    public void changeImage(boolean goForward) {
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
