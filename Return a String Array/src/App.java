import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ClearScreen();

        try {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter 3 values seperated by a comma: ");
        String input = scan.nextLine();

        String values[] = returnArray(input);
        System.out.print("\n");

        for (String i : values) {
            System.out.println(i);
        }

        scan.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] returnArray(String input) {

        String[] userValues = input.split(", ");
        return userValues;
    }

    public static void ClearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
