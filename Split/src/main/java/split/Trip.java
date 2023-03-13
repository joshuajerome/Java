package split;
import java.util.*;

public class Trip {

    private String name;
    private HashSet<Event> events;
    private HashSet<User> participants;

    // Each event has an expense
    // maybe create a class called expense manager?
    // trip should be able to collect all expense data from all events and store/show them
    
    /* TRIP CONSTRUCTION FUNCTIONS */

    public Trip(String name) {
        this.name = name;
        events = new HashSet<>();
        participants = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void editName(String s) {
        name = s;
    }

    /* PARTICIPANT MANAGEMENT FUNCTIONS */

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void deleteParticipant(User user) {
        participants.remove(user);
    }

    /* EVENT MANAGEMENT FUNCTIONS */

    public void addEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(Event event) {
        if (events.contains(event)) {
            events.remove(event);
        }
    }

    public void addAllParticipantsToEvent(Event event) {
        event.addAllMembers(participants);
    }

    /* UTILITY FUNCTIONS */

    public void printTripDetails() {
        StringBuilder details = new StringBuilder();
        details.append("\nTrip:\t" + getName());
        details.append("\nParticipants:\n");
        for (User user : participants) {
            details.append("\tParticipant Name:\t" + user.getName() + "\tFields:\t" + user.getFields() + "\n");
        }
        details.append("\nEvents:\n");
        for (Event event : events) {
            details.append(event.getEventDetails());
        }
        System.out.println(details);
    }
}
