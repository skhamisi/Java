import java.util.Scanner;

public class App {

    static Scanner scan = new Scanner(System.in);
    static int i = 0;
    static int[] product;
    public static void main(String[] args) throws Exception {

        System.out.print("Enter 5 numbers, separated by a comma: ");

        String input = scan.next();
        String[] p = input.split(",");
        int[] nums = new int[p.length];

        // for (i = 0; i < p.length; i++) {

        //     nums[i] = Integer.parseInt(p[i]);
        //     System.out.println(nums[i]);
        // }

        int[] finalProduct = recursiveProduct(nums);

        for (int i: finalProduct) {
            System.out.println(i);
        }

    }

    static int[] recursiveProduct(int[] userInput) {

        if (userInput.length > 0) {

            product[i] *= userInput[i];
            i++;
            recursiveProduct(new int[product.length - 1]);
        }
        return product;
    }
}
