    import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testCheckStudentNummerLength {

    @Test
    public void testCheckStudentNummerLength_InputZero_ReturnsFalse() {
        Student student = new Student();
        String input = "";
        boolean result = student.checkStudentNummerLength(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputOne_ReturnsTrue() {
        Student student = new Student();
        String input = "5";
        boolean result = student.checkStudentNummerLength(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputFive_ReturnsTrue() {
        Student student = new Student();
        String input = "12345";
        boolean result = student.checkStudentNummerLength(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputEight_ReturnsTrue() {
        Student student = new Student();
        String input = "12345678";
        boolean result = student.checkStudentNummerLength(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputNine_ReturnsFalse() {
        Student student = new Student();
        String input = "123456789";
        boolean result = student.checkStudentNummerLength(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckStudentNummerLength_InputTwentyThree_ReturnsFalse() {
        Student student = new Student();
        String input = "12345671234567123456712";
        boolean result = student.checkStudentNummerLength(input);
        Assertions.assertFalse(result);
    }
}
