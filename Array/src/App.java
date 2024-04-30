import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Declare an array of type Integer
        Integer[] scores = {40, 60, 35, 20, 80, 110, 71}; // Initialized array with 7 elements

        Arrays.sort(scores, Collections.reverseOrder()); // Sorting and reversing the elements in the array so that the scores output in descending order

        int i = 1;
        // Use a for loop to iterate through the array and print out all the elements
        for (int score : scores){
            System.out.println("Rank " + i + ": "+ score);
            i++; 
        }
    }
}
