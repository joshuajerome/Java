package split;

/* Transactions can be of the following types */
enum TransactionType {
    REQUEST,
    SETTLED
}

/* Transactions have an amount, message, and type. Virtually the exist between users but have no internal relation to the users. 
 * Externally, they are connected to users through higher order classes.
*/

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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction type: " + transactionType.toString() + "\t");
        sb.append("Transaction amount: $" + amount + "\t");
        sb.append("Transaction message: " + message + "\n");
        return sb.toString();
    }
}
