import java.util.ArrayList;
import java.util.Scanner;

class Menu {

    String opties[];
    Examen examen[];
    Student student[];
    ArrayList<String> StudentenLijst = new ArrayList<String>();
    Scanner reader = new Scanner(System.in);


    public void showMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Lijst met examens ");
        System.out.println("2. Lijst met studenten ");
        System.out.println("3. Nieuwe student inschrijven ");
        System.out.println("4. Student Uitschrijven ");
        System.out.println("5. Welke examens heeft student gehaald? ");
        System.out.println("6. Welke student heeft de meeste examens gehaald?");
        System.out.println("7. Exit");
        System.out.println("Voer je keuze in:");

        Integer invoer = scanner.nextInt();
        getChoice(invoer);

    }

    public void getChoice(Integer keuze){
        switch (keuze) {
            case 1:
                System.out.println("Lijst examens");
                break;
            case 2:
                System.out.println("Lijst studenten");
                break;
            case 3:
                studentInschrijven();
                break;
            case 4:
//                studentUitschrijven();
                break;
            case 5:
                System.out.println("damn bruh");
                break;
            case 6:
                System.out.println("Student Wishal Heeft de meeste examens gehaald");
                break;
            case 7:
                System.out.println("exit");
                break;
            default:
                System.out.println("Bruh "+keuze +" bestaad niet, voer iets ander in man.");

        }
    }

    public ArrayList<Examen> getExams(){
        return null;

    }

    public ArrayList<Student> getStudents(){
        return null;

    }

    public void studentInschrijven(){

        for (int i = 0; i < 2500; i++) {
            String studentNummer = reader.nextLine();

            if (!StudentenLijst.contains(studentNummer)) {
                System.out.println("Vul uw naam in");
                String studentNaam = reader.nextLine();

                StudentenLijst.add(studentNummer + " " + studentNaam);
                System.out.println("U bent succesvol ingeschreven.");
            } else {
                System.out.println("Deze studenten nummer is al in gebruik, probeer het opnieuw.");
            }
        }
    }

    public void studentUitschrijven(){

    }

}

class Examen{

}

class Student{

}
