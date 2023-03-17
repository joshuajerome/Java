package split;

enum TransactionType {
    REQUEST,
    SETTLED
}

public class Transaction {

    private double amount;
    private String message;
    private TransactionType transactionType;

    public Transaction(TransactionType transactionType, double amount, String message) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.message = message;
    }

    public TransactionType getTransactionType() { return transactionType; }

    public double getAmount() { return amount; }

    public String getMessage() { return message; }
    
    // implement as toString
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction type: " + transactionType.toString() + "\t");
        sb.append("Transaction amount: $" + amount + "\t");
        sb.append("Transaction message: " + message + "\n");
        return sb.toString();
    }
}
