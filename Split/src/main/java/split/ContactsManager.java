package split;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class ContactsManager {

    private static ContactsManager contactsManager = null;
    private static HashMap<UUID,Contacts> contactsDatabase = null;

    private ContactsManager() {
        contactsDatabase = new HashMap<>();
    }

    public static ContactsManager getInstance() {
        if (contactsManager == null) {
            contactsManager = new ContactsManager();
        }
        return contactsManager;
    }

    public void addEntry(UUID id, Contacts contacts) {
        assertTrue(!contactsDatabase.containsKey(id));
        contactsDatabase.put(id, contacts);
    }

    public void removeEntry(UUID id) {
        assertTrue(contactsDatabase.containsKey(id));
        contactsDatabase.remove(id);
    }

    public Contacts getEntry(UUID id) {
        assertTrue(contactsDatabase.containsKey(id));
        return contactsDatabase.get(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contacts Database:\n");
        for (UUID id : contactsDatabase.keySet()) {
            sb.append(UserManager.get(id) + "'s Contacts:\n");
            sb.append(getEntry(id).toString());
        }
        return sb.toString();
    }

    
}
