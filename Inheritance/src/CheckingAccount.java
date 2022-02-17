import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

class CheckingAccount extends BankAccount {
    static Random rn = new Random();
    double interestRate;
    static int accountID = rn.nextInt(9999999) + 0;
    static Scanner scan = new Scanner(System.in);

    public CheckingAccount(String firstName, String lastName, int accountID, double balance) {
        super(firstName, lastName, accountID, balance);
    }

    void ProcessWithdrawal(double withdrawAmount) {
        
        if (withdrawAmount <= balance) {
            Withdrawal(withdrawAmount);
        }
        else if (withdrawAmount > balance) {
            int fee = 30;
            Withdrawal(withdrawAmount + fee);
            System.out.println("\nA $30 overdraft fee has been assessed to your account");
        }
    }

    double[] CalculateInterest() {
        double apy = .01;
        double interestEarned;
        double newBalance;
        // List<Double> values = new ArrayList<>();
        double[] values = new double[2];

        if (balance > 0 && balance <= 10000) {
            interestEarned = balance * apy;
            newBalance = balance + interestEarned;
            setBalance(newBalance);
        }
        else if (balance > 1000) {
            apy = .025;
            interestEarned = balance * apy;
        }
        else {
            interestEarned = 0;
        }

        values[0] = interestEarned;
        values[1] = apy;
        // values.add(interestEarned);
        // values.add(apy);
        return values;
    }

    void DisplayAccount() {
        // double apy = .01;
        // double interestEarned;
        // double newBalance;

        // if (balance > 0 && balance <= 10000) {
        //     interestEarned = balance * apy;
        //     newBalance = balance + interestEarned;
        //     setBalance(newBalance);
        // }
        // else if (balance > 1000) {

        // }
        // else {
        //     interestEarned = 0;
        // }
        double[] values = CalculateInterest(); 
        AccountSummary();
        System.out.println("APY: " + values[1] + "%");
        System.out.println("Interest Earned: $" + values[0]);
    }

    static CheckingAccount CreateAccount() {
        System.out.println("To open a new checking account, please provide your information\n");
        System.out.print("First Name: ");
        String firstName = scan.next();
        System.out.print("Last Name: ");
        String lastName = scan.next();
        System.out.println("Account Number: " + accountID);

        CheckingAccount newAccount = new CheckingAccount(firstName, lastName, accountID, 0);
        return newAccount;
    }

    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
