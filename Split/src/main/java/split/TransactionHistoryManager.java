package split;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

/* Transaction History Manager is the highest order managerial class for transaction history/records.
 * This class' methods will be invoked in TranactionManager.
 * This class follows Singelton Pattern
 */

public class TransactionHistoryManager {

    private static TransactionHistoryManager transactionHistoryManager = null;

    private static HashMap<UUID,TransactionHistory> transactionHistoryMap;

    private TransactionHistoryManager() {
        transactionHistoryMap = new HashMap<>();
    }

    public static synchronized TransactionHistoryManager getInstance() {
        if (transactionHistoryManager == null) {
            transactionHistoryManager = new TransactionHistoryManager();
        }
        return transactionHistoryManager;
    }

    public void addRecord(UUID id, TransactionRecord record) {
        if (!transactionHistoryMap.containsKey(id)) {
            transactionHistoryMap.put(id, new TransactionHistory());
        }
        transactionHistoryMap.get(id).addRecord(record);
    }

    public void removeRecord(UUID id, TransactionRecord record) {
        assertTrue(transactionHistoryMap.containsKey(id));
        transactionHistoryMap.get(id).removeRecord(record);
    }

    public TransactionHistory getTransactionHistory(UUID id) {
        assertTrue(transactionHistoryMap.containsKey(id));
        return transactionHistoryMap.get(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction Histories:\n");
        for (UUID id : transactionHistoryMap.keySet()) {
            sb.append(UserManager.get(id).getName() + "'s Transaction History:\n");
            sb.append(transactionHistoryMap.get(id).toString());
        }
        return sb.toString();
    }
    
}
