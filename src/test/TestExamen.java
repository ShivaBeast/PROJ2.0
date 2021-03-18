import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestExamen {
    @Test
    public void testConstructorExamen() {
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        vragen.add(new Vraag("Vraag 1?", "Antwoord 1.", 10));
        vragen.add(new Vraag("Vraag 2?", "Antwoord 2.", 10));

        Examen examen = new Examen("Examen 1", vragen, 55, 90);

        Assertions.assertEquals("Examen 1", examen.getNaam());
        Assertions.assertEquals(vragen, examen.getVragen());
        Assertions.assertEquals(55, examen.getVoldoendeBij());
        Assertions.assertEquals(90, examen.getTijdOmTeMaken());
    }

    @Test
    public void testSetGetNaam() {
        Examen examen = new Examen("Examen 2", null, 55, 90);

        examen.setNaam("Examen 3");
        Assertions.assertEquals("Examen 3", examen.getNaam());
    }

    @Test
    public void testSetGetVoldoendeBij() {
        Examen examen = new Examen("Examen 4", null, 60, 120);

        examen.setVoldoendeBij(90);
        Assertions.assertEquals(90, examen.getVoldoendeBij());
    }

    @Test
    public void testSetGetTijdOmTeMaken() {
        Examen examen = new Examen("Examen 5", null, 40, 120);

        examen.setTijdOmTeMaken(60);
        Assertions.assertEquals(60, examen.getTijdOmTeMaken());
    }

    @Test
    public void testSetGetVragen() {
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        vragen.add(new Vraag("Vraag 99?", "Antwoord 99.", 10));
        vragen.add(new Vraag("Vraag 100?", "Antwoord 100.", 10));

        Examen examen = new Examen("Examen 6", null, 45, 90);

        examen.setVragen(vragen);
        Assertions.assertEquals(vragen, examen.getVragen());
    }

    @Test
    public void testSetGetGemaaktDoor() {
        Examen examen = new Examen("Examen 7", null, 55, 60);
        Student student = new Student("John Doe", "12345678");

        examen.setGemaaktDoor(student);
        Assertions.assertEquals(student, examen.getGemaaktDoor());
    }
}