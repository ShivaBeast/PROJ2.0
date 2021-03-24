public class Afname {
    private boolean geslaagd;
    private int voldoendeBij;
    private Examen van;

    public Afname(boolean geslaagd, int voldoendeBij) {
        this.geslaagd = geslaagd;
        this.voldoendeBij = voldoendeBij;
    }

    public boolean getGeslaagd() {
        return geslaagd;
    }

    public void setGeslaagd(boolean geslaagd) {
        this.geslaagd = geslaagd;
    }

    public int getVoldoendeBij() {
        return voldoendeBij;
    }

    public Examen getVan() {
        return van;
    }

    public void setVan(Examen examen) {
        van = examen;
    }
}
