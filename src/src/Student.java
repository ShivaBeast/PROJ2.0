import java.util.Scanner;

public class Student {

    private String name;
    private String studentNummer;

    public Student(String name,String studentNummer){
        this.name = name;
        this.studentNummer = studentNummer;
    }

    public Student(){
    };

    public String getName(){
        return this.name;
    }

    public String getStudentNummer() {
        return this.studentNummer;
    }
}

    public void inloggen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer je naam in: ");
        this.name = scanner.nextLine();
        System.out.println("Voer je studentnummer in: ");
        this.studentNummer = scanner.nextLine();
        while(!checkStudentNummerLength(this.studentNummer)){
            System.out.println("Een student nummer is 1 - 8 karakters lang. Voer opnieuw in: ");
            this.studentNummer = scanner.nextLine();
         }
        System.out.printf("Inloggen succcesvol. Naam: %s, studentnummer: %s",this.name,this.studentNummer);
    }

    public boolean checkStudentNummerLength(String studentNummer){
        if(studentNummer.length() <= 0 || studentNummer.length() > 8){
            return false;
        }
        return true;
    }
}
