package src;
import java.io.*;
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
    protected List<Occasion> occasions;
    protected List<User> members;
    
    public Event() {}

    public Event(String name) {
        this.name = name;
        occasions = new ArrayList<>();
        members = new ArrayList<>();
    }

    public boolean addMember(String name) {
        try {
            members.add(searchUser(name));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public void printMembers() {
        StringBuilder sb = new StringBuilder();
        members.forEach(sb::append);
        System.out.println(sb.toString());
    }

    





    

}
