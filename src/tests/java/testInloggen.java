import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testInloggen {
    private Student student;

    @BeforeEach
    public void setup(){
        student = new Student("kees","12345678910");
        student.inloggen();
    }

    //werkt niet atm
    @Test
    public void testInloggen(){
        Assertions.assertTrue(student.getStudentNummer().length() <= 8);
        Assertions.assertTrue(student.getStudentNummer().length() > 0);
    }
}
