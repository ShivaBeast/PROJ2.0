import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testCheckStudentNummerLength {

    @Test
    public void testCheckStudentNummerLength_InputZero_ReturnsFalse() {
        String input = "";
        boolean result = Student.checkLengteStudentenNummer(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputOne_ReturnsTrue() {
        String input = "5";
        boolean result = Student.checkLengteStudentenNummer(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputFive_ReturnsTrue() {
        String input = "12345";
        boolean result = Student.checkLengteStudentenNummer(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputEight_ReturnsTrue() {
        String input = "12345678";
        boolean result = Student.checkLengteStudentenNummer(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputNine_ReturnsFalse() {
        String input = "123456789";
        boolean result = Student.checkLengteStudentenNummer(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputTwentyThree_ReturnsFalse() {
        String input = "12345671234567123456712";
        boolean result = Student.checkLengteStudentenNummer(input);
        Assertions.assertFalse(result);
    }
}
