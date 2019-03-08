package tuni.tamk.fi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// TODO: tee peli
public class MyGame extends Game {
	private SpriteBatch batch;
	private MainMenu mainMenu;
    private OrthographicCamera camera;
    private TextRenderer textRenderer;

	@Override
	public void create () {
		batch = new SpriteBatch();
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, 16f, 9f);
        textRenderer = new TextRenderer(batch);
        mainMenu = new MainMenu(this);
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

    @Override
	public void render () {
		super.render();
    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
