class BankAccount {
    
    String firstName;
    String lastName;
    int accountID;
    double balance;

    public BankAccount(String firstName, String lastName, int accountID, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = balance;
    }

    void Deposit(double deposit) {
        this.balance += deposit;
    }

    double Withdrawal(double withdraw) {
        return this.balance -= withdraw;
    }

    String getFirstName() {
        return firstName;
    }
    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }
    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    int getAccountID() {
        return accountID;
    }
    void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    double getBalance() {
        return balance;
    }
    void setBalance(double balance) {
        this.balance = balance;
    }

    void AccountSummary() {
        System.out.println("\nAccount Summary\n===============");
        // "Account ID: " + this.getAccountID() + "\n" +
        // "Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
        // "Balance: $" + String.format("%.2f",this.getBalance()));
        System.out.printf("Account ID:        %15s\n", this.getAccountID());
        System.out.printf("Name:              %15s\n", this.getFirstName() + " " + this.getLastName());
        System.out.printf("Balance:           %15.2f\n", this.getBalance());
    }
}
