import java.util.Scanner;

public class App {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        System.out.println("Enter 5 numbers: ");

        String input = scan.nextLine();

        int finalProduct = recursiveProduct(input, Character.getNumericValue(input.charAt(0)));
        System.out.print(finalProduct);
    }

    static int recursiveProduct(String numString, int product) {

        if (numString.length() == 1) {
            return product;

        } else {
            int nextString = Character.getNumericValue(numString.charAt(1));
            product *= nextString;
            return recursiveProduct(numString.substring(1, numString.length()), product);
        }
    }
}
