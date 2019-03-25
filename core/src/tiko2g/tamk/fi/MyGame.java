package tiko2g.tamk.fi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// TODO: tee peli
//TODO: poista ^
public class MyGame extends Game {
    public static boolean playSounds;
    public static boolean playMusic;
	private SpriteBatch batch;
	private MainMenu mainMenu;
	private RecipeMenu recipeMenu;
    private OrthographicCamera camera;
    private TextRenderer textRenderer;

	@Override
	public void create () {
		batch = new SpriteBatch();
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, 16f, 9f);
        textRenderer = new TextRenderer(batch);
        mainMenu = new MainMenu(this);
        playSounds = true;
        playMusic = true;
	    setScreen(mainMenu);
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
        recipeMenu = new RecipeMenu(this);
        setScreen(recipeMenu);
    }

    public RecipeMenu getRecipeMenu() {
        return recipeMenu;
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
