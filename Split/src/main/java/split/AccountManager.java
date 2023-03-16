package split;
import java.util.*;

public class AccountManager {

    private HashMap<UUID, List<Account>> accountDatabase;

    public AccountManager() {
        accountDatabase = new HashMap<>();
    }

    public void addEntry(UUID id) {
        accountDatabase.put(id, new ArrayList<>());
    }

    public void deleteEntry(UUID id) {
        accountDatabase.remove(id);
    }

    public void createAccount(UUID id, AccountType accountType) {
        Account account = new Account(accountType);

        if (accountDatabase.get(id) == null) {
            accountDatabase.put(id, new ArrayList<>());
        }
        accountDatabase.get(id).add(account);
    }

    public void deleteAccount(UUID id, AccountType accountType) {
        List<Account> accounts = accountDatabase.get(id);
        for (Account account : accounts) {
            if (account.getAccountType() == accountType) {
                accounts.remove(account);
                return;
            }
        }
    }








    
}
