import sas.Picture;
import sas.Sprite;
import sas.View;

public abstract class Figur {
    /* static variables */

    /* static methods */

    /* attributes */

    protected String name;
    protected View view;
    protected Sprite avatar;
    protected Healthbar healthbar;
    protected int lebenspunkte;
    protected int angriffswert;
    protected int beginningLP;
    protected Picture state0, state1, state2, state3;

    /* constructors */

    /* abstract methods */
    public abstract void angriffswertBerechnen();
    public abstract void move(int distance);
    protected abstract void initImg();


    /* object methods */
    public void verliereLebenspunkt() {
        if (lebenspunkte != 0) {
            lebenspunkte--;
            healthbar.decreaseLP();
        }
    }

    public void checkData (){
        if (lebenspunkte <= 0 || name == null || name.matches("[0-9]+")) {
            System.exit(404);
        }
    }

    public void idle (View view) {
        state0.setHidden(false);
        view.wait(100);
        state0.setHidden(true);
        state1.setHidden(false);
        view.wait(100);
        state1.setHidden(true);
        state2.setHidden(false);
        view.wait(100);
        state2.setHidden(true);
        state3.setHidden(false);
        view.wait(100);
        state3.setHidden(true);
        state0.setHidden(false);
    }

    protected void initStates () {
        avatar = new Sprite(state0);
        avatar.add(state1);
        avatar.add(state2);
        avatar.add(state3);
        state0.setHidden(false);
        state1.setHidden(true);
        state2.setHidden(true);
        state3.setHidden(true);
    }

    public void initHealthBar (int offsetX, int offsetY) {
        healthbar = new Healthbar(this, offsetX, offsetY);
    }

    public void resetLP () {
        lebenspunkte = beginningLP;
        healthbar.resetHP(); //TODO delete the old red bar from the view (somehow)
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
    public View getView (){
        return view;
    }
    public double getPositionX () {
        return avatar.getShapeX();
    }
    public double getPositionY () {
        return avatar.getShapeY();
    }
    public int getBeginningLP() {
        return beginningLP;
    }

}
