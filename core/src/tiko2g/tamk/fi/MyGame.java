package tiko2g.tamk.fi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

// TODO: tee peli
//TODO: poista ^
public class MyGame extends Game {
    public static boolean playSounds;
    public static boolean playMusic;
	private SpriteBatch batch;
	private MainMenu mainMenu;
	private RecipeMenu recipeMenu;
	private TutorialScreen tutorialScreen;
    private OrthographicCamera camera;
    private TextRenderer textRenderer;
    private I18NBundle myBundle;

	@Override
	public void create () {
		batch = new SpriteBatch();
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, 16f, 9f);
        textRenderer = new TextRenderer(batch);
        playSounds = true;
        playMusic = true;
        mainMenu = new MainMenu(this);
        Locale locale = Locale.getDefault();
        myBundle = I18NBundle.createBundle(Gdx.files.internal("MyBundle"), locale);
	    setScreen(mainMenu);
	}

    public I18NBundle getMyBundle() {
        return myBundle;
    }

    public TextRenderer getTextRenderer() {
        return textRenderer;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void createRecipeMenu() {
	    if(recipeMenu == null){
            recipeMenu = new RecipeMenu(this);
        }
        setScreen(recipeMenu);
    }

    public RecipeMenu getRecipeMenu() {
        return recipeMenu;
    }
    public void createTutorialScreen(){
	    if(tutorialScreen == null){
	        tutorialScreen = new TutorialScreen(this);
        }
        setScreen(tutorialScreen);
    }
    public TutorialScreen getTutorialScreen(){
	    return tutorialScreen;
    }
    @Override
	public void render () {
		super.render();
    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
