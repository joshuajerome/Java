package split;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

/* Transaction history is subject to each user. Every user that has made a transaction has a transaction history */

public class TransactionHistory {

    private HashSet<TransactionRecord> records;

    public TransactionHistory() {
        records = new HashSet<>();
    }

    public void addRecord(TransactionRecord record) {
        assertTrue(!records.contains(record));
        records.add(record);
    }

    public void removeRecord(TransactionRecord record) {
        assertTrue(records.contains(record));
        records.remove(record);
    }

    public HashSet<TransactionRecord> getTransactionHistory() {
        return records;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TransactionRecord record : records) {
            sb.append("\t" + record.toString() + "\n");
        }
        sb.append("\n");
        return sb.toString();
    }
    
}
