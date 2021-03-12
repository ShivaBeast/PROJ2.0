public class Vraag {
    private String vraag;
    private String antwoord;
    private int nummer;
    private String mcvraag;
    private char mcantwoord;
    private int punten;

    public Vraag(String vraag, String antwoord, int punten){

        this.vraag = vraag;
        this.antwoord = antwoord;
        this.punten = punten;

    }

    public Vraag(int nummer, String mcvraag, char mcantwoord, int punten){

        this.nummer = nummer;
        this.mcvraag = mcvraag;
        this.mcantwoord = mcantwoord;
        this.punten = punten;

    }

    public String getVraag() { return vraag; }

    public String getAntwoord() { return antwoord; }

    public int getNummer() { return nummer; }

    public String getMcvraag() { return mcvraag; }

    public char getMcantwoord() { return mcantwoord; }

    public int getPunten() { return punten; }
}