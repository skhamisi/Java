import java.io.Console;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        Console cnsl = System.console();
        clearScreen();
        System.out.print("Enter phone provider: ");
        String phoneProvider = userInput.next();

        System.out.print("Enter phone model: ");
        String phoneModel = cnsl.readLine();
        // String phoneModel = userInput.next();
        
        System.out.print("Enter monthly minutes limit: ");
        int minutesLimit = userInput.nextInt();

        System.out.print("Enter monthly data limit (In GB): ");
        int dataLimit = userInput.nextInt();

        System.out.print("Enter current minutes used: ");
        int currentMinUsage = userInput.nextInt();

        System.out.print("Enter current data used: ");
        int currentDataUsage = userInput.nextInt();

        System.out.println("\nUsage Statistics");
        System.out.println("----------------");
        System.out.println("Provider: " + phoneProvider);
        System.out.println("Phone Model: " + phoneModel);
        System.out.println("Remaining Minutes: " + (minutesLimit - currentMinUsage) + "min");
        System.out.println("Remaining Data: " + (dataLimit - currentDataUsage) + "GB");
        // CalculateMinUsage(minutesLimit, currentMinUsage);
        // CalculateDataUsage(dataLimit, currentDataUsage);
        userInput.close();

    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    // static void CalculateMinUsage(int minLimit, int minUsag)
    // {
    //     int remainingMin = minLimit - minLimit;
    //     System.out.println("Remaining Minutes: " + remainingMin);
    // }

    // static void CalculateDataUsage(int DataLimit, int dataUsage)
    // {
    //     int remainingData = DataLimit - dataUsage;
    //     System.out.println("Reamining Data: " + remainingData + ("GB"));
    // }
}