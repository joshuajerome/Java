package src;
import java.util.*;

class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        User joshua = new User("joshua");
        joshua.database.addContactFile("resources/sample.txt");
        Calculator c = new Calculator();
        Double array1[] = new Double[] {7.0,11.0,13.0,9.0,41.0,37.0,23.0,29.0,43.0}; // 53.25 split by 4
        Double array2[] = new Double[] {5.0,7.0,11.0,14.0,22.0,39.0,50.0}; // 49.33 split by 3
        Double array3[] = new Double[] {5.0,10.0,20.0,8.0,15.0}; // 19.33 split by 3
        Double array4[] = new Double[] {10.0,15.0,20.0,1.0,35.0,20.0}; // 33.66 split by 3
        List<Double> totalCost = Arrays.asList(array2);
        System.out.println(c.printSubArrays(totalCost, 3));
    }
    
}