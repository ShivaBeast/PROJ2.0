public class Student {
    private String naam;
    private String studentenNummer;

    /**
     * Standaard constructor.
     * @param naam naam van student.
     * @param studentenNummer nummer van student.
     */
    public Student(String naam,String studentenNummer) {
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
     * Getter voor studentennummer.
     * @return studentennummer
     */
    public String getStudentenNummer() {
        return studentenNummer;
    }
}
