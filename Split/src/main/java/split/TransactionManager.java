package split;

import java.util.*;

public class TransactionManager {
    
    private User receiver, sender;
    private Transaction transaction;
    private TransactionRecord transactionRecord;

    public TransactionManager(User receiver, User sender, Transaction transaction) {
        this.receiver = receiver;
        this.sender = sender;
        this.transaction = transaction;
        transactionRecord = new TransactionRecord(transaction);
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
       
    }

    private void settle() {

    }
}
