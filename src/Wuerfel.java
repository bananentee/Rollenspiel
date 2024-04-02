import java.util.Random;

/**
 * @author Sven Ibe
 */
public class Wuerfel {
    private static Random rand = new Random();

    public static int wuerfeln(int pAnzahlSeiten) {
        return rand.nextInt(pAnzahlSeiten);
    }
}

