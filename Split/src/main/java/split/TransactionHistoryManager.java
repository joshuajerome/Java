package split;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class TransactionHistoryManager {

    private HashMap<UUID,TransactionHistory> transactionHistoryMap;

    public TransactionHistoryManager() {
        transactionHistoryMap = new HashMap<>();
    }

    public void addEntry() {}

    public void removeEntry() {}

    public TransactionHistory getTransactionHistory(UUID id) {
        assertTrue(transactionHistoryMap.containsKey(id));
        return transactionHistoryMap.get(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
    
}
