import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final Scanner scan = new Scanner(System.in);

        do {

            Vehicle.clearScreen();
            System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\n\n" + RESET);
            
            System.out.println("INVENTORY OPTIONS");
            System.out.println("=======================*");
            System.out.println("1. Add Vehicle         |");
            System.out.println("2. Remove Vehicle      |");
            System.out.println("3. Update Vehicle      |");
            System.out.println("4. Print Vehicle List  |");
            System.out.println("5. Exit                |");
            System.out.println("=======================*\n");

            System.out.print("\nPlease enter your choice: ");
            int userChoice = scan.nextInt();

            switch (userChoice) {
                case 1:
                    Vehicle.clearScreen();
                    Vehicle.addVehicle();
                    break;
                case 2:
                    Vehicle.clearScreen();
                    Vehicle.removeVehicle();
                    break;
                case 3:
                    Vehicle.clearScreen();
                    Vehicle.updateVehicle();
                    break;
                case 4:
                    Vehicle.clearScreen();
                    Vehicle.printfile();
                    break;
                case 5:
                System.out.println("\nThank you for using the vehicle management system. Goodbye.");
                System.exit(0);
                break;
                default:
                    System.out.println(RED + "\nInvalid choice" + RESET);
                    Vehicle.PressEnter();
            }

            if(userChoice == 4)
                break;

        } while (true);

        PrintWriter pw = new PrintWriter("VEHICLE INVENTORY");
        String text = "Index | Make | Model | Color | Year | Mileage\n---------------------------------------------\n";

        for (AutoMobile auto : Vehicle.vehicleList) {
            text += auto.getIndex() + "     " + auto.getMake() + "   " + auto.getModel() + "   " + auto.getColor()+ "   " + auto.getYear() + "   " + auto.getMileage() + " mi." + "\n";
        }

        pw.write(text);
        pw.flush();
        pw.close();

        System.out.println(GREEN + "FILE OUTPUT STATUS: Success" + RESET);
        System.out.println();
        System.out.println(text);

        scan.close();
    }
}
