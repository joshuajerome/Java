package split;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class TransactionHistoryManager {

    private HashMap<UUID,TransactionHistory> transactionHistoryMap;

    public TransactionHistoryManager() {
        transactionHistoryMap = new HashMap<>();
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
            sb.append(UserManager.getUser(id).getName() + "'s Transaction History:\n");
            sb.append(transactionHistoryMap.get(id).toString());
        }
        return sb.toString();
    }
    
}
