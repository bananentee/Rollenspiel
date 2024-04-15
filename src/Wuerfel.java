import java.util.Random;

/**
 * @author Sven Ibe
 */
public class Wuerfel { // Wrapper-Klasse für einen Random Number Generator
    private static final Random rand = new Random();

    public static int wuerfeln(int pAnzahlSeiten) {
        return rand.nextInt(pAnzahlSeiten);
    }
}

