public abstract class Figur {
    /* static variables */

    /* static methods */

    /* attributes */
    protected int angriffswert;
    protected String name;
    protected int lebenspunkte;
    /* constructors */

    /* object methods */
    public int verliereLebenspunkt() {
        if (lebenspunkte != 0) {
            lebenspunkte--;
        }
        return lebenspunkte;
    }

    public abstract int angriffswertBerechnen();

    /* getters and setters */

    public String getName() {
        return name;
    }

    public int getLebenspunkte() {
        return lebenspunkte;
    }

}
