package split;
import java.util.*;
import org.apache.commons.lang3.text.WordUtils;

public class User {
    
    private String name;
    /* Fields map stores all fields that users can have such as: email, number, etc. */
    private HashMap<String, String> fields;
    /* Each user has a contacts in which the user themself is stored along with user's contacts */
    private HashSet<User> contacts;

    private HashMap<User, Double> balances;
    private double balance;
    private List<Transaction> transactionHistory;

    /* GENERAL USER FUNCTIONS */
    
    /* Primariy constructor for User, assigns field name */
    public User(String name) {
        fields = new HashMap<>();
        contacts = new HashSet<>();
        balances = new HashMap<>();
        balance = 0;
        transactionHistory = new ArrayList<>();
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

    /* TRANSACTION BALANCE FUNCTIONS */

    public HashMap<User, Double> getBalances() {
        return balances;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        balances.put(this,balance);
    }

    public double getBalance() {
        return balance;
    }

    public void request(User user, double amount, String msg) {
        Transaction transaction = new Transaction(this, user, TransactionType.REQUEST, amount, msg);
        transaction.transact();
        transactionHistory.add(transaction);
    }

    public void send(User user, double amount, String msg) {
        Transaction transaction = new Transaction(this, user, TransactionType.SEND, amount, msg);
        transaction.transact();
        transactionHistory.add(transaction);
    }

    public void ignore(Transaction transaction) {
        transaction.setTransactionType(TransactionType.IGNORE);
    }

    public void settle(Transaction transaction) {

    }

    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "'s Transaction History:\n\n" );
        for (Transaction transaction : transactionHistory) {
            sb.append(transaction.getInfo() + "\n\n");
        }
        return sb.toString();
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
