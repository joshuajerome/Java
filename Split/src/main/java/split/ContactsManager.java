package split;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class ContactsManager {

    private HashMap<UUID,Contacts> contactsDatabase;
    
    public ContactsManager() {
        contactsDatabase = new HashMap<>();
    }

    public void addEntry(UUID id) {
        assertTrue(!contactsDatabase.containsKey(id));
        contactsDatabase.put(id, new Contacts());
    }

    public void removeEntry(UUID id) {
        assertTrue(contactsDatabase.containsKey(id));
        contactsDatabase.remove(id);
    }
}
