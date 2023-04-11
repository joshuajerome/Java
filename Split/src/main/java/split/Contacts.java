package split;

import java.util.*;

public class Contacts {

    /* CONTACTS FUNCTIONS */
    
    private HashSet<UUID> contacts;

    public Contacts() {
        contacts = new HashSet<>();
    }

    public void addContact(UUID id) {
        contacts.add(id);
    }

    public void deleteContact(UUID id) {
        contacts.remove(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (contacts.size() == 0) {
            sb.append("Contacts is empty!");
        }
        int counter = 0;
        for (UUID id : contacts) {
            sb.append("Entry " + ++counter + ":\t" + UserManager.get(id).getName() + "\tFields: " + UserManager.get(id).toString() + "\n");
        }
        return sb.toString();
    }
}
