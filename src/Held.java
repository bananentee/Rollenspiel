import sas.Picture;
import sas.View;

/**
 * @author Sven Ibe
 */
public class Held extends Figur {
    private int gewonneneKaempfe;
    private int staerke;
    private Waffe waffe;
    private View view;

    public Held(String pName, int pLebenspunkte, Waffe pWaffe, View pView) {
        view = pView;
        name = pName;
        lebenspunkte = pLebenspunkte;
        waffe = pWaffe;

        checkData();
        new Picture(20,view.getHeight() - 20 - 224,"ass/hero.png");
    }

    public int angriffswertBerechnen() { // strength is randomized; cap at 6
        if (waffe != null) {
            staerke = Wuerfel.wuerfeln(6);
            angriffswert = staerke + waffe.getBonus();
        }
        return angriffswert;
    }
    public int erhoeheSiege() {
        return gewonneneKaempfe++;
    }
    public int getGewonneneKaempfe() {
        return gewonneneKaempfe;
    }


}
