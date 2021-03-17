import java.util.ArrayList;
import java.util.Scanner;

class Menu {

    public static Boolean firstRun = true;
    public static ArrayList<String> StudentenLijst = new ArrayList<>();
    Scanner reader = new Scanner(System.in);


    //Deze methode toont het menu
    public void showMenu() {

        if(!firstRun){
            System.out.println("\n\nDruk op een toets om door te gaan...");
            reader.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n");
        }
        firstRun = false;


        //ASCII text source: https://fsymbols.com/generators/carty/
        System.out.println("\n" +
            "░█─░█ █▀▀█ █▀▀█ █▀▀▀ █▀▀ █▀▀ 　 ░█─░█ █▀▀█ █▀▀▀ █▀▀ 　 ░█▀▀▀█ █▀▀ █──█ █▀▀█ █▀▀█ █── \n" +
            "░█▀▀█ █▄▄█ █▄▄█ █─▀█ ▀▀█ █▀▀ 　 ░█▀▀█ █──█ █─▀█ █▀▀ 　 ─▀▀▀▄▄ █── █▀▀█ █──█ █──█ █── \n" +
            "░█─░█ ▀──▀ ▀──▀ ▀▀▀▀ ▀▀▀ ▀▀▀ 　 ░█─░█ ▀▀▀▀ ▀▀▀▀ ▀▀▀ 　 ░█▄▄▄█ ▀▀▀ ▀──▀ ▀▀▀▀ ▀▀▀▀ ▀▀▀");
        System.out.println("1. Lijst met examens ");
        System.out.println("2. Lijst met studenten ");
        System.out.println("3. Student inschrijven ");
        System.out.println("4. Student Uitschrijven ");
        System.out.println("5. Welke examens heeft student gehaald? ");
        System.out.println("6. Welke student heeft de meeste examens gehaald?");
        System.out.println("7. Examen afnemen ");
        System.out.println("8. Exit");
        System.out.println("Voer je keuze in:");
        String invoer = reader.nextLine();
        getChoice(invoer);
    }

    //Deze methode verkrijgt de invoer van de gebruiker en stuurt hem in het volgende scherm
    public void getChoice(String keuze) {
        switch (keuze) {
            case "1":
                getExams();
                break;
            case "2":
                getStudents();
                break;
            case "3":
                studentInschrijven();
                break;
            case "4":
                studentUitschrijven();
                break;
            case "5":
                System.out.println("Student Wishal Heeft alle examens gehaald.");
                this.showMenu();
                break;
            case "6":
                System.out.println("Student Wishal Heeft de meeste examens gehaald");
                this.showMenu();
                break;
            case "7":
                System.out.println("Examen afnemen");
                this.showMenu();
                break;
            case "8":
                System.out.println("Exit");
                break;
            default:
                System.out.println("\033[1;31m" + "\nWAARSCHUWING! '" + keuze + "' bestaad niet!\n" + "\033[0m" + "Voer een geldig getal in.");
                this.showMenu();

        }
    }

    public void getExams() {
        System.out.println("Lijst Examens:");
        //TODO Functie afmaken

        this.showMenu();

    }

    public void getStudents() {
        System.out.println("Lijst Studenten:");
        //TODO Functie afmaken

        this.showMenu();
    }

    public void studentInschrijven() {

        for (int i = 0; i < 2500; i++) {
            System.out.println("Vul uw studentnummer in");
            String studentNummer = reader.nextLine();

            // TODO : studentNummer <= 8
            // TODO : Opslaan naam bij studentnummer

            if (!StudentenLijst.contains(studentNummer)) {
                System.out.println("Vul uw naam in");
                String studentNaam = reader.nextLine();

                StudentenLijst.add(studentNummer);
                System.out.println(studentNaam + ", U bent succesvol ingeschreven.");
                this.showMenu();
                break;

            } else {
                System.out.println("Dit studentennummer is al ingeschreven, probeer het opnieuw.");
            }
        }
    }


    public void studentUitschrijven(){
        System.out.println("Vul uw studentnummer in");
        String studentNummer = reader.nextLine();

        for (int i = 0; i < StudentenLijst.size(); i++) {
            while (StudentenLijst.get(i).equals(studentNummer)) {
                StudentenLijst.remove(i);
                System.out.println("U bent succesvol uitgeschreven");
                System.out.println(StudentenLijst); // Check, can be removed later
                this.showMenu();

            }
        }
        if (!StudentenLijst.contains(studentNummer)) {
            System.out.println("U was niet ingeschreven");
            this.showMenu();

        }
    }
}
