package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * The type Fifth level.
 */
public class FifthLevel extends BaseLevel {
    /**
     * The Thrown objects.
     */
    Array<ThrownObject> thrownObjects = new Array<ThrownObject>(7);
    /**
     * The Array index.
     */
    int arrayIndex;
    /**
     * The Top obstacle.
     */
    Obstacle topObstacle;
    /**
     * The Bot obstacle.
     */
    Obstacle botObstacle;

    /**
     * Instantiates a new Fifth level.
     *
     * @param g           the g
     * @param veganStatus the vegan status
     */
    public FifthLevel(MyGame g, boolean veganStatus) {
        super(g, "bg-shady-woods.png", "ground.png");

        super.stopMusic();
        if(game.getPrefs().getMusicStatus()) {
            game.getShadyWoodsTheme().play();
        }

        arrayIndex = 0;
        topObstacle = new Obstacle(game, this, 7.4f, 5.5f, 0.65f, 10);
        botObstacle = new Obstacle(game, this, 7.4f, 0, 0.65f, 3);
        catapult = new Catapult(1, 0.7f);
        pot = new Pot(this, game, 12, 0);
        veganMode = veganStatus;

        //for (int i = 0; i < 3; i++) {
        //    ThrownObject object = new Carrot(game, this);
        //    getProjectiles().add(object);
        //}
        if(!veganMode) {
            thrownObjects.add(new Chicken(game, this), new Chicken(game, this), new Chicken(game, this), new Lettuce(game, this));
            thrownObjects.add(new Lettuce(game, this), new BellPepper(game, this), new BellPepper(game, this));
        } else {
            thrownObjects.add(new Onion(game, this), new Onion(game, this), new Tomato(game, this), new Tomato(game, this));
            thrownObjects.add(new Tomato(game, this), new Potato(game, this), new Potato(game, this));
        }

        currentProjectile = thrownObjects.get(0);

        setNextProjectile();

        createBorderWall(-0.5f, 0);
        createBorderWall(46.5f, 0);
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

        if(!currentProjectile.isThrown() && Gdx.input.isTouched()){
            arrow.draw(batch, touchStart, new Vector2(Gdx.input.getX() / 100f, Gdx.input.getY() / 100f));
        }
        prevMenuButton.draw(batch);
        ground.draw();
        topObstacle.draw();
        botObstacle.draw();
        pot.drawTop();
        currentProjectile.draw();
        pot.draw();
        catapult.draw(batch);
        batch.end();
        moveCam();
        doPhysicsStep(delta);
        if(endGame) {
            game.setScreen(new EndLevelScreen(game, 5, score, veganMode));
        }
        super.render(delta);
        if(veganMode) {
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("highscore") + " " + game.getPrefs().getVeganFifthLevelScore(), 12f * 100f, 8.4f * 100f, font32);
        } else {
            game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("highscore") + " " + game.getPrefs().getFifthLevelScore(), 12f * 100f, 8.4f * 100f, font32);
        }
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("ingredients") + " " + (thrownObjects.size - arrayIndex), 12f * 100f, 0.7f * 100f, font32);
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
            if(score > game.getPrefs().getFifthLevelScore()) {
                game.getPrefs().setFifthLevelScore(score);
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
