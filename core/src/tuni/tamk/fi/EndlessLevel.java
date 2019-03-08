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
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, 16, 9);
        blueBerry.draw();
        ground.draw();
//        for (Body body : bodies) {
//            if(body.getUserData() != null){
//                float radius = body.getFixtureList().get(0).getShape().getRadius();
//                Texture texture = (Texture) body.getUserData();
//                batch.draw(texture,
//                        body.getPosition().x - radius,
//                        body.getPosition().y - radius,
//                        radius,
//                        radius,
//                        radius * 2f,
//                        radius * 2f,
//                        1.0f,
//                        1.0f,
//                        body.getTransform().getRotation() * MathUtils.radiansToDegrees,
//                        0,
//                        0,
//                        texture.getWidth(),
//                        texture.getHeight(),
//                        false,
//                        false);
//            }
//        }
        batch.end();
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
