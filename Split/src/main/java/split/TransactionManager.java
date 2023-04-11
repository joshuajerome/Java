package split;

import java.util.*;

public class TransactionManager {

    private static TransactionManager transactionManager = null;
    private static TransactionHistoryManager transactionHistoryManager = null;

    private TransactionManager() {
        transactionHistoryManager = TransactionHistoryManager.getInstance();
    }

    public static synchronized TransactionManager getInstance() {
        if (transactionManager == null) {
            transactionManager = new TransactionManager();
        }
        return transactionManager;
    }
    
    public void transact(UUID sender, UUID reciever, Transaction transaction) {
        TransactionRecord record = new TransactionRecord(sender, reciever, transaction);
        transactionHistoryManager.addRecord(sender, record);
        transactionHistoryManager.addRecord(reciever, record);
    }

    private void name(TransactionRecord record) {

    }

}
