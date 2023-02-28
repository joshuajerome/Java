package split;
import java.util.*;

public class Trip extends Database {

    private String name;
    protected List<Event> events;
    protected List<User> users; // participants
    
    /* TRIP CONSTRUCTION FUNCTIONS */

    public Trip() {}

    public Trip(String name) {
        // name = formatString(name);
        this.name = name;
        events = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void editName(String s) {
        // s = formatString(s);
        name = s;
    }

    public String getName() {
        return this.name;
    }

    /* MEMBER MANAGEMENT FUNCTIONS */

    @Override
    public void addUser(User user) {
        users.add(user);
        transaction_balance.put(user,0.0);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    /* EVENT MANAGEMENT FUNCTIONS */

    public void createEvent(String name) {
        // name = formatString(name);
        Event event = new Event(name);
        events.add(event);
    }

    public void deleteEvent(Event event) {
        if (events.contains(event)) {
            events.remove(event);
        }
    }

    /* UTILITY FUNCTIONS */

    public void getTripDetails() {
        StringBuilder details = new StringBuilder();
        details.append("\nTrip:\t" + getName());
        details.append("\nUsers:\t");
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            details.append(userIterator.next().printFields() + "\n\t");
        }
        // details.append("\nEvents:");
        // Iterator<Event> eventIterator = events.iterator();
        // while (eventIterator.hasNext()) {
        //     Event tmp = eventIterator.next();
        //     details.append(tmp.getName());
        // }
        System.out.println(details);
    }
}
