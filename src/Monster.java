import sas.Picture;
import sas.View;

/**
 * @author Sven Ibe
 */
public class Monster extends Figur {
    private Picture avatar;
    private View view;
    public Monster(int pLebenspunkte, View pView) {
        lebenspunkte = pLebenspunkte;
        beginningLP = pLebenspunkte;
        view = pView;
        name = "Monster";

        checkData();
        avatar = new Picture((double) pView.getWidth() /2,pView.getHeight() - 20 - 224,"ass/monster.png");
    }

    public void angriffswertBerechnen() {
        angriffswert = Wuerfel.wuerfeln(10);
    }

    @Override
    public void move() {
        avatar.move(-((double) view.getWidth() / 2));
        view.wait(500);
        avatar.move((double) view.getWidth() / 2);
        view.wait(500);
    }


}
