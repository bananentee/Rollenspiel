/**
 * @author Sven Ibe
 */
public class Waffe {
    private int bonus;
    private int materialWert;
    private int magie;
    private String material;
    
    public Waffe (String pMaterial, int pMagie) {
        material = pMaterial;
        magie = pMagie;
    }
    
    private void bonusBerechnen () {
        switch (material) {
            case "Holz":
                materialWert = 1;
                break;
            case "Eisen":
                materialWert = 2;
                break;
            case "Stahl":
                materialWert = 3;
                break;
            case "Diamant":
                materialWert = 4;
                break;
            default :
                materialWert = 0;
                //falsches Material wurde angegeben
        }
        bonus = materialWert + magie;
    }
    
    public int getBonus () {
        bonusBerechnen();
        return bonus;
    }
}
