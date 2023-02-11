package src;

import java.util.*;
import java.io.*;

public class Database {
    
    protected HashMap<String, User> contacts;
    protected HashMap<String, List<Occasion>> events;
    protected HashMap<User, Double> transaction_balance;

    public Database() {
        contacts = new HashMap<>();
        events = new HashMap<>();
    }

    public void addContact(String input) {
        User user = new User(input);
        String name = user.toString();
        if (contacts.containsKey(name)) {
            System.out.println(user + " already exists in database!\n");
            return;   
        }
        contacts.put(name, user);
    }

    public void deleteContact(String input) {
        User user = new User(input);
        String name = user.toString();
        if (!contacts.containsKey(name)) {
            System.out.println("Database does not contain: " + user + "!\n");   
            return;
        }
        contacts.remove(name);
    }

    public void clearContacts() {
        contacts.clear();
    }

    public void printContacts() {
        Iterator<String> iterator = contacts.keySet().iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            User user = contacts.get(key);

            System.out.println("Entry " + ++counter + ":\tKey: " + key + "\tValue: " + user.getFields());
        }

        if (contacts.size() == 0) System.out.println("Database is empty!\n");
    }

    // For ease of adding several contacts 
    public void addNameFile(String filename) {
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

}
