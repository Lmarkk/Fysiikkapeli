package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class EndlessLevel extends BaseLevel {

    public EndlessLevel(MyGame g) {
        super(g, "phbackground.png", "groundtexture.png");

        for (int i = 0; i < 10; i++) {
            ThrownObject object = new Meat(game, this);
            getProjectiles().add(object);
        }
        setNextProjectile();

//        createBorderWall(1, 0);
        createBorderWall(46.5f, 0);

        pot = new Pot(this, game);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, 16, 9);
        batch.draw(background, 16, 0, 16, 9);
        batch.draw(background, 32, 0, 16, 9);
        //for (ThrownObject object: getProjectiles()) {
        //    object.draw();
        //}
        mainMenuButton.draw(batch);
        ground.draw();
        pot.drawTop();
        currentProjectile.draw();
        pot.draw();
        batch.end();
        moveCam();
        if(pot.getPotRect().overlaps(currentProjectile.getRect())){
            System.out.println("SCORE!");
        }
        doPhysicsStep(delta);
        super.render(delta);
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
