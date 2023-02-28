package split;
import java.util.*;

public class Event extends Trip {

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
    private int memberCount = 0;
    private int adminCount = 0;

    public Event(String name) {
        this.name = name;
        events.add(this);
    }

    public Event() {}
    
    public String getName() {
        return name;
    }

}
