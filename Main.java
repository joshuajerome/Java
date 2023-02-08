
class Main {

    private static Database database = new Database();
    public static void main(String[] args) {
        database.clearDatabase();
        database.addNameFile("sample.txt");
        database.printDatabase();

        System.out.println("\n");
        database.add("Asher");
        database.printDatabase();

        database.clearDatabase();
    }
}
