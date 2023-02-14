package src;
import java.util.*;

public class Calculator extends Occasion {

    /* Calculator Class
     * 
     * Description: Calculates expenses for inviduals over Occasions and Events
     */
    
    public Calculator() {}

    /* Functionality:   Calculates sum of a list
     * Implementation:  Computing sum of sub arrays and original input
     * Pre-Condition:   List is a non-null non-empty list of values
     *                  each of which are > 0.0
     * Post-Condition:  Returns the sum of all values in list
     */
    private double sumList(List<Double> list) {
        double sum = 0;
        for (double i : list) {
            sum += i;
        }
        return sum;
    }

    /* Functionality:   Specific
     * Implementation:  For a given totalCost and k subarrays, calculate
     *                  the expected cost for each subarray. That is, the
     *                  value which sumList on a subarray yields.
     * Pre-Condition:   TotalCost is >= 0.0, k is >= 1
     * Post-Condition:  Returns a list of 'k' double values which represents
     *                  the total cost for each subarray.
     */
    private List<Double> expected(double totalCost, int k) {
        List<Double> expectedValues = new ArrayList<>();                        /* (Returned) List of expected values for each sub array */
        double rawAvg = totalCost/k;                                          /* Stores the raw base expected value for each sub array */
        int tmp = (int)(rawAvg * 100.0);
        double avgValue = tmp/100.0;
        double remainder;

        for (int i = 0; i < k; i++) {                                           /* Fills expectedValues with the respective expected values */
            expectedValues.add(avgValue);
            double runningSum = 0.0;

        }
        return expectedValues;
    }

    /* Functionality:   Primariy function for bill splitting
     * Implementation:  
     * Pre-Condition:   
     * Post-Condition:  
     */
    public List<List<Double>> split(List<Double> allCosts, int k) {
        List<List<Double>> subArrays = new ArrayList<>();
        
        int n = allCosts.size();
        double allCostsSum = sumList(allCosts);
        // List<Integer> kExpected = expected(allCostsSum, k);
        List<Double> kActual;



        return subArrays;
    }

}
