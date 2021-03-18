import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static ArrayList<String> StudentenLijst = new ArrayList<String>();
    private Scanner reader = new Scanner(System.in);
    private ExamenDatabase examenDatabase = new ExamenDatabase();

    // Deze methode toont het menu
    public void showMenu() {
        //ASCII text source: https://fsymbols.com/generators/carty/
        System.out.println("\n" +
            "░█─░█ █▀▀█ █▀▀█ █▀▀▀ █▀▀ █▀▀ 　 ░█─░█ █▀▀█ █▀▀▀ █▀▀ 　 ░█▀▀▀█ █▀▀ █──█ █▀▀█ █▀▀█ █── \n" +
            "░█▀▀█ █▄▄█ █▄▄█ █─▀█ ▀▀█ █▀▀ 　 ░█▀▀█ █──█ █─▀█ █▀▀ 　 ─▀▀▀▄▄ █── █▀▀█ █──█ █──█ █── \n" +
            "░█─░█ ▀──▀ ▀──▀ ▀▀▀▀ ▀▀▀ ▀▀▀ 　 ░█─░█ ▀▀▀▀ ▀▀▀▀ ▀▀▀ 　 ░█▄▄▄█ ▀▀▀ ▀──▀ ▀▀▀▀ ▀▀▀▀ ▀▀▀");

        System.out.println("\n1. Lijst met examens");
        System.out.println("2. Lijst met studenten");
        System.out.println("3. Student inschrijven");
        System.out.println("4. Student Uitschrijven");
        System.out.println("5. Welke examens heeft student gehaald?");
        System.out.println("6. Welke student heeft de meeste examens gehaald?");
        System.out.println("7. Examen afnemen");
        System.out.println("8. Afsluiten");
        System.out.print("Voer je keuze in: ");
    }

    //Deze methode verkrijgt de invoer van de gebruiker en stuurt hem in het volgende scherm
    public void getChoice(String keuze) {
        switch (keuze) {
            case "1":
                getExams();
                break;
            case "2":
                System.out.println(getStudents());
                break;
            case "3":
                studentInschrijven();
                break;
            case "4":
                studentUitschrijven();
                break;
            case "5":
                System.out.println("Student Wishal Heeft alle examens gehaald.");
                break;
            case "6":
                System.out.println("Student Wishal Heeft de meeste examens gehaald");
                break;
            case "7":
                System.out.println("Examen afnemen");
                break;
            case "8":
                break;
            default:
                System.out.println("\033[1;31m" + "\nWAARSCHUWING! '" + keuze + "' bestaat niet!\n" + "\033[0m" + "Voer een geldig getal in.");
        }
    }

    /**
     * Laat een lijst zien van alle examens die toegevoegd zijn aan het programma.
     */
    public void getExams() {
        for (Examen examen : examenDatabase.getAlleExamens()) {
            System.out.println(
                "\n\t\t\tnaam: " + examen.getNaam() + "\n" +
                "tijd om te maken: " + examen.getTijdOmTeMaken() + " minuten\n" +
                "   voldoende bij: " + examen.getVoldoendeBij() + " punten of meer\n" +
                "   aantal vragen: " + examen.getVragen().size());
        }
    }

    public ArrayList<String> getStudents() {
        System.out.println("Lijst Studenten:");
        return StudentenLijst;
    }



    public void studentInschrijven() {
        for (int i = 0; i < 2500; i++) {
            System.out.println("Vul uw studentnummer in");
            String studentNummer = reader.nextLine();

            while (studentNummer.matches("^[a-zA-Z]+$")) {
                System.out.println("Vul uw studentnummer in");
                studentNummer = reader.next();
            }

            // TODO : studentNummer <= 8

            if (!StudentenLijst.contains(studentNummer)) {
                System.out.println("Vul uw naam in");

                String studentNaam = reader.nextLine();

                while (!studentNaam.matches("^[a-zA-Z]+$")) {
                    System.out.println("Vul uw naam in");
                    studentNaam = reader.next();
                }

                StudentenLijst.add(studentNummer + " " + studentNaam);
                System.out.println(studentNaam + ", U bent succesvol ingeschreven.");
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
            while (!StudentenLijst.contains(studentNummer)) {
                System.out.println(StudentenLijst.get(i) + ", U bent succesvol uitgeschreven.");
                StudentenLijst.remove(i);
                System.out.println(StudentenLijst); // Check, can be removed later
            }
        }
        if (!StudentenLijst.contains(studentNummer)) {
            System.out.println("U was niet ingeschreven");
        }
    }
}
