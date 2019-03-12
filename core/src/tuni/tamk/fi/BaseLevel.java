package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

public class BaseLevel implements Screen {
    MyGame game;
    SpriteBatch batch;
    Texture background;
    Ground ground;
    OrthographicCamera camera;
    private float accumulator;
    private float timeStep;
    private World gameWorld;
    private Vector2 touchStart = new Vector2();
    private Vector2 touchEnd = new Vector2();
    private Vector2 throwDirection = new Vector2();

    private boolean gameRunning = false;
    private Body currentProjectile;
    private float startTimer = 0f;

    public BaseLevel(MyGame g, String backgroundTextureSource, String groundTextureSource) {
        game = g;
        camera = g.getCamera();
        background = new Texture(backgroundTextureSource);
        batch = g.getBatch();
        gameWorld = new World(new Vector2(0, -9.81f), true);
        ground = new Ground(game, this, groundTextureSource);



        gameWorld.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Body body1 = contact.getFixtureA().getBody();
                Body body2 = contact.getFixtureB().getBody();
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
                System.out.println(touchStart);
                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(isGameRunning()){
                    touchEnd = new Vector2(screenX / 100f, screenY / 100f);
                    throwProjectile(currentProjectile);
                }
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });
        accumulator = 0;
        timeStep = 1/60f;
    }
    public void throwProjectile(Body body){
        if(body != null){
            throwDirection = new Vector2(touchStart.sub(touchEnd));
            throwDirection.y *= -1;
            body.applyLinearImpulse(throwDirection, body.getWorldCenter(), true);
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
        desiredPosition.x = currentProjectile.getPosition().x;
        desiredPosition.y = 3f;
        if(desiredPosition.x > 7.5f && desiredPosition.x < 40.5f) {
            camera.position.slerp(desiredPosition, Gdx.graphics.getDeltaTime() * 10);
            camera.update();
        }
    }

    public void setCurrentProjectile(Body currentProjectile) {
        this.currentProjectile = currentProjectile;
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
    }
}
