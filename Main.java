
class Main {

    private static Database database = new Database();
    public static void main(String[] args) {
        database.addNameFile("sample2.txt");
        database.addNameFile("sample.txt");
        database.printDatabase();
    }
}
