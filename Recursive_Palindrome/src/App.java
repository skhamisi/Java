import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        /* Requirements
        * 1. Decide whether a word is a palindrome or not
        * 2. Prompt user for string input
        * 3. accept one string as a parameter
        * 4. Use Recursion to find result
        * 5. Return boolean value
        * 6. Notify user whether their word is or is not a palindrome
        */

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String string = scan.next(); // Takes in string value from user

        if (isPalindrome(string.toLowerCase()))
            System.out.println(string + " is a palindrome"); // If returned value is true, tells user their word is a palindrome
        else
            System.out.println(string + " is not a palindrome"); // If returned value is false, tells user their word is not a palindrome
        scan.close();
    }
        // 'static' = method type, 'boolean' = return type, 'isPalindrome' = method name
        static boolean isPalindrome(String word)
        {
            // This is the method body, it uses conditional statements and recursion to decide whether a word is a palindrome or not
            if (word.length() == 0 || word.length() == 1) {
                return true; // method return value
            }

            else if (word.charAt(0) == word.charAt(word.length() - 1)) {
                return isPalindrome(word.substring(1, word.length() - 1)); // method return value
            }

            return false; // method return value
        }
}