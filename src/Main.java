package src;
class Main {

    public static void main(String[] args) {
        User joshua = new User("Joshua");

        if (args.length != 0) {
            for (String s : args) {
                joshua.database.addNameFile(s);
            }
        } else {
            joshua.database.addNameFile("resources/sample.txt");
            joshua.database.addNameFile("resources/sample2.txt");
            // database.contacts.get("Joshua").setEmail("joshua.jerome@gmail.com");
            joshua.database.contacts.get("Joshua").setPhone("9256403186");
            joshua.database.contacts.get("Joshua").setPhone("510676221");
            joshua.database.contacts.get("Joshua").setPhone("5106762224");
            // System.out.println(joshua.database.contacts.containsKey("Dante"));

        }

        joshua.database.printContacts();
    }

    // private static User createUser() {

    // }
}