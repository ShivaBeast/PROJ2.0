import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PogingTest {
    private static Poging poging;

    @BeforeAll
    public static void init() {
        poging = new Poging(false);
    }

    @Test
    public void testConstructor() {
        Assertions.assertFalse(poging.getGeslaagd());

        poging.setGeslaagd(true);

        Assertions.assertTrue(poging.getGeslaagd());
    }

    @Test
    public void testVOLDOENDEBIJ() {
        Assertions.assertEquals(55, poging.getVOLDOENDEBIJ());
    }

    @Test
    public void testIsStudentGeslaagd() {
        Assertions.assertTrue(poging.isStudentGeslaagd(100));
        Assertions.assertFalse(poging.isStudentGeslaagd(10));
    }
}