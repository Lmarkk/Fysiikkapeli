package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextRenderer {
    private OrthographicCamera camera;
    private SpriteBatch batch;

    public TextRenderer(SpriteBatch batch){
        this.batch = batch;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
    }
    public void renderText(String text, float x, float y, BitmapFont font){
        batch.setProjectionMatrix(camera.combined);
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text);
        batch.begin();
        font.draw(batch, text, x - layout.width / 2f, y + layout.height / 2f);
        batch.end();
    }

    public BitmapFont createFont(String fontFile, int fontSize, Color borderColor, int borderWidth){
        BitmapFont font;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontFile));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = fontSize;
        parameter.borderColor = borderColor;
        parameter.borderWidth = borderWidth;
        font = generator.generateFont(parameter);
        return font;
    }
}