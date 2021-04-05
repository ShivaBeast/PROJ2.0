import java.util.ArrayList;

public class ExamenVerzameling {
    private final ArrayList<Examen> ALLEEXAMENS = new ArrayList<Examen>();

    /**
     * Voeg de twee bestaande examens toe aan de arraylist.
     */
    public ExamenVerzameling() {
        ALLEEXAMENS.add(new Examen("Examen 1", Vraag.vragen()));
        ALLEEXAMENS.add(new Examen("Examen 2", Vraag.MCVragen()));
    }

    /**
     * Getter voor alle examens.
     * @return arraylist met alle examens.
     */
    public ArrayList<Examen> getAlleExamens() {
        return ALLEEXAMENS;
    }
}
