package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

public class BaseLevel implements Screen {
    private MyGame game;
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

    private Body currentProjectile = null;

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
                touchStart = new Vector2(screenX, screenY);
                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                touchEnd = new Vector2(screenX, screenY);
                throwProjectile(currentProjectile);
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
            System.out.println(throwDirection);
            body.applyLinearImpulse(throwDirection, body.getWorldCenter(), true);
        }
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

    public World getGameWorld() {
        return gameWorld;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
