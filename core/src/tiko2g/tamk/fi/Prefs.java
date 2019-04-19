package tiko2g.tamk.fi;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.I18NBundle;

/**
 * Class used to store and manage all information that persists between play sessions.
 *
 * @author Lassi Markkinen
 * @version 2019.0419
 */
public class Prefs {
    /**
     * MyGame, received as a parameter in constructor and used to retrieve language bundles.
     */
    private MyGame game;
    /**
     * Preferences file used to store persistent data.
     */
    private Preferences pref ;
    /**
     * Boolean for managing diet-based menu output.
     */
    private boolean displayGameModeVegan;
    /**
     * Whether sounds are enabled in the game.
     */
    private boolean soundStatus;
    /**
     * Whether music is enabled in the game.
     */
    private boolean musicStatus;

    /**
     * Level 1's unlock status.
     */
    private boolean levelOneOpen;
    /**
     * Level 2's unlock status.
     */
    private boolean levelTwoOpen;
    /**
     * Level 3's unlock status.
     */
    private boolean levelThreeOpen;
    /**
     * Level 4's unlock status.
     */
    private boolean levelFourOpen;
    /**
     * Level 5's unlock status.
     */
    private boolean levelFiveOpen;

    /**
     * Vegan Level 1's unlock status.
     */
    private boolean veganLevelOneOpen;
    /**
     * Vegan Level 2's unlock status.
     */
    private boolean veganLevelTwoOpen;
    /**
     * Vegan Level 3's unlock status.
     */
    private boolean veganLevelThreeOpen;
    /**
     * Vegan Level 4's unlock status.
     */
    private boolean veganLevelFourOpen;
    /**
     * Vegan Level 5's unlock status.
     */
    private boolean veganLevelFiveOpen;

    /**
     * Recipe 1's unlock status.
     */
    private boolean recipeOneOpen;
    /**
     * Recipe 2's unlock status.
     */
    private boolean recipeTwoOpen;
    /**
     * Recipe 3's unlock status.
     */
    private boolean recipeThreeOpen;
    /**
     * Recipe 4's unlock status.
     */
    private boolean recipeFourOpen;
    /**
     * Recipe 5's unlock status.
     */
    private boolean recipeFiveOpen;

    /**
     * Vegan recipe 1's unlock status.
     */
    private boolean veganRecipeOneOpen;
    /**
     * Vegan recipe 2's unlock status.
     */
    private boolean veganRecipeTwoOpen;
    /**
     * Vegan recipe 3's unlock status.
     */
    private boolean veganRecipeThreeOpen;
    /**
     * Vegan recipe 4's unlock status.
     */
    private boolean veganRecipeFourOpen;
    /**
     * Vegan recipe 5's unlock status.
     */
    private boolean veganRecipeFiveOpen;

    /**
     * Variable for tracking how many regular recipes are currently unlocked by the player.
     */
    private int normalRecipesOpen;
    /**
     * Variable for tracking how many vegan recipes are currently unlocked by the player.
     */
    private int veganRecipesOpen;

    /**
     * Variable that holds the language bundle that is currently used in the game.
     */
    private I18NBundle currentLanguage;
    /**
     * Variable used for toggling between the used languages.
     */
    private int storedLanguage;
    /**
     * Variable that holds the highest achieved score for the first level.
     */
    private int firstLevelScore;
    /**
     * Variable that holds the highest achieved score for the second level.
     */
    private int secondLevelScore;
    /**
     * Variable that holds the highest achieved score for the third level.
     */
    private int thirdLevelScore;
    /**
     * Variable that holds the highest achieved score for the fourth level.
     */
    private int fourthLevelScore;
    /**
     * Variable that holds the highest achieved score for the fifth level.
     */
    private int fifthLevelScore;
    /**
     * Variable that holds the highest achieved score for the first vegan level.
     */
    private int veganFirstLevelScore;
    /**
     * Variable that holds the highest achieved score for the second vegan level.
     */
    private int veganSecondLevelScore;
    /**
     * Variable that holds the highest achieved score for the third vegan level.
     */
    private int veganThirdLevelScore;
    /**
     * Variable that holds the highest achieved score for the fourth vegan level.
     */
    private int veganFourthLevelScore;
    /**
     * Variable that holds the highest achieved score for the fifth vegan level.
     */
    private int veganFifthLevelScore;


    /**
     * Instantiates a new Prefs. Sets the status for recipes and levels 2-5 to be initially locked.
     *
     * @param g the MyGame used for retrieving language bundles.
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
     * Toggles the currently used language bundle.
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
     * Toggles whether sound is enabled in game.
     */
    public void toggleSound (){
        soundStatus = !soundStatus;
        pref.putBoolean("soundStatus",soundStatus);
        pref.flush();
    }

    /**
     * Toggles whether music is enabled in game.
     */
    public void toggleMusic(){
        musicStatus = !musicStatus;
        pref.putBoolean("musicStatus",musicStatus);
        pref.flush();
    }

    /**
     * Toggle between displaying regular and vegan levels in level selection and recipes in
     * recipe menu.
     */
    public void toggleDisplayGameMode() {
        displayGameModeVegan = !displayGameModeVegan;
        pref.putBoolean("displayGameModeVegan", displayGameModeVegan);
        pref.flush();
    }

    /**
     * Sets first level highscore.
     *
     * @param score the score.
     */
    public void setFirstLevelScore(int score) {
        firstLevelScore = score;
        pref.putInteger("firstLevelScore", firstLevelScore);
        pref.flush();
    }

    /**
     * Sets second level highscore.
     *
     * @param score the score.
     */
    public void setSecondLevelScore(int score) {
        secondLevelScore = score;
        pref.putInteger("secondLevelScore", secondLevelScore);
        pref.flush();
    }

    /**
     * Sets third level highscore.
     *
     * @param score the score.
     */
    public void setThirdLevelScore(int score) {
        thirdLevelScore = score;
        pref.putInteger("thirdLevelScore", thirdLevelScore);
        pref.flush();
    }

    /**
     * Sets fourth level highscore.
     *
     * @param score the score.
     */
    public void setFourthLevelScore(int score) {
        fourthLevelScore = score;
        pref.putInteger("fourthLevelScore", fourthLevelScore);
        pref.flush();
    }

    /**
     * Sets fifth level highscore.
     *
     * @param score the score.
     */
    public void setFifthLevelScore(int score) {
        fifthLevelScore = score;
        pref.putInteger("fifthLevelScore", fifthLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan first level highscore.
     *
     * @param score the score.
     */
    public void setVeganFirstLevelScore(int score) {
        veganFirstLevelScore = score;
        pref.putInteger("veganFirstLevelScore", veganFirstLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan second level highscore.
     *
     * @param score the score.
     */
    public void setVeganSecondLevelScore(int score) {
        veganSecondLevelScore = score;
        pref.putInteger("veganSecondLevelScore", veganSecondLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan third level highscore.
     *
     * @param score the score.
     */
    public void setVeganThirdLevelScore(int score) {
        veganThirdLevelScore = score;
        pref.putInteger("veganThirdLevelScore", veganThirdLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan fourth level highscore.
     *
     * @param score the score.
     */
    public void setVeganFourthLevelScore(int score) {
        veganFourthLevelScore = score;
        pref.putInteger("veganFourthLevelScore", veganFourthLevelScore);
        pref.flush();
    }

    /**
     * Sets vegan fifth level highscore.
     *
     * @param score the score.
     */
    public void setVeganFifthLevelScore(int score) {
        veganFifthLevelScore = score;
        pref.putInteger("veganFifthLevelScore", veganFifthLevelScore);
        pref.flush();
    }

    /**
     * Sets level one open status.
     *
     * @param status the status to set.
     */
    public void setLevelOneOpen(boolean status) {
        levelOneOpen = status;
        pref.putBoolean("levelOneOpen", levelOneOpen);
        pref.flush();
    }

    /**
     * Sets level two open status.
     *
     * @param status the status to set.
     */
    public void setLevelTwoOpen(boolean status) {
        levelTwoOpen = status;
        pref.putBoolean("levelTwoOpen", levelTwoOpen);
        pref.flush();
    }

    /**
     * Sets level three open status.
     *
     * @param status the status to set.
     */
    public void setLevelThreeOpen(boolean status) {
        levelThreeOpen = status;
        pref.putBoolean("levelThreeOpen", levelThreeOpen);
        pref.flush();
    }

    /**
     * Sets level four open status.
     *
     * @param status the status to set.
     */
    public void setLevelFourOpen(boolean status) {
        levelFourOpen = status;
        pref.putBoolean("levelFourOpen", levelFourOpen);
        pref.flush();
    }

    /**
     * Sets level five open status.
     *
     * @param status the status to set.
     */
    public void setLevelFiveOpen(boolean status) {
        levelFiveOpen = status;
        pref.putBoolean("levelFiveOpen", levelFiveOpen);
        pref.flush();
    }

    /**
     * Sets vegan level one open status.
     *
     * @param status the status to set.
     */
    public void setVeganLevelOneOpen(boolean status) {
        veganLevelOneOpen = status;
        pref.putBoolean("veganLevelOneOpen", veganLevelOneOpen);
        pref.flush();
    }

    /**
     * Sets vegan level two open status.
     *
     * @param status the status to set.
     */
    public void setVeganLevelTwoOpen(boolean status) {
        veganLevelTwoOpen = status;
        pref.putBoolean("veganLevelTwoOpen", veganLevelTwoOpen);
        pref.flush();
    }

    /**
     * Sets vegan level three open status.
     *
     * @param status the status to set.
     */
    public void setVeganLevelThreeOpen(boolean status) {
        veganLevelThreeOpen = status;
        pref.putBoolean("veganLevelThreeOpen", veganLevelThreeOpen);
        pref.flush();
    }

    /**
     * Sets vegan level four open status.
     *
     * @param status the status to set.
     */
    public void setVeganLevelFourOpen(boolean status) {
        veganLevelFourOpen = status;
        pref.putBoolean("veganLevelFourOpen", veganLevelFourOpen);
        pref.flush();
    }

    /**
     * Sets vegan level five open status.
     *
     * @param status the status to set.
     */
    public void setVeganLevelFiveOpen(boolean status) {
        veganLevelFiveOpen = status;
        pref.putBoolean("veganLevelFiveOpen", veganLevelFiveOpen);
        pref.flush();
    }

    /**
     * Sets recipe one open status.
     *
     * @param status the status to set.
     */
    public void setRecipeOneOpen(boolean status) {
        recipeOneOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeOneOpen", recipeOneOpen);
        pref.flush();
    }

    /**
     * Sets recipe two open status.
     *
     * @param status the status to set.
     */
    public void setRecipeTwoOpen(boolean status) {
        recipeTwoOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeTwoOpen", recipeTwoOpen);
        pref.flush();
    }

    /**
     * Sets recipe three open status.
     *
     * @param status the status to set.
     */
    public void setRecipeThreeOpen(boolean status) {
        recipeThreeOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeThreeOpen", recipeThreeOpen);
        pref.flush();
    }

    /**
     * Sets recipe four open status.
     *
     * @param status the status to set.
     */
    public void setRecipeFourOpen(boolean status) {
        recipeFourOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeFourOpen", recipeFourOpen);
        pref.flush();
    }

    /**
     * Sets recipe five open status.
     *
     * @param status the status to set.
     */
    public void setRecipeFiveOpen(boolean status) {
        recipeFiveOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeFiveOpen", recipeFiveOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe one open status.
     *
     * @param status the status to set.
     */
    public void setVeganRecipeOneOpen(boolean status) {
        veganRecipeOneOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeOneOpen", veganRecipeOneOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe two open status.
     *
     * @param status the status to set.
     */
    public void setVeganRecipeTwoOpen(boolean status) {
        veganRecipeTwoOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeTwoOpen", veganRecipeTwoOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe three open status.
     *
     * @param status the status to set.
     */
    public void setVeganRecipeThreeOpen(boolean status) {
        veganRecipeThreeOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeThreeOpen", veganRecipeThreeOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe four open status.
     *
     * @param status the status to set.
     */
    public void setVeganRecipeFourOpen(boolean status) {
        veganRecipeFourOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeFourOpen", veganRecipeFourOpen);
        pref.flush();
    }

    /**
     * Sets vegan recipe five open status.
     *
     * @param status the status to set.
     */
    public void setVeganRecipeFiveOpen(boolean status) {
        veganRecipeFiveOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeFiveOpen", veganRecipeFiveOpen);
        pref.flush();
    }


    /**
     * Getter for sound status boolean.
     *
     * @return the boolean value.
     */
    public boolean getSoundStatus(){
        return soundStatus;
    }

    /**
     * Getter for music status boolean.
     *
     * @return the boolean value.
     */
    public boolean getMusicStatus() {
        return musicStatus;
    }

    /**
     * Gets first level highscore.
     *
     * @return the first level highscore.
     */
    public int getFirstLevelScore() {
        return firstLevelScore;
    }

    /**
     * Gets second level highscore.
     *
     * @return the second level highscore.
     */
    public int getSecondLevelScore() {
        return secondLevelScore;
    }

    /**
     * Gets third level highscore.
     *
     * @return the third level highscore.
     */
    public int getThirdLevelScore() {
        return thirdLevelScore;
    }

    /**
     * Gets fourth level highscore.
     *
     * @return the fourth level highscore.
     */
    public int getFourthLevelScore() {
        return fourthLevelScore;
    }

    /**
     * Gets fifth level highscore.
     *
     * @return the fifth level highscore.
     */
    public int getFifthLevelScore() {
        return fifthLevelScore;
    }

    /**
     * Gets vegan first level highscore.
     *
     * @return the vegan first level highscore.
     */
    public int getVeganFirstLevelScore() {
        return veganFirstLevelScore;
    }

    /**
     * Gets vegan second level highscore.
     *
     * @return the vegan second level highscore.
     */
    public int getVeganSecondLevelScore() {
        return veganSecondLevelScore;
    }

    /**
     * Gets vegan third level highscore.
     *
     * @return the vegan third level highscore.
     */
    public int getVeganThirdLevelScore() {
        return veganThirdLevelScore;
    }

    /**
     * Gets vegan fourth level highscore.
     *
     * @return the vegan fourth level highscore.
     */
    public int getVeganFourthLevelScore() {
        return veganFourthLevelScore;
    }

    /**
     * Gets vegan fifth level highscore.
     *
     * @return the vegan fifth level highscore.
     */
    public int getVeganFifthLevelScore() {
        return veganFifthLevelScore;
    }

    /**
     * Gets level one open status.
     *
     * @return the level one open status.
     */
    public boolean getLevelOneOpen() {
        return levelOneOpen;
    }

    /**
     * Gets level two open status.
     *
     * @return the level two open status.
     */
    public boolean getLevelTwoOpen() {
        return levelTwoOpen;
    }

    /**
     * Gets level three open status.
     *
     * @return the level three open status.
     */
    public boolean getLevelThreeOpen() {
        return levelThreeOpen;
    }

    /**
     * Gets level four open status.
     *
     * @return the level four open status.
     */
    public boolean getLevelFourOpen() {
        return levelFourOpen;
    }

    /**
     * Gets level five open status.
     *
     * @return the level five open status.
     */
    public boolean getLevelFiveOpen() {
        return levelFiveOpen;
    }

    /**
     * Gets vegan level one open status.
     *
     * @return the vegan level one open status.
     */
    public boolean getVeganLevelOneOpen() {
        return veganLevelOneOpen;
    }

    /**
     * Gets vegan level two open status.
     *
     * @return the vegan level two open status.
     */
    public boolean getVeganLevelTwoOpen() {
        return veganLevelTwoOpen;
    }

    /**
     * Gets vegan level three open status.
     *
     * @return the vegan level three open status.
     */
    public boolean getVeganLevelThreeOpen() {
        return veganLevelThreeOpen;
    }

    /**
     * Gets vegan level four open status.
     *
     * @return the vegan level four open status.
     */
    public boolean getVeganLevelFourOpen() {
        return veganLevelFourOpen;
    }

    /**
     * Gets vegan level five open status.
     *
     * @return the vegan level five open status.
     */
    public boolean getVeganLevelFiveOpen() {
        return veganLevelFiveOpen;
    }

    /**
     * Gets amount of regular recipes open.
     *
     * @return the amount of regular recipes open
     */
    public int getRecipesOpen() {
        return normalRecipesOpen;
    }

    /**
     * Gets amount of vegan recipes open.
     *
     * @return the amount of vegan recipes open
     */
    public int getVeganRecipesOpen() {
        return veganRecipesOpen;
    }

    /**
     * Gets recipe one open status.
     *
     * @return the recipe one open status.
     */
    public boolean getRecipeOneOpen() {
        return recipeOneOpen;
    }

    /**
     * Gets recipe two open status.
     *
     * @return the recipe two open status.
     */
    public boolean getRecipeTwoOpen() {
        return recipeTwoOpen;
    }

    /**
     * Gets recipe three open status.
     *
     * @return the recipe three open status.
     */
    public boolean getRecipeThreeOpen() {
        return recipeThreeOpen;
    }

    /**
     * Gets recipe four open status.
     *
     * @return the recipe four open status.
     */
    public boolean getRecipeFourOpen() {
        return recipeFourOpen;
    }

    /**
     * Gets recipe five open status.
     *
     * @return the recipe five open status.
     */
    public boolean getRecipeFiveOpen() {
        return recipeFiveOpen;
    }

    /**
     * Gets vegan recipe one open status.
     *
     * @return the vegan recipe one open status.
     */
    public boolean getVeganRecipeOneOpen() {
        return veganRecipeOneOpen;
    }

    /**
     * Gets vegan recipe two open status.
     *
     * @return the vegan recipe two open status.
     */
    public boolean getVeganRecipeTwoOpen() {
        return veganRecipeTwoOpen;
    }

    /**
     * Gets vegan recipe three open status.
     *
     * @return the vegan recipe three open status.
     */
    public boolean getVeganRecipeThreeOpen() {
        return veganRecipeThreeOpen;
    }

    /**
     * Gets vegan recipe four open status.
     *
     * @return the vegan recipe four open status.
     */
    public boolean getVeganRecipeFourOpen() {
        return veganRecipeFourOpen;
    }

    /**
     * Gets vegan recipe five open status.
     *
     * @return the vegan recipe five open status.
     */
    public boolean getVeganRecipeFiveOpen() {
        return veganRecipeFiveOpen;
    }

    /**
     * Gets whether the displayed game mode is vegan.
     *
     * @return true if the displayed game mode is vegan.
     */
    public boolean getDisplayGameModeVegan() {
        return displayGameModeVegan;
    }

    /**
     * Gets current language.
     *
     * @return the current language bundle in use.
     */
    public I18NBundle getCurrentLanguage() {
        return currentLanguage;
    }
}
