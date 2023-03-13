package split;

import java.util.*;

public class TransactionManager {
    
    private User admin, user;
    private Transaction transaction;

    public TransactionManager(User admin, User user, Transaction transaction) {
        this.admin = admin;
        this.user = user;
        this.transaction = transaction;
    }

    public void transact() {
        switch (transaction.getTransactionType()) {
            case REQUEST:
                request();
                break;
            case SETTLED:
                settle();
                break;
        }
    }

    private void request() {

        admin.getTransactionHistory().put(transaction,this);
        user.getTransactionHistory().put(transaction,this);

        admin.getBalances().put(user, admin.getBalances().getOrDefault(user, 0.0) + transaction.getAmount());
        user.getBalances().put(admin, user.getBalances().getOrDefault(admin, 0.0) - transaction.getAmount());
    }

    private void settle() {

        admin.getTransactionHistory().put(transaction,this);
        user.getTransactionHistory().put(transaction,this);

        admin.getBalances().replace(user, admin.getBalances().get(user) - transaction.getAmount());
        user.getBalances().replace(admin, user.getBalances().get(admin) + transaction.getAmount());

    }
}
