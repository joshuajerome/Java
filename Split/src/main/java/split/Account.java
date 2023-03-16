package split;

enum AccountType {
    Zelle,
    Paypal,
    Venmo
}

public class Account {

    private AccountType accountType;

    private double balance;
    
    public Account(AccountType accountType) {
        this.accountType = accountType;
        balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

}
