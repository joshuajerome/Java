package split;

import java.util.*;

public class TransactionManager {
    
    TransactionHistoryManager transactionHistoryManager;

    public TransactionManager() {
       transactionHistoryManager = new TransactionHistoryManager();
    }

    public void transact(UUID sender, UUID reciever, Transaction transaction) {
        transactionHistoryManager.addEntry(sender);
        transactionHistoryManager.addEntry(reciever);
        TransactionRecord record = new TransactionRecord(transaction);
        transactionHistoryManager.getTransactionHistory(sender).addRecord(record);
        transactionHistoryManager.getTransactionHistory(reciever).addRecord(record);
    }

}
