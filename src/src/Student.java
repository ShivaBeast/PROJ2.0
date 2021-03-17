import java.util.Scanner;


class Student {
    public static void main(String[] args) {

    }
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

    public void inloggen(){
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        while(studentNummer.length() <= 0 || studentNummer.length() > 8){
            this.studentNummer = scanner.nextLine();
        }
    }
}