public class Student {
    private String naam;
    private String studentenNummer;

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

    public String getNaam(){
        return naam;
    }

    public String getStudentenNummer() {
        return studentenNummer;
    }
}
