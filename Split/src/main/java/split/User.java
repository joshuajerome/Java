package split;
import java.util.*;
import org.apache.commons.lang3.text.WordUtils;

public class User {
    
    private String name;
    /* Fields map stores all fields that users can have such as: email, number, etc. */
    private HashMap<String, String> fields;
    /* Each user has a contacts in which the user themself is stored along with user's contacts */
    private HashSet<User> contacts;

    private HashMap<Transaction, TransactionManager> transactionHistory;
    private HashMap<User, Double> balances;


    /* GENERAL USER FUNCTIONS */
    
    /* Primariy constructor for User, assigns field name */
    public User(String name) {
        fields = new HashMap<>();
        contacts = new HashSet<>();
        transactionHistory = new HashMap<>();
        balances = new HashMap<>();
        this.name = name;
        addContact(this);
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

    /* CONTACTS FUNCTIONS */

    public void addContact(User user) {
        contacts.add(user);
    }

    public void deleteContact(User user) {
        if (contacts.contains(user)) {
            contacts.remove(user);
            return;
        }
    }

    public void printContacts() {
        if (contacts.size() == 0) {
            System.out.println("Users is empty!");
            return;
        }
        int counter = 0;
        for (User user : contacts) {
            System.out.println("Entry " + ++counter + ":\t" + user.getName() + "\tFields: " + user.getFields() + "\n");
        }
        if (contacts.size() == 0) System.out.println("Database is empty!\n");
    }

    /* TRANSACTION FUNCTIONS */

    public Transaction request(User user, double amount, String message) {
        Transaction transaction = new Transaction(TransactionType.REQUEST, amount, message);
        TransactionManager transactionManager = new TransactionManager(this, user, transaction);
        transactionManager.transact();
        return transaction;
    }

    public void settle(Transaction transaction) {
        transaction.setTransactionType(TransactionType.SETTLE);
        transactionHistory.get(transaction).transact();
    }

    public String printTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "'s Transaction History:\n\n" );
        for (Transaction transaction : transactionHistory.keySet()) {
            sb.append(transaction.getInfo() + "\n\n");
        }
        return sb.toString();
    }

    public HashMap<Transaction,TransactionManager> getTransactionHistory() {
        return transactionHistory;
    }

    /* BALANCE FUNCTIONS */

    public HashMap<User, Double> getBalances() {
        return balances;
    }

    public String printBalances() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "'s Balances:\n");
        if (balances == null) {
            sb.append("null");   
            return sb.toString();
        }
        for (User key : balances.keySet()) {
            sb.append("\t\t" + key.getName() + ":\t" + balances.get(key));
        }
        sb.append("\n");
        return sb.toString();
    }
}
