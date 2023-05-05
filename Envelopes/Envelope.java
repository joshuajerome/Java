import javax.naming.CannotProceedException;

public class Envelope {
    
    private int balance;
    private String name;
    private int priority;
    private UUID id;

    public Envelope(String name, int balance) {
        this.name = name;
        this.balance = balance;
        id = new UUID();
    }

    public void setPriority(int x) {
        priority = x;
    }

    public int getPriority() {
        return priority;
    }

    public int getbalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public UUID getUUID() {
        return id;
    }

    public void decerement(int amount) {
        if (amount > balance) throw new CannotProceedException("decrement amount > balance");
        balance -= amount;
    }

    public void increment(int amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: " + name + "\n");
        stringBuilder.append("Balance:" + balance + "\n");
        stringBuilder.append("Priority" + priority + "\n");
        return stringBuilder.toString();
    }
}
