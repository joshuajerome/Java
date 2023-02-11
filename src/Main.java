package src;
class Main {

    private static Database database = new Database();
    public static void main(String[] args) {

        if (args.length != 0) {
            for (String s : args) {
                database.addNameFile(s);
            }
        } else {
            database.addNameFile("resources/sample.txt");
            database.addNameFile("resources/sample2.txt");
        }
        database.printContacts();
    }

    // private static User createUser() {

    // }
}