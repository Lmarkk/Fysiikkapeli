package tiko2g.tamk.fi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * The type Tutorial screen.
 */
public class TutorialScreen extends BaseMenu {
    private Button mainMenuButton;
    private Button nextImageButton;
    private Button prevImageButton;
    private Rectangle tutorialRect;
    private Texture[] tutorialImages = new Texture[4];
    private Texture currentImage;
    private int currentImageIndex = 0;

    /**
     * Instantiates a new Tutorial screen.
     *
     * @param g the g
     */
    public TutorialScreen(MyGame g) {
        super(g);
        createButtons();
        tutorialRect = new Rectangle(3.4f, 1.6f, 9.11f, 4.21f);
        tutorialImages[0] = new Texture("TutorialSampleScreen1.png");
        tutorialImages[1] = new Texture("TutorialSampleScreen2.png");
        tutorialImages[2] = new Texture("TutorialSampleScreen3.png");
        tutorialImages[3] = new Texture("TutorialSampleScreen4.png");
        currentImage = tutorialImages[currentImageIndex];
    }
    @Override
    public void show() {

    }
    public void createButtons(){
        super.createButtons();
        mainMenuButton = new Button(game, "button-home.png", "button-home-pressed.png",1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);
        nextImageButton = new Button(game, "button-right.png", "button-right-pressed.png",13.5f, 3.5f, 1, Button.BUTTONTYPE_NEXTIMAGE);
        prevImageButton = new Button(game, "button-left.png", "button-left-pressed.png",1, 3.5f, 1, Button.BUTTONTYPE_PREVIMAGE);
        buttonList.add(mainMenuButton, nextImageButton, prevImageButton);
    }
    public void renderButtons(){
        super.renderButtons();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(currentImage, tutorialRect.x, tutorialRect.y, tutorialRect.getWidth(), tutorialRect.getHeight());
        batch.end();
        game.getTextRenderer().renderTextCenter((currentImageIndex+1) + "/4", 8f * 100f, 0.7f * 100f, font30);
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("tutorialtext"), 8.2f * 100f, 6.7f * 100f, font30);
    }
    @Override
    public void changeImage(boolean goForward) {
        int nextImg = goForward ? 1 : -1;
        int next = currentImageIndex + nextImg;

        if(next >= tutorialImages.length){
            currentImageIndex = 0;
        } else if (next < 0){
            currentImageIndex = tutorialImages.length + nextImg;
        } else {
            currentImageIndex = next;
        }
        currentImage = tutorialImages[currentImageIndex];
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
        for (Texture texture: tutorialImages){
            texture.dispose();
        }
    }
}
