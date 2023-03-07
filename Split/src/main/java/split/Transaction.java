package split;
import java.util.*;

enum TransactionType {
    REQUEST,
    SEND,
    SETTLE,
    IGNORE
}

public class Transaction {

    private User user1, user2;
    private HashMap <User, Double> user1Balances, user2Balances; 
    private double amount;
    private String message;

    private TransactionType transactionType;

    public Transaction(User user1, User user2, TransactionType transactionType, double amount, String message) {
        this.user1 = user1;
        this.user2 = user2;
        setTransactionType(transactionType);
        this.amount = amount;
        this.message = message;
        user1Balances = user1.getBalances();
        user2Balances = user2.getBalances();
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void transact() {
        switch(transactionType) {
            case REQUEST:
                request();
                break;
            case SEND:
                send();
                break;
            case SETTLE:
                settle();
                break;
            case IGNORE:
                ignore();
                break;
        }
    }

    private void request() {}

    private void send() {
        user2Balances.put(user1, user2Balances.getOrDefault(user1, 0.0) + amount);
        user2.setBalance(user2.getBalance() + amount);
    }

    private void settle() {
        
    }

    private void ignore() {
    
    }
    
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction between " + user1.getName() + " and " + user2.getName() + "\n");
        sb.append("Transaction type: " + transactionType.toString() + "\t$" + amount + "\n");
        sb.append("Transaction message: " + message);
        return sb.toString();
    }
}
