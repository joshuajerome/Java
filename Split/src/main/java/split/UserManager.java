package split;
import java.util.*;

public abstract class UserManager {

    private static HashMap<User,UUID> users = new HashMap<>();
    private static HashMap<UUID,User> uuids = new HashMap<>();

    public static User add(String name) {
        User user = new User(name);
        users.put(user, user.getID());
        uuids.put(user.getID(), user);
        return user;
    }

    public static void remove(User user) {
        uuids.remove(get(user));
        users.remove(user);
    }

    public static UUID get(User user) {
        return user.getID();
    }

    public static User get(UUID id) {
        return uuids.get(id);
    }

    public static String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Users map: (K: User, V: UUID)");
        for (UUID id : uuids.keySet()) {
            sb.append("User: " + get(id).getName() + "\tUUID: " + id);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return print();
    }
}
