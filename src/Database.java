package src;

import java.util.*;
import java.io.*;

public class Database {
    
    protected HashMap<String, List<String>> contacts;
    protected HashMap<String, List<String>> events;

    public Database() {
        contacts = new HashMap<>();
        events = new HashMap<>();
    }

    public void addContact(String input) {
        String user = input.toLowerCase();
        if (contacts.containsKey(user)) {
            System.out.println(user + " already exists in database!\n");
            return;   
        }
        contacts.put(user, new ArrayList<>());
        // need to create a User
    }

    public void deleteContact(String input) {
        String user = input.toLowerCase();
        if (!contacts.containsKey(user)) {
            System.out.println("Database does not contain: " + user + "!\n");   
            return;
        }
        contacts.remove(user);
    }

    public void clearContacts() {
        contacts.clear();
    }

    public void printContacts() {
        Iterator<String> iterator = contacts.keySet().iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            List<String> value = contacts.get(key);
            
            StringBuilder sb = new StringBuilder();
            value.forEach(sb::append);

            System.out.println("Entry " + ++counter + ":\tKey: " + key + "\tValue: " + sb.toString());
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
