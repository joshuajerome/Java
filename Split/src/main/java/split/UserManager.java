package split;
import java.util.*;

public class UserManager {

    private static HashMap<User,UUID> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void createUser(String name) {
        User user = new User(name);
        addUser(user);
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

    public static User getUser(UUID id) {
        for (User user : users.keySet()) {
            if (user.getID() == id) return user;
        }
        return null;
    }
}
