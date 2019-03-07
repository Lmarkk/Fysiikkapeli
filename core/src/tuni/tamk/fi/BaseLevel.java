package tuni.tamk.fi;

import com.badlogic.gdx.Screen;
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
    private SpriteBatch batch;
    private float accumulator;
    private float timeStep;
    private World gameWorld;


    public BaseLevel(MyGame g) {
        game = g;
        batch = g.getBatch();
        gameWorld = new World(new Vector2(0, -9.81f), true);
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
        accumulator = 0;
        timeStep = 1/60f;
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
