import sas.Picture;

/**
 * @author Sven Ibe
 */
public class Held extends Figur {
    private int gewonneneKaempfe;
    private int staerke;
    private Waffe waffe;

    public Held(String pName, int pLebenspunkte, Waffe pWaffe) {
        name = pName;
        lebenspunkte = pLebenspunkte;
        waffe = pWaffe;
        new Picture(0,0,"ass/hero.png");
    }

    public int angriffswertBerechnen() { // Staerke ist random gewurfelt; cap liegt bei 6
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
