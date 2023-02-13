package src;

import java.util.*;
import java.io.*;

public class Database extends User {
    
    protected HashMap<User, HashMap<String, String>> contacts;  // User, [Name of Field, Actual Field]
    protected HashMap<Event, String> events;                    // 
    protected HashMap<User, Double> transaction_balance;        // 

    public Database() {
        contacts = new HashMap<>();
        events = new HashMap<>();
    }

    public void addContact(String input) {
        User user = new User(input);
        if (contacts.containsKey(user)) {
            System.out.println(user + " already exists in database!\n");
            return;   
        }
        contacts.put(user,fields);
    }

    public void deleteContact(String input) {
        Iterator<User> iterator = contacts.keySet().iterator();
        input = validateName(input);
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
            System.out.println("Entry " + ++counter + ":\tKey: " + user.fields.get("Name") + "\tValue: " + user.getFields());
        }

        if (contacts.size() == 0) System.out.println("Database is empty!\n");
    }

    public User searchUser(String name) {
        Iterator<User> iterator = contacts.keySet().iterator();
        name = validateName(name);
        User tmp;
        while (iterator.hasNext()) {
            tmp = iterator.next();
            if (tmp.fields.get("Name").equals(name)) return tmp; // contains value method
        }
        throw new NoSuchElementException(name);
    }

    // For ease of adding several contacts 
    public void addContactFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            readFromInputStream(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                addContact(line);
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
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
