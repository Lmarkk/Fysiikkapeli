package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;


/**
 * BaseLevel is the superclass for all level classes such as FirstLevel and EndlessLevel.
 *
 * @author Lassi Markkinen, Arttu Knuutinen
 * @version 2019.0418
 */
public class BaseLevel implements Screen {
    private final Vector2 CAM_DEFAULT_POS = new Vector2(8, 4.5f);
    private final Vector2 THROW_MAX_FORCE = new Vector2(25f, 20f);
    private final float THROW_FORCE_MULTIPLIER = 3.5f;

    /**
     * Instance of MyGame received as a parameter in constructor.
     */
    MyGame game;
    /**
     * SpriteBatch used for rendering.
     */
    SpriteBatch batch;
    /**
     * Background texture for the current level.
     */
    Texture background;
    /**
     * The Ground for the current level.
     */
    Ground ground;
    /**
     * The Pot for the current level, used as a target for the player.
     */
    Pot pot;
    /**
     * The Camera that follows the projectiles the player throws.
     */
    OrthographicCamera camera;
    /**
     * The current projectile held on the catapult or being thrown by the player.
     */
    ThrownObject currentProjectile;
    /**
     * Menu button for returning to previous menu screen.
     */
    Button prevMenuButton;
    /**
     * Sound that plays when the player lands a projectile into the pot.
     */
    private Sound scoreGetSound;
    /**
     * Animated catapult used to visualize the projectile "thrower" for the player.
     */
    Catapult catapult;
    /**
     * Coordinates that determine where the projectile is held before launched by the player.
     */
    Vector2 projectileStartPos = new Vector2(1, 2.2f);
    /**
     * Arrow that illustrates the power and angle of the player's throw to them.
     */
    Arrow arrow;
    /**
     * Score of the current run of the current level.
     */
    int score;
    /**
     * Value for determining whether the current projectile has touched ground/pot bottom or not.
     */
    boolean projectileLanded = false;
    /**
     * Value that determines whether the level uses vegan objects and tracks vegan recipe unlock progress.
     */
    boolean veganMode;
    /**
     * BitmapFont used for rendering text in levels.
     */
    BitmapFont font32;

    /**
     * Value used to ensure that the score get sound is only played once per throw.
     */
    boolean scoreGetSoundPlayed;
    /**
     * Value used to ensure that the player only receives points once per throw.
     */
    boolean scoreGiven;
    /**
     * Value that determines whether the current level is over.
     */
    boolean endGame = false;
    /**
     * Value used with World physics steps.
     */
    private float accumulator;
    /**
     * Value used with World physics steps.
     */
    private float timeStep;
    /**
     * World used for physics handling within the levels.
     */
    private World gameWorld;
    /**
     * Variable that holds the start coordinates of the player's touch action.
     */
    Vector2 touchStart = new Vector2();
    /**
     * Variable that holds the end coordinates of the player's touch action.
     */
    private Vector2 touchEnd = new Vector2();
    /**
     * Value for whether game is running or not.
     */
    private boolean gameRunning = true;

    //private float startTimer = 0f;

    /**
     * Array that holds all the projectiles for the current level.
     */
    private ArrayList<ThrownObject> projectiles = new ArrayList<ThrownObject>();
    /**
     * Index that tracks the position of the current projectile in the array
     */
    private int currentProjectileIndex = 0;
    /**
     * The leftmost limit for Camera tracking.
     */
    private Vector2 cameraStartPosition = new Vector2(8f, 3f);
    /**
     * The rightmost limit for Camera tracking.
     */
    private Vector2 cameraEndPosition = new Vector2(40f, 3);
    /**
     * Timer that forces the Camera to wait before moving to the position of the new projectile.
     */
    private float landingTimer = 0f;
    /**
     * Box2DDebugRenderer used for testing hitboxes etc.
     */
    private Box2DDebugRenderer debugRenderer;
    /**
     * Vector2 that holds the x and y coordinates of the center of the menu button.
     */
    private Vector2 menuButtonCenter;

    /**
     * Instantiates a new BaseLevel.
     *
     * Camera, SpriteBatch and BitmapFont are retrieved using the MyGame instance. It is
     * also given to any contructors that require it. GameWorld is set as ContactListener to
     * enable collision detection. BaseLevel is also set as InputProcessor. This allows for projectile
     * throwing mechanics.
     *
     * @param g                       the MyGame used to retrieve spriteBatch, font, etc.
     * @param backgroundTextureSource the background texture source path.
     * @param groundTextureSource     the ground texture source path.
     */
    public BaseLevel(MyGame g, String backgroundTextureSource, String groundTextureSource) {
        game = g;
        camera = g.getCamera();
        background = new Texture(backgroundTextureSource);
        batch = g.getBatch();
        gameWorld = new World(new Vector2(0, -9.81f), true);
        ground = new Ground(game, this, groundTextureSource);
        scoreGetSound =  Gdx.audio.newSound(Gdx.files.internal("Osuma.ogg"));
        scoreGetSoundPlayed = false;
        scoreGiven = false;
        prevMenuButton = new Button(game, "button-left.png", "button-left-pressed.png",1.5f , 6, 1, Button.BUTTONTYPE_PLAYMODES);
        camera.position.set(cameraStartPosition, 0);
        camera.update();
        debugRenderer = new Box2DDebugRenderer();
        menuButtonCenter = new Vector2();
        menuButtonCenter = prevMenuButton.getButtonRect().getCenter(menuButtonCenter);
        font32 = game.getFont32();
        score = 0;
        arrow = new Arrow();


        gameWorld.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Body body1 = contact.getFixtureA().getBody();
                Body body2 = contact.getFixtureB().getBody();
                if (body1 == currentProjectile.getBody() || body2 == currentProjectile.getBody()) {
                    projectileLanded = true;
                    catapult.setShoot(false);
                }
            }
            @Override
            public void endContact(Contact contact) {

            }
            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }
            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
        Gdx.input.setInputProcessor(new MyInputProcessor() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if(isGameRunning()){
                    touchStart = new Vector2(screenX / 100f, screenY / 100f);
                }

                prevMenuButton.setTexture(screenX, screenY, true);

                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(isGameRunning()){
                    touchEnd = new Vector2(screenX / 100f, screenY / 100f);
                    throwProjectile(currentProjectile);
                }

                prevMenuButton.pressFunction(screenX, screenY);
                prevMenuButton.setTexture(screenX, screenY, false);

                return super.touchUp(screenX, screenY, pointer, button);
            }
        });
        accumulator = 0;
        timeStep = 1/60f;
    }

    /**
     * Method for throwing projectiles. Also limits the force and direction of the throw for a
     * better play experience.
     *
     * @param projectile the projectile used for throwing.
     */
    public void throwProjectile(ThrownObject projectile){
        Vector2 throwDirection;
        if(projectile != null && !projectile.isThrown()){
            throwDirection = new Vector2(touchStart.sub(touchEnd));
            throwDirection = throwDirection.scl(THROW_FORCE_MULTIPLIER);
            throwDirection.y *= -1;
            if(throwDirection.x < 0){
                return;
            } else if(throwDirection.x > THROW_MAX_FORCE.x){
                throwDirection.x = THROW_MAX_FORCE.x;
            }
            if(throwDirection.y < 0){
                return;
            } else if(throwDirection.y > THROW_MAX_FORCE.y){
                throwDirection.y = THROW_MAX_FORCE.y;
            }
            Body b = projectile.getBody();
            b.setType(BodyDef.BodyType.DynamicBody);
            b.applyLinearImpulse(throwDirection, b.getWorldCenter(), true);
            b.applyAngularImpulse(-1f, true);
            projectile.setThrown(true);
            catapult.setShoot(true);
        }
    }

    /**
     * Getter for isGameRunning boolean.
     *
     * @return boolean value.
     */
    private boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Creates border walls for the level based on x and y coordinates.
     *
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    public void createBorderWall(float x, float y) {
        BorderWall borderWall = new BorderWall(game, this, x, y);
    }

    /**
     * Handles the Box2d World physics stepping through the use of deltaTime and timeStep variables.
     *
     * @param deltaTime the deltatime variable.
     */
    public void doPhysicsStep(float deltaTime) {
        float frameTime = deltaTime;
        if(deltaTime > 1 / 4f) {
            frameTime = 1 / 4f;
        }
        accumulator += frameTime;

        while(accumulator >= timeStep) {
            gameWorld.step(timeStep, 7, 2);
            accumulator -= timeStep;
        }
    }

    /**
     * Method for moving Camera. The Camera constantly updates it's desired position based on
     * the current projectile's x coordinate. Camera.slerp is used to achieve a smooth tracking
     * action.
     */
    public void moveCam() {
        Vector3 desiredPosition = new Vector3();
        desiredPosition.x = currentProjectile.getBody().getPosition().x;
        desiredPosition.y = 3f;
        if(desiredPosition.x > cameraStartPosition.x && desiredPosition.x < cameraEndPosition.x) {
            camera.position.slerp(desiredPosition, Gdx.graphics.getDeltaTime() * 10);
            prevMenuButton.setX(camera.position.x -7.5f);
            camera.update();
        } else if(desiredPosition.x <= projectileStartPos.x){
            camera.position.slerp(new Vector3(cameraStartPosition.x, cameraStartPosition.y ,0), Gdx.graphics.getDeltaTime() * 10);
            prevMenuButton.setX(camera.position.x -7.5f);
            camera.update();
        }
    }

    /**
     * Sets next projectile to be thrown. Also handles score system and sets endGame = true if
     * the player is out of projectiles.
     */
    public void setNextProjectile() {
        if(currentProjectileIndex < projectiles.size()){
            scoreGetSoundPlayed = false;
            scoreGiven = false;

            if(currentProjectileIndex > 0) {
                projectiles.get(currentProjectileIndex - 1).getTexture().dispose();
                gameWorld.destroyBody(projectiles.get(currentProjectileIndex - 1).getBody());
            }

            if(currentProjectileIndex < projectiles.size()) {
                currentProjectile = projectiles.get(currentProjectileIndex);
                currentProjectile.getBody().setTransform(projectileStartPos, 0f);
                currentProjectileIndex++;
            }
        } else {
            endGame = true;
        }
        projectileLanded = false;
    }

    /**
     * Getter for gameWorld.
     *
     * @return gameWorld.
     */
    public World getGameWorld() {
        return gameWorld;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //if(!isGameRunning()){
        //    startTimer += delta;
        //    if(startTimer >= 0.1f){
        //        gameRunning = true;
        //    }
        //}

        if(projectileLanded){
            landingTimer += delta;
            if(landingTimer > 3f){
                setNextProjectile();
                landingTimer = 0f;
            }
        }
        if(pot.getPotRect().overlaps(currentProjectile.getRect())){
            if(!scoreGiven) {
                score += 100;
                scoreGiven = true;
            }
            if(game.getPrefs().getSoundStatus()) {
                if(!scoreGetSoundPlayed) {
                    scoreGetSound.play();
                }
                scoreGetSoundPlayed = true;
            }
        }


        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("score") + " " + score, 8f * 100f, 8.4f * 100f, font32);

    }

    /**
     * Stops all music.
     */
    public void stopMusic() {
        game.getMenuTheme().stop();
        game.getWheatFieldsTheme().stop();
        game.getGreenHillsTheme().stop();
        game.getShadyWoodsTheme().stop();
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
        gameWorld.dispose();
        background.dispose();
        game.dispose();
        prevMenuButton.dispose();
    }

    /**
     * Getter for projectile ArrayList.
     *
     * @return projectile ArrayList.
     */
    public ArrayList<ThrownObject> getProjectiles() {
        return projectiles;
    }
}
