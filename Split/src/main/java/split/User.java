package split;
import java.util.*;

public class User {
    
    protected HashMap<String, String> fields;
    protected Database database;

    protected int userHash = this.hashCode();

    /* GENERAL USER FUNCTIONS */

    public User() {}
    
    public User(String name) {
        database = new Database();
        fields = new HashMap<>();
        addField("Name",formatString(name));
        database.contacts.put(this, fields);
    }

    public void addField(String key, String value) {
        key = formatString(key);
        if (!fields.containsKey(key)) {
            fields.put(key,value);
        }
    }

    public void editField(String key, String newValue) {
        key = formatString(key);
        newValue = formatString(newValue);
        if (fields.containsKey(key)) {
            fields.replace(key, newValue);
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

    /* FORMATTING FUNCTIONS */

    protected String formatString(String input) {
        StringBuilder valid = new StringBuilder();
        valid.append(Character.toString(input.toUpperCase().charAt(0)));
        valid.append(input.substring(1).toLowerCase());
        return valid.toString();
    }

}
