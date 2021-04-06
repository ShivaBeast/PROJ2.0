import java.util.ArrayList;

public class Examen {
    private String naam;
    private ArrayList<Vraag> vragen;
    private ArrayList<Poging> pogingen = new ArrayList<>();

    /**
     * Constructor voor een examen object.
     * @param naam naam van het examen.
     * @param vragen een lijst met alle vragen in het examen.
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
     * @param naam naam
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
     * @param vragen een vragenlijst.
     */
    public void setVragen(ArrayList<Vraag> vragen) {
        this.vragen = vragen;
    }

    /**
     * Getter voor pogingen.
     * @return lijst met pogingen
     */
    public ArrayList<Poging> getPogingen() {
        return pogingen;
    }

    /**
     * Setter voor pogingen.
     * @param pogingen ArrayList met pogingen
     */
    public void setPogingen(ArrayList<Poging> pogingen) {
        this.pogingen = pogingen;
    }

    /**
     * Voeg een poging toe aan een ArrayList van pogingen.
     * @param poging een poging
     */
    public void voegToeAanPogingen(Poging poging) {
        pogingen.add(poging);
    }
}