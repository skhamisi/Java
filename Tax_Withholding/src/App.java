import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        ClearScreen();
        System.out.print("Please enter your weekly income: $");
        double weeklyIncome = scan.nextDouble();

        System.out.println("\nTax Statistics");
        System.out.println("--------------");
        if (weeklyIncome < 500) {
            double tax = Math.round(weeklyIncome * .10);
            System.out.println("Weekly income: $" + weeklyIncome);
            System.out.println("Weekly tax witholding: $" + tax);
            System.out.println("Monthly tax witholding: $" + tax * 4);
        }
        else if (weeklyIncome >= 500 && weeklyIncome < 1500){
            double tax = Math.round(weeklyIncome * .15);
            System.out.println("Weekly income: $" + weeklyIncome);
            System.out.println("Weekly tax witholding: $" + tax);
            System.out.println("Monthly tax witholding: $" + tax * 4);
        }
        else if (weeklyIncome >= 1500 && weeklyIncome < 2500){
            double tax = Math.round(weeklyIncome * .20);
            System.out.println("Weekly income: $" + weeklyIncome);
            System.out.println("Weekly tax witholding: $" + tax);
            System.out.println("Monthly tax witholding: $" + tax * 4);
        }
        else if (weeklyIncome >= 2500){
            double tax = Math.round(weeklyIncome * .30);
            System.out.println("Weekly income: $" + weeklyIncome);
            System.out.println("Weekly tax witholding: $" + tax);
            System.out.println("Monthly tax witholding: $" + tax * 4);
        }

        scan.close();
    }

    public static void ClearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
