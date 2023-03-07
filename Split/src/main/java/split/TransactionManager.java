package split;

import java.util.*;

public class TransactionManager {
    
    private User admin, user;
    private Transaction transaction;

    
    private double adminBalance;
    private double userBalance;

    public TransactionManager(User admin, User user, Transaction transaction) {
        this.admin = admin;
        this.user = user;
        this.transaction = transaction;

        adminBalance = 0.0;
        userBalance = 0.0;
    }

    public void transact() {
        switch (transaction.getTransactionType()) {
            case REQUEST:
                request();
                break;
            case SETTLE:
                settle();
                break;
            case IGNORE:
                ignore();
                break;
        }
    }

    private void request() {
        adminBalance = transaction.getAmount();
        userBalance = -1.0 * transaction.getAmount();

        admin.getTransactionHistory().put(transaction.getID(),transaction);
    }

    private void settle() {
        adminBalance = 0.0;
        userBalance = 0.0;

        admin.getTransactionHistory().put(transaction.getID(),transaction);
        user.getTransactionHistory().put(transaction.getID(),transaction);
    }

    private void ignore() {
        adminBalance *= -1.0;
        userBalance = 0.0;

        admin.getTransactionHistory().put(transaction.getID(),transaction);
        user.getTransactionHistory().put(transaction.getID(),transaction);
    }


}
