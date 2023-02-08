
class Main {

    private static Database database = new Database();
    public static void main(String[] args) {
        database.addNameFile("resources/sample2.txt");
        database.addNameFile("resources/sample.txt");
        database.printDatabase();
    }
}
