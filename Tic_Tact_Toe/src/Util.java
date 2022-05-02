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
    static final Scanner scan = new Scanner(System.in);

    static void PrintMenu() {
        do {

            Util.PrintHeader();
            
            System.out.println("TIC TAC TOE");
            System.out.println("=======================*");
            System.out.println("1. New Game            |");
            System.out.println("2. Exit                |");
            System.out.println("=======================*\n");

            System.out.print(CYAN + "\nENTER CHOICE: ");
            int userChoice = scan.nextInt();

            SwitchMenu(userChoice);

        } while (true);
    }

    static void SwitchMenu(int userChoice) {

        switch (userChoice) {
            case 1:
                Game.gameInit();
                break;
            case 2:
                System.out.println(Util.RESET + Util.CYAN + "\nThank you for using the vehicle management system. Goodbye.\n" + Util.RESET);
                Util.scan.close();
                System.exit(0);
                break;
            default:
                System.out.println(Util.RED + "\nInvalid choice" + Util.RESET);
                Util.PressEnter();
        }
    }
    
    static void PrintHeader() {
        clearScreen();
        System.out.println(CYAN_Bold_Underline + "VEHICLE INVENTORY MANAGEMENT SYSTEM" + RESET);
        System.out.println(CYAN + "CURRENT TIME: "  + date + "\n\n" + RESET);
    }

    // Clears screen of any previous text
    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    // Waits for user to press key before continuing execution
    static void PressEnter()
    { 
        System.out.println("\nPress [ENTER] to continue" + RESET);
        scan.nextLine();
        scan.nextLine();
    }
}
