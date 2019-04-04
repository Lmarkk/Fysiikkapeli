package tiko2g.tamk.fi;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.I18NBundle;

public class Prefs {
    private MyGame game;
    private Preferences pref ;
    private boolean soundStatus;
    private boolean musicStatus;
    private I18NBundle currentLanguage;
    private int storedLanguage;
    private int firstLevelScore;
    private int secondLevelScore;

    public Prefs(MyGame g) {
        game = g;
        pref = Gdx.app.getPreferences("My Preferences");
        soundStatus = pref.getBoolean("soundStatus",true);
        musicStatus = pref.getBoolean("musicStatus", true);
        firstLevelScore = pref.getInteger("firstLevelScore", 0);
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

    public void toggleMusic (){
        musicStatus = !musicStatus;
        pref.putBoolean("musicStatus",musicStatus);
        pref.flush();
    }
    public void setFirstLevelScore(int score) {
        firstLevelScore = score;
        pref.putInteger("firstLevelScore", firstLevelScore);
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
    public I18NBundle getCurrentLanguage() {
        return currentLanguage;
    }
}
