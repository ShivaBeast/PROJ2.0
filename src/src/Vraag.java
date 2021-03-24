import java.util.ArrayList;

public class Vraag {
    private String vraag;
    private String antwoord;
//    private String mcvraag;
//    private char mcantwoord;
    private int punten;
    private ArrayList<String> keuzes;

    public Vraag() {
        this("", "", 0);
    }

    public Vraag(String vraag, String antwoord, int punten){
        this.vraag = vraag;
        this.antwoord = antwoord;
        this.punten = punten;

    }

    public Vraag(String vraag, ArrayList<String> keuzes, String antwoord, int punten){
        this.keuzes = keuzes;
        this.vraag = vraag;
        this.antwoord = antwoord;
        this.punten = punten;

    }

    public ArrayList<Vraag> vragen() {
        ArrayList<Vraag> open = new ArrayList<>();

        open.add(new Vraag("Wat is het 3e planeet in ons zonnestelsel?", "Aarde", 10));
        open.add(new Vraag("Hoe heet de koning van Nederland?", "Willem Alexander", 10));
        open.add(new Vraag("Wie was de 1e gekleurde president van Amerika?", "Barack Obama", 10));
        open.add(new Vraag("Welk land heeft de meeste bewoners van heel de wereld?", "China", 10));
        open.add(new Vraag("Welk land behoort sinds 2020 niet meer tot de EU?", "Het Verenigd Koninkrijk", 10));
        open.add(new Vraag("Welke wereldwonder bevindt zich in India?", "De Taj Mahal", 10));
        open.add(new Vraag("Wat is de beste vriend van mens?", "De hond", 10));
        open.add(new Vraag("Waar zijn panda beren bekend om?", "Hun kleur", 10));
        open.add(new Vraag("Hoe lang duurt het gemiddeld wanneer een baby geboren is?", "9 maanden", 10));
        open.add(new Vraag("Wie is de huidige president van Amerika?", "Joe Biden", 10));

        return open;
    }

    public ArrayList<Vraag> MCVragen() {
        ArrayList<Vraag> mc = new ArrayList<>();

        mc.add(new Vraag("Hoeveel Megabytes is 1 Gigabyte?", opties("1000", "10", "100","1"), "A", 10));
        mc.add(new Vraag( "Welke smartphone bedrijf behoort niet tot China?", opties("Huawei", "Samsung", "Honor", "Xiaomi"), "B", 10));
        mc.add(new Vraag( "Wat is de hoofdstad van Nederland?", opties("Den Haag", "Amsterdam", "Rotterdam", "Giethoorn"), "B", 10));
        mc.add(new Vraag("Wat is de functie van campers?", opties("Trollen", "Uitschelden", "Helpen", "Boosten"), "A", 10));
        mc.add(new Vraag( "Welke van de 4 personen is de rijkste man ter wereld?", opties("Elon Musk", "Bill Gates", "Jeff Bezos", "Mark Zuckerberg"), "C", 10));
        mc.add(new Vraag( "Welk land werd de 1e die wiet legaliseerde?", opties("Amerika", "Nederland", "Canada", "Singapore"), "C", 10));
        mc.add(new Vraag( "Welke programmeertaal wordt gebruikt voor het bouwen van een website?", opties("Java", "Python", "HTML/CSS", "C#"), "C", 10));
        mc.add(new Vraag( "Welk land behoort niet tot Zuid-Amerika?", opties("Venezuela", "Colombia", "Chile", "Indian"), "D", 10));
        mc.add(new Vraag( "Wie heeft de wereldrecord als de snelste man ter wereld?", opties("Florence Griffith-Joyner", "Usian Bolt", "Tyson Gay", "Mike Rodgers"), "B", 10));
        mc.add(new Vraag( "Hoe heet de zoon van god?",opties("Jezus Christus","Keanu Reeves","Penquinz0","Lucifer Morningstar"), "A", 10));

        return mc;
    }

    public ArrayList<String> opties(String A, String B, String C, String D){
        ArrayList<String> keuzes = new ArrayList<String>();
        keuzes.add("A. " + A);
        keuzes.add("B. " + B);
        keuzes.add("C " + C);
        keuzes.add("D " + D);

        return keuzes;
    }

    public String getVraag() { return vraag; }

    public String getAntwoord() { return antwoord; }

    public ArrayList<String> getKeuzes() { return keuzes; }

//    public String getMcvraag() { return mcvraag; }
//
//    public char getMcantwoord() { return mcantwoord; }

    public int getPunten() { return punten; }
}