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
            joshua.database.search("dantE").setEmail("db@icloud.com");

        }

        joshua.database.printContacts();
    }

    // private static User createUser() {

    // }
}