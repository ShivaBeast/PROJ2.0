import java.util.ArrayList;

public class ExamenVerzameling {
    private ArrayList<Examen> alleExamens = new ArrayList<Examen>();
    private Vraag vragen = new Vraag();

    /**
     * Bij het aanmaken van een instance, worden alvast de bestaande examens toegevoegd.
     */
    public ExamenVerzameling() {
        // Voeg de bestaande examens toe aan de lijst.
        alleExamens.add(new Examen("Examen 1", vragen.vragen()));
        alleExamens.add(new Examen("Examen 2", vragen.MCVragen()));
    }

    /**
     * Getter voor alle examens in de "database".
     *
     * @return ArrayList<Examen> - Een ArrayList dat alle examens bevat.
     */
    public ArrayList<Examen> getAlleExamens() {
        return alleExamens;
    }

    /**
     * Voegt een examen toe.
     *
     * @param examen - De toe te voegen examen.
     */
    public void voegExamenToe(Examen examen) {
        alleExamens.add(examen);
    }

    /**
     * Verwijdert een examen.
     *
     * @param examenNaam - Naam van de ongewenste examen.
     */
    public void verwijderExamen(String examenNaam) {
        alleExamens.removeIf(examen -> examen.getNaam().equals(examenNaam));
    }
}
