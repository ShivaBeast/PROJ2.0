/**
 * Best.naam:   TestExamen.java
 * Auteur:      Pitt Khotchada
 * St.nummer:   19117884
 * Groep:       6C
 * Aangepast:   11-03
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestExamen {
    @Test
    public void testExamen() {
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        vragen.add(new Vraag("Wat is een cel?", "Geen idee",10));
        vragen.add(new Vraag("Wat is een mens?", "Een dier", 10));
        Examen examen = new Examen("Biologie", vragen, 55, 120);

        Assertions.assertEquals("Biologie", examen.getNaam());
        Assertions.assertEquals("Geen idee", examen.getVragen().get(0).getAntwoord());
        Assertions.assertEquals("Wat is een mens?", examen.getVragen().get(1).getVraag());
        Assertions.assertEquals(55, examen.getVoldoendeBij());
        Assertions.assertEquals(120, examen.getTijdOmTeMaken());
    }
}