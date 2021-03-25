public class Feedback {
    private boolean geslaagd;
    private final int VOLDOENDEBIJ = 55;
    private int behaaldePunten;
    private Examen op;

    public Feedback(boolean geslaagd) {
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

    public Examen getOp() {
        return op;
    }

    public void setOp(Examen examen) {
        op = examen;
    }
}
