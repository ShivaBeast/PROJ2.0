import java.util.Scanner;

public class ExamenAdministratie {
    private Menu menu = new Menu();
    private Scanner reader = new Scanner(System.in);


    public void start() {
        menu.showMenu();
        String keuze = reader.nextLine();

        while (!keuze.equals("8")){
            menu.getChoice(keuze);
            System.out.println("\nDruk op een knop om door te gaan...");
            reader.nextLine();
            menu.showMenu();
            keuze = reader.nextLine();

        }
        stop();
    }
    private void stop() {
        System.out.println("Exit");
    }
}
