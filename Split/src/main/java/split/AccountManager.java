package split;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class AccountManager {

    private HashMap<UUID, List<Account>> accountDatabase;

    public AccountManager() {
        accountDatabase = new HashMap<>();
    }

    public void addEntry(UUID id) {
        assertTrue(!accountDatabase.containsKey(id));
        accountDatabase.put(id, new ArrayList<>());
    }

    public void removeEntry(UUID id) {
        assertTrue(accountDatabase.containsKey(id));
        accountDatabase.remove(id);
    }

    public void createAccount(UUID id, AccountType accountType) {
        assertTrue(accountDatabase.containsKey(id));

        if (accountDatabase.get(id) == null) {
            accountDatabase.put(id, new ArrayList<>());
        }
        List<Account> accounts = accountDatabase.get(id);
        for (Account account: accounts) {
            if (account.getAccountType().equals(accountType)) {
                return;
            }
        }
        accounts.add(new Account(accountType));
    }

    public void deleteAccount(UUID id, AccountType accountType) {
        assertTrue(accountDatabase.containsKey(id));
        assertNotNull(accountDatabase.get(id));

        List<Account> accounts = accountDatabase.get(id);
        for (Account account : accounts) {
            if (account.getAccountType() == accountType) {
                accounts.remove(account);
                return;
            }
        }
    }

    public Account getAccount(UUID id, AccountType accountType) {
        assertNotNull(accountDatabase.get(id));
        List<Account> accounts = accountDatabase.get(id);
        for (Account account : accounts) {
            if (account.getAccountType().equals(accountType)) {
                return account;
            }
        }
        throw new RuntimeException("User does not contain account of type: " + accountType.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<UUID> iterator = accountDatabase.keySet().iterator();
        while (iterator.hasNext()) {
            UUID key = iterator.next();
            sb.append("UUID:\t" + key.toString() + "\n");
            for (Account account : accountDatabase.get(key)) {
                sb.append("\t" + account.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }








    
}
