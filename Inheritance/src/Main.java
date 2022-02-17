
public class Main {
    public static void main(String[] args) throws Exception {
        CheckingAccount.clearScreen();
        CheckingAccount account1 = CheckingAccount.CreateAccount();

        System.out.print("\nHow much would you like to deposit?: $");
        double deposit = CheckingAccount.scan.nextDouble();
        account1.Deposit(deposit);

        System.out.println("\nWould you like to make a withdrawal?");
        System.out.println("Y (Yes) / N (No)");
        String input = CheckingAccount.scan.next();

        if (input.equalsIgnoreCase("y")) {
            System.out.print("\nWithdrawal Amount: $");
            double withdrawalAmount = CheckingAccount.scan.nextDouble();
            account1.ProcessWithdrawal(withdrawalAmount);
            account1.DisplayAccount();
        }
        else {
            account1.DisplayAccount();
        }

        CheckingAccount.scan.close();
    }
}
