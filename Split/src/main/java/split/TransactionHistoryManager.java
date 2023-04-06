package split;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

/* Transaction History Manager is the highest order managerial class for transaction history/records.
 * This class' methods will be invoked in TranactionManager.
 */

public abstract class TransactionHistoryManager {

    private static HashMap<UUID,TransactionHistory> transactionHistoryMap = new HashMap<>();

    public static void addRecord(UUID id, TransactionRecord record) {
        if (!transactionHistoryMap.containsKey(id)) {
            transactionHistoryMap.put(id, new TransactionHistory());
        }
        transactionHistoryMap.get(id).addRecord(record);
    }

    public static void removeRecord(UUID id, TransactionRecord record) {
        assertTrue(transactionHistoryMap.containsKey(id));
        transactionHistoryMap.get(id).removeRecord(record);
    }

    public static TransactionHistory getTransactionHistory(UUID id) {
        assertTrue(transactionHistoryMap.containsKey(id));
        return transactionHistoryMap.get(id);
    }

    /* Does not override print because objects of this class can not be instantiated */
    public static String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction Histories:\n");
        for (UUID id : transactionHistoryMap.keySet()) {
            sb.append(UserManager.get(id).getName() + "'s Transaction History:\n");
            sb.append(transactionHistoryMap.get(id).toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return print();
    }
    
}
