import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Grade Statistics");
        System.out.println("----------------\n");

        Scanner scan = new Scanner(System.in);
        ArrayList<Float> grades = new ArrayList<Float>();

 
        int i = 0;

        do {
            System.out.print("Please enter a grade: ");
            grades.add(scan.nextFloat());
            i++;
        } while (i < 10);

        scan.close();
        Collections.sort(grades);

        float sumAverage = 0;
        float maximum = 0;
        float minimum = 100;

        for (Float num : grades) {
            sumAverage += num;

            if (num > maximum) {
                maximum = num;
            }
            if (num < minimum) {
                minimum = num;
            }
        }

        System.out.println("\nAverage = " + sumAverage / 10);
        System.out.println("Maximum = " + maximum);
        System.out.println("Minimum = " + minimum);
    } 
}
