/**
 * @author Sven Ibe
 */
public class Monster extends Figur {

    public Monster(int pLebenspunkte) {
        lebenspunkte = pLebenspunkte;
    }

    public int angriffswertBerechnen() {
        return angriffswert = Wuerfel.wuerfeln(10);
    }
}
