package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EndlessLevel extends BaseLevel {
    Array<ThrownObject> thrownObjects = new Array<ThrownObject>(4);

    public EndlessLevel(MyGame g) {
        super(g, "bg-green-hills.png", "ground.png");
        catapult = new Catapult(1, 0.7f);
        pot = new Pot(this, game, 14, 0);

        thrownObjects.add(new Potato(game, this), new Chicken(game, this), new Meat(game, this), new Tomato(game, this));
        currentProjectile = thrownObjects.get(MathUtils.random(0, thrownObjects.size -1)).cloneObject();

        setNextProjectile();

        createBorderWall(1, 0);
        createBorderWall(46.5f, 0);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, -1, 16, 9);
        batch.draw(background, 16, -1, 16, 9);
        batch.draw(background, 32, -1, 16, 9);
        //for (ThrownObject object: getProjectiles()) {
        //    object.draw();
        //}
        if(!currentProjectile.isThrown() && Gdx.input.isTouched()){
            arrow.draw(batch, touchStart, new Vector2(Gdx.input.getX() / 100f, Gdx.input.getY() / 100f));
        }
        mainMenuButton.draw(batch);
        ground.draw();
        pot.drawTop();
        if(currentProjectile.isThrown()) {
            currentProjectile.draw();
        }
        pot.draw();
        catapult.draw(batch);
        batch.end();
        moveCam();
        doPhysicsStep(delta);
        if(endGame) {
            game.setScreen(new EndLevelScreen(game, 1));
        }
        super.render(delta);
    }
    @Override
    public void setNextProjectile() {
        getGameWorld().destroyBody(currentProjectile.getBody());
        currentProjectile = thrownObjects.get(MathUtils.random(0, thrownObjects.size -1)).cloneObject();
        scoreGetSoundPlayed = false;
        scoreGiven = false;
        projectileLanded = false;
        currentProjectile.getBody().setTransform(projectileStartPos, 0f);
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
        super.dispose();
    }
}
