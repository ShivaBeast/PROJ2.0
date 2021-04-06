public class Poging {
    private boolean geslaagd;
    private final int VOLDOENDEBIJ = 55;
    private int behaaldePunten;
    private Examen examen;
    private Student student;

    /**
     * Constructor.
     * @param geslaagd is de student geslaagd
     */
    public Poging(boolean geslaagd) {
        this.geslaagd = geslaagd;
    }

    /**
     * Checkt of de student geslaagd is aan de hand van zijn/haar behaalde punten.
     * @param behaaldePunten aantal behaalde punten
     * @return true of false
     */
    public boolean isStudentGeslaagd(int behaaldePunten) {
        return behaaldePunten >= VOLDOENDEBIJ;
    }

    /**
     * Getter voor geslaagd.
     * @return true of false
     */
    public boolean getGeslaagd() {
        return geslaagd;
    }

    /**
     * Setter voor geslaagd.
     * @param geslaagd true of false
     */
    public void setGeslaagd(boolean geslaagd) {
        this.geslaagd = geslaagd;
    }

    /**
     * Getter voor VOLDOENDEBIJ.
     * @return drempelwaarde voor een voldoende
     */
    public int getVOLDOENDEBIJ() {
        return VOLDOENDEBIJ;
    }

    /**
     * Getter voor het aantal behaalde punten.
     * @return behaalde punten
     */
    public int getBehaaldePunten() {
        return behaaldePunten;
    }

    /**
     * Setter voor behaalde punten.
     * @param behaaldePunten behaalde punten
     */
    public void setBehaaldePunten(int behaaldePunten) {
        this.behaaldePunten = behaaldePunten;
    }

    /**
     * Getter voor examen.
     * @return examen
     */
    public Examen getExamen() {
        return examen;
    }

    /**
     * Setter voor examen.
     * @param examen examen
     */
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    /**
     * Getter voor student.
     * @return student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Setter voor student.
     * @param student student
     */
    public void setStudent(Student student) {
        this.student = student;
    }
}
