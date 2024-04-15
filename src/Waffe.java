/**
 * @author Sven Ibe
 */
public class Waffe {
    private int materialWert;
    private final String material;
    
    public Waffe (String pMaterial) {
        material = pMaterial;
    }
    
    private void calcMaterialWert() {
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
    }
    
    public int getMaterialWert() {
        calcMaterialWert();
        return materialWert;
    }
}
