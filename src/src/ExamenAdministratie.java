import java.util.Scanner;

public class ExamenAdministratie {
    private Menu menu = new Menu();
    private Scanner reader = new Scanner(System.in);

    public void start() {
        menu.showMenu();
        String keuze = reader.nextLine();

        while (!keuze.equals("8")) {
            menu.getChoice(keuze);
            System.out.print("\nVoer je keuze in: ");
            keuze = reader.nextLine();
        }

        stop();
    }

    private void stop() {
        System.out.println("Exit");
    }
}
