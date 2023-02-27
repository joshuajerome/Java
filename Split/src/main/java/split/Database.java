package split;
import java.util.*;

public class Database extends User {
    
    protected HashSet<User> users;
    protected HashMap<Trip, String> trips;
    protected HashMap<User, Double> transaction_balance;

    public Database() {
        users = new HashSet<>();
        trips = new HashMap<>();
    }

    /* PRIMITIVE FUNCTIONS -- can be implemented directly by accessing users HashSet */

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public void deleteUser(User user) {
        if (user == this) {
            return; // implement by deleting from firebase
        }
        if (users.contains(user)) {
            users.remove(user);
            return;
        }
        System.out.println(fields.get("Name") + "'s database does not contain " 
        + user.fields.get("Name") + "!");
    }

    /* UTILITY FUNCTIONS */

    public void printUsers() {
        if (users.size() == 0) {
            System.out.println("Users is empty!");
            return;
        }
        Iterator<User> iterator = users.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println("Entry " + ++counter + ":\tKey: " + user.fields.get("Name") + "\tValue: " + user.printFields());
        }

        if (users.size() == 0) System.out.println("Database is empty!\n");
    }

    /* TRIP FUNCTIONS */

    public void createTrip(String name) {
        Trip event = new Trip(name);
        trips.put(event, name);
        event.users.add(this);
    }
}
