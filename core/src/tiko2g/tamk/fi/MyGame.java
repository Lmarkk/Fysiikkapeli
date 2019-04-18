package tiko2g.tamk.fi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

// TODO: tee peli
//TODO: poista ^
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
        mainMenu = new MainMenu(this);
	    setScreen(mainMenu);

	}

    public I18NBundle getFinBundle() {
        return finBundle;
    }

    public I18NBundle getEnBundle() {
        return enBundle;
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

    public Prefs getPrefs() {
        return prefs;
    }

    public Music getGreenHillsTheme() {
        return greenHillsTheme;
    }

    public Music getShadyWoodsTheme() {
        return shadyWoodsTheme;
    }

    public Music getWheatFieldsTheme() {
        return wheatFieldsTheme;
    }

    public Music getMenuTheme() {
        return menuTheme;
    }

    public String getKreonFont() {
        return kreonFont;
    }

    public BitmapFont getFont30() {
        return font30;
    }

    public BitmapFont getFont42() {
        return font42;
    }

    public BitmapFont getFont64() {
        return font64;
    }

    public BitmapFont getFont100() {
        return font100;
    }

    public BitmapFont getFont120() {
        return font120;
    }

    @Override
	public void render () {
		super.render();
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		greenHillsTheme.dispose();
		wheatFieldsTheme.dispose();
		menuTheme.dispose();
	}
}
