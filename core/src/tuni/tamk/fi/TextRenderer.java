package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextRenderer {
    private FreeTypeFontGenerator generator;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont titleFont;

    public TextRenderer(SpriteBatch batch){
        this.batch = batch;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("OptimusPrincepsSemiBold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 48;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 3;
        titleFont = generator.generateFont(parameter);
    }
    public void renderText(String text, float x, float y, BitmapFont font){
        batch.setProjectionMatrix(camera.combined);
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text);
        batch.begin();
        font.draw(batch, text, x - layout.width / 2f, y - layout.height / 2f);
        batch.end();
    }


    public BitmapFont getTitleFont() {
        return titleFont;
    }
}