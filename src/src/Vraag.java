import java.util.ArrayList;

public class Vraag {
    private String vraag;
    private String antwoord;
    private String mcvraag;
    private char mcantwoord;
    private int punten;
    private ArrayList<String> keuzes;

    public Vraag(String vraag, String antwoord, int punten){

        this.vraag = vraag;
        this.antwoord = antwoord;
        this.punten = punten;

    }

    public Vraag(ArrayList<String> keuzes, String mcvraag, char mcantwoord, int punten){

        this.keuzes = keuzes;
        this.mcvraag = mcvraag;
        this.mcantwoord = mcantwoord;
        this.punten = punten;

    }

    public String getVraag() { return vraag; }

    public String getAntwoord() { return antwoord; }

    public ArrayList<String> getKeuzes() { return keuzes; }

    public String getMcvraag() { return mcvraag; }

    public char getMcantwoord() { return mcantwoord; }

    public int getPunten() { return punten; }
}