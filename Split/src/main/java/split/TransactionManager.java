package split;

import java.util.*;

public class TransactionManager {
    
    TransactionHistoryManager transactionHistoryManager;

    public TransactionManager() {
       transactionHistoryManager = new TransactionHistoryManager();
    }

    public void transact(UUID sender, UUID reciever, Transaction transaction) {
        TransactionRecord record = new TransactionRecord(sender, reciever, transaction);
        transactionHistoryManager.addRecord(sender, record);
        transactionHistoryManager.addRecord(reciever, record);
    }

    public void printTransactionHistoryManager() {
        System.out.println(transactionHistoryManager.toString());
    }

}
