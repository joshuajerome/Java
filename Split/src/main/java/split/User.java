package split;
import java.util.*;

public class User {
    
    /* Fields map stores all fields that users can have such as: name, email, number, etc. */
    protected HashMap<String, String> fields;
    /* Each user has a database in which the user themself is stored along with user's contacts */
    protected Database database;

    /* GENERAL USER FUNCTIONS */

    /* Default constructor required for super class initialization */
    public User() {}
    
    /* Primariy constructor for User, assigns field name */
    public User(String name) {
        database = new Database();
        fields = new HashMap<>();
        name = formatString(name); // if format string is deleted, delete this line
        addField("Name",name);
        
        /* Comment:
         * Purpose of the line below is to add a User to it's own contact list 
         * when this constructor is called in Database.addContact(), 
         * the new user is added to it's own contact list AND is added to 'this' user's
         * contact list.
        */
        database.users.add(this);
    }

    /* Generic addField function that allows user to specify a new field and value to add
     * to a user. User CANNOT add identical field names with different values.
     */
    public void addField(String key, String value) {
        key = formatString(key); // if format string is deleted, delete this line
        if (!fields.containsKey(key)) {
            fields.put(key,value);
        }
    }

    /* Edits a current field and replaces it with a newValue */
    public void editField(String key, String newValue) {
        key = formatString(key);
        newValue = formatString(newValue);
        if (fields.containsKey(key)) {
            fields.replace(key, newValue);
        }
    }

    /* Deletes a field */
    public void deleteField(String key) {
        key = formatString(key); // if format string si deleted, delete this line
        fields.remove(key);
    }
    
    /* Prints all fields of this User */
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

    /* Formats a string by making the first character uppercase, and the rest lowercase */
    protected String formatString(String input) {
        StringBuilder valid = new StringBuilder();
        valid.append(Character.toString(input.toUpperCase().charAt(0)));
        valid.append(input.substring(1).toLowerCase());
        return valid.toString();
    }

}
