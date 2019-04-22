package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
    hotPot, /**
     * Chicken salad recipe type.
     */
    chickenSalad, /**
     * Meat soup recipe type.
     */
    meatSoup, /**
     * Vegetable stew recipe type.
     */
    vegetableStew, /**
     * Filled bell peppers recipe type.
     */
    filledBellPeppers, /**
     * Lentil soup recipe type.
     */
    lentilSoup, /**
     * Chili sin carne recipe type.
     */
    chiliSinCarne, /**
     * Chicken rice recipe type.
     */
    chickenRice, /**
     * Vegetable curry recipe type.
     */
    vegetableCurry, /**
     * Bean bolognese recipe type.
     */
    beanBolognese}

/**
 * The type Recipe.
 */
public class Recipe implements Screen {
    /**
     * The Anchor position.
     */
    Vector2 anchorPosition = new Vector2(0f, 0f);
    /**
     * The Game.
     */
    MyGame game;
    /**
     * The Batch.
     */
    SpriteBatch batch;
    /**
     * The Camera.
     */
    OrthographicCamera camera;
    /**
     * The Home button.
     */
    Button homeButton;
    /**
     * The Background.
     */
    Texture background;
    /**
     * The Font 30.
     */
    BitmapFont font30;
    /**
     * The Kreon font.
     */
    String kreonFont = "Kreon-Regular.ttf";
    /**
     * The Previous y.
     */
    float previousY;
    /**
     * The Touch start y.
     */
    float touchStartY;

    private String ingredients;
    private String instructions;
    private final Vector2 ingredientPos = new Vector2(250f, 850f);
    private final Vector2 instructionPos = new Vector2(50f, 450f);


    /**
     * Instantiates a new Recipe.
     *
     * @param g          the g
     * @param recipeType the recipe type
     */
    public Recipe(MyGame g, recipeType recipeType) {
        game = g;
        batch = game.getBatch();
        camera = game.getCamera();
        background = new Texture("menu-bg.png");
        homeButton = new Button(game, "button-left.png", "button-left-pressed.png", 1, 7.5f, 1, Button.BUTTONTYPE_RECIPES);
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
                if(pressedButton == null){
                    pressedButton = homeButton.getButton(screenX, screenY);
                    if(pressedButton != null){
                        pressedButton.setTexture(screenX, screenY, true);
                    }
                }
                touchStartY = screenY;
                previousY = screenY / 100f;
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
            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if(screenY > 0 && screenY <= Gdx.graphics.getHeight()){
                    if(screenY < touchStartY) {
//                        anchorPosition.y -= scrollSpeed * Gdx.graphics.getDeltaTime();
                        touchStartY = screenY;
                    } else {
//                        anchorPosition.y += scrollSpeed * Gdx.graphics.getDeltaTime();
                        touchStartY = screenY;

                    }
                }

//                camera.update();
//                previousY = screenY / 100f;
                return super.touchDragged(screenX, screenY, pointer);
            }
        });
    }

    /**
     * Move cam.
     *
     * @param desiredY the desired y
     */
    public void moveCam(float desiredY) {
//        Vector3 desiredPosition = new Vector3();
//        desiredPosition.x = camera.position.x;
//        desiredPosition.y = desiredY;
//        System.out.println(desiredPosition.y);
//        if(desiredPosition.y < 3 && desiredPosition.y > -20) {
//            System.out.println("juu");
//            camera.position.slerp(desiredPosition, Gdx.graphics.getDeltaTime() * 10);
//            homeButton.getButtonRect().setY(anchorPosition.y + 7.5f);
//            camera.update();
//        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, 16, 9);
        batch.end();
        game.getTextRenderer().renderText(instructions, instructionPos.x, anchorPosition.y + instructionPos.y, font30);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
//        batch.draw(background, 0, 5f, 16, 4f);
        homeButton.draw(batch);
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
