package split;

import java.util.*;

public class TransactionManager {
    
    private User receiver, sender;
    private Transaction transaction;

    public TransactionManager(User receiver, User sender, Transaction transaction) {
        this.receiver = receiver;
        this.sender = sender;
        this.transaction = transaction;
    }

    public void transact() {
        switch (transaction.getTransactionType()) {
            case REQUEST:
                request();
                break;
            case SETTLED:
                settle();
                break;
        }
    }

    private void request() {

        receiver.getTransactionHistory().put(transaction,this);
        sender.getTransactionHistory().put(transaction,this);

        receiver.getBalances().put(sender, receiver.getBalances().getOrDefault(sender, 0.0) + transaction.getAmount());
        sender.getBalances().put(receiver, sender.getBalances().getOrDefault(receiver, 0.0) - transaction.getAmount());
    }

    private void settle() {

        receiver.getTransactionHistory().put(transaction,this);
        sender.getTransactionHistory().put(transaction,this);

        receiver.getBalances().replace(sender, receiver.getBalances().get(sender) - transaction.getAmount());
        sender.getBalances().replace(receiver, sender.getBalances().get(receiver) + transaction.getAmount());

    }
}
