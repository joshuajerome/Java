package split;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class TransactionHistoryManager {

    private HashMap<UUID,TransactionHistory> transactionHistoryMap;

    public TransactionHistoryManager() {
        transactionHistoryMap = new HashMap<>();
    }

    public void addEntry(UUID id) {
        assertTrue(!transactionHistoryMap.containsKey(id));
        transactionHistoryMap.put(id,new TransactionHistory());
    }

    public void removeEntry(UUID id) {
        assertTrue(transactionHistoryMap.containsKey(id));
        transactionHistoryMap.remove(id);
    }

    public TransactionHistory getTransactionHistory(UUID id) {
        assertTrue(transactionHistoryMap.containsKey(id));
        return transactionHistoryMap.get(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction History Manager:\n");
        for (UUID id : transactionHistoryMap.keySet()) {
            sb.append("id: " + id + "\n");
            sb.append(transactionHistoryMap.get(id).toString());
        }
        return sb.toString();
    }
    
}
