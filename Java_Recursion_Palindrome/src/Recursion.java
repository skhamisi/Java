import java.util.Scanner;

public class Recursion {
    
    String word;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word or number: ");
        String word = scan.next();

        if(isPalindrome(word.toLowerCase()))
            System.out.println(word + " is a palindrome");
        else
            System.out.println(word + " is not a palindrome");

        scan.close();
    }

    static boolean isPalindrome(String word) {

        //Base Case
        if(word.length() == 0 || word.length() == 1)
            return true;

        //Recursive Step
        if(word.charAt(0) == word.charAt(word.length()-1))
            //if condition is true, calls "isPalindrome()" and checks the base case
            return isPalindrome(word.substring(1, word.length()-1));

        return false;
    }
}
