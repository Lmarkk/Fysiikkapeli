package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
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
 * The type Base level.
 */
public class BaseLevel implements Screen {
    private final Vector2 CAM_DEFAULT_POS = new Vector2(8, 4.5f);
    private final Vector2 THROW_MAX_FORCE = new Vector2(25f, 20f);
    private final float THROW_FORCE_MULTIPLIER = 3.5f;

    /**
     * The Game.
     */
    MyGame game;
    /**
     * The Batch.
     */
    SpriteBatch batch;
    /**
     * The Background.
     */
    Texture background;
    /**
     * The Ground.
     */
    Ground ground;
    /**
     * The Pot.
     */
    Pot pot;
    /**
     * The Camera.
     */
    OrthographicCamera camera;
    /**
     * The Current projectile.
     */
    ThrownObject currentProjectile;
    /**
     * The Prev menu button.
     */
    Button prevMenuButton;
    /**
     * The Score get sound.
     */
    Sound scoreGetSound;
    /**
     * The Catapult.
     */
    Catapult catapult;
    /**
     * The Projectile start pos.
     */
    Vector2 projectileStartPos = new Vector2(1, 2.2f);
    /**
     * The Arrow.
     */
    Arrow arrow;
    /**
     * The Score.
     */
    int score;
    /**
     * The Projectile landed.
     */
    boolean projectileLanded = false;
    /**
     * The Vegan mode.
     */
    boolean veganMode;
    /**
     * The Font 32.
     */
    BitmapFont font32;

    /**
     * The Score get sound played.
     */
    boolean scoreGetSoundPlayed;
    /**
     * The Score given.
     */
    boolean scoreGiven;
    /**
     * The End game.
     */
    boolean endGame = false;
    private float accumulator;
    private float timeStep;
    private World gameWorld;
    /**
     * The Touch start.
     */
    Vector2 touchStart = new Vector2();
    private Vector2 touchEnd = new Vector2();
    private boolean gameRunning = false;
    private float startTimer = 0f;
    private ArrayList<ThrownObject> projectiles = new ArrayList<ThrownObject>();
    private int currentProjectileIndex = 0;
    private Vector2 cameraStartPosition = new Vector2(8f, 3f);
    private Vector2 cameraEndPosition = new Vector2(40f, 3);
    private float landingTimer = 0f;
    private Box2DDebugRenderer debugRenderer;
    private Vector2 menuButtonCenter;

    /**
     * Instantiates a new Base level.
     *
     * @param g                       the g
     * @param backgroundTextureSource the background texture source
     * @param groundTextureSource     the ground texture source
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
     * Throw projectile.
     *
     * @param projectile the projectile
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
     * Is game running boolean.
     *
     * @return the boolean
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Create border wall.
     *
     * @param x the x
     * @param y the y
     */
    public void createBorderWall(float x, float y) {
        BorderWall borderWall = new BorderWall(game, this, x, y);
    }

    /**
     * Do physics step.
     *
     * @param deltaTime the delta time
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
     * Move cam.
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
     * Sets next projectile.
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
     * Gets game world.
     *
     * @return the game world
     */
    public World getGameWorld() {
        return gameWorld;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(!isGameRunning()){
            startTimer += delta;
            if(startTimer >= 0.1f){
                gameRunning = true;
            }
        }

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
        //if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
        //    game.setScreen(new EndLevelScreen(game, 2, 800));
        //}

        batch.begin();
        debugRenderer.render(getGameWorld(), camera.combined);
        batch.end();

        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("score") + " " + score, 8f * 100f, 8.4f * 100f, font32);

    }

    /**
     * Stop music.
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
     * Gets projectiles.
     *
     * @return the projectiles
     */
    public ArrayList<ThrownObject> getProjectiles() {
        return projectiles;
    }
}
