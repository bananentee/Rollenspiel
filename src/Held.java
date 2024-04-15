import sas.Picture;
import sas.View;

/**
 * @author Sven Ibe
 */
public class Held extends Figur {
    private int gewonneneKaempfe;
    private final Waffe waffe;

    public Held(String pName, int pLebenspunkte, Waffe pWaffe, View pView) {
        view = pView;
        name = pName;
        lebenspunkte = pLebenspunkte;
        beginningLP = pLebenspunkte;
        waffe = pWaffe;
        checkData();
        initImg();
    }
    @Override
    public void angriffswertBerechnen() { // strength is randomized; cap at 6
        if (waffe != null) {
            int staerke = Wuerfel.wuerfeln(6);
            angriffswert = staerke + waffe.getMaterialWert();
        }
    }

    @Override
    public void move(int distance) {
        avatar.move(distance);
        view.wait(500);
        avatar.move(-(distance));
        view.wait(500);
    }
    @Override
    protected void initImg () {
        state0 = new Picture (20,view.getHeight() - 320 -20,"ass/hero/sprite_hero0.png" );
        state1 = new Picture (20,view.getHeight() - 320 -20,"ass/hero/sprite_hero1.png" );
        state2 = new Picture (20,view.getHeight() - 320 -20,"ass/hero/sprite_hero2.png" );
        state3 = new Picture (20,view.getHeight() - 320 -20,"ass/hero/sprite_hero3.png" );
        initStates();
    }

    public void erhoeheSiege() {
        gewonneneKaempfe++;
    }
    public int getGewonneneKaempfe() {
        return gewonneneKaempfe;
    }

}
