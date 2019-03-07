package tuni.tamk.fi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// TODO: tee peli
public class MyGame extends Game {
	private SpriteBatch batch;
	private MainMenu mainMenu;
	private EndlessLevel endlessLevel;
    private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, 16f, 9f);
	    mainMenu = new MainMenu(this);
	    endlessLevel = new EndlessLevel(this);
	    setScreen(mainMenu);
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
