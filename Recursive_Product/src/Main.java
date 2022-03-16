import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ClearScreen();

        System.out.print("Enter 5 comma separated numbers: ");
        String input = scan.nextLine();

        String[] string = input.replaceAll("\\s", "").split(",");
        int[] nums = new int[string.length];

        for (int i = 0; i < string.length; i++) {
            nums[i] = Integer.parseInt(string[i]);
        }

        int finalProduct = recursiveProduct(nums, nums[0]);
        System.out.print("\n" + finalProduct);
    }

    static int recursiveProduct(int[] inputArray, int product) {

        if (inputArray.length == 1) {
            return product;

        } else {
            int nextInt = inputArray[1];
            product *= nextInt;
            return recursiveProduct(Arrays.copyOfRange(inputArray, 1, inputArray.length), product);
        }
    }
    
    public static void ClearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
