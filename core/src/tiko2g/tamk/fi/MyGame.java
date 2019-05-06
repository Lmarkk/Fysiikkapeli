package tiko2g.tamk.fi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

/**
 * The type My game.
 *
 * @author Lassi Markkinen
 * @version 2.0
 */
public class MyGame extends Game {
    private Prefs prefs;
	private SpriteBatch batch;
	private MainMenu mainMenu;
    private OrthographicCamera camera;
    private TextRenderer textRenderer;
    private I18NBundle finBundle;
    private I18NBundle enBundle;
    private Music greenHillsTheme;
    private Music wheatFieldsTheme;
    private Music shadyWoodsTheme;
    private Music menuTheme;
    private String kreonFont = "Kreon-Regular.ttf";
    private BitmapFont font64;
    private BitmapFont font100;
    private BitmapFont font42;
    private BitmapFont font120;
    private BitmapFont font30;
    private BitmapFont font32;
    private BitmapFont font35;

	@Override
	public void create () {
	    greenHillsTheme = Gdx.audio.newMusic(Gdx.files.internal("music-greenhills.ogg"));
	    greenHillsTheme.setLooping(true);
        wheatFieldsTheme = Gdx.audio.newMusic(Gdx.files.internal("music-wheatfields.ogg"));
        wheatFieldsTheme.setLooping(true);
        shadyWoodsTheme = Gdx.audio.newMusic(Gdx.files.internal("ShadiestWoodsEU.ogg"));
        shadyWoodsTheme.setLooping(true);
        menuTheme = Gdx.audio.newMusic(Gdx.files.internal("music-menu.ogg"));
        menuTheme.setLooping(true);
        finBundle = I18NBundle.createBundle(Gdx.files.internal("MyBundle"), new Locale("fi", "FI"));
        enBundle = I18NBundle.createBundle(Gdx.files.internal("MyBundle"), new Locale("en", "US"));
	    prefs = new Prefs(this);
		batch = new SpriteBatch();
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, 16f, 9f);
        textRenderer = new TextRenderer(batch);
        font64 = getTextRenderer().createFont(kreonFont, 64, Color.BLACK, 3);
        font100 = getTextRenderer().createFont(kreonFont, 100, Color.BLACK, 3);
        font42 = getTextRenderer().createFont(kreonFont, 42, Color.BLACK, 3);
        font120 = getTextRenderer().createFont(kreonFont, 120, Color.BLACK, 3);
        font30 = getTextRenderer().createFont(kreonFont, 30, Color.BLACK, 3);
        font32 = getTextRenderer().createFont(kreonFont, 32, Color.BLACK, 3);
        font35 = getTextRenderer().createFont(kreonFont, 35, Color.BLACK, 3);
        mainMenu = new MainMenu(this);
	    setScreen(mainMenu);
	}

    @Override
    public void setScreen(Screen screen) {
	    Screen prevScreen = getScreen();
	    if(prevScreen != null){
            prevScreen.dispose();
        }
        super.setScreen(screen);
    }

    /**
     * Gets fin bundle.
     *
     * @return the fin bundle
     */
    public I18NBundle getFinBundle() {
        return finBundle;
    }

    /**
     * Gets en bundle.
     *
     * @return the en bundle
     */
    public I18NBundle getEnBundle() {
        return enBundle;
    }

    /**
     * Gets text renderer.
     *
     * @return the text renderer
     */
    public TextRenderer getTextRenderer() {
        return textRenderer;
    }

    /**
     * Gets batch.
     *
     * @return the batch
     */
    public SpriteBatch getBatch() {
        return batch;
    }

    /**
     * Gets camera.
     *
     * @return the camera
     */
    public OrthographicCamera getCamera() {
        return camera;
    }

    /**
     * Gets prefs.
     *
     * @return the prefs
     */
    public Prefs getPrefs() {
        return prefs;
    }

    /**
     * Gets green hills theme.
     *
     * @return the green hills theme
     */
    public Music getGreenHillsTheme() {
        return greenHillsTheme;
    }

    /**
     * Gets shady woods theme.
     *
     * @return the shady woods theme
     */
    public Music getShadyWoodsTheme() {
        return shadyWoodsTheme;
    }

    /**
     * Gets wheat fields theme.
     *
     * @return the wheat fields theme
     */
    public Music getWheatFieldsTheme() {
        return wheatFieldsTheme;
    }

    /**
     * Gets menu theme.
     *
     * @return the menu theme
     */
    public Music getMenuTheme() {
        return menuTheme;
    }

    /**
     * Gets font 30.
     *
     * @return the font 30
     */
    public BitmapFont getFont30() {
        return font30;
    }

    /**
     * Gets font 42.
     *
     * @return the font 42
     */
    public BitmapFont getFont42() {
        return font42;
    }

    /**
     * Gets font 64.
     *
     * @return the font 64
     */
    public BitmapFont getFont64() {
        return font64;
    }

    /**
     * Gets font 100.
     *
     * @return the font 100
     */
    public BitmapFont getFont100() {
        return font100;
    }

    /**
     * Gets font 120.
     *
     * @return the font 120
     */
    public BitmapFont getFont120() {
        return font120;
    }

    public BitmapFont getFont32() {
        return font32;
    }

    public BitmapFont getFont35() {
        return font35;
    }

    @Override
	public void render () {
		super.render();
    }
	
	@Override
	public void dispose () {
		greenHillsTheme.dispose();
		wheatFieldsTheme.dispose();
		shadyWoodsTheme.dispose();
		menuTheme.dispose();
	}
}
