import java.util.ArrayList;

public class Poging {
    private boolean geslaagd;
    private final int VOLDOENDEBIJ = 55;
    private int behaaldePunten;
    private Examen examen;
    private Student student;
    private static ArrayList<Poging> pogingenVanStudenten = new ArrayList<Poging>();

    public Poging(boolean geslaagd) {
        this.geslaagd = geslaagd;
    }

    public boolean isStudentGeslaagd(int behaaldePunten) {
        return behaaldePunten >= VOLDOENDEBIJ;
    }

    public boolean getGeslaagd() {
        return geslaagd;
    }

    public void setGeslaagd(boolean geslaagd) {
        this.geslaagd = geslaagd;
    }

    public int getVOLDOENDEBIJ() {
        return VOLDOENDEBIJ;
    }

    public int getBehaaldePunten() {
        return behaaldePunten;
    }

    public void setBehaaldePunten(int behaaldePunten) {
        this.behaaldePunten = behaaldePunten;
    }

    public boolean isGeslaagd() {
        return geslaagd;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public static ArrayList<Poging> getPogingenVanStudenten() {
        return pogingenVanStudenten;
    }

    public static void setPogingenVanStudenten(ArrayList<Poging> pogingenVanStudenten) {
        Poging.pogingenVanStudenten = pogingenVanStudenten;
    }

    public static void voegToeAanPogingen(Poging poging) {
        pogingenVanStudenten.add(poging);
    }
}
