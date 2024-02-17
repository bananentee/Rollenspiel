import sas.*;
import sasio.Label;

import java.awt.*;

public class Gui {
    /* static variables */

    /* attributes */
    private View view;
    private Label label;
    private Spiel game;

    /* constructors */
    public Gui() {
        game = new Spiel();
        view = new View(1600, 900, "Dungeons and Dragons");
        label = new Label(
                view.getWidth() / 2 - 150, view.getHeight() / 2 - 50,
                300, 70,
                "Punktzahl: " + game.getHeld().getGewonneneKaempfe(),
                Color.BLUE);
    }

    public void startGui () {
        while (!view.keyPressed('x')) {
            if (view.keyPressed('r')) {
                Spiel.setSpielBeendet(false);
                game.reset();
                label.setLabelText("Punktzahl: " + game.getHeld().getGewonneneKaempfe());
            }
            Spiel.setSpielBeendet(true);
        }
    }

    /* static methods */
    public static void main(String[] args) {
        new Gui().startGui();
    }
    /* object methods */

    /* getters and setters */

}
