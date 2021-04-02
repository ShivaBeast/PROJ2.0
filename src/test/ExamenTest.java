import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ExamenTest {
    // TODO: tests maken

    @Test
    public void TestGetNaam(){
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        vragen.add(new Vraag("hoe heet jij?","Pitt Khotchada", 10));
        Examen examen = new Examen("Biologie", vragen);
        Assertions.assertEquals("Biologie", examen.getNaam());

    }

    @Test
    public void TestGetVragen(){
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        vragen.add(new Vraag());
        Examen examen = new Examen("Biologie", vragen);
        Assertions.assertEquals(vragen, examen.getVragen());

    }
}