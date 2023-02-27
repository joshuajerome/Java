package split;
import java.io.*;
import java.util.*;

public class Trip extends Database{
    
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
    protected List<Event> events;
    protected List<User> users;
    
    public Trip() {}

    public Trip(String name) {
        this.name = name;
        events = new ArrayList<>();
        users = new ArrayList<>();
    }

    // public boolean addMember(String name) {
    //     try {
    //         users.add(searchUser(name));
    //         return true;
    //     } catch (NoSuchElementException e) {
    //         return false;
    //     }
    // }

    public String getName() {
        return this.name;
    }

    public Event creatOccasion(String name) {
        Event occasion = new Event(name);
        return occasion;
    }

    public void printusers() {
        StringBuilder sb = new StringBuilder();
        users.forEach(sb::append);
        System.out.println(sb.toString());
    }

}
