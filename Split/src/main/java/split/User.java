package split;
import java.util.*;

public class User {
    
    protected HashMap<String, String> fields;
    protected Database database;

    /* GENERAL USER FUNCTIONS */

    public User() {}
    
    public User(String name) {
        database = new Database();
        fields = new HashMap<>();
        setName(name);
        database.contacts.put(this, fields);
    }

    public void addField(String key, String value) {
        key = formatString(key);
        if (!fields.containsKey(key)) {
            fields.put(key,value);
        }
    }
    
    public String printFields() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = fields.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            sb.append("\t\t" + key + ":\t" + fields.get(key));
        }
        return sb.toString();
    }

    /* BASIC USER FIELDS */

    public boolean setName(String input) {
        Iterator<User> iterator = database.contacts.keySet().iterator();
        input = formatString(input);
        while (iterator.hasNext()) {
            User tmp = iterator.next();
            if (tmp.fields.get("name").equals(input)) {
                return false;
            }
        }
        fields.put("name",input);
        return true;
    }

    public boolean setEmail(String email) {
        fields.put("email", email);
        return true;
    }

    public boolean setPhone(String phone) {
        if (validatePhone(phone).length() != 0) {
            fields.put("phone", phone);
            return true;
        }
        return false;
    }

    protected String validatePhone(String input) {
        StringBuffer valid = new StringBuffer();
        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                valid.append(c);
            }
        }
        if (valid.length() != 10) return "";        
        return valid.toString();
    }

    /* FORMATTING FUNCTIONS */

    protected String formatString(String input) {
        StringBuilder valid = new StringBuilder();
        valid.append(Character.toString(input.toUpperCase().charAt(0)));
        valid.append(input.substring(1).toLowerCase());
        return valid.toString();
    }

}
