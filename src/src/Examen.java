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
     * Getter voor tijdOmTeMaken.
     * @return int tijdOmTeMaken
     */
    public int getTijdOmTeMaken() {
        return tijdOmTeMaken;
    }

    /**
     * Getter voor vragen.
     * @return ArrayList<Vraag> vragen
     */
    public ArrayList<Vraag> getVragen() {
        return vragen;
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