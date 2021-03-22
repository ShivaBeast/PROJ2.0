import java.util.ArrayList;

public class Examen {
    private String naam;
    private boolean geslaagd;
    private int voldoendeBij;
    private int tijdOmTeMaken;
    private ArrayList<Vraag> vragen;
    private Student gemaaktDoor;

    /**
     * Constructor voor een examen object.
     * @param naam - Naam van het examen.
     * @param vragen - Een lijst met alle vragen in het examen.
     * @param voldoendeBij - Het aantal punten om een voldoende te behalen.
     * @param tijdOmTeMaken - Hoelang het examen duurt in minuten.
     */
    public Examen(String naam, ArrayList<Vraag> vragen, int voldoendeBij, int tijdOmTeMaken) {
        this.naam = naam;
        this.vragen = vragen;
        this.voldoendeBij = voldoendeBij;
        this.tijdOmTeMaken = tijdOmTeMaken;
    }

    /**
     * Getter voor naam.
     * @return String naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Setter voor naam.
     * @param naam - naam
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Getter voor geslaagd.
     * @return boolean geslaagd
     */
    public boolean isGeslaagd() {
        return geslaagd;
    }

    /**
     * Setter voor geslaagd.
     * @param geslaagd - true of false
     */
    public void setGeslaagd(boolean geslaagd) {
        this.geslaagd = geslaagd;
    }

    /**
     * Getter voor voldoendeBij.
     * @return int voldoendeBij
     */
    public int getVoldoendeBij() {
        return voldoendeBij;
    }

    /**
     * Setter voor voldoendeBij.
     * @param voldoende - Aantal punten waarbij een student een voldoende heeft.
     */
    public void setVoldoendeBij(int voldoende) {
        voldoendeBij = voldoende;
    }

    /**
     * Getter voor tijdOmTeMaken.
     * @return int tijdOmTeMaken
     */
    public int getTijdOmTeMaken() {
        return tijdOmTeMaken;
    }

    /**
     * Setter voor tijdOmTeMaken.
     * @param tijd - Hoeveelheid tijd om een examen te maken.
     */
    public void setTijdOmTeMaken(int tijd) {
        tijdOmTeMaken = tijd;
    }

    /**
     * Getter voor vragen.
     * @return ArrayList<Vraag> vragen
     */
    public ArrayList<Vraag> getVragen() {
        return vragen;
    }

    /**
     * Setter voor vragen.
     * @param vragen - Een vragenlijst.
     */
    public void setVragen(ArrayList<Vraag> vragen) {
        this.vragen = vragen;
    }

    /**
     * Getter voor gemaaktDoor.
     * @return Student gemaaktDoor
     */
    public Student getGemaaktDoor() {
        return gemaaktDoor;
    }

    /**
     * Setter voor gemaaktDoor.
     * @param door - Degene die het examen maakt.
     */
    public void setGemaaktDoor(Student door) {
        gemaaktDoor = door;
    }
}