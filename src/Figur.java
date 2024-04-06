
public abstract class Figur {
    /* static variables */

    /* static methods */

    /* attributes */

    protected String name;
    protected int lebenspunkte;
    protected int angriffswert;
    protected int beginningLP;

    /* constructors */

    /* abstract methods */
    public abstract void angriffswertBerechnen();
    public abstract void move();

    /* object methods */
    public int verliereLebenspunkt() {
        if (lebenspunkte != 0) {
            lebenspunkte--;
        }
        return lebenspunkte;
    }

    public void checkData (){
        if (lebenspunkte <= 0 || name == null || name.matches("[0-9]+")) {
            System.exit(404);
        }
    }

    public void resetLP () {
        lebenspunkte = beginningLP;
    }

    /* getters and setters */
    public String getName() {
        return name;
    }
    public int getLebenspunkte() {
        return lebenspunkte;
    }
    public int getAngriffswert() {
        return angriffswert;
    }
}
