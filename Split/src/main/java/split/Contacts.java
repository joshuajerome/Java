package split;

import java.util.*;

public class Contacts {

    /* CONTACTS FUNCTIONS */
    
    private HashSet<User> contacts;

    public Contacts() {
        contacts = new HashSet<>();
    }

    public void addContact(User user) {
        contacts.add(user);
    }

    public void deleteContact(User user) {
        contacts.remove(user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (contacts.size() == 0) {
            sb.append("Users is empty!");
        }
        int counter = 0;
        for (User user : contacts) {
            sb.append("Entry " + ++counter + ":\t" + user.getName() + "\tFields: " + user.getFields() + "\n");
        }
        if (contacts.size() == 0) sb.append("Database is empty!\n");
        return sb.toString();
    }
}
