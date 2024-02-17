import java.util.Random;

/**
 * @author Sven Ibe
 */
public class Wuerfel {
    static private Random rand = new Random();
    private int anzahlSeiten;

    Wuerfel(int pAnzahlSeiten) {
        anzahlSeiten = pAnzahlSeiten;
    }

    public static int wuerfeln(int pAnzahlSeiten) {
        return rand.nextInt(pAnzahlSeiten);
    }
}

