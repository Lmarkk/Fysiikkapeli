package tiko2g.tamk.fi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class FirstRecipe extends Recipe {
    String recipeText;

    public FirstRecipe(MyGame g) {
        super(g);
        FileHandle file = Gdx.files.internal("karjalanpaisti.txt");
        recipeText = file.readString();

    }
    @Override
    public void render(float delta) {
        super.render(delta);
        Vector2 rectCenter = new Vector2();
        game.getTextRenderer().renderText(
                "\uFEFFAinekset (4 annosta):\n" +
                        "800g Pilkottua lihaa\n" +
                        "250g sipulia\n" +
                        "2-3 Porkkanaa\n" +
                        "1tl Suolaa\n" +
                        "10 Kokonaista maustepippuria\n" +
                        "Vettä", 2.5f * 100f, 5 * 100f, font30);
        game.getTextRenderer().renderText(
                "\uFEFFValmistus (arvioitu valmistusaika yli 60 min):\n" +
                        "Kuori ja lohko sipulit. Kuori ja paloittele porkkanat paloiksi.\n" +
                        "Pane voideltuun pataan tai vuokaan kerroksittain lihaa, sipulia ja porkkanoita, suolaa ja pippureita.\n" +
                        "Kaada vuokaan vettä sen verran, että lihat juuri ja juuri peittyvät.\n" +
                        "Kypsennä 175 asteessa 2-3 tuntia. Lisää vettä tarvittaessa.\n" +
                        "Peitä halutessasi kypsymisen loppuvaiheessa kannella.\n" +
                        "Tarjoa keitettyjen perunoiden tai perunasoseen kanssa.", 5.5f * 100f, 3 * 100f, font30);
    }
}
