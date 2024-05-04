import sas.Rectangle;
import sas.Sprite;

import java.awt.*;

public class Healthbar{
    /* static variables */

    /* static methods */

    /* attributes */

    private  Rectangle rec;
    private final Figur figur;
    private final Sprite body;
    private final int offsetX;
    private final int offsetY;

    /* constructors */
    public Healthbar (Figur figur, int offsetX, int offsetY) {
        this.figur = figur;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        rec = new Rectangle(figur.getPositionX() + offsetX, figur.getPositionY() + offsetY, 200, 10, Color.RED);
        body = new Sprite(new Rectangle(figur.getPositionX() + offsetX, figur.getPositionY() + offsetY, 200, 10, Color.BLACK));
        body.add(rec);

    }
    /* object methods */
    public void decreaseLP () {
        if (rec != null) {
            int factor = 200 / figur.getBeginningLP();
            rec.scaleTo(rec.getShapeWidth() - factor, rec.getShapeHeight());
            rec.move(-((double) factor / 2));
        }
        System.out.println("Alarm!");
    }

    public void updatePos (int distance) {
        body.move(distance);
    }

    public void resetHP () {
        rec = null;
        rec = new Rectangle(figur.getPositionX() + offsetX, figur.getPositionY() + offsetY, 200, 10, Color.RED);
    }
    /* getters and setters */

}
