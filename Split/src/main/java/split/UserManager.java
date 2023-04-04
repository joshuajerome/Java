package split;
import java.util.*;

public class UserManager {

    private HashMap<User,UUID> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user, user.getID());
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public UUID getUUID(User user) {
        return user.getID();
    }

    public User getUser(UUID id) {
        for (User user : users.keySet()) {
            if (user.getID() == id) return user;
        }
        return null;
    }
}
