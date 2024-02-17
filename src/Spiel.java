import java.util.Scanner;

/**
 * @author Sven Ibe
 * @version 0.4
 */
public class Spiel {
    private static boolean spielBeendet;
    private int anzahlRunden;
    private Held held;
    private Monster monster;
    private Scanner in = new Scanner(System.in);
    public Spiel() {
        spielBeendet = false;
        erstelleHeld();
        erstelleMonster();
        spielStart();
    }

    public static void setSpielBeendet(boolean pSpielbeendet) {
        spielBeendet = pSpielbeendet;
    }

    public static void main(String[] args) {
        new Spiel();
    }

    public void showStats() {
        System.out.println("======================");
        System.out.println("Anzahl der Runden: " + anzahlRunden);
        System.out.println("gewonnene Kämpfe: " + held.getGewonneneKaempfe());
        System.out.println("verlorene Kämpfe: " + (anzahlRunden - held.getGewonneneKaempfe()));
        System.out.println("======================");
    }

    public void showInGameStats() {
        System.out.println("----------------------");
        System.out.println("Angriffswert Held " + held.angriffswertBerechnen());
        System.out.println("Angriffswert Monster " + monster.angriffswertBerechnen());
        System.out.println("----------------------");
    }

    /**
     * Die Methode <code>spielStart</code> ist die wichtigste Methode des Spiels.
     * Zunächst wird <code>anzahlRunden</code> erhöht, um anzugeben, dass ein neuer Kampf gestartet wird.
     * Es wird geprüft, dass das Spiel noch nicht beendet ist. Falls dieser beendet ist, wird es in der Konsole gemeldet.
     * Falls <code>spielBeendet</code> nicht wahr ist, werden die Angriffswerte der Objekte der Klassen Held und Monster berechnet.
     * Anschließend wird der Kampf mit der Methode <code>Kampfregel.kampf</code> aufgerufen.
     */
    private void spielStart() {
        anzahlRunden++;
        while (!spielBeendet) {
            Kampfregel.kampf(held, monster);
        }
        System.out.println("Der Kampf ist beendet!");
        showStats();
        showInGameStats();
    }

    private void erstelleHeld() {
        System.out.println("Name des Helden: ");
        String nameHeld = in.nextLine();
        System.out.println("Lebenspunkte des Helden: ");
        int lebenspunkteHeld = in.nextInt();
        held = new Held(nameHeld, lebenspunkteHeld, new Waffe("Stahl", 0));
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

    public void reset() {
        if (!spielBeendet) {
//            erstelleHeld();
//            erstelleMonster();
            spielStart();
        }
    }

    public Held getHeld () {
        return held;
    }
}