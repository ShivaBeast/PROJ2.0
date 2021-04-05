import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class PogingTest {

    //test getGeslaagd() denk ik idk
    @Test
    public void TestPoging(){
        ArrayList<Poging> pogingenVanStudenten = new ArrayList<>();
        Poging poging = new Poging(true);
        pogingenVanStudenten.add(poging);
        Poging poging2 = pogingenVanStudenten.get(0);
        Assertions.assertTrue(poging2.getGeslaagd());
    }


}