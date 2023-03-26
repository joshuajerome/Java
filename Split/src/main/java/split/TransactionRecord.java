package split;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TransactionRecord {
    
    private Transaction transaction;
    private LocalDateTime timeStamp;
    private UUID sender, reciever;

    public TransactionRecord(UUID sender, UUID reciever, Transaction transaction) {
        this.transaction = transaction;
        this.sender = sender;
        this.reciever = reciever;
        timeStamp = LocalDateTime.now();
    }

    public TransactionRecord getTransactionRecord() {
        return this;
    }

    // apache org date time formatting
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
        sb.append("From: " + sender + "\tTo: " + reciever + "\n");
        return sb.toString();
    }



}
