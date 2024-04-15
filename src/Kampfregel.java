/**
 * @author Sven Ibe
 */
public class Kampfregel {
    /**
     * Die statische Methode der Klasse Kampfregel steuert den Prozess des Kampfes und ist für die Logik zuständig.
     * Es wird mit Getter der Angriffswert der beiden Objekte der Klasse Held und Monster verglichen.
     * Wenn dieser nicht identisch ist, wird überprüft welcher Angriffswert höher ist. Die Instanz mit dem niedrigsten Angriffswert wird die Methode <code>verliereLebenspunkt()</code> ausgeführt.
     * Diese zieht den Objekten extern (in der eigenen Klasse) die Lebenspunkte ab. Nach jeder Aktion wird in der Konsole ein Text ausgegeben.
     * Bei einem gleichen Angriffswert zwischen Held und Monster wird durch die Konsole der Text "Pariert!" ausgegeben.
     *
     * @param pHeld    importiertes Objekt der Klasse Held, welches im weiteren Verlauf verwendet wird.
     * @param pMonster importiertes Objekt der Klasse Monster, welches im weiteren Verlauf verwendet wird.
     */
    public static void kampf(Held pHeld, Monster pMonster) {
        pHeld.angriffswertBerechnen();
        pMonster.angriffswertBerechnen();
        if (pHeld.getAngriffswert() != pMonster.getAngriffswert()) {
            if (pHeld.getAngriffswert() > pMonster.getAngriffswert()) {
                if (pMonster.getLebenspunkte() != 0) {
                    pMonster.verliereLebenspunkt();
                    System.out.println("||Monster verliert Lebenspunkt! ");
                    printStats(pHeld, pMonster);
                    pHeld.move(pHeld.getView().getWidth() - 320 - 20);
                } else {
                    System.out.println("|||Der Held hat den Drachen besiegt");
                    pHeld.erhoeheSiege();
                    Spiel.setSpielBeendet(true);
                }
            } else {
                if (pHeld.getLebenspunkte() != 0) {
                    pHeld.verliereLebenspunkt();
                    System.out.println("||Held verliert Lebenspunkt! " + pHeld.getLebenspunkte());
                    printStats(pHeld, pMonster);
                    pMonster.move(pHeld.getView().getWidth() - 320 - 20);
                } else {
                    System.out.println("|||Der Held ist gestorben");
                    Spiel.setSpielBeendet(true);
                }
            }
        } else {
            //unentschieden
            System.out.println("||Pariert!");
            printStats(pHeld, pMonster);
        }
    }

    private static void printStats(Held pHeld, Monster pMonster) {
        System.out.println("|LP Held: " + pHeld.getLebenspunkte());
        System.out.println("|LP Monster: " + pMonster.getLebenspunkte());
        System.out.println("|AW Held: " + pHeld.getAngriffswert());
        System.out.println("|AW Monster: "+ pMonster.getAngriffswert());
    }
}
