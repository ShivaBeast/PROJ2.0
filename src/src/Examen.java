import java.util.ArrayList;

public class Examen {
    private String naam;
    private ArrayList<Vraag> vragen;

    /**
     * Constructor voor een examen object.
     * @param naam - Naam van het examen.
     * @param vragen - Een lijst met alle vragen in het examen.
     */
    public Examen(String naam, ArrayList<Vraag> vragen) {
        this.naam = naam;
        this.vragen = vragen;
    }

    /**
     * Constructor zonder parameters.
     */
    public Examen() {
        this("", null);
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
}