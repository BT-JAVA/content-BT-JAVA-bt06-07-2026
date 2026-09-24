import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kaffeemaschine kaffeemaschine = new Kaffeemaschine();

        while (kaffeemaschine.isEingeschaltet()) {
            System.out.println("Kaffeemaschine einschalten [e], Kaffeemaschine ausschalten [a], " +
                    "Wasser auffüllen [w], Bohnen auffüllen [b], Kaffee kochen [k], Status anzeigen [s]");

            String input = scanner.next().toLowerCase();

            switch (input) {
                case "e" -> kaffeemaschine.einschalten();
                case "a" -> kaffeemaschine.ausschalten();
                case "w" -> {
                    System.out.println("Wie viel Wasser möchten Sie auffüllen");
                    kaffeemaschine.wasserAuffuellen(scanner.nextDouble());
                }
                case "b" -> {
                    System.out.println("Wie viele Bohnen möchten Sie auffüllen");
                    kaffeemaschine.bohnenAuffuellen(scanner.nextInt());
                }

                case "k" -> {
                    System.out.println("Espresso - Latte - Capuccino?");
                    kaffeemaschine.kochen(scanner.next());
                }

                case "s" -> kaffeemaschine.print();
                default -> System.out.println("Fehler: Ungültige Auswahl.");
            }
        }
    }
}
