public class Feedback {
    private Examen examen;

    Feedback(Examen examen){
        this.examen = examen;
    }

    public boolean isVoldoende(int aantalGoed, int voldoendeBij){
        if (aantalGoed >= voldoendeBij){
            return true;
        }
        return false;
    }
}
