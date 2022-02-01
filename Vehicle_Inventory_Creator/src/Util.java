import java.util.Scanner;

public class Util {

    final static String RESET = "\u001B[0m";
    final static String RED = "\u001B[31m";
    final static String GREEN = "\u001B[32m";
    final static String YELLOW = "\u001B[33m";
    static final Scanner scan = new Scanner(System.in);

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    public static void PressEnter()
    { 
        System.out.println(YELLOW + "\nPress [ENTER] to continue" + RESET);
        scan.nextLine();
    }
}
