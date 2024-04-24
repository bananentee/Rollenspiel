import sas.Picture;
import sas.Rectangle;
import sas.Text;
import sas.View;
import sasio.Label;
import java.awt.*;

/**
 * @author Sven Ibe
 * @version 0.4
 */
public class Spiel {

    /* main method (.executable) */
    public static void main(String[] args) {
        new Spiel();
    }

    /* static variables */
    private static boolean spielBeendet;

    /* static methods */
    public static void setSpielBeendet(boolean pSpielbeendet) {
        spielBeendet = pSpielbeendet;
    }

    /* object variables */
    private int anzahlRunden;
    private Held held;
    private Monster monster;
    private final View view;
    private final Text label;

    /* constructor */
    public Spiel() {
        /* inits of important variables */
        spielBeendet = false;
        view = new View(1600, 900, "Dungeons and Dragons");

        /* GUI related inits */
        //* construction of Background */
        constructBG();
        //* construction of Foreground */
        label = new Text(
                10, 10,
                "Punktzahl: 0",
                Color.BLUE); // first frame of the label (therefore Punktzahl = 0)

        /* method calls from below */
        erstelleHeld();
        erstelleMonster();
        spielStart(); //needs to be called after the object inits
        startGui(); //needs to be called after the GUI related objects inits
    }

    /* object methods */
    //* START */
    /**
     * Die Methode <code>spielStart</code> ist die wichtigste Methode des Spiels.
     * Zunächst wird <code>anzahlRunden</code> erhöht, um anzugeben, dass ein neuer Kampf gestartet wird.
     * Es wird geprüft, dass das Spiel noch nicht beendet ist. Falls dieser beendet ist, wird es in der Konsole gemeldet.
     * Falls <code>spielBeendet</code> nicht wahr ist, werden die Angriffswerte der Objekte der Klassen Held und Monster berechnet.
     * Anschließend wird der Kampf mit der Methode <code>Kampfregel.kampf</code> aufgerufen.
     */
    private void spielStart() {
        anzahlRunden++;
        System.out.println("|||Kampflog:");
        while (!spielBeendet) {
            held.idle(view);
            monster.idle(view);
            Kampfregel.kampf(held, monster);
        }
        System.out.println("|||Der Kampf ist beendet!");
        showStats();
    }

    public void startGui () {
        while (!view.keyPressed('x')) {
            if (view.keyPressed('r')) {
                Spiel.setSpielBeendet(false);
                reset();
                label.setText("Punktzahl: " + held.getGewonneneKaempfe());
            }
            Spiel.setSpielBeendet(true);
        }
        System.out.println("Spiel beendet!");
    }

    //* INIT OF OBJECTS */
    private void erstelleHeld() {
        held = new Held("Held", 5, new Waffe("Stahl"), view);
        System.out.println("======================");
        System.out.println("Neuer Held wurde erstellt!");
        System.out.println("Name: " + "Held");
        System.out.println("Anzahl der Lebenspunkte: " + 5);
        System.out.println("======================");
    }

    private void erstelleMonster() {
        monster = new Monster(5, view);
        System.out.println("======================");
        System.out.println("Neues Monster wurde erstellt!");
        System.out.println("Anzahl der Lebenspunkte: " + 5);
        System.out.println("======================");
    }

    private void constructBG () {
        view.setBackgroundColor(Color.CYAN);
        Rectangle ground = new Rectangle(
                0, view.getHeight() - 20, // Die Koordinaten beziehen sich auf die linke obere Ecke des Rechtecks.
                view.getWidth(), 20,
                Color.GREEN
        );
        ground.setHidden(false);
        new Picture((double) view.getWidth() /2,view.getHeight() - 20 - 640, 640, 640,"ass/tree.png");
    }

    //* LOG OF STATS */
    public void showStats() {
        System.out.println("======================");
        System.out.println("Anzahl der Runden: " + anzahlRunden);
        System.out.println("gewonnene Kämpfe: " + held.getGewonneneKaempfe());
        System.out.println("verlorene Kämpfe: " + (anzahlRunden - held.getGewonneneKaempfe()));
        System.out.println("======================");
    }

    //* RESET */
    public void reset() {
        if (!spielBeendet) {
            held.resetLP();
            monster.resetLP();
            spielStart();
        }
    }

}