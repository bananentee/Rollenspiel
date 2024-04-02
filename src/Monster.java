import sas.Picture;
import sas.View;

/**
 * @author Sven Ibe
 */
public class Monster extends Figur {

    public Monster(int pLebenspunkte, View view) {
        lebenspunkte = pLebenspunkte;
        name = "Monster";
        checkData();
        new Picture(view.getWidth()/2,view.getHeight() - 20 - 224,"ass/monster.png");
    }

    public int angriffswertBerechnen() {
        return angriffswert = Wuerfel.wuerfeln(10);
    }
}
