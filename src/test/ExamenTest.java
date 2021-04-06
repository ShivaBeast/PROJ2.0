import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ExamenTest {
    private static ArrayList<Vraag> vragen;
    private static Examen examen;

    @BeforeAll
    public static void init() {
        vragen = new ArrayList<>();
        vragen.add(new Vraag("Hallo?", "Hallo!", 100));
        examen = new Examen("Biologie", vragen);
    }

    @Test
    public void testConstructorMetParameters() {
        Assertions.assertEquals("Biologie", examen.getNaam());
        Assertions.assertEquals(vragen, examen.getVragen());
    }

    @Test
    public void testConstructorZonderParameters() {
        Examen examen = new Examen("", null);

        Assertions.assertEquals("", examen.getNaam());
        Assertions.assertEquals(null, examen.getVragen());
    }

    @Test
    public void testVoegToeAanPogingen() {
        Poging poging = new Poging(false);

        Assertions.assertTrue(examen.getPogingen().isEmpty());

        examen.voegToeAanPogingen(poging);

        Assertions.assertFalse(examen.getPogingen().isEmpty());
    }
}