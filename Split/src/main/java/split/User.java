package split;
import java.util.*;
import org.apache.commons.lang3.text.WordUtils;

public class User {
    
    private String name;
    /* Fields map stores all fields that users can have such as: email, number, etc. */
    private HashMap<String, String> fields;
    private UUID id;

    /* GENERAL USER FUNCTIONS */
    
    /* Primariy constructor for User, assigns field name */
    public User(String name) {
        fields = new HashMap<>();
        id = UUID.fromString(name);
        this.name = name;
        /*
         * Purpose of the line above is to add a User to it's own contact list 
         * when this constructor is called in Database.addContact(), 
         * the new user is added to it's own contact list AND is added to 'this' user's
         * contact list.
        */
    }

    public String getName() {
        return name;
    }

    public UUID getID() {
        return id;
    }

    /* Generic addField function that allows user to specify a new field and value to add
     * to a user. User CANNOT add identical field names with different values.
     */
    public void addField(String key, String value) {
        key = WordUtils.capitalize(key); // if format string is deleted, delete this line
        if (!fields.containsKey(key)) {
            fields.put(key,value);
        }
    }

    /* Edits a current field and replaces it with a newValue */
    public void editField(String key, String newValue) {
        key = WordUtils.capitalize(key);
        newValue = WordUtils.capitalize(newValue);
        if (fields.containsKey(key)) {
            fields.replace(key, newValue);
        }
    }

    /* Deletes a field */
    public void deleteField(String key) {
        key = WordUtils.capitalize(key); // if format string si deleted, delete this line
        fields.remove(key);
    }
    
    /* Prints all fields of this User */
    public String getFields() {
        StringBuilder sb = new StringBuilder();
        if (fields == null) {
            sb.append("null");   
            return sb.toString();
        }
        Iterator<String> iterator = fields.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            sb.append("\t\t" + key + ":\t" + fields.get(key));
        }
        return sb.toString();
    }
}
