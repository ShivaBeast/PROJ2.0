public class Feedback {
    private boolean geslaagd;
    private int voldoendeBij;
    private Examen op;

    public Feedback(boolean geslaagd, int voldoendeBij) {
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

    public Examen getOp() {
        return op;
    }

    public void setOp(Examen examen) {
        op = examen;
    }

    public boolean isVoldoende(int aantalGoed, int voldoendeBij){
        if (aantalGoed >= voldoendeBij){
            return true;
        }
        return false;
    }
}
