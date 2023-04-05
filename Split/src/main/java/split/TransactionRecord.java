package split;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/* When transactions are created a record of this transaction is instantiated. Records have timestamps as well as an explicit 
 * connection to sender and reciever.
  */

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
    /* Formats the time-stamp upon initialization into a readable MM-dd-yyyy and HH:mm:ss */
    private String formatTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formatted = timeStamp.format(formatter);
        return formatted;
    }

    /* Since users are referenced via there UUID for space optimization, toString() invokes UserManager class' static methods to map UUID to User  */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tTransaction from: " + UserManager.getUser(sender).getName() + "\tto: " + UserManager.getUser(reciever).getName() + "\n");
        sb.append("\t" + transaction.toString());
        sb.append("\t@ " + formatTimeStamp() + "\n");
        return sb.toString();
    }



}
