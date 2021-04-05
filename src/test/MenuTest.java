import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {


    @Test
    void testShowStudentenLijst() {
        Menu menu1 = new Menu();
        ArrayList<Student> studentenLijst = new ArrayList<Student>();

        Student student1 = new Student("Wishal Toekoen", "19105843");
        Student student2 = new Student("Rowin Hartog", "20581919");
        studentenLijst.add(student1);
        studentenLijst.add(student2);

        menu1.setStudentenLijst(studentenLijst);
        Assertions.assertEquals
                ("\n[1] Wishal Toekoen 19105843\n" + "[2] Rowin Hartog 20581919", menu1.showStudentenLijst());

    }

    @Test
    void testIsExamenKeuzeAanwezig() {
        Menu menu1 = new Menu();
        Assertions.assertTrue(menu1.isExamenKeuzeAanwezig("Examen 1"));
    }

    @Test
    void testIsStudentenNummerUniek() {
        Menu menu1 = new Menu();
        ArrayList<Student> studentenLijst = new ArrayList<Student>();
        Student student = new Student("Wishal Toekoen", "19105843");
        Student student2 = new Student("Rowin Hartog", "20581919");

        studentenLijst.add(student);
        studentenLijst.add(student2);
        menu1.setStudentenLijst(studentenLijst);

        Assertions.assertTrue(menu1.isStudentenNummerUniek(student2.getStudentenNummer()));
    }

    @Test
    public void testShowExamens() {
        Menu menu1 = new Menu();
        Assertions.assertEquals("[Vak: Examen 1, Aantal vragen: 10]\n" +
                                         "[Vak: Examen 2, Aantal vragen: 10]\n", menu1.showExamens());
    }
}


