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
    private Picture avatar;

    public Held(String pName, int pLebenspunkte, Waffe pWaffe, View pView) {
        view = pView;
        name = pName;
        lebenspunkte = pLebenspunkte;
        beginningLP = pLebenspunkte;
        waffe = pWaffe;
        checkData();

        avatar = new Picture(20,view.getHeight() - 224,"ass/hero.png");
    }

    public void angriffswertBerechnen() { // strength is randomized; cap at 6
        if (waffe != null) {
            staerke = Wuerfel.wuerfeln(6);
            angriffswert = staerke + waffe.getBonus();
        }
    }

    @Override
    public void move() {
        avatar.move((double) view.getWidth() / 2);
        view.wait(500);
        avatar.move(-((double) view.getWidth() / 2));
        view.wait(500);
    }

    public int erhoeheSiege() {
        return gewonneneKaempfe++;
    }
    public int getGewonneneKaempfe() {
        return gewonneneKaempfe;
    }


}
