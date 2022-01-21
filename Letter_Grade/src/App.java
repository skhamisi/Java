import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Receives grade input from user
        System.out.print("Please enter a grade: ");
        int grade = scan.nextInt();
        LetterGrade(grade);
        scan.close();
    }

    public static void LetterGrade(int input){
        // Ternary checks to see if value is above 100
        input = input > 100 ? 100 : input;
        // Divides entered value by 10 in order to route to proper case output
        int inter = input/10;
        switch (inter) {
            case 10:
            case 9:  System.out.println("You got an A");
            break;
            case 8:  System.out.println("You got a B");
            break;
            case 7:  System.out.println("You got a C");
            break;
            case 6:  System.out.println("You got a D");
            break;
            default: System.out.println("You got an F");
        }      
    } 
}
