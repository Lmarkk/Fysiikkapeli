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

public class Recipe implements Screen {
    Vector2 anchorPosition = new Vector2(0f, 0f);
    MyGame game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Button homeButton;
    Texture background;
    BitmapFont font30;
    String kreonFont = "Kreon-Regular.ttf";
    float previousY;
    float touchStartY;
    float scrollSpeed = 500f;
    public Recipe(MyGame g) {
        game = g;
        batch = game.getBatch();
        camera = game.getCamera();
        background = new Texture("menu-bg.png");
        homeButton = new Button(game, "button-home.png", "button-home-pressed.png", 1, 7.5f, 1, Button.BUTTONTYPE_MAINMENU);
        font30 = game.getTextRenderer().createFont(kreonFont, 30, Color.BLACK, 4);

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
                        anchorPosition.y -= scrollSpeed * Gdx.graphics.getDeltaTime();
                        touchStartY = screenY;
                    } else {
                        anchorPosition.y += scrollSpeed * Gdx.graphics.getDeltaTime();
                        touchStartY = screenY;

                    }
                }

//                camera.update();
//                previousY = screenY / 100f;
                return super.touchDragged(screenX, screenY, pointer);
            }
        });
    }
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
        //batch.draw(background, 0, 0, 16, 9);
        homeButton.draw(batch);
        batch.end();

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
