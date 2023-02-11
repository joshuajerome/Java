package src;
import java.util.*;

public class User {
    
    private String phone;
    private String email;
    private String name;
    
    public User(String name) {
        this.name = Character.toString(name.toUpperCase().charAt(0)) + name.substring(1).toLowerCase();;
    }

    public String getFields() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tName:\t" + name);
        sb.append("\t\tPhone:\t" + phone);
        sb.append("\t\tEmail:\t" + email);
        return sb.toString();
    }

    @Override
    public String toString() {
        return name;
    }

}
