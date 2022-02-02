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
    //public static final String FILENAME = "C:\\Users\\Samer\\Desktop\\AUTO_INVENTORY.txt";
    public static final String FILENAME = "C:\\Users\\Samer.Khamisi\\Documents\\AUTO_INVENTORY.txt";
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
        System.out.println(CYAN_Bold_Underline + "VEHICLE INVENTORY MANAGEMENT SYSTEM" + RESET);
        System.out.println(CYAN + "CURRENT TIME: "  + date + "\n\n" + RESET);
    }
}
