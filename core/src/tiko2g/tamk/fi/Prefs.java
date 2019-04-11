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
    private boolean recipeOneOpen;
    private boolean recipeTwoOpen;
    private boolean recipeThreeOpen;
    private boolean recipeFourOpen;
    private boolean recipeFiveOpen;

    private I18NBundle currentLanguage;
    private int storedLanguage;
    private int firstLevelScore;
    private int secondLevelScore;
    private int thirdLevelScore;

    public Prefs(MyGame g) {
        game = g;
        pref = Gdx.app.getPreferences("My Preferences");

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

    public void setRecipeOneOpen(boolean status) {
        recipeOneOpen = status;
        pref.putBoolean("recipeOneOpen", recipeOneOpen);
        pref.flush();
    }
    public void setRecipeTwoOpen(boolean status) {
        recipeTwoOpen = status;
        pref.putBoolean("recipeTwoOpen", recipeTwoOpen);
        pref.flush();
    }
    public void setRecipeThreeOpen(boolean status) {
        recipeThreeOpen = status;
        pref.putBoolean("recipeThreeOpen", recipeThreeOpen);
        pref.flush();
    }
    public void setRecipeFourOpen(boolean status) {
        recipeFourOpen = status;
        pref.putBoolean("recipeFourOpen", recipeFourOpen);
        pref.flush();
    }
    public void setRecipeFiveOpen(boolean status) {
        recipeFiveOpen = status;
        pref.putBoolean("recipeFiveOpen", recipeFiveOpen);
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

    public boolean getDisplayGameModeVegan() {
        return displayGameModeVegan;
    }

    public I18NBundle getCurrentLanguage() {
        return currentLanguage;
    }
}
