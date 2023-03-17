package split;
import java.util.*;

public class ContactsManager {

    private HashMap<UUID,Contacts> contactsDatabase;
    
    public ContactsManager() {
        contactsDatabase = new HashMap<>();
    }

    public void addEntry(UUID id) {
        if (!contactsDatabase.containsKey(id)) {
            contactsDatabase.put(id, new Contacts());
        }
    }

    public void removeEntry(UUID id) {
        if (contactsDatabase.containsKey(id)) {
            contactsDatabase.remove(id);
        }
    }

    
}
