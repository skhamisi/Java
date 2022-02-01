import java.io.FileNotFoundException;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final Scanner scan = new Scanner(System.in);
        final Date date = new Date();

        do {

            Vehicle.clearScreen();
            System.out.println(YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\nCURRENT TIME: " + date + "\n\n" + RESET);
            
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
        
        scan.close();
    }
}
