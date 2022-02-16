import java.util.Random;
import java.util.Scanner;

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

    void DisplayAccount() {
        double apy = .01;
        double interestEarned;
        double newBalance;

        if (balance > 0) {
            interestEarned = balance * apy;
            newBalance = balance + interestEarned;
            setBalance(newBalance);
        }
        else {
            interestEarned = 0;
        }

        AccountSummary();
        System.out.println("APY: " + apy + "%");
        System.out.println("Interest Earned: $" + interestEarned);
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
}
