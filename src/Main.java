package src;
import java.util.*;

class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        User joshua = new User("joshua");
        joshua.database.addContactFile("resources/sample.txt");

        // joshua.database.searchUser("Suvass").setName("Raghav");
        joshua.database.deleteContact("Gautam");

        joshua.database.createEvent("Dinner");

        // System.out.println(joshua.database.getEvent("Dinner").addMember("Gautam"));
        // joshua.database.getEvent("Dinner").printMembers();

        User dante = new User("dante");
        dante.database.addContactFile("resources/sample2.txt");
        
        System.out.println("\nJoshua's Contacts:\n");
        joshua.database.printContacts();

        System.out.println("\nDante's Contacts:\n");
        dante.database.printContacts();
    }
}