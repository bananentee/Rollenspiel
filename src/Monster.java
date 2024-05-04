import sas.Picture;
import sas.View;

/**
 * @author Sven Ibe
 */
public class Monster extends Figur {

    public Monster(int pLebenspunkte, View pView) {
        lebenspunkte = pLebenspunkte;
        beginningLP = pLebenspunkte;
        view = pView;
        name = "Monster";

        checkData();
        initImg();
        initHealthBar(70,-25);
    }
    @Override
    public void angriffswertBerechnen() {
        angriffswert = Wuerfel.wuerfeln(10);
    }

    @Override
    public void move(int distance) {
        avatar.move(-distance);
        healthbar.updatePos(-distance);
        view.wait(500);
        avatar.move(distance);
        healthbar.updatePos(distance);
        view.wait(500);
    }
    @Override
    protected void initImg () {
        state0 = new Picture (view.getWidth() - 320 -20 ,view.getHeight() - 320 -20,"ass/monster/sprite_monster0.png" );
        state1 = new Picture (view.getWidth() - 320 -20 ,view.getHeight() - 320 -20,"ass/monster/sprite_monster1.png" );
        state2 = new Picture (view.getWidth() - 320 -20 ,view.getHeight() - 320 -20,"ass/monster/sprite_monster2.png" );
        state3 = new Picture (view.getWidth() - 320 -20 ,view.getHeight() - 320 -20,"ass/monster/sprite_monster3.png" );
        initStates();
    }

}
