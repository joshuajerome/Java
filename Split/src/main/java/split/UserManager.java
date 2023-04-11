package split;
import java.util.*;

public class UserManager {

    private static UserManager userManager = null;

    private static HashMap<User,UUID> users = null;
    private static HashMap<UUID,User> uuids = null;

    private UserManager() {
        users = new HashMap<>();
        uuids = new HashMap<>();
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    public User addUser(String name) {
        User user = new User(name);
        users.put(user, user.getID());
        uuids.put(user.getID(), user);
        return user;
    }

    public void removeUser(User user) {
        uuids.remove(get(user));
        users.remove(user);
    }

    public static UUID get(User user) {
        return user.getID();
    }

    public static User get(UUID id) {
        return uuids.get(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Users map: (K: User, V: UUID)");
        for (UUID id : uuids.keySet()) {
            sb.append("User: " + get(id).getName() + "\tUUID: " + id);
        }
        return sb.toString();
    }
}
