package split;

enum TransactionType {
    REQUEST,
    SETTLED
}

public class Transaction {

    private int ID;
    private double amount;
    private String message;
    private TransactionType transactionType;

    public Transaction(TransactionType transactionType, double amount, String message) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.message = message;
        ID = this.hashCode();
    }

    public int getID() { return ID; }

    public void setTransactionType(TransactionType tt) { transactionType = tt; }

    public TransactionType getTransactionType() { return transactionType; }

    public double getAmount() { return amount; }

    public String getMessage() { return message; }
    
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction ID: " + ID + "\t");
        sb.append("Transaction type: " + transactionType.toString() + "\t");
        sb.append("Transaction amount: $" + amount + "\t");
        sb.append("Transaction message: " + message + "\n");
        return sb.toString();
    }
}
