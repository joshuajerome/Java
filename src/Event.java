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

    public Occasion creatOccasion(String name) {
        Occasion occasion = new Occasion(name);
        return occasion;
    }

    public void printMembers() {
        StringBuilder sb = new StringBuilder();
        members.forEach(sb::append);
        System.out.println(sb.toString());
    }
    
    /** BRANCH MANAGEMENT
     *  1) git checkout -b "name of branch" origin/main
     *  - check what branch i'm on: git branch -a
     *  - see differences: git diff "File name"
     *  2) Make changes
     *  3) git add
     *  4) git commit -m "message"
     *  5) git push origin "branch name"
     *  6) create pull request
     *  7) Get approval
     *  8) create merge request
     *  9) Then locally...
     * 10) git checkout main
     * 11) git fetch
     * 12) git rebase 
     * 13) git branch -D "branch name"
     */





    

}
