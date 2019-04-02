package tiko2g.tamk.fi;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Prefs {
    private Preferences pref ;
    private boolean soundStatus;
    private boolean musicStatus;

    public Prefs() {
        pref = Gdx.app.getPreferences("My Preferences");
        soundStatus = pref.getBoolean("soundStatus",true);
        musicStatus = pref.getBoolean("musicStatus", true);
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

    public boolean getSoundStatus(){
        return soundStatus;
    }
    public boolean getMusicStatus() {
        return musicStatus;
    }

}
