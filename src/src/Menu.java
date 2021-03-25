import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private final Scanner reader = new Scanner(System.in);
    private ArrayList<Student> studentenLijst = new ArrayList<Student>();
    private ExamenVerzameling examenVerzameling = new ExamenVerzameling();
    private ArrayList<Examen> alleExamens = examenVerzameling.getAlleExamens();

    private Examen afTeNemenExamen = new Examen();
    private Student examenNemer = new Student();
    private Feedback poging = new Feedback(false);

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
        System.out.println("4. Student uitschrijven");
        System.out.println("5. Welke examens heeft een student gehaald?");
        System.out.println("6. Welke student heeft de meeste examens gehaald?");
        System.out.println("7. Examen afnemen");
        System.out.println("8. Afsluiten");
        System.out.print("Voer je keuze in: ");
    }

    //Deze methode verkrijgt de invoer van de gebruiker en stuurt hem in het volgende scherm
    public void getChoice(String keuze) {
        switch (keuze) {
            case "1":
                showExamens();
                break;
            case "2":
                showStudentenLijst();
                break;
            case "3":
                studentInschrijven();
                break;
            case "4":
                studentUitschrijven();
                break;
            case "5":
                studentGeslaagdVoor();
                break;
            case "6":
                System.out.println("Student Wishal Heeft de meeste examens gehaald");
                break;
            case "7":
                // Als er geen studenten ingeschreven zijn, geef de optie om in te schrijven.
                if (studentenLijst.isEmpty()) {
                    System.out.print("Er zijn geen studenten! Wil je je inschrijven? (Ja/Nee) ");
                    String inschrijven = reader.nextLine().toLowerCase(Locale.ROOT);
                    if (inschrijven.equals("ja")) {
                        studentInschrijven();
                    }
                } else {
                    infoVoorExamenDoen();
                }
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
    public void showExamens() {
        for (Examen examen : examenVerzameling.getAlleExamens()) {
            System.out.println(
                    "[Vak: " + examen.getNaam() + ", " +
                    "Aantal vragen: " + examen.getVragen().size() + "]"
            );
        }
    }

    public void showStudentenLijst() {
        for (int i = 0; i < studentenLijst.size(); i++) {
            System.out.println("[" + (i+1) + "]" + " " + studentenLijst.get(i).getNaam() + " " + studentenLijst.get(i).getStudentenNummer());
        }
    }

    /**
     * Deze methode vergaart alle informatie die er nodig zijn om een examen te doen.
     * Er zal eerst gevraagd worden welk examen een student wil doen.
     * Daarna wordt er gevraagd wie de student is.
     */
    public void infoVoorExamenDoen() {
        // Toon alle beschikbare examens.
        showExamens();

        // Vraag welke de student wil doen.
        System.out.print("Welk examen wil je doen? Type de naam in: ");
        String examenKeuze = reader.nextLine();

        // Als het examen niet aanwezig is, wordt nog een keer om een invoer gevraagd.
        while (!isExamenKeuzeAanwezig(examenKeuze)) {
            System.out.print("Ongeldige invoer, probeer het nog een keer: ");
            examenKeuze = reader.nextLine();
            isExamenKeuzeAanwezig(examenKeuze);
        }

        // Geef aan welk examen een student gaat maken tijdens deze afname.
        poging.setOp(afTeNemenExamen);

        // Gebruiker zichzelf selecteren.
        identiteitStudentKiezen();

        // Start het examen.
        examenAfnemen();
    }

    /**
     * Deze methode legt het examen af.
     */
    public void examenAfnemen() {
        poging.setBehaaldePunten(0);
        int behaaldePunten = poging.getBehaaldePunten();

        // Vragen random stellen.
        ArrayList<Vraag> examenVragen = afTeNemenExamen.getVragen();
        Collections.shuffle(examenVragen);

        for (Vraag vraag : examenVragen) {
            // Stel de vraag.
            System.out.println(vraag.getVraag());

            // Als het een meerkeuze vraag is, toon de keuzes.
            if (vraag.getKeuzes() != null) {
                for (String keuze : vraag.getKeuzes()) {
                    System.out.println(keuze);
                }
            }

            // Gebruiker geeft antwoord.
            System.out.print("Jouw antwoord: ");
            String antwoord = reader.nextLine();

            // Als een antwoord goed is, tel het op bij behaalde punten.
            if (vraag.getAntwoord().equals(antwoord)) {
                behaaldePunten += vraag.getPunten();
            }
        }

        // Bij een voldoende, zet geslaagd op true.
        if (poging.isStudentGeslaagd(behaaldePunten)) {
            poging.setGeslaagd(true);
            System.out.println("Je bent geslaagd met " + behaaldePunten + " punten.");
        } else {
            System.out.println("Je bent gezakt met " + behaaldePunten + " punten.");
        }
        poging.setBehaaldePunten(behaaldePunten);

        // Voeg de poging toe bij student.
        // Zodat je later kan zien hoeveel pogingen er gedaan zijn en
        // hoeveel daarvan een voldoende zijn.
        examenNemer.voegFeedbackToe(poging);
    }

    /**
     * Deze methode checkt of de ingevoerde examen aanwezig is in het programma.
     * @param examenKeuze - invoer van gebruiker
     * @return true of false
     */
    public boolean isExamenKeuzeAanwezig(String examenKeuze) {
        boolean r = false;
        for (Examen examen : alleExamens) {
            if (examen.getNaam().equals(examenKeuze)) {
                afTeNemenExamen = examen;
                r = true;
            }
        }
        return r;
    }

    /**
     * Gebruiker kan zichzelf kiezen.
     */
    public void identiteitStudentKiezen() {
        // Vervolgens, toon de lijst met alle ingeschreven studenten.
        showStudentenLijst();

        // Student kan aan de hand van het nummertje voor hun naam zichzelf kiezen.
        System.out.print("Wie ben je? Voer het nummer voor je naam in: ");
        int studentKeuze = reader.nextInt();
        reader.nextLine();

        // Als het nummer te laag of te hoog is, vraag opnieuw om invoer.
        while (studentKeuze > studentenLijst.size() || studentKeuze <= 0) {
            System.out.print("Ongeldige keuze, voer het nog een keer in: ");
            studentKeuze = reader.nextInt();
            reader.nextLine();
        }

        // Selecteer de student uit de lijst.
        examenNemer = studentenLijst.get(studentKeuze - 1);
    }

    /**
     * Laat zien waar de student voor geslaagd is.
     */
    public void studentGeslaagdVoor() {
        identiteitStudentKiezen();

        if (examenNemer.getKrijgt().isEmpty()) {
            // Als de student nog geen examens heeft gedaan.
            System.out.println("Je hebt nog geen examens gedaan.");
        } else {
            System.out.println("Aantal examens gedaan: " + examenNemer.getKrijgt().size());
            System.out.println("Geslaagd voor: ");
            for (Feedback feedback : examenNemer.getKrijgt()) {
                if (feedback.getGeslaagd()) {
                    System.out.println(feedback.getOp().getNaam() + " " + feedback.getBehaaldePunten() + " punten");
                }
            }
        }
    }

    /**
     * Gebruiker moet eerst een studentennummer invullen.
     * Daarna hun naam.
     */
    public void studentInschrijven() {
        System.out.print("Vul jouw naam in: ");
        String studentenNaam = reader.nextLine().trim();
        while (!studentenNaam.matches("^[a-zA-Z ]+$")) {
            System.out.print("Niet toegestaan, vul je naam nog een keer in: ");
            studentenNaam = reader.nextLine().trim();
        }

        System.out.print("Vul jouw studentennummer in: ");
        String studentenNummer = reader.nextLine().trim();

        while (studentenNummer.matches("^[a-zA-Z]+$") || !Student.checkLengteStudentenNummer(studentenNummer) || isStudentenNummerUniek(studentenNummer)) {
            System.out.print("Niet toegestaan, vul het nog een keer in: ");
            studentenNummer = reader.nextLine().trim();
        }

        Student student = new Student(studentenNaam, studentenNummer);
        studentenLijst.add(student);
    }

    /**
     * Check of een studentennummer uniek is.
     * @param studentenNummer - studentennummer
     * @return true of false
     */
    public boolean isStudentenNummerUniek(String studentenNummer) {
        boolean isUniek = false;
        for (Student student : studentenLijst) {
            if (student.getStudentenNummer().equals(studentenNummer)) {
                isUniek = true;
                break;
            }
        }

        return isUniek;
    }

    /**
     * Gebruiker kan op naam zich/haarzelf uitschrijven.
     */
    public void studentUitschrijven() {
        if (studentenLijst.size() != 0) {
            System.out.print("Vul jouw naam in: ");
            String studentenNaam = reader.nextLine();
            if (studentenLijst.removeIf(student -> student.getNaam().equals(studentenNaam))) {
                System.out.println("Succesvol uitgeschreven.");
            } else {
                System.out.println("Er ging wat mis.");
                studentUitschrijven();
            }
        } else {
            System.out.println("Geen studenten om uit te schrijven.");
        }
    }
}
