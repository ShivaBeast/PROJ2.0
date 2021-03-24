import java.util.ArrayList;

public class Student {
    private String naam;
    private String studentenNummer;
    private ArrayList<Afname> afnamen = new ArrayList<Afname>();

    public Student(String naam,String studentenNummer){
        this.naam = naam;
        this.studentenNummer = studentenNummer;
    }

    public Student() {
        this("", "");
    }

    public static boolean checkLengteStudentenNummer(String studentenNummer) {
        return studentenNummer.length() > 0 && studentenNummer.length() <= 8;
    }

    public void setAfname(ArrayList<Afname> afnamen) {
        this.afnamen = afnamen;
    }

    public ArrayList<Afname> getAfnamen() {
        return afnamen;
    }

    public void voegToeAanAfnamen(Afname afname) {
        afnamen.add(afname);
    }

    public String getNaam(){
        return naam;
    }

    public String getStudentenNummer() {
        return studentenNummer;
    }
}
