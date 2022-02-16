import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {

    // Sets ASCII color values to variables
    static final String RESET = "\u001B[0m";
    static final String RED = "\033[1;31m";
    static final String GREEN = "\033[1;32m";
    static final String CYAN_Bold_Underline = "\033[4;36m" + "\033[1;36m";
    static final String CYAN = "\033[1;36m";
    static final String YELLOW = "\033[1;33m";
    static final LocalDateTime localDateTime = LocalDateTime.now();
    static final DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm:ss");
    static final String date = localDateTime.format(formattedDate);
    public static final String FILENAME = "C:\\Users\\Samer\\Desktop\\AUTO_INVENTORY.txt";
    //static final String FILENAME = "C:\\Users\\Samer.Khamisi\\Documents\\AUTO_INVENTORY.txt";
    static final Scanner scan = new Scanner(System.in);

    // Clears screen of any previous text
    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    // Waits for user to press key before continuing execution
    static void PressEnter()
    { 
        System.out.println(YELLOW + "\nPress [ENTER] to continue" + RESET);
        scan.nextLine();
        scan.nextLine();
    }

    static void PrintHeader() {
        clearScreen();
        System.out.println(CYAN_Bold_Underline + "VEHICLE INVENTORY MANAGEMENT SYSTEM" + RESET);
        System.out.println(CYAN + "CURRENT TIME: "  + date + "\n\n" + RESET);
    }

    static void PrintMenu() {
        do {

            Util.PrintHeader();
            
            System.out.println("INVENTORY OPTIONS");
            System.out.println("=======================*");
            System.out.println("1. Add Vehicle         |");
            System.out.println("2. Remove Vehicle      |");
            System.out.println("3. Update Vehicle      |");
            System.out.println("4. Print Vehicle List  |");
            System.out.println("5. Exit                |");
            System.out.println("=======================*\n");

            System.out.print(CYAN + "\nENTER CHOICE: " + YELLOW);
            int userChoice = scan.nextInt();

            SwitchMenu(userChoice);

        } while (true);
    }

    static void SwitchMenu(int userChoice) {

        switch (userChoice) {
            case 1:
                Vehicle.AddVehicle();
                break;
            case 2:
                Vehicle.RemoveVehicle();
                break;
            case 3:
                Vehicle.UpdateVehicle();
                break;
            case 4:
                Vehicle.PrintFile();
                break;
            case 5:
                System.out.println(Util.RESET + Util.CYAN + "\nThank you for using the vehicle management system. Goodbye.\n" + Util.RESET);
                Util.scan.close();
                System.exit(0);
                break;
            default:
                System.out.println(Util.RED + "\nInvalid choice" + Util.RESET);
                Util.PressEnter();
        }
    }
}
