import java.util.Scanner;

public class Student {

    private String name;
    private String studentNummer;

    public Student(String name,String studentNummer){
        this.name = name;
        this.studentNummer = studentNummer;
    }

    public String getName(){
        return this.name;
    }

    public String getStudentNummer() {
        return this.studentNummer;
    }
}