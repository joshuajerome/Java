package split;
import java.util.*;

public class Event {

    /** Event Criteria:
     * 
     * 1. There are 'n' people involved
     * 2. There is a cost 'x' to be settled
     * 3. Include a SPLIT option where cost is split among SPLIT users
     * 4. Include a REQUEST option --> In USER
     * 5. Include a TRANSFER option --> IN USER
     * 6. Each person owes everyone else 'y' amount of money --> HashTable in User
    */
    
    private String name;
    private HashSet<User> members;

    

    /* EVENT CONSTRUCTION FUNCTIONS */

    Event(String eventName) {
        name = eventName;
        members = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void editName(String s) {
        name = s;
    }

    /* MEMBER MANAGEMENT FUNCTIONS */

    public void addMember(User user) {
        members.add(user);
    }

    public void addAllMembers(HashSet<User> setOfUsers) {
        members.addAll(setOfUsers);
    } 

    public void deleteMember(User user) {
        members.remove(user);
    }

    /* UTILITY FUNCTIONS */

    public String getEventDetails() {
        StringBuilder details = new StringBuilder();
        details.append("\nEvent Name:\t" + getName());
        details.append("\nMembers:\n");
        for (User user : members) {
            details.append("\tMember Name:\t" + user.getName() + "\tFields:\t" + user.toString() + "\n");
        }
        return details.toString();
    }


}
