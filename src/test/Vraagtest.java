import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Vraagtest {

    @Test
    public void testGetVraag(){
        Vraag vraag = new Vraag("Wat is mijn naam?", "Shiva", 10);
        Assertions.assertEquals("Wat is mijn naam?", vraag.getVraag());
    }

    @Test
    public void testGetAntwoord(){
        Vraag antwoord = new Vraag("Wat is mijn naam?", "Shiva", 10);
        Assertions.assertEquals("Shiva", antwoord.getAntwoord());
    }

    @Test
    public void testGetNummer(){
        ArrayList<String> keuzes = new ArrayList<String>();
        keuzes.add("A. Jupiter");
        keuzes.add("B. Venus");
        keuzes.add("C. Aarde");
        keuzes.add("D. Pluto");
        Vraag nummer = new Vraag("Hoe heet de 3e planeet van ons zonnestelsel?",keuzes, "C", 10);
        Assertions.assertEquals(keuzes, nummer.getKeuzes());
        System.out.println(keuzes);
    }

    @Test
    public void testGetMcvraag(){
        ArrayList<String> keuzes = new ArrayList<String>();
        keuzes.add("A. Jupiter");
        keuzes.add("B. Venus");
        keuzes.add("C. Aarde");
        keuzes.add("D. Pluto");
        Vraag vraag = new Vraag("Hoe heet de 3e planeet van ons zonnestelsel?", keuzes, "C", 10);
        Assertions.assertEquals("Hoe heet de 3e planeet van ons zonnestelsel?", vraag.getVraag());
    }

    @Test
    public void testGetMcantwoord() {
        ArrayList<String> keuzes = new ArrayList<String>();
        keuzes.add("A. Jupiter");
        keuzes.add("B. Venus");
        keuzes.add("C. Aarde");
        keuzes.add("D. Pluto");
        Vraag antwoord = new Vraag("Hoe heet de 3e planeet van ons zonnestelsel?", keuzes, "C", 10);
        Assertions.assertEquals("C", antwoord.getAntwoord());
    }

    @Test
    public void testGetPunten() {
        Vraag punten = new Vraag("Hoe heet de 3e planeet van ons zonnestelsel?", "Aarder", 10);
        Assertions.assertEquals(10, punten.getPunten());
    }
}
