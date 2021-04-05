import java.util.Scanner;

public class ExamenAdministratie {
    private final Menu MENU = new Menu();
    private final Scanner READER = new Scanner(System.in);

    /**
     * Hiermee wordt het hele programma gestart.
     */
    public void start() {
        MENU.showMenu();
        String keuze = READER.nextLine();

        while (!keuze.equals("8")) {
            MENU.getChoice(keuze);
            System.out.print("\nVoer je keuze in: ");
            keuze = READER.nextLine();
        }

        stop();
    }

    /**
     * Print alleen een berichtje uit bij het stoppen van dit programma.
     */
    private void stop() {
        System.out.println("Exit");
    }
}
