import java.util.ArrayList;

public class Student {
    private String naam;
    private String studentenNummer;
    private ArrayList<Poging> pogingen = new ArrayList<>();

    /**
     * Standaard constructor.
     * @param naam naam van student.
     * @param studentenNummer nummer van student.
     */
    public Student(String naam, String studentenNummer) {
        this.naam = naam;
        this.studentenNummer = studentenNummer;
    }

    /**
     * Constructor zonder parameters.
     */
    public Student() {
        this("", "");
    }

    /**
     * Check de lengte van de studentennummer.
     * @param studentenNummer nummer van student
     * @return true of false
     */
    public static boolean checkLengteStudentenNummer(String studentenNummer) {
        return studentenNummer.length() > 0 && studentenNummer.length() <= 8;
    }

    /**
     * Getter voor studentennaam.
     * @return naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Setter voor naam.
     * @param naam naam van de student
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Getter voor studentennummer.
     * @return studentennummer
     */
    public String getStudentenNummer() {
        return studentenNummer;
    }

    /**
     * Setter voor studentennummer.
     * @param studentenNummer nummer van student
     */
    public void setStudentenNummer(String studentenNummer) {
        this.studentenNummer = studentenNummer;
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
