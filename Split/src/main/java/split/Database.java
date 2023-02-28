package split;
import java.util.*;

import org.apache.commons.lang3.text.WordUtils;

public class Database {
    
    protected List<User> users;
    protected HashMap<Trip, String> trips;
    protected HashMap<User, Double> transaction_balance;

    public Database() {
        users = new ArrayList<>();
        trips = new HashMap<>();
        transaction_balance = new HashMap<>();
    }

    /* PRIMITIVE FUNCTIONS -- can be implemented directly by accessing users HashSet */

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            return;
        }
        System.out.println(user.fields.get("Name") + "'s database does not contain " 
        + user.fields.get("Name") + "!");
    }

    /* UTILITY FUNCTIONS */

    public void printUsers() {
        if (users.size() == 0) {
            System.out.println("Users is empty!");
            return;
        }
        int counter = 0;
        for (User user : users) {
            System.out.println("Entry " + ++counter + ":\tKey: " + user.fields.get("Name") + "\tValue: " + user.printFields() + "\n");
        }
        if (users.size() == 0) System.out.println("Database is empty!\n");
    }

    /* TRIP FUNCTIONS */

    public Trip createTrip(String name) {
        name = WordUtils.capitalize(name);
        Trip trip = new Trip(name);
        trips.put(trip, name);
        return trip;
    }
}
