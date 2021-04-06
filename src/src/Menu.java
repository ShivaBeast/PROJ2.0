import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private final Scanner READER = new Scanner(System.in);

    // Alle studenten.
    private ArrayList<Student> studentenlijst = new ArrayList<>();

    // Lijst met alle examens.
    private final ExamenVerzameling EXAMENVERZAMELING = new ExamenVerzameling();
    private final ArrayList<Examen> ALLE_EXAMENS = EXAMENVERZAMELING.getAlleExamens();

    private Examen afTeNemenExamen = new Examen();
    private Student examenNemer = new Student();
    private Poging poging = new Poging(false);

    /**
     * Deze methode toont het menu.
     */
    public void showMenu() {
        // ASCII text source: https://fsymbols.com/generators/carty/
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

    /**
     * Deze methode krijgt de input van de gebruiker en stuurt hem naar het volgende scherm.
     * @param keuze keuze van de gebruiker.
     */
    public void getChoice(String keuze) {
        switch (keuze) {
            case "1":
                System.out.println("\n" + showExamens());
                break;
            case "2":
                System.out.println(showStudentenlijst());
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
                studentMetMeesteVoldoendes();
                break;
            case "7":
                // Als er geen studenten ingeschreven zijn, geef de optie om in te schrijven.
                if (studentenlijst.isEmpty()) {
                    System.out.print("\nEr zijn geen studenten! Wil je je inschrijven? (Ja/Nee) ");
                    String inschrijven = READER.nextLine().toLowerCase(Locale.ROOT);
                    if (inschrijven.equals("ja")) {
                        studentInschrijven();
                    }
                } else {
                    poging = nieuwePoging();
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
     * @return alle examens
     */
    public String showExamens() {
        String exams = "";
        for (int i = 0; i < ALLE_EXAMENS.size(); i++) {
            Examen examen = ALLE_EXAMENS.get(i);

            if (i == ALLE_EXAMENS.size() - 1) {
                exams += "[Vak: " + examen.getNaam() + ", " + "Aantal vragen: " + examen.getVragen().size() + "]";
            } else {
                exams += "[Vak: " + examen.getNaam() + ", " + "Aantal vragen: " + examen.getVragen().size() + "]\n";
            }
        }
        return exams;
    }

    /**
     * Laat een lijst zien van alle studenten in het programma.
     * @return studentenlijst
     */
    public String showStudentenlijst() {
        String students = "";
        for (int i = 0; i < studentenlijst.size(); i++) {
            students += "\n[" + (i+1) + "]" + " " + studentenlijst.get(i).getNaam() + " " + studentenlijst.get(i).getStudentenNummer();
        }
        return students;
    }

    /**
     * Maak een nieuwe poging object, want als dit niet gedaan wordt,
     * blijft het programma steeds met dezelfde object werken.
     * @return nieuwe Poging object.
     */
    public Poging nieuwePoging() {
        return new Poging(false);
    }

    /**
     * Deze methode vergaart alle informatie die er nodig zijn om een examen te doen.
     * Er zal eerst gevraagd worden welk examen een student wil doen.
     * Daarna wordt er gevraagd wie de student is.
     */
    public void infoVoorExamenDoen() {
        // Toon alle beschikbare examens.
        System.out.println("\n" + showExamens());

        // Vraag welke de student wil doen.
        System.out.print("\nWelk examen wil je doen? Type de naam in: ");
        String examenKeuze = READER.nextLine();

        // Als het examen niet aanwezig is, wordt nog een keer om een invoer gevraagd.
        while (!isExamenKeuzeAanwezig(examenKeuze)) {
            System.out.print("Ongeldige invoer, probeer het nog een keer: ");
            examenKeuze = READER.nextLine();
            isExamenKeuzeAanwezig(examenKeuze);
        }

        // Geef aan welk examen een student gaat maken tijdens deze afname.
        poging.setExamen(afTeNemenExamen);

        // Gebruiker zichzelf selecteren.
        identiteitStudentKiezen();
        poging.setStudent(examenNemer);

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
            String antwoord = READER.nextLine();
            System.out.println();

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

        examenNemer.voegToeAanPogingen(poging);
        afTeNemenExamen.voegToeAanPogingen(poging);
    }

    /**
     * Deze methode checkt of de ingevoerde examen aanwezig is in het programma.
     * @param examenKeuze invoer van gebruiker.
     * @return true of false
     */
    public boolean isExamenKeuzeAanwezig(String examenKeuze) {
        boolean r = false;
        for (Examen examen : ALLE_EXAMENS) {
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
        // Toon de lijst met alle ingeschreven studenten.
        System.out.println(showStudentenlijst());

        // Student kan aan de hand van het nummertje voor hun naam zichzelf kiezen.
        System.out.println();
        System.out.print("Wie ben je? Voer het nummer voor je naam in: ");
        int studentKeuze = READER.nextInt();
        READER.nextLine();
        System.out.println();

        // Als het nummer te laag of te hoog is, vraag opnieuw om invoer.
        while (studentKeuze > studentenlijst.size() || studentKeuze <= 0) {
            System.out.print("Ongeldige keuze, voer het nog een keer in: ");
            studentKeuze = READER.nextInt();
            READER.nextLine();
        }

        // Selecteer de student uit de lijst en sla hem/haar op in examenNemer.
        examenNemer = studentenlijst.get(studentKeuze - 1);
    }

    /**
     * Laat zien waar de student voor geslaagd is.
     * @returns examens waarvoor de student geslaagd is
     */
    public void studentGeslaagdVoor() {
        // Laat de gebruiker eerst zijn/haar eigen profiel kiezen.
        identiteitStudentKiezen();

        ArrayList<Poging> pogingenVanStudent = examenNemer.getPogingen();

        String geslaagdVoor = "";
        if (pogingenVanStudent.isEmpty()) {
            geslaagdVoor = "Je hebt nog geen examens gemaakt.";
        } else {
            geslaagdVoor = "Je bent geslaagd voor:\n";

            for (int i = 0; i < pogingenVanStudent.size(); i++) {
                Poging poging = pogingenVanStudent.get(i);

                if (poging.getGeslaagd()) {
                    if (i == pogingenVanStudent.size() - 1) {
                        geslaagdVoor += "\t- " + poging.getExamen().getNaam() + " met " + poging.getBehaaldePunten() + " punten";
                    } else {
                        geslaagdVoor += "\t- " + poging.getExamen().getNaam() + " met " + poging.getBehaaldePunten() + " punten\n";
                    }
                }
            }
        }

        System.out.println(geslaagdVoor);
    }

    /**
     * Laat de student met de meeste geslaagde examens zien.
     * @return naam van de student met aantal geslaagde examens.
     */
    public void studentMetMeesteVoldoendes() {
        int tempGeslaagdTeller = 0;
        int geslaagdTeller = 0;
        String mvp = "";

        // Ga elke student uit de lijst een voor een af.
        for (Student student : studentenlijst) {
            ArrayList<Poging> pogingen = student.getPogingen();

            // Als een student pogingen heeft gedaan,
            if (!pogingen.isEmpty()) {
                for (Poging poging : pogingen) {
                    // kijk dan of een poging geslaagd is,
                    // zo ja, tel het op bij tempGeslaagdTeller.
                    if (poging.getGeslaagd()) { tempGeslaagdTeller++; }
                }
            }

            // Vergelijk nu wat in tempGeslaagdTeller staat met het getal in geslaagdTeller.
            // Als het hoger is dan geslaagdTeller, vervang het.
            // En sla de naam op van die student.
            if (tempGeslaagdTeller > geslaagdTeller) {
                geslaagdTeller = tempGeslaagdTeller;
                mvp = student.getNaam() + " met " + geslaagdTeller + " geslaagde examens.";
            }

            tempGeslaagdTeller = 0;
        }

        System.out.println(mvp);
    }

    /**
     * Gebruiker moet eerst een studentennummer invullen.
     * Daarna hun naam.
     */
    public void studentInschrijven() {
        // Vraag om de naam.
        System.out.print("\nVul jouw naam in: ");

        // Haal de whitespaces weg voor en na de naam.
        String studentenNaam = READER.nextLine().trim();

        // Als de naam niet overeenkomt met de verwachte karakterpatroon
        // in dit geval: alfabetische karakters, dan wordt aan de gebruiker
        // nog een keer om input gevraagd.
        while (!studentenNaam.matches("^[a-zA-Z ]+$")) {
            System.out.print("Niet toegestaan, vul je naam nog een keer in: ");
            studentenNaam = READER.nextLine().trim();
        }

        // Vraag om de studentennummer.
        System.out.print("Vul jouw studentennummer in: ");
        String studentenNummer = READER.nextLine().trim();

        // Hetzelfde als bij naam, maar hierbij wordt gecheckt of de input wel
        // overeenkomt met alfabetische karakters (want het moeten cijfers zijn).
        // Daarnaast wordt gecheckt of de lengte toegestaan is en of het nummer al wel of niet
        // voorkomt in het programma.
        while (studentenNummer.matches("^[a-zA-Z]+$") || !Student.checkLengteStudentenNummer(studentenNummer) || isStudentenNummerUniek(studentenNummer)) {
            System.out.print("Niet toegestaan, vul het nog een keer in: ");
            studentenNummer = READER.nextLine().trim();
        }

        // Maak een nieuw studenten object aan en voeg het toe aan de studentenlijst.
        Student student = new Student(studentenNaam, studentenNummer);
        studentenlijst.add(student);
    }

    /**
     * Check of een studentennummer uniek is.
     * @param studentenNummer studentennummer van student.
     * @return true of false
     */
    public boolean isStudentenNummerUniek(String studentenNummer) {
        boolean isUniek = false;
        for (Student student : studentenlijst) {
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
        if (studentenlijst.size() != 0) {
            // Als de lijst niet leeg is, vraag om input.
            System.out.print("Vul jouw naam in: ");
            String studentenNaam = READER.nextLine();

            // Student wordt verwijderd met een "Predicative" (iets met logica).
            if (studentenlijst.removeIf(student -> student.getNaam().equals(studentenNaam))) {
                System.out.println("Succesvol uitgeschreven.");
            } else {
                // Methode roept zichzelf nog een keer aan, als er wat fout ging.
                // Dit heet "recursie".
                System.out.println("Er ging wat mis.");
                studentUitschrijven();
            }
        } else {
            // Als de lijst leeg is, toon dit.
            System.out.println("Geen studenten om uit te schrijven.");
        }
    }

    /**
     * Setter voor studentenlijst.
     * @param studentenlijst een lijst van studenten
     */
    public void setStudentenlijst(ArrayList<Student> studentenlijst) {
        this.studentenlijst = studentenlijst;
    }
}
