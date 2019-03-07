package tuni.tamk.fi;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;

public class EndlessLevel implements Screen {
    private MyGame game;
    private SpriteBatch batch;



    public EndlessLevel(MyGame g) {
        game = g;
        batch = g.getBatch();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
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
