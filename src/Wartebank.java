public class Wartebank {
    private final Held [] patient;

    private int patientAnzahl;

    public Wartebank (int length){
        patient = new Held[length];
    }

    public void addNewPatient (Held pHeld) {
        for (int i = 0; i < patient.length; i++) {
            if (patient[i] == null) {
                patient[i] = pHeld;
                patientAnzahl++;
                System.out.println(pHeld.getName() + "hat sich auf Platz" + i + "gesetzt.");
                break;
            }
        }
        System.out.println("Die Bank ist voll!");
    }

    private void compress () {
        for (int i = 0; i < patient.length; i++) {
            if (patient[i] == null) {
                for (int j = i + 1; j < patient.length; j++) {
                    patient[j-1] = patient[j];
                }
            }
        }
        patient [patient.length-1] = null;
    }

    public Held getFirstInTheLine () {
        boolean warteBankVoll = false;
        for (Held value : patient) {
            if (value != null) {
                warteBankVoll = true;
                break;
            }
        }

        if (!warteBankVoll) {
            patientAnzahl = 0;
            System.out.println("Es befinden sich keine Helden auf der Wartebank!");
            return null;
        }

        Held held = patient[0];
        patient[0] = null;
        patientAnzahl--;
        compress();
        System.out.println(held.getName() + "wurde aufgerufen!");
        return held;
    }

    public int getPatientenAnzahl () {
        return patientAnzahl;
    }
}