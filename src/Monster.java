/**
 * @author Sven Ibe
 */
public class Monster extends Figur {

    public Monster(int pLebenspunkte) {
        lebenspunkte = pLebenspunkte;
        name = "Monster";
        checkData();
    }

    public int angriffswertBerechnen() {
        return angriffswert = Wuerfel.wuerfeln(10);
    }
}
