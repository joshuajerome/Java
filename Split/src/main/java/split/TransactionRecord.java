package split;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionRecord {
    
    private Transaction transaction;
    private LocalDateTime timeStamp;

    public TransactionRecord(Transaction transaction) {
        this.transaction = transaction;
        timeStamp = LocalDateTime.now();
    }

    public TransactionRecord getTransactionRecord() {
        return this;
    }

    private String formatTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatted = timeStamp.format(formatter);
        return formatted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction:\n\t" + transaction.toString());
        sb.append("\t@\t" + formatTimeStamp() + "\n");
        return sb.toString();
    }



}
