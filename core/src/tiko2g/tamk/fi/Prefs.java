package tiko2g.tamk.fi;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.I18NBundle;

/**
 * The type Prefs.
 */
public class Prefs {
    private MyGame game;
    private Preferences pref ;
    private boolean displayGameModeVegan;

    private boolean soundStatus;
    private boolean musicStatus;

    private boolean levelOneOpen;
    private boolean levelTwoOpen;
    private boolean levelThreeOpen;
    private boolean levelFourOpen;
    private boolean levelFiveOpen;

    private boolean veganLevelOneOpen;
    private boolean veganLevelTwoOpen;
    private boolean veganLevelThreeOpen;
    private boolean veganLevelFourOpen;
    private boolean veganLevelFiveOpen;

    private boolean recipeOneOpen;
    private boolean recipeTwoOpen;
    private boolean recipeThreeOpen;
    private boolean recipeFourOpen;
    private boolean recipeFiveOpen;

    private boolean veganRecipeOneOpen;
    private boolean veganRecipeTwoOpen;
    private boolean veganRecipeThreeOpen;
    private boolean veganRecipeFourOpen;
    private boolean veganRecipeFiveOpen;

    private int normalRecipesOpen;
    private int veganRecipesOpen;

    private I18NBundle currentLanguage;
    private int storedLanguage;
    private int firstLevelScore;
    private int secondLevelScore;
    private int thirdLevelScore;
    private int fourthLevelScore;
    private int fifthLevelScore;
    private int veganFirstLevelScore;
    private int veganSecondLevelScore;
    private int veganThirdLevelScore;
    private int veganFourthLevelScore;
    private int veganFifthLevelScore;


    /**
     * Instantiates a new Prefs.
     *
     * @param g the g
     */
    public Prefs(MyGame g) {
        game = g;
        pref = Gdx.app.getPreferences("My Preferences");

        normalRecipesOpen = pref.getInteger("recipesOpen", 0);
        veganRecipesOpen = pref.getInteger("veganRecipesOpen", 0);

        levelOneOpen = pref.getBoolean("levelOneOpen", true);
        levelTwoOpen = pref.getBoolean("levelTwoOpen", false);
        levelThreeOpen = pref.getBoolean("levelThreeOpen", false);
        levelFourOpen = pref.getBoolean("levelFourOpen", false);
        levelFiveOpen = pref.getBoolean("levelFiveOpen", false);

        veganLevelOneOpen = pref.getBoolean("veganLevelOneOpen", true);
        veganLevelTwoOpen = pref.getBoolean("veganLevelTwoOpen", false);
        veganLevelThreeOpen = pref.getBoolean("veganLevelThreeOpen", false);
        veganLevelFourOpen = pref.getBoolean("veganLevelFourOpen", false);
        veganLevelFiveOpen = pref.getBoolean("veganLevelFiveOpen", false);

        veganRecipeOneOpen = pref.getBoolean("veganRecipeOneOpen", false);
        veganRecipeTwoOpen = pref.getBoolean("veganRecipeTwoOpen", false);
        veganRecipeThreeOpen = pref.getBoolean("veganRecipeThreeOpen", false);
        veganRecipeFourOpen = pref.getBoolean("veganRecipeFourOpen", false);
        veganRecipeFiveOpen = pref.getBoolean("veganRecipeFiveOpen", false);

        recipeOneOpen = pref.getBoolean("recipeOneOpen", false);
        recipeTwoOpen = pref.getBoolean("recipeTwoOpen", false);
        recipeThreeOpen = pref.getBoolean("recipeThreeOpen", false);
        recipeFourOpen = pref.getBoolean("recipeFourOpen", false);
        recipeFiveOpen = pref.getBoolean("recipeFiveOpen", false);

        displayGameModeVegan = pref.getBoolean("displayGameModeVegan", false);

        soundStatus = pref.getBoolean("soundStatus",true);
        musicStatus = pref.getBoolean("musicStatus", true);

        firstLevelScore = pref.getInteger("firstLevelScore", 0);
        secondLevelScore = pref.getInteger("secondLevelScore", 0);
        thirdLevelScore = pref.getInteger("thirdLevelScore", 0);
        fourthLevelScore = pref.getInteger("fourthLevelScore", 0);
        fifthLevelScore = pref.getInteger("fifthLevelScore", 0);

        veganFirstLevelScore = pref.getInteger("veganFirstLevelScore", 0);
        veganSecondLevelScore = pref.getInteger("veganSecondLevelScore", 0);
        veganThirdLevelScore = pref.getInteger("veganThirdLevelScore", 0);
        veganFourthLevelScore = pref.getInteger("veganFourthLevelScore", 0);
        veganFifthLevelScore = pref.getInteger("veganFifthLevelScore", 0);

        storedLanguage = pref.getInteger("storedLanguage", 0);
        if(storedLanguage == 0) {
            currentLanguage = game.getEnBundle();
        } else {
            currentLanguage = game.getFinBundle();
        }
    }

    /**
     * Toggle language.
     */
    public void toggleLanguage() {
        if(storedLanguage == 0) {
            storedLanguage = 1;
            currentLanguage = game.getFinBundle();
            pref.putInteger("storedLanguage", storedLanguage);
            pref.flush();
        } else {
            storedLanguage = 0;
            currentLanguage = game.getEnBundle();
            pref.putInteger("storedLanguage", storedLanguage);
            pref.flush();
        }
    }

    /**
     * Toggle sound.
     */
    public void toggleSound (){
        soundStatus = !soundStatus;
        pref.putBoolean("soundStatus",soundStatus);
        pref.flush();
    }

    /**
     * Toggle music.
     */
    public void toggleMusic(){
        musicStatus = !musicStatus;
        pref.putBoolean("musicStatus",musicStatus);
        pref.flush();
    }

    /**
     * Toggle display game mode.
     */
    public void toggleDisplayGameMode() {
        displayGameModeVegan = !displayGameModeVegan;
        pref.putBoolean("displayGameModeVegan", displayGameModeVegan);
        pref.flush();
    }

    /**
     * Sets first level score.
     *
     * @param score the score
     */
    public void setFirstLevelScore(int score) {
        firstLevelScore = score;
        pref.putInteger("firstLevelScore", firstLevelScore);
        pref.flush();
    }

    /**
     * Sets second level score.
     *
     * @param score the score
     */
    public void setSecondLevelScore(int score) {
        secondLevelScore = score;
        pref.putInteger("secondLevelScore", secondLevelScore);
        pref.flush();
    }

    /**
     * Sets third level score.
     *
     * @param score the score
     */
    public void setThirdLevelScore(int score) {
        thirdLevelScore = score;
        pref.putInteger("thirdLevelScore", thirdLevelScore);
        pref.flush();
    }

    /**
     * Sets fourth level score.
     *
     * @param score the score
     */
    public void setFourthLevelScore(int score) {
        fourthLevelScore = score;
        pref.putInteger("fourthLevelScore", fourthLevelScore);
        pref.flush();
    }

    /**
     * Sets fifth level score.
     *
     * @param score the score
     */
    public void setFifthLevelScore(int score) {
        fifthLevelScore = score;
        pref.putInteger("fifthLevelScore", fifthLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan first level score.
     *
     * @param score the score
     */
    public void setVeganFirstLevelScore(int score) {
        veganFirstLevelScore = score;
        pref.putInteger("veganFirstLevelScore", veganFirstLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan second level score.
     *
     * @param score the score
     */
    public void setVeganSecondLevelScore(int score) {
        veganSecondLevelScore = score;
        pref.putInteger("veganSecondLevelScore", veganSecondLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan third level score.
     *
     * @param score the score
     */
    public void setVeganThirdLevelScore(int score) {
        veganThirdLevelScore = score;
        pref.putInteger("veganThirdLevelScore", veganThirdLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan fourth level score.
     *
     * @param score the score
     */
    public void setVeganFourthLevelScore(int score) {
        veganFourthLevelScore = score;
        pref.putInteger("veganFourthLevelScore", veganFourthLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan fifth level score.
     *
     * @param score the score
     */
    public void setVeganFifthLevelScore(int score) {
        veganFifthLevelScore = score;
        pref.putInteger("veganFifthLevelScore", veganFifthLevelScore);
        pref.flush();
    }

    /**
     * Sets level one open.
     *
     * @param status the status
     */
    public void setLevelOneOpen(boolean status) {
        levelOneOpen = status;
        pref.putBoolean("levelOneOpen", levelOneOpen);
        pref.flush();
    }

    /**
     * Sets level two open.
     *
     * @param status the status
     */
    public void setLevelTwoOpen(boolean status) {
        levelTwoOpen = status;
        pref.putBoolean("levelTwoOpen", levelTwoOpen);
        pref.flush();
    }

    /**
     * Sets level three open.
     *
     * @param status the status
     */
    public void setLevelThreeOpen(boolean status) {
        levelThreeOpen = status;
        pref.putBoolean("levelThreeOpen", levelThreeOpen);
        pref.flush();
    }

    /**
     * Sets level four open.
     *
     * @param status the status
     */
    public void setLevelFourOpen(boolean status) {
        levelFourOpen = status;
        pref.putBoolean("levelFourOpen", levelFourOpen);
        pref.flush();
    }

    /**
     * Sets level five open.
     *
     * @param status the status
     */
    public void setLevelFiveOpen(boolean status) {
        levelFiveOpen = status;
        pref.putBoolean("levelFiveOpen", levelFiveOpen);
        pref.flush();
    }

    /**
     * Sets vegan level one open.
     *
     * @param status the status
     */
    public void setVeganLevelOneOpen(boolean status) {
        veganLevelOneOpen = status;
        pref.putBoolean("veganLevelOneOpen", veganLevelOneOpen);
        pref.flush();
    }

    /**
     * Sets vegan level two open.
     *
     * @param status the status
     */
    public void setVeganLevelTwoOpen(boolean status) {
        veganLevelTwoOpen = status;
        pref.putBoolean("veganLevelTwoOpen", veganLevelTwoOpen);
        pref.flush();
    }

    /**
     * Sets vegan level three open.
     *
     * @param status the status
     */
    public void setVeganLevelThreeOpen(boolean status) {
        veganLevelThreeOpen = status;
        pref.putBoolean("veganLevelThreeOpen", veganLevelThreeOpen);
        pref.flush();
    }

    /**
     * Sets vegan level four open.
     *
     * @param status the status
     */
    public void setVeganLevelFourOpen(boolean status) {
        veganLevelFourOpen = status;
        pref.putBoolean("veganLevelFourOpen", veganLevelFourOpen);
        pref.flush();
    }

    /**
     * Sets vegan level five open.
     *
     * @param status the status
     */
    public void setVeganLevelFiveOpen(boolean status) {
        veganLevelFiveOpen = status;
        pref.putBoolean("veganLevelFiveOpen", veganLevelFiveOpen);
        pref.flush();
    }

    /**
     * Sets recipe one open.
     *
     * @param status the status
     */
    public void setRecipeOneOpen(boolean status) {
        recipeOneOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeOneOpen", recipeOneOpen);
        pref.flush();
    }

    /**
     * Sets recipe two open.
     *
     * @param status the status
     */
    public void setRecipeTwoOpen(boolean status) {
        recipeTwoOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeTwoOpen", recipeTwoOpen);
        pref.flush();
    }

    /**
     * Sets recipe three open.
     *
     * @param status the status
     */
    public void setRecipeThreeOpen(boolean status) {
        recipeThreeOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeThreeOpen", recipeThreeOpen);
        pref.flush();
    }

    /**
     * Sets recipe four open.
     *
     * @param status the status
     */
    public void setRecipeFourOpen(boolean status) {
        recipeFourOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeFourOpen", recipeFourOpen);
        pref.flush();
    }

    /**
     * Sets recipe five open.
     *
     * @param status the status
     */
    public void setRecipeFiveOpen(boolean status) {
        recipeFiveOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeFiveOpen", recipeFiveOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe one open.
     *
     * @param status the status
     */
    public void setVeganRecipeOneOpen(boolean status) {
        veganRecipeOneOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeOneOpen", veganRecipeOneOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe two open.
     *
     * @param status the status
     */
    public void setVeganRecipeTwoOpen(boolean status) {
        veganRecipeTwoOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeTwoOpen", veganRecipeTwoOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe three open.
     *
     * @param status the status
     */
    public void setVeganRecipeThreeOpen(boolean status) {
        veganRecipeThreeOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeThreeOpen", veganRecipeThreeOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe four open.
     *
     * @param status the status
     */
    public void setVeganRecipeFourOpen(boolean status) {
        veganRecipeFourOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeFourOpen", veganRecipeFourOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe five open.
     *
     * @param status the status
     */
    public void setVeganRecipeFiveOpen(boolean status) {
        veganRecipeFiveOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeFiveOpen", veganRecipeFiveOpen);
        pref.flush();
    }


    /**
     * Get sound status boolean.
     *
     * @return the boolean
     */
    public boolean getSoundStatus(){
        return soundStatus;
    }

    /**
     * Gets music status.
     *
     * @return the music status
     */
    public boolean getMusicStatus() {
        return musicStatus;
    }

    /**
     * Gets first level score.
     *
     * @return the first level score
     */
    public int getFirstLevelScore() {
        return firstLevelScore;
    }

    /**
     * Gets second level score.
     *
     * @return the second level score
     */
    public int getSecondLevelScore() {
        return secondLevelScore;
    }

    /**
     * Gets third level score.
     *
     * @return the third level score
     */
    public int getThirdLevelScore() {
        return thirdLevelScore;
    }

    /**
     * Gets fourth level score.
     *
     * @return the fourth level score
     */
    public int getFourthLevelScore() {
        return fourthLevelScore;
    }

    /**
     * Gets fifth level score.
     *
     * @return the fifth level score
     */
    public int getFifthLevelScore() {
        return fifthLevelScore;
    }

    /**
     * Gets vegan first level score.
     *
     * @return the vegan first level score
     */
    public int getVeganFirstLevelScore() {
        return veganFirstLevelScore;
    }

    /**
     * Gets vegan second level score.
     *
     * @return the vegan second level score
     */
    public int getVeganSecondLevelScore() {
        return veganSecondLevelScore;
    }

    /**
     * Gets vegan third level score.
     *
     * @return the vegan third level score
     */
    public int getVeganThirdLevelScore() {
        return veganThirdLevelScore;
    }

    /**
     * Gets vegan fourth level score.
     *
     * @return the vegan fourth level score
     */
    public int getVeganFourthLevelScore() {
        return veganFourthLevelScore;
    }

    /**
     * Gets vegan fifth level score.
     *
     * @return the vegan fifth level score
     */
    public int getVeganFifthLevelScore() {
        return veganFifthLevelScore;
    }

    /**
     * Gets level one open.
     *
     * @return the level one open
     */
    public boolean getLevelOneOpen() {
        return levelOneOpen;
    }

    /**
     * Gets level two open.
     *
     * @return the level two open
     */
    public boolean getLevelTwoOpen() {
        return levelTwoOpen;
    }

    /**
     * Gets level three open.
     *
     * @return the level three open
     */
    public boolean getLevelThreeOpen() {
        return levelThreeOpen;
    }

    /**
     * Gets level four open.
     *
     * @return the level four open
     */
    public boolean getLevelFourOpen() {
        return levelFourOpen;
    }

    /**
     * Gets level five open.
     *
     * @return the level five open
     */
    public boolean getLevelFiveOpen() {
        return levelFiveOpen;
    }

    /**
     * Gets vegan level one open.
     *
     * @return the vegan level one open
     */
    public boolean getVeganLevelOneOpen() {
        return veganLevelOneOpen;
    }

    /**
     * Gets vegan level two open.
     *
     * @return the vegan level two open
     */
    public boolean getVeganLevelTwoOpen() {
        return veganLevelTwoOpen;
    }

    /**
     * Gets vegan level three open.
     *
     * @return the vegan level three open
     */
    public boolean getVeganLevelThreeOpen() {
        return veganLevelThreeOpen;
    }

    /**
     * Gets vegan level four open.
     *
     * @return the vegan level four open
     */
    public boolean getVeganLevelFourOpen() {
        return veganLevelFourOpen;
    }

    /**
     * Gets vegan level five open.
     *
     * @return the vegan level five open
     */
    public boolean getVeganLevelFiveOpen() {
        return veganLevelFiveOpen;
    }

    /**
     * Gets recipes open.
     *
     * @return the recipes open
     */
    public int getRecipesOpen() {
        return normalRecipesOpen;
    }

    /**
     * Gets vegan recipes open.
     *
     * @return the vegan recipes open
     */
    public int getVeganRecipesOpen() {
        return veganRecipesOpen;
    }

    /**
     * Gets recipe one open.
     *
     * @return the recipe one open
     */
    public boolean getRecipeOneOpen() {
        return recipeOneOpen;
    }

    /**
     * Gets recipe two open.
     *
     * @return the recipe two open
     */
    public boolean getRecipeTwoOpen() {
        return recipeTwoOpen;
    }

    /**
     * Gets recipe three open.
     *
     * @return the recipe three open
     */
    public boolean getRecipeThreeOpen() {
        return recipeThreeOpen;
    }

    /**
     * Gets recipe four open.
     *
     * @return the recipe four open
     */
    public boolean getRecipeFourOpen() {
        return recipeFourOpen;
    }

    /**
     * Gets recipe five open.
     *
     * @return the recipe five open
     */
    public boolean getRecipeFiveOpen() {
        return recipeFiveOpen;
    }

    /**
     * Gets vegan recipe one open.
     *
     * @return the vegan recipe one open
     */
    public boolean getVeganRecipeOneOpen() {
        return veganRecipeOneOpen;
    }

    /**
     * Gets vegan recipe two open.
     *
     * @return the vegan recipe two open
     */
    public boolean getVeganRecipeTwoOpen() {
        return veganRecipeTwoOpen;
    }

    /**
     * Gets vegan recipe three open.
     *
     * @return the vegan recipe three open
     */
    public boolean getVeganRecipeThreeOpen() {
        return veganRecipeThreeOpen;
    }

    /**
     * Gets vegan recipe four open.
     *
     * @return the vegan recipe four open
     */
    public boolean getVeganRecipeFourOpen() {
        return veganRecipeFourOpen;
    }

    /**
     * Gets vegan recipe five open.
     *
     * @return the vegan recipe five open
     */
    public boolean getVeganRecipeFiveOpen() {
        return veganRecipeFiveOpen;
    }

    /**
     * Gets display game mode vegan.
     *
     * @return the display game mode vegan
     */
    public boolean getDisplayGameModeVegan() {
        return displayGameModeVegan;
    }

    /**
     * Gets current language.
     *
     * @return the current language
     */
    public I18NBundle getCurrentLanguage() {
        return currentLanguage;
    }
}
