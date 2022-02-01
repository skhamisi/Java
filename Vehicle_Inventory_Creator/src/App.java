import java.io.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        do {

            Util.clearScreen();
            System.out.println(Util.YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\nCURRENT TIME: " + Util.date + "\n\n" + Util.RESET);
            
            System.out.println("INVENTORY OPTIONS");
            System.out.println("=======================*");
            System.out.println("1. Add Vehicle         |");
            System.out.println("2. Remove Vehicle      |");
            System.out.println("3. Update Vehicle      |");
            System.out.println("4. Print Vehicle List  |");
            System.out.println("5. Exit                |");
            System.out.println("=======================*\n");

            System.out.print("\nENTER CHOICE: ");
            int userChoice = Util.scan.nextInt();

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
                Util.scan.close();
                System.exit(0);
                break;
                default:
                    System.out.println(Util.RED + "\nInvalid choice" + Util.RESET);
                    Util.PressEnter();
            }

        } while (true);
    }
}
