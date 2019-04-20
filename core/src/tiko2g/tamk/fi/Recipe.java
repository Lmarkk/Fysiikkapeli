package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * The enum Recipe type.
 */
enum recipeType {
    /**
     * Hot pot recipe type.
     */
    hotPot,
    /**
     * Chicken salad recipe type.
     */
    chickenSalad,
    /**
     * Meat soup recipe type.
     */
    meatSoup,
    /**
     * Vegetable stew recipe type.
     */
    vegetableStew,
    /**
     * Filled bell peppers recipe type.
     */
    filledBellPeppers,
    /**
     * Lentil soup recipe type.
     */
    lentilSoup,
    /**
     * Chili sin carne recipe type.
     */
    chiliSinCarne,
    /**
     * Chicken rice recipe type.
     */
    chickenRice,
    /**
     * Vegetable curry recipe type.
     */
    vegetableCurry,
    /**
     * Bean bolognese recipe type.
     */
    beanBolognese
}

/**
 * Recipe displays a recipe on a screen specified by recipeType.
 *
 * @author Arttu Knuutinen
 * @version 2019.0418
 */
public class Recipe implements Screen {
    /**
     * MyGame reference used for various utilities.
     */
    private MyGame game;
    /**
     * Reference to the SpriteBatch instance.
     */
    private SpriteBatch batch;
    /**
     * Reference to the Camera instance.
     */
    private OrthographicCamera camera;
    /**
     * Button that returns user to the recipe menu.
     */
    private Button recipeMenuButton;
    /**
     * The Background texture of a recipe.
     */
    private Texture background;
    /**
     * The font used to render recipe texts.
     */
    private BitmapFont font30;
    /**
     * The ingredients of a recipe.
     */
    private String ingredients;
    /**
     * The instructions of a recipe.
     */
    private String instructions;
    /**
     * The position in pixels on the screen where to draw ingredients text.
     */
    private final Vector2 ingredientPos = new Vector2(250f, 850f);
    /**
     * The position in pixels on the screen where to draw instructions text.
     */
    private final Vector2 instructionPos = new Vector2(50f, 450f);

    /**
     * Instantiates a new Recipe.
     *
     * @param g          the game
     * @param recipeType the recipe type
     */
    public Recipe(MyGame g, recipeType recipeType) {
        game = g;
        batch = game.getBatch();
        camera = game.getCamera();
        background = new Texture("menu-bg.png");
        recipeMenuButton = new Button(game, "button-left.png", "button-left-pressed.png", 1, 7.5f, 1, Button.BUTTONTYPE_RECIPES);
        font30 = game.getFont30();
        switch (recipeType){
            case hotPot:
                ingredients = g.getPrefs().getCurrentLanguage().get("hotPotIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("hotPotInstructions");
                break;
            case meatSoup:
                ingredients = g.getPrefs().getCurrentLanguage().get ("meatSoupIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("meatSoupInstructions");
                break;
            case chickenSalad:
                ingredients = g.getPrefs().getCurrentLanguage().get ("chickenSaladIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("chickenSaladInstructions");
                break;
            case vegetableStew:
                ingredients = g.getPrefs().getCurrentLanguage().get ("vegetableStewIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("vegetableStewInstructions");
                break;
            case filledBellPeppers:
                ingredients = g.getPrefs().getCurrentLanguage().get ("filledBellPepperIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("filledBellPepperInstructions");
                break;
            case lentilSoup:
                ingredients = g.getPrefs().getCurrentLanguage().get ("lentilSoupIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("lentilSoupInstructions");
                break;
            case chickenRice:
                ingredients = g.getPrefs().getCurrentLanguage().get ("chickenRiceIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("chickenRiceInstructions");
                break;
            case chiliSinCarne:
                ingredients = g.getPrefs().getCurrentLanguage().get ("chiliSinCarneIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("chiliSinCarneInstructions");
                break;
            case beanBolognese:
                ingredients = g.getPrefs().getCurrentLanguage().get ("beanBologneseIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("beanBologneseInstructions");
                break;
            case vegetableCurry:
                ingredients = g.getPrefs().getCurrentLanguage().get ("vegetableCurryIngredients");
                instructions = g.getPrefs().getCurrentLanguage().get("vegetableCurryInstructions");
                break;
        }

        Gdx.input.setInputProcessor(new MyInputProcessor() {
            Button pressedButton;
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                pressedButton = null;

                pressedButton = recipeMenuButton.getButton(screenX, screenY);
                if(pressedButton != null){
                    pressedButton.setTexture(screenX, screenY, true);
                }
                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(pressedButton != null){
                    pressedButton.pressFunction(screenX, screenY);
                    pressedButton.setTexture(screenX, screenY, false);
                }

                return super.touchUp(screenX, screenY, pointer, button);
            }
        });
    }

    @Override
    public void show() {

    }

    /**
     * https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/Screen.html#render-float-
     *
     * @param delta graphics delta time
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, 16, 9);
        batch.end();
        game.getTextRenderer().renderText(instructions, instructionPos.x, instructionPos.y, font30);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        recipeMenuButton.draw(batch);
        batch.end();
        game.getTextRenderer().renderText(ingredients, ingredientPos.x, ingredientPos.y, font30);
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

    }

}
