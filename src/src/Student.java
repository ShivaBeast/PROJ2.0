import java.util.ArrayList;

public class Student {
    private String naam;
    private String studentenNummer;
    private ArrayList<Feedback> krijgt = new ArrayList<Feedback>();

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

    public void setKrijgt(ArrayList<Feedback> krijgt) {
        this.krijgt = krijgt;
    }

    public ArrayList<Feedback> getKrijgt() {
        return krijgt;
    }

    public void voegFeedbackToe(Feedback feedback) {
        krijgt.add(feedback);
    }

    public String getNaam(){
        return naam;
    }

    public String getStudentenNummer() {
        return studentenNummer;
    }
}
