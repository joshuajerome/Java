package src;
import java.util.*;
public class Event extends Database{
    
    /** Event Criteria:
     * 
     * 1. There are 'n' people involved
     * 2. There is a cost 'x' to be settled
     * 3. Include a SPLIT option where cost is split among SPLIT members
     * 4. Include a REQUEST option --> In USER
     * 5. Include a TRANSFER option --> IN USER
     * 6. Each person owes everyone else 'y' amount of money --> HashTable in User
    */

    private String name;
    private HashSet<String> members; // smart comma splicing on a large string -- check that each spliced member is in database. 

    public Event(String name) {
        this.name = name;
        members = new HashSet<>();
    }

    

}