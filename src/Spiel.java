import sas.Rectangle;
import sas.View;
import sasio.Label;
import java.awt.*;
import java.util.Scanner;

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
    private Scanner in = new Scanner(System.in);
    private View view;
    private Label label;

    /* constructor */
    public Spiel() {

        /* inits of important variables */
        spielBeendet = false;
        view = new View(1600, 900, "Dungeons and Dragons");

        /* GUI related inits */
        //* construction of Background */
        constructBG();
        //* construction of Foreground */
        label = new Label(
                view.getWidth() / 2 - 150, view.getHeight() / 2 - 50,
                300, 70,
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
        held.angriffswertBerechnen();
        monster.angriffswertBerechnen();
        showInGameStats();
        while (!spielBeendet) {
            Kampfregel.kampf(held, monster);
        }
        System.out.println("Der Kampf ist beendet!");
        showStats();
    }

    public void startGui () {
        while (!view.keyPressed('x')) {
            if (view.keyPressed('r')) {
                Spiel.setSpielBeendet(false);
                reset();
                label.setLabelText("Punktzahl: " + held.getGewonneneKaempfe());
            }
            Spiel.setSpielBeendet(true);
        }
    }

    //* INIT OF OBJECTS */
    private void erstelleHeld() {
        System.out.println("Name des Helden: ");
        String nameHeld = in.nextLine();
        System.out.println("Lebenspunkte des Helden: ");
        int lebenspunkteHeld = in.nextInt();
        held = new Held(nameHeld, lebenspunkteHeld, new Waffe("Stahl", 0), view);
        System.out.println("======================");
        System.out.println("Neuer Held wurde erstellt!");
        System.out.println("Name: " + nameHeld);
        System.out.println("Anzahl der Lebenspunkte: " + lebenspunkteHeld);
        System.out.println("======================");
    }

    private void erstelleMonster() {
        System.out.println("Lebenspunkte des Monsters: ");
        int lebenspunkteMonster = in.nextInt();
        monster = new Monster(lebenspunkteMonster);
        System.out.println("======================");
        System.out.println("Neues Monster wurde erstellt!");
        System.out.println("Anzahl der Lebenspunkte: " + lebenspunkteMonster);
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
    }

    //* LOG OF STATS */
    public void showStats() {
        System.out.println("======================");
        System.out.println("Anzahl der Runden: " + anzahlRunden);
        System.out.println("gewonnene Kämpfe: " + held.getGewonneneKaempfe());
        System.out.println("verlorene Kämpfe: " + (anzahlRunden - held.getGewonneneKaempfe()));
        System.out.println("======================");
    }

    public void showInGameStats() {
        System.out.println("----------------------");
        System.out.println("Angriffswert Held " + held.getAngriffswert());
        System.out.println("Angriffswert Monster " + monster.getAngriffswert());
        System.out.println("----------------------");
    }

    //* RESET */
    public void reset() {
        if (!spielBeendet) {
//            erstelleHeld();
//            erstelleMonster();
            spielStart();
        }
    }

}