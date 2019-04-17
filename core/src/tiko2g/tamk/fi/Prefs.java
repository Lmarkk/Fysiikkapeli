package tiko2g.tamk.fi;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.I18NBundle;

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

    public void toggleSound (){
        soundStatus = !soundStatus;
        pref.putBoolean("soundStatus",soundStatus);
        pref.flush();
    }

    public void toggleMusic(){
        musicStatus = !musicStatus;
        pref.putBoolean("musicStatus",musicStatus);
        pref.flush();
    }
    public void toggleDisplayGameMode() {
        displayGameModeVegan = !displayGameModeVegan;
        pref.putBoolean("displayGameModeVegan", displayGameModeVegan);
        pref.flush();
    }

    public void setFirstLevelScore(int score) {
        firstLevelScore = score;
        pref.putInteger("firstLevelScore", firstLevelScore);
        pref.flush();
    }
    public void setSecondLevelScore(int score) {
        secondLevelScore = score;
        pref.putInteger("secondLevelScore", secondLevelScore);
        pref.flush();
    }
    public void setThirdLevelScore(int score) {
        thirdLevelScore = score;
        pref.putInteger("thirdLevelScore", thirdLevelScore);
        pref.flush();
    }
    public void setFourthLevelScore(int score) {
        fourthLevelScore = score;
        pref.putInteger("fourthLevelScore", fourthLevelScore);
        pref.flush();
    }
    public void setFifthLevelScore(int score) {
        fifthLevelScore = score;
        pref.putInteger("fifthLevelScore", fifthLevelScore);
        pref.flush();
    }
    public void setVeganFirstLevelScore(int score) {
        veganFirstLevelScore = score;
        pref.putInteger("veganFirstLevelScore", veganFirstLevelScore);
        pref.flush();
    }
    public void setVeganSecondLevelScore(int score) {
        veganSecondLevelScore = score;
        pref.putInteger("veganSecondLevelScore", veganSecondLevelScore);
        pref.flush();
    }
    public void setVeganThirdLevelScore(int score) {
        veganThirdLevelScore = score;
        pref.putInteger("veganThirdLevelScore", veganThirdLevelScore);
        pref.flush();
    }
    public void setVeganFourthLevelScore(int score) {
        veganFourthLevelScore = score;
        pref.putInteger("veganFourthLevelScore", veganFourthLevelScore);
        pref.flush();
    }
    public void setVeganFifthLevelScore(int score) {
        veganFifthLevelScore = score;
        pref.putInteger("veganFifthLevelScore", veganFifthLevelScore);
        pref.flush();
    }

    public void setLevelOneOpen(boolean status) {
        levelOneOpen = status;
        pref.putBoolean("levelOneOpen", levelOneOpen);
        pref.flush();
    }
    public void setLevelTwoOpen(boolean status) {
        levelTwoOpen = status;
        pref.putBoolean("levelTwoOpen", levelTwoOpen);
        pref.flush();
    }
    public void setLevelThreeOpen(boolean status) {
        levelThreeOpen = status;
        pref.putBoolean("levelThreeOpen", levelThreeOpen);
        pref.flush();
    }
    public void setLevelFourOpen(boolean status) {
        levelFourOpen = status;
        pref.putBoolean("levelFourOpen", levelFourOpen);
        pref.flush();
    }
    public void setLevelFiveOpen(boolean status) {
        levelFiveOpen = status;
        pref.putBoolean("levelFiveOpen", levelFiveOpen);
        pref.flush();
    }

    public void setVeganLevelOneOpen(boolean status) {
        veganLevelOneOpen = status;
        pref.putBoolean("veganLevelOneOpen", veganLevelOneOpen);
        pref.flush();
    }
    public void setVeganLevelTwoOpen(boolean status) {
        veganLevelTwoOpen = status;
        pref.putBoolean("veganLevelTwoOpen", veganLevelTwoOpen);
        pref.flush();
    }
    public void setVeganLevelThreeOpen(boolean status) {
        veganLevelThreeOpen = status;
        pref.putBoolean("veganLevelThreeOpen", veganLevelThreeOpen);
        pref.flush();
    }
    public void setVeganLevelFourOpen(boolean status) {
        veganLevelFourOpen = status;
        pref.putBoolean("veganLevelFourOpen", veganLevelFourOpen);
        pref.flush();
    }
    public void setVeganLevelFiveOpen(boolean status) {
        veganLevelFiveOpen = status;
        pref.putBoolean("veganLevelFiveOpen", veganLevelFiveOpen);
        pref.flush();
    }

    public void setRecipeOneOpen(boolean status) {
        recipeOneOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeOneOpen", recipeOneOpen);
        pref.flush();
    }
    public void setRecipeTwoOpen(boolean status) {
        recipeTwoOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeTwoOpen", recipeTwoOpen);
        pref.flush();
    }
    public void setRecipeThreeOpen(boolean status) {
        recipeThreeOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeThreeOpen", recipeThreeOpen);
        pref.flush();
    }
    public void setRecipeFourOpen(boolean status) {
        recipeFourOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeFourOpen", recipeFourOpen);
        pref.flush();
    }
    public void setRecipeFiveOpen(boolean status) {
        recipeFiveOpen = status;
        normalRecipesOpen++;
        pref.putInteger("recipesOpen", normalRecipesOpen);
        pref.putBoolean("recipeFiveOpen", recipeFiveOpen);
        pref.flush();
    }

    public void setVeganRecipeOneOpen(boolean status) {
        veganRecipeOneOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeOneOpen", veganRecipeOneOpen);
        pref.flush();
    }
    public void setVeganRecipeTwoOpen(boolean status) {
        veganRecipeTwoOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeTwoOpen", veganRecipeTwoOpen);
        pref.flush();
    }
    public void setVeganRecipeThreeOpen(boolean status) {
        veganRecipeThreeOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeThreeOpen", veganRecipeThreeOpen);
        pref.flush();
    }
    public void setVeganRecipeFourOpen(boolean status) {
        veganRecipeFourOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeFourOpen", veganRecipeFourOpen);
        pref.flush();
    }
    public void setVeganRecipeFiveOpen(boolean status) {
        veganRecipeFiveOpen = status;
        veganRecipesOpen++;
        pref.putInteger("veganRecipesOpen", veganRecipesOpen);
        pref.putBoolean("veganRecipeFiveOpen", veganRecipeFiveOpen);
        pref.flush();
    }


    public boolean getSoundStatus(){
        return soundStatus;
    }
    public boolean getMusicStatus() {
        return musicStatus;
    }

    public int getFirstLevelScore() {
        return firstLevelScore;
    }
    public int getSecondLevelScore() {
        return secondLevelScore;
    }
    public int getThirdLevelScore() {
        return thirdLevelScore;
    }
    public int getFourthLevelScore() {
        return fourthLevelScore;
    }
    public int getFifthLevelScore() {
        return fifthLevelScore;
    }

    public int getVeganFirstLevelScore() {
        return veganFirstLevelScore;
    }
    public int getVeganSecondLevelScore() {
        return veganSecondLevelScore;
    }
    public int getVeganThirdLevelScore() {
        return veganThirdLevelScore;
    }
    public int getVeganFourthLevelScore() {
        return veganFourthLevelScore;
    }
    public int getVeganFifthLevelScore() {
        return veganFifthLevelScore;
    }

    public boolean getLevelOneOpen() {
        return levelOneOpen;
    }
    public boolean getLevelTwoOpen() {
        return levelTwoOpen;
    }
    public boolean getLevelThreeOpen() {
        return levelThreeOpen;
    }
    public boolean getLevelFourOpen() {
        return levelFourOpen;
    }
    public boolean getLevelFiveOpen() {
        return levelFiveOpen;
    }

    public boolean getVeganLevelOneOpen() {
        return veganLevelOneOpen;
    }
    public boolean getVeganLevelTwoOpen() {
        return veganLevelTwoOpen;
    }
    public boolean getVeganLevelThreeOpen() {
        return veganLevelThreeOpen;
    }
    public boolean getVeganLevelFourOpen() {
        return veganLevelFourOpen;
    }
    public boolean getVeganLevelFiveOpen() {
        return veganLevelFiveOpen;
    }

    public int getRecipesOpen() {
        return normalRecipesOpen;
    }
    public int getVeganRecipesOpen() {
        return veganRecipesOpen;
    }
    public boolean getRecipeOneOpen() {
        return recipeOneOpen;
    }
    public boolean getRecipeTwoOpen() {
        return recipeTwoOpen;
    }
    public boolean getRecipeThreeOpen() {
        return recipeThreeOpen;
    }
    public boolean getRecipeFourOpen() {
        return recipeFourOpen;
    }
    public boolean getRecipeFiveOpen() {
        return recipeFiveOpen;
    }

    public boolean getVeganRecipeOneOpen() {
        return veganRecipeOneOpen;
    }
    public boolean getVeganRecipeTwoOpen() {
        return veganRecipeTwoOpen;
    }
    public boolean getVeganRecipeThreeOpen() {
        return veganRecipeThreeOpen;
    }
    public boolean getVeganRecipeFourOpen() {
        return veganRecipeFourOpen;
    }
    public boolean getVeganRecipeFiveOpen() {
        return veganRecipeFiveOpen;
    }

    public boolean getDisplayGameModeVegan() {
        return displayGameModeVegan;
    }

    public I18NBundle getCurrentLanguage() {
        return currentLanguage;
    }
}
