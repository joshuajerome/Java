package split;

import java.util.*;

public abstract class TransactionManager {
    
    public static void transact(UUID sender, UUID reciever, Transaction transaction) {
        TransactionRecord record = new TransactionRecord(sender, reciever, transaction);
        TransactionHistoryManager.addRecord(sender, record);
        TransactionHistoryManager.addRecord(reciever, record);
    }

    public static void printTransactionHistoryManager() {
        System.out.println(TransactionHistoryManager.print());
    }

}
