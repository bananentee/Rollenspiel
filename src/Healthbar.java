import sas.Rectangle;
import sas.Sprite;

import java.awt.*;

public class Healthbar {
    /* static variables */

    /* static methods */

    /* attributes */

    private final Rectangle rec;
    private int counter;
    private final int factor;
    private final Sprite body;


    /* constructors */
    public Healthbar (Figur figur, int offsetX, int offsetY) {
        rec = new Rectangle(figur.getPositionX() + offsetX, figur.getPositionY() + offsetY, 200, 10, Color.RED);
        body = new Sprite(new Rectangle(figur.getPositionX() + offsetX, figur.getPositionY() + offsetY, 200, 10, Color.BLACK));
        body.add(rec);
        factor = 200 / figur.getBeginningLP();
        counter = 0;
    }
    /* object methods */
    public void decreaseLP () {
        rec.scaleTo(rec.getShapeWidth() - factor, rec.getShapeHeight());
        rec.move(-((double) factor / 2));
        counter++;
    }

    public void updatePos (int distance) {
        body.move(distance);
    }

    public void resetHP () {
        for (int i = 0; i < counter; i++) {
            rec.scaleTo(200, rec.getShapeHeight());
            rec.move(-((double) factor / 2));
        }
        counter = 0;
    }
    /* getters and setters */

}
