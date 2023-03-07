package split;
import java.util.*;

enum TransactionType {
    REQUEST,
    SEND
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
        this.transactionType = transactionType;
        this.amount = amount;
        this.message = message;
        user1Balances = user1.getBalances();
        user2Balances = user2.getBalances();
    }

    public void transact() {
        switch(transactionType) {
            case REQUEST:
                request();
                break;
            case SEND:
                send();
                break;
        }
        
    }

    private void request() {
        user1Balances.put(user2, user1Balances.getOrDefault(user2, 0.0) + amount);
        user2Balances.put(user1, user2Balances.getOrDefault(user1, 0.0) - amount);
    }

    private void send() {
        user1Balances.put(user2, user1Balances.getOrDefault(user2, 0.0) - amount);
        user2Balances.put(user1, user2Balances.getOrDefault(user1, 0.0) + amount);
    }
    
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction between " + user1.getName() + " and " + user2.getName() + "\n");
        sb.append("Transaction type: " + transactionType.toString() + "\t$" + amount + "\n");
        sb.append("Transaction message: " + message);
        return sb.toString();
    }
}
