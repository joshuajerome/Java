package src;
import java.util.*;

public class User{
    
    private String phone;
    private String email;
    private String name;

    protected Database database;
    
    public User(String name) {
        database = new Database();
        setName(name);
    }

    public String getFields() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tPhone:\t" + phone);
        sb.append("\t\tEmail:\t" + email);
        return sb.toString();
    }

    public boolean setName(String name) {
        name = validateName(name);
        System.out.println(database.contacts.containsKey("Dante"));
        if (database.contacts.containsKey(name)) return false;
        this.name = name;
        return true;
    }

    private String validateName(String input) {
        StringBuilder valid = new StringBuilder();
        valid.append(Character.toString(input.toUpperCase().charAt(0)));
        valid.append(input.substring(1).toLowerCase());
        return valid.toString();
    }

    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public boolean setPhone(String phone) {
        if (validatePhone(phone).length() != 0) {
            this.phone = phone;
            return true;
        }
        return false;
    }

    private String validatePhone(String input) {
        StringBuffer valid = new StringBuffer();
        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                valid.append(c);
            }
        }
        if (valid.length() != 10) return "";        
        return valid.toString();
    }

    @Override
    public String toString() {
        return name;
    }

}
