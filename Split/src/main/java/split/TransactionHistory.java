package split;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

public class TransactionHistory {

    private HashSet<TransactionRecord> records;

    public TransactionHistory() {
        records = new HashSet<>();
    }

    public void addRecord(TransactionRecord record) {
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
