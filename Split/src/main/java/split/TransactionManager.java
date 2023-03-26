package split;

import java.util.*;

public class TransactionManager {
    
    TransactionHistoryManager transactionHistoryManager;

    public TransactionManager() {
       transactionHistoryManager = new TransactionHistoryManager();
    }

    public void transact(UUID sender, UUID reciever, Transaction transaction) {
        TransactionRecord record = new TransactionRecord(sender, reciever, transaction);
        transactionHistoryManager.getTransactionHistory(sender).addRecord(record);
        transactionHistoryManager.getTransactionHistory(reciever).addRecord(record);
    }

    public void printTransactionHistoryManager() {
        System.out.println(transactionHistoryManager.toString());
    }

}
