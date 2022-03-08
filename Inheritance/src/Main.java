
public class Main {
    public static void main(String[] args) throws Exception {
        CheckingAccount.clearScreen();
        CheckingAccount newAccount = CheckingAccount.CreateAccount();

        System.out.print("\nHow much would you like to deposit?: $");
        double deposit = CheckingAccount.scan.nextDouble();
        newAccount.Deposit(deposit);

        System.out.println("\nWould you like to make a withdrawal?");
        System.out.println("Y (Yes) / N (No)");
        String input = CheckingAccount.scan.next();

        if (input.equalsIgnoreCase("y")) {
            System.out.print("\nWithdrawal Amount: $");
            double withdrawalAmount = CheckingAccount.scan.nextDouble();
            newAccount.ProcessWithdrawal(withdrawalAmount);
            newAccount.DisplayAccount();
        }
        else {
            newAccount.DisplayAccount();
        }

        CheckingAccount.scan.close();
    }
}
