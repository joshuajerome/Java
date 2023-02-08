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
        }
        database.add(person);
    }

    public void addNameFile(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("resources/" + filename);
        try {
            readFromInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                database.add(line.toLowerCase());
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public void printDatabase() {
        Iterator<String> iterator = database.iterator();
        int counter = 1;
        while (iterator.hasNext()) {
            System.out.println("Entry " + counter + ":\t" + iterator.next());
            counter++;
        }

        if (database.size() == 0) System.out.println("Database is empty!\n");
    }

    public void clearDatabase() {
        database.removeAll(database);
    }


}
