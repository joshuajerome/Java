package split;
import java.util.*;

public class Trip {

    private String name;
    private List<Event> events;
    private List<User> participants;

    // Each event has a expense
    // maybe create a class called expense manager?
    // trip should be able to collect all expense data from all events and store/show them
    
    /* TRIP CONSTRUCTION FUNCTIONS */

    public Trip(String name) {
        this.name = name;
        events = new ArrayList<>();
        participants = new ArrayList<>();
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

    public void addNewEvent(String eventName) {
        events.add(new Event(eventName));
    }

    public void addExisitingEvent(Event event) {
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
        Iterator<User> participantsIterator = participants.iterator();
        while (participantsIterator.hasNext()) {
            details.append(participantsIterator.next().printFields() + "\n\t");
        }
        details.append("\nEvents:");
        Iterator<Event> eventIterator = events.iterator();
        while (eventIterator.hasNext()) {
            Event tmp = eventIterator.next();
            details.append(tmp.getName());
        }
        System.out.println(details);
    }
}
