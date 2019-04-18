package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * The type Text renderer.
 */
public class TextRenderer {
    private OrthographicCamera camera;
    private SpriteBatch batch;

    /**
     * Instantiates a new Text renderer.
     *
     * @param batch the batch
     */
    public TextRenderer(SpriteBatch batch){
        this.batch = batch;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1600, 900);
    }

    /**
     * Render text center.
     *
     * @param text the text
     * @param x    the x
     * @param y    the y
     * @param font the font
     */
    public void renderTextCenter(String text, float x, float y, BitmapFont font){
        batch.setProjectionMatrix(camera.combined);
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text);
        batch.begin();
        font.draw(batch, text, x - layout.width / 2f, y + layout.height / 2f);
        batch.end();
    }

    /**
     * Render text.
     *
     * @param text the text
     * @param x    the x
     * @param y    the y
     * @param font the font
     */
    public void renderText(String text, float x, float y, BitmapFont font){
        String[] splitText = text.split("_SPLIT_");
        batch.setProjectionMatrix(camera.combined);
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, splitText[0]);
        batch.begin();
        font.draw(batch, splitText[0], x, y);
        if(splitText.length > 1) {
            font.draw(batch, splitText[1], x + layout.width + 50f, y);
        }
        batch.end();
    }

    /**
     * Create font bitmap font.
     *
     * @param fontFile    the font file
     * @param fontSize    the font size
     * @param borderColor the border color
     * @param borderWidth the border width
     * @return the bitmap font
     */
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