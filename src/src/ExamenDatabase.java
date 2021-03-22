import java.util.ArrayList;

public class ExamenDatabase {
    // In deze ArrayList komen alle examens te staan.
    private ArrayList<Examen> alleExamens = new ArrayList<Examen>();

    /**
     * Bij het aanmaken van een instance, worden alvast de bestaande examens toegevoegd.
     */
    public ExamenDatabase() {
        // Voeg de bestaande examens toe aan de lijst.
        alleExamens.add(new Examen("Examen 1", vragen(), 55, 90));
        alleExamens.add(new Examen("Examen 2", MCVragen(), 55, 120));
    }

    /**
     * Getter voor alle examens in de "database".
     *
     * @return ArrayList<ArrayList<Examen>> - Een ArrayList dat alle examens bevat.
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

    /******************** Vragen voor de examens ********************/

    public ArrayList<Vraag> vragen() {
        ArrayList<Vraag> open = new ArrayList<>();

        open.add(new Vraag("Wat is het 3e planeet in ons zonnestelsel?", "Aarde", 10));
        open.add(new Vraag("Hoe heet de koning van Nederland?", "Willem Alexander", 10));
        open.add(new Vraag("Wie was de 1e gekleurde president van Amerika?", "Barack Obama", 10));
        open.add(new Vraag("Welk land heeft de meeste bewoners van heel de wereld?", "China", 10));
        open.add(new Vraag("Welk land behoort sinds 2020 niet meer tot de EU?", "Het Verenigd Koninkrijk", 10));
        open.add(new Vraag("Welke wereldwonder bevindt zich in India?", "De Taj Mahal", 10));
        open.add(new Vraag("Wat is de beste vriend van mens?", "De hond", 10));
        open.add(new Vraag("Waar zijn panda beren bekend om?", "Hun kleur", 10));
        open.add(new Vraag("Hoe lang duurt het gemiddeld wanneer een baby geboren is?", "9 maanden", 10));
        open.add(new Vraag("Wie is de huidige president van Amerika?", "Joe Biden", 10));

        return open;
    }

    public ArrayList<Vraag> MCVragen() {
        ArrayList<Vraag> mc = new ArrayList<>();

        mc.add(new Vraag(1, "Waar staat HTML voor?", 'A', 10));
        mc.add(new Vraag(2, "Welke smartphone bedrijf behoort niet tot China?", 'B', 10));
        mc.add(new Vraag(3, "Welke code is correct?", 'B', 10));
        mc.add(new Vraag(4, "Wat is de functie van de Scrum Master?", 'A', 10));
        mc.add(new Vraag(5, "Welke van de 4 methoden is de constructor?", 'C', 10));
        mc.add(new Vraag(6, "Welk land werd de 1e die wiet legaliseerde?", 'C', 10));
        mc.add(new Vraag(7, "Welke programmeertaal wordt gebruikt voor het bouwen van een website?", 'C', 10));
        mc.add(new Vraag(8, "Welk land behoort niet tot Zuid-Amerika?", 'D', 10));
        mc.add(new Vraag(9, "Wie heeft de wereldrecord als de snelste man ter wereld?", 'B', 10));
        mc.add(new Vraag(10, "Hoe heet de zoon van god?", 'A', 10));

        return mc;
    }
}
