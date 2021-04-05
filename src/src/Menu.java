import java.util.*;

public class Menu {
    private final Scanner READER = new Scanner(System.in);

    // Alle studenten.
    private final ArrayList<Student> STUDENTENLIJST = new ArrayList<Student>();
    
    // Lijst met alle examens.
    private final ExamenVerzameling EXAMENVERZAMELING = new ExamenVerzameling();
    private final ArrayList<Examen> ALLEEXAMENS = EXAMENVERZAMELING.getAlleExamens();

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
                showExamens();
                break;
            case "2":
                showSTUDENTENLIJST();
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
                if (Poging.getPogingenVanStudenten().isEmpty()) {
                    System.out.println("Er is nog niemand.");
                } else {
                    System.out.println(studentMetMeesteVoldoendes());
                }
                break;
            case "7":
                // Als er geen studenten ingeschreven zijn, geef de optie om in te schrijven.
                if (STUDENTENLIJST.isEmpty()) {
                    System.out.print("Er zijn geen studenten! Wil je je inschrijven? (Ja/Nee) ");
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
     */
    public void showExamens() {
        for (Examen examen : ALLEEXAMENS) {
            System.out.println(
                    "[Vak: " + examen.getNaam() + ", " +
                    "Aantal vragen: " + examen.getVragen().size() + "]"
            );
        }
    }

    /**
     * Laat een lijst zien van alle studenten in het programma.
     */
    public void showSTUDENTENLIJST() {
        for (int i = 0; i < STUDENTENLIJST.size(); i++) {
            System.out.println("[" + (i+1) + "]" + " " + STUDENTENLIJST.get(i).getNaam() + " " + STUDENTENLIJST.get(i).getStudentenNummer());
        }
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
        showExamens();

        // Vraag welke de student wil doen.
        System.out.print("Welk examen wil je doen? Type de naam in: ");
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

        Poging.voegToeAanPogingen(poging);
    }

    /**
     * Deze methode checkt of de ingevoerde examen aanwezig is in het programma.
     * @param examenKeuze invoer van gebruiker.
     * @return true of false
     */
    public boolean isExamenKeuzeAanwezig(String examenKeuze) {
        boolean r = false;
        for (Examen examen : ALLEEXAMENS) {
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
        showSTUDENTENLIJST();

        // Student kan aan de hand van het nummertje voor hun naam zichzelf kiezen.
        System.out.print("Wie ben je? Voer het nummer voor je naam in: ");
        int studentKeuze = READER.nextInt();
        READER.nextLine();

        // Als het nummer te laag of te hoog is, vraag opnieuw om invoer.
        while (studentKeuze > STUDENTENLIJST.size() || studentKeuze <= 0) {
            System.out.print("Ongeldige keuze, voer het nog een keer in: ");
            studentKeuze = READER.nextInt();
            READER.nextLine();
        }

        // Selecteer de student uit de lijst.
        examenNemer = STUDENTENLIJST.get(studentKeuze - 1);
    }

    /**
     * Laat zien waar de student voor geslaagd is.
     */
    public void studentGeslaagdVoor() {
        identiteitStudentKiezen();

        System.out.println("Je bent geslaagd voor: ");
        for (Poging p : Poging.getPogingenVanStudenten()) {
            if (p.getStudent().equals(examenNemer) && p.getGeslaagd()) {
                System.out.println(p.getExamen().getNaam() + " met " + p.getBehaaldePunten() + " punten.");
            }
        }
    }

    /**
     * Deze methode laat zien, welke student de meeste examens heeft gehaald.
     *
     * Algoritme:
     * 0. Maak een kopie van pogingenVanStudenten.
     *     0.1 Maak de volgende variabelen aan.
     *         0.1.1 mvpTemp: String
     *         0.1.2 mvp: String
     *         0.1.3 mvpTempCount: int
     *         0.1.4 mvpCount: int
     *         0.1.5 vorigePoging: poging
     * 1. Selecteer een poging object uit de ArrayList en sla deze op in vorigePoging.
     * 2. Haal de naam van de bijbehorende student op en sla deze op in mvpTemp.
     * 3. Is de instance variabele "geslaagd" van poging true?
     *     3.1 Ja, tel dan 1 op bij mvpTempCount.
     *     3.2 Nee, doe niets.
     * 4. Verwijder poging van vorigePoging uit de ArrayList.
     *     4.1 Selecteer de volgende object uit de ArrayList.
     * 5. Haal de naam van de bijbehorende student op. Is deze hetzelfde als in mvpTemp?
     *     5.1 Ja, ga naar stap 3.
     *     5.2 Nee, ga naar stap 6.
     * 6. Is het einde van de ArrayList bereikt?
     *     6.1 Is mvpTempCount hoger dan mvpCount?
     *         6.1.1 Ja, sla mvpTempCount op in mvpCount.
     *             6.1.1.1 Sla de studentennaam op in mvp.
     *         6.1.2 Nee, doe niks.
     *     6.2 Reset mvpTempCount.
     *     6.3 Reset mvpTemp.
     *     6.4 Ga weer naar 1.
     *
     * @return student met meest behaalde examens.
     */
    public String studentMetMeesteVoldoendes() {
        // Maak een kopie van alle pogingen, zodat de originele onaangetast blijft.
        ArrayList<Poging> kopiePogingen = new ArrayList<Poging>(Poging.getPogingenVanStudenten());

        // De huidige student waarvoor de loop het aantal geslaagde examens bijhoudt.
        String mvpTemp = kopiePogingen.get(0).getStudent().getNaam();

        // De uiteindelijke "MVP".
        String mvp = "";

        // Tijdelijke counter.
        int mvpTempCount = 0;

        // De hoogste score komt hier te staan.
        int mvpCount = 0;

        Poging vorigePoging;

        for (int i = 0; i < kopiePogingen.size(); i++) {
            Poging poging = kopiePogingen.get(i);
            vorigePoging = poging;

            // Als de naam van het huidige student object overeenkomt,
            // met wat er in mvpTemp staat, dan
            if (poging.getStudent().getNaam().equals(mvpTemp)) {
                // check of hij/zij geslaagd is.
                if (poging.getGeslaagd()) {
                    mvpTempCount++;
                }
            }

            // Verwijder de huidige poging object,
            // zodat als we later weer door de lijst gaan loopen,
            // dat we geen rekening hoeven te houden met de huidige poging object.
            // Zeg maar zoiets als "trial by elimination".
            kopiePogingen.remove(vorigePoging);

            // Aangekomen bij het einde van de array?
            if (i == kopiePogingen.size() - 1) {
                // Check of de het aantal geslaagde examens van deze student
                // hoger is dan wat er in de mvpCount staat.
                if (mvpTempCount >= mvpCount) {
                    mvpCount = mvpTempCount;

                    // Zijn/haar naam wordt dan ook in mvp gezet.
                    mvp = mvpTemp;
                }
                // Reset alles weer, en begin weer van voren af aan.
                mvpTempCount = 0;
                i = 0;
                mvpTemp = kopiePogingen.get(0).getStudent().getNaam();
            }
        }

        // Toont alleen maar één persoon. Het kan zijn dat twee of meer personen
        // geslaagd zijn voor hetzelfde aantal examens, maar dat werd te complex (als dat als niet is),
        // dus heb ik dat maar opgegeven.
        String deBeste = mvp + " is met " + mvpCount + " punt(en) de beste.";
        return deBeste;
    }

    /**
     * Gebruiker moet eerst een studentennummer invullen.
     * Daarna hun naam.
     */
    public void studentInschrijven() {
        // Vraag om de naam.
        System.out.print("Vul jouw naam in: ");

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

        // Maak een nieuw studenten object aan en voeg het toe aan de STUDENTENLIJST.
        Student student = new Student(studentenNaam, studentenNummer);
        STUDENTENLIJST.add(student);
    }

    /**
     * Check of een studentennummer uniek is.
     * @param studentenNummer studentennummer van student.
     * @return true of false
     */
    public boolean isStudentenNummerUniek(String studentenNummer) {
        boolean isUniek = false;
        for (Student student : STUDENTENLIJST) {
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
        if (STUDENTENLIJST.size() != 0) {
            // Als de lijst niet leeg is, vraag om input.
            System.out.print("Vul jouw naam in: ");
            String studentenNaam = READER.nextLine();

            // Student wordt verwijderd met een "Predicative" (iets met logica).
            if (STUDENTENLIJST.removeIf(student -> student.getNaam().equals(studentenNaam))) {
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
}
