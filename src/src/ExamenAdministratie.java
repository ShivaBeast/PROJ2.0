import java.util.Scanner;

public class ExamenAdministratie {
    private Menu menu = new Menu();
    private Scanner reader = new Scanner(System.in);

    public void start() {
        menu.showMenu();
        String keuze = reader.nextLine();
        menu.getChoice(keuze);

        stop();
    }

    private void stop() {
        System.out.println("Exit");
    }
}
