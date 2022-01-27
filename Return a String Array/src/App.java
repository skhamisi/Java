import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        try {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter 3 values seperated by a comma: ");
        String input = scan.nextLine();

        String values[] = returnArray(input);

        for (String i : values) {
            System.out.println(i);
        }

        scan.close();
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String[] returnArray(String input) {

        String[] userValues = input.split(", ");
        return userValues;
    }
}
