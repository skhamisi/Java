import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";
        final Scanner scan = new Scanner(System.in);
        final Date date = new Date();

        do {

            Util.clearScreen();
            System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\nCURRENT TIME: " + date + "\n\n" + RESET);
            
            System.out.println("INVENTORY OPTIONS");
            System.out.println("=======================*");
            System.out.println("1. Add Vehicle         |");
            System.out.println("2. Remove Vehicle      |");
            System.out.println("3. Update Vehicle      |");
            System.out.println("4. Print Vehicle List  |");
            System.out.println("5. Exit                |");
            System.out.println("=======================*\n");

            System.out.print("\nENTER CHOICE: ");
            int userChoice = scan.nextInt();

            switch (userChoice) {
                case 1:
                    Util.clearScreen();
                    Vehicle.addVehicle();
                    break;
                case 2:
                    Util.clearScreen();
                    Vehicle.removeVehicle();
                    break;
                case 3:
                    Util.clearScreen();
                    Vehicle.updateVehicle();
                    break;
                case 4:
                    Util.clearScreen();
                    Vehicle.printfile();
                    break;
                case 5:
                System.out.println("\nThank you for using the vehicle management system. Goodbye.\n");
                scan.close();
                System.exit(0);
                break;
                default:
                    System.out.println(RED + "\nInvalid choice" + RESET);
                    Util.PressEnter();
            }

        } while (true);
    }
}
