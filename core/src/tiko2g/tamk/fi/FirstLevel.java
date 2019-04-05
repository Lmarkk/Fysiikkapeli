package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;

public class FirstLevel extends BaseLevel {
    Array<ThrownObject> thrownObjects = new Array<ThrownObject>(7);
    int arrayIndex;

    public FirstLevel(MyGame g) {
        super(g, "bg-green-hills2.png", "groundtexture.png");
        arrayIndex = 0;
        catapult = new Catapult(1, 0.7f);
        pot = new Pot(this, game, 12, 0);

        //for (int i = 0; i < 3; i++) {
        //    ThrownObject object = new Carrot(game, this);
        //    getProjectiles().add(object);
        //}

        thrownObjects.add(new Meat(game, this), new Meat(game, this), new Onion(game, this), new Onion(game, this));
        thrownObjects.add(new Carrot(game, this), new Carrot(game, this), new Carrot(game, this));
        currentProjectile = thrownObjects.get(0);

        setNextProjectile();

        createBorderWall(-0.5f, 0);
        createBorderWall(30, 0);
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
        catapult.draw(batch);
        batch.end();
        moveCam();
        doPhysicsStep(delta);
        if(endGame) {
            game.setScreen(new EndLevelScreen(game, 9));
        }
        super.render(delta);
        game.getTextRenderer().renderText(game.getPrefs().getCurrentLanguage().get("highscore") + " " + game.getPrefs().getFirstLevelScore(), 11f * 100f, 8.4f * 100f, font32);
    }

    @Override
    public void setNextProjectile() {
        if(arrayIndex < thrownObjects.size) {
            getGameWorld().destroyBody(currentProjectile.getBody());
            currentProjectile = thrownObjects.get(arrayIndex).cloneObject();
            arrayIndex++;
            scoreGetSoundPlayed = false;
            scoreGiven = false;
            projectileLanded = false;
            currentProjectile.getBody().setTransform(projectileStartPos, 0f);
        } else {
            if(score > game.getPrefs().getFirstLevelScore()) {
                game.getPrefs().setFirstLevelScore(score);
            }
            endGame = true;
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
        super.dispose();
    }
}


