package split;
import java.util.*;

public class Database extends User {
    
    protected HashMap<User, HashMap<String, String>> contacts;  // user, user.fields
    protected HashMap<Event, String> events;                    // 
    protected HashMap<User, Double> transaction_balance;        // 

    public Database() {
        contacts = new HashMap<>();
        events = new HashMap<>();
    }

    public User addContact(String name) {
        User user = new User(name);
        contacts.put(user,fields);
        return user;
    }

    public void deleteContact(String input) {
        Iterator<User> iterator = contacts.keySet().iterator();
        input = formatString(input);
        while (iterator.hasNext()) {
            User tmp = iterator.next();
            if (tmp.fields.get("Name").equals(input)) {
                contacts.remove(tmp);
                return;
            }
        }
        System.out.println("Database does not contain: " + input + "!\n"); 
    }

    public void clearContacts() {
        contacts.clear();
    }

    public void printContacts() {
        Iterator<User> iterator = contacts.keySet().iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println("Entry " + ++counter + ":\tKey: " + user.fields.get("Name") + "\tValue: " + user.printFields());
        }

        if (contacts.size() == 0) System.out.println("Database is empty!\n");
    }

    public User searchUser(String name) {
        Iterator<User> iterator = contacts.keySet().iterator();
        name = formatString(name);
        User tmp;
        while (iterator.hasNext()) {
            tmp = iterator.next();
            if (tmp.fields.get("Name").equals(name)) return tmp; // contains value method
        }
        throw new NoSuchElementException(name);
    }

    /* EVENT FUNCTIONS */

    public void createEvent(String name) {
        Event event = new Event(name);
        events.put(event, name);
        event.members.add(this);
    }

    public Event getEvent(String name) {
        Iterator<Event> iterator = events.keySet().iterator();
        Event curr;
        while (iterator.hasNext()) {
            curr = iterator.next();
            if (curr.getName().equals(name)) return curr;
        }
        throw new NoSuchElementException(name);
    }

}
