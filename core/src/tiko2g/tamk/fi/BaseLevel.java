package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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

public class BaseLevel implements Screen {
    private final Vector2 CAM_DEFAULT_POS = new Vector2(8, 4.5f);

    MyGame game;
    SpriteBatch batch;
    Texture background;
    Ground ground;
    Pot pot;
    OrthographicCamera camera;
    ThrownObject currentProjectile;
    Button mainMenuButton;
    private BitmapFont font64;
    private boolean endGame = false;
    private float accumulator;
    private float timeStep;
    private World gameWorld;
    private Vector2 touchStart = new Vector2();
    private Vector2 touchEnd = new Vector2();
    private Vector2 throwDirection = new Vector2();
    private boolean gameRunning = false;
    private float startTimer = 0f;
    private ArrayList<ThrownObject> projectiles = new ArrayList<ThrownObject>();
    private Vector2 projectileStartPos = new Vector2(2, 2);
    private int currentProjectileIndex = 0;
    private Vector2 cameraStartPosition = new Vector2(8f, 3f);
    private Vector2 cameraEndPosition = new Vector2(40f, 3);
    private boolean projectileLanded = false;
    private float landingTimer = 0f;
    private Box2DDebugRenderer debugRenderer;
    private Vector2 menuButtonCenter;

    public BaseLevel(MyGame g, String backgroundTextureSource, String groundTextureSource) {
        game = g;
        camera = g.getCamera();
        background = new Texture(backgroundTextureSource);
        batch = g.getBatch();
        gameWorld = new World(new Vector2(0, -9.81f), true);
        ground = new Ground(game, this, groundTextureSource);
        font64 = game.getTextRenderer().createFont("OptimusPrincepsSemiBold.ttf", 64, Color.BLACK, 4);
        mainMenuButton = new Button(game, "button.png", "button-pressed.png",1.5f , 6, 1, Button.BUTTONTYPE_MAINMENU);
        camera.position.set(cameraStartPosition, 0);
        camera.update();
        debugRenderer = new Box2DDebugRenderer();
        menuButtonCenter = new Vector2();
        menuButtonCenter = mainMenuButton.getButtonRect().getCenter(menuButtonCenter);
        pot = new Pot(this, game);


        gameWorld.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Body body1 = contact.getFixtureA().getBody();
                Body body2 = contact.getFixtureB().getBody();
                if (body1 == currentProjectile.getBody() || body2 == currentProjectile.getBody()) {
                    projectileLanded = true;
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

                mainMenuButton.setTexture(screenX, screenY, true);

                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(isGameRunning()){
                    touchEnd = new Vector2(screenX / 100f, screenY / 100f);
                    throwProjectile(currentProjectile);
                }

                mainMenuButton.pressFunction(screenX, screenY);
                mainMenuButton.setTexture(screenX, screenY, false);

                return super.touchUp(screenX, screenY, pointer, button);
            }
        });
        accumulator = 0;
        timeStep = 1/60f;
    }
    public void throwProjectile(ThrownObject projectile){
        Vector2 throwDirection;
        if(projectile != null && !projectile.isThrown()){
            throwDirection = new Vector2(touchStart.sub(touchEnd));
            throwDirection.y *= -1;
            Body b = projectile.getBody();
            b.setType(BodyDef.BodyType.DynamicBody);
            b.applyLinearImpulse(throwDirection, b.getWorldCenter(), true);
            b.applyAngularImpulse(-1f, true);
            projectile.setThrown(true);
        }
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void createBorderWall(float x, float y) {
        BorderWall borderWall = new BorderWall(game, this, x, y);
    }

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
    public void moveCam() {
        Vector3 desiredPosition = new Vector3();
        desiredPosition.x = currentProjectile.getBody().getPosition().x;
        desiredPosition.y = 3f;
        if(desiredPosition.x > cameraStartPosition.x && desiredPosition.x < cameraEndPosition.x) {
            camera.position.slerp(desiredPosition, Gdx.graphics.getDeltaTime() * 10);
            mainMenuButton.setX(camera.position.x -7.5f);
            camera.update();
        } else if(desiredPosition.x == projectileStartPos.x){
            camera.position.slerp(new Vector3(cameraStartPosition.x, cameraStartPosition.y ,0), Gdx.graphics.getDeltaTime() * 10);
            mainMenuButton.setX(camera.position.x -7.5f);
            camera.update();
        }
    }

    public void setNextProjectile() {
        if(currentProjectileIndex < projectiles.size()){

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
            //System.out.println("Out of projectiles");
            endGame = true;
        }
        projectileLanded = false;
    }

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
        if(endGame) {
            game.setScreen(new EndLevelScreen(game));
        }
        batch.begin();
        debugRenderer.render(getGameWorld(), camera.combined);
        batch.end();
        game.getTextRenderer().renderText("MENU", menuButtonCenter.x * 100f, (menuButtonCenter.y + (CAM_DEFAULT_POS.y - cameraStartPosition.y)) * 100f, font64);
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
    }

    public ArrayList<ThrownObject> getProjectiles() {
        return projectiles;
    }
}
