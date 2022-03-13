import java.util.Random;
import java.util.Scanner;

class CheckingAccount extends BankAccount {
    static Random rn = new Random();
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
        double apyTwo = .0025;
        double interestEarned;
        double newBalance;
        double totalInterestEarned = 0;
        double[] interestValues = new double[3];

        if (balance > 0 && balance <= 10000) {
            apyTwo = 0;
            totalInterestEarned = balance * apy;
            newBalance = balance + totalInterestEarned;
            setBalance(newBalance);
        }
        else if (balance > 10000) {
            double excessBalance = balance - 10000;
            double excessInterestEarned = excessBalance * apyTwo;

            interestEarned = balance * apy;
            totalInterestEarned = interestEarned + excessInterestEarned;
            newBalance = balance + totalInterestEarned;
            setBalance(balance);

        }
        else if (balance <= 0) {
            interestEarned = 0;
            apy = 0;
            apyTwo = 0;
        }

        interestValues[0] = totalInterestEarned;
        interestValues[1] = apy;
        interestValues[2] = apyTwo;
        return interestValues;
    }

    void DisplayAccount() {

        double[] values = CalculateInterest(); 

        AccountSummary();
        System.out.println("APY earned on balance below $10000: " + String.format("%.2f", values[1]) + "%");
        System.out.println("APY earned on balance above $10000: " + String.format("%.2f", values[2]) + "%");
        System.out.println("Interest Earned: $" + String.format("%.2f", values[0]));
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
