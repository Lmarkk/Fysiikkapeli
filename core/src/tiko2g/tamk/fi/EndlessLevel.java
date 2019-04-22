package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * The type Endless level.
 */
public class EndlessLevel extends BaseLevel {
    /**
     * The Thrown objects.
     */
    Array<ThrownObject> thrownObjects = new Array<ThrownObject>(9);

    /**
     * Instantiates a new Endless level.
     *
     * @param g the g
     */
    public EndlessLevel(MyGame g) {
        super(g, "bg-green-hills2.png", "ground.png");

        super.stopMusic();

        int random = MathUtils.random(1,3);
        if(random == 1) {
            background = new Texture("bg-wheat-fields.png");
            if(game.getPrefs().getMusicStatus()) {
                game.getWheatFieldsTheme().play();
            }
        } else if(random == 2) {
            background = new Texture("bg-shady-woods.png");
            if(game.getPrefs().getMusicStatus()) {
                game.getShadyWoodsTheme().play();
            }
        } else {
            if(game.getPrefs().getMusicStatus()) {
                game.getGreenHillsTheme().play();
            }
        }

        catapult = new Catapult(1, 0.7f);
        pot = new Pot(this, game, 14, 0);

        thrownObjects.add(new Potato(game, this), new Chicken(game, this), new Meat(game, this), new Tomato(game, this));
        thrownObjects.add(new Onion(game, this), new Carrot(game, this), new BellPepper(game, this), new Lettuce(game, this));
        thrownObjects.add(new Peach(game, this));
        currentProjectile = thrownObjects.get(MathUtils.random(0, thrownObjects.size -1)).cloneObject();

        setNextProjectile();

        createBorderWall(-0.5f, 0);
        createBorderWall(48f, 0);


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

        if(!currentProjectile.isThrown() && Gdx.input.isTouched()){
            arrow.draw(batch, touchStart, new Vector2(Gdx.input.getX() / 100f, Gdx.input.getY() / 100f));
        }
        prevMenuButton.draw(batch);
        ground.draw();
        pot.drawTop();
        currentProjectile.draw();
        pot.draw();
        catapult.draw(batch);
        batch.end();
        moveCam();
        doPhysicsStep(delta);
        if(endGame) {
            game.setScreen(new EndLevelScreen(game, 1, score, false));
        }
        game.getTextRenderer().renderTextCenter(game.getPrefs().getCurrentLanguage().get("score") + " " +  score, 8f * 100f, 8.4f * 100f, font35);
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
