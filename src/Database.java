package src;
import java.util.*;
import java.io.*;

public class Database {
    
    private HashSet<String> database;

    public Database() {
        database = new HashSet<>();
    }

    public void add(String input) {
        String person = input.toLowerCase();
        if (database.contains(person)) {
            System.out.println(person + " already exists in database!\n");
            return;   
        }
        database.add(person);
        // need to create a User
    }

    public void delete(String input) {
        String person = input.toLowerCase();
        if (!database.contains(person)) {
            System.out.println("Database does not contain: " + person + "!\n");   
            return;
        }
        database.remove(person);
    }

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
                if (database.contains(line.toLowerCase())) {
                    System.out.println("Database already contains: " + line);
                } else {
                    database.add(line.toLowerCase());
                    // create a user
                }
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public void printDatabase() {
        Iterator<String> iterator = database.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            System.out.println("Entry " + ++counter + ":\t" + iterator.next());
        }

        if (database.size() == 0) System.out.println("Database is empty!\n");
    }

    public void clearDatabase() {
        database.removeAll(database);
    }


}
