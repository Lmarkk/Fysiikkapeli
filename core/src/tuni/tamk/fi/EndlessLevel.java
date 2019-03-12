package tuni.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.Body;

public class EndlessLevel extends BaseLevel {
    ThrownObject blueBerry;

    public EndlessLevel(MyGame g) {
        super(g, "phbackground.png", "groundtexture.png");
        blueBerry = new ThrownObject(game, this, "blueberry.png", ThrownObject.OBJECTSHAPE_CIRCLE);
        setCurrentProjectile(blueBerry.getBody());
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        super.render(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, 16, 9);
        batch.draw(background, 16, 0, 16, 9);
        batch.draw(background, 32, 0, 16, 9);
        blueBerry.draw();
        ground.draw();
        batch.end();
        moveCam();
        doPhysicsStep(Gdx.graphics.getDeltaTime());
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
    private static void createFloor(){

    }
    private Body createBody(){
        return null;
    }
}
