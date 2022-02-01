import java.util.Date;
import java.util.Scanner;

public class Util {

    // Sets ASCII color values to variables
    final static String RESET = "\u001B[0m";
    final static String RED = "\u001B[31m";
    final static String GREEN = "\u001B[32m";
    final static String YELLOW = "\u001B[33m";
    final static Date date = new Date();
    static final Scanner scan = new Scanner(System.in);

    // Clears screen of any previous text
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    // Waits for user to press key before continuing execution
    public static void PressEnter()
    { 
        System.out.println(YELLOW + "\nPress [ENTER] to continue" + RESET);
        scan.nextLine();
        scan.nextLine();
    }

    public static void PrintHeader() {
        clearScreen();
        System.out.println(Util.YELLOW + "VEHICLE INVENTORY MANAGEMENT SYSTEM\nCURRENT TIME: " + Util.date + "\n\n" + Util.RESET);
    }
}
