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
     * Pre-Condition:   List is a non-null non-empty list of values,
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

    /* Functionality:   Given a number, truncate to n decimal places
     * Implementation:  For a cost with recurring decimal values, truncate it
     * Pre-Condition:   number > 0 and has n decimal places
     * Post-Condition:  truncated number is returned
     */
    private double truncate(double number, int n) {
        double multFactor = Math.pow(10,n);
        int intRep = (int)(number * multFactor);
        return intRep/multFactor;
    }

    private double roundTo(double number, int n) {
        double multFactor = Math.pow(10,n+1);
        int intRep = (int)(number * multFactor);
        if (intRep % 10 > 4) {
            intRep /= 10;
            intRep++;
        } else {
            intRep /= 10;
        }
        multFactor = Math.pow(10,n);
        return intRep/multFactor;
    }

    /* Functionality:   Given a number with 'n' decimal places, return the last digit
     * Implementation:  In expected(), find the remainder value that will be added to
     *                  select values of baseAvg so that total cost is hit
     * Pre-Condition:   Number is some positive number (works regardless), n > 0
     * Post-Condition:  Double to be used as a divisor in expected()
     */
    private double getDivisor(double number, int n) {
        double multFactor = Math.pow(10,n);
        int intRep = (int)(number * multFactor);
        n = -1 * n;
        while (intRep > 0) {
            if (intRep % 10 > 0) return Math.pow(10,n);
            intRep /= 10;
            n++;
        }
        return 0.0;
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
        List<Double> expectedValues = new ArrayList<>();                            /* (Returned) List of expected values for each sub array */

        double baseAvg = truncate(totalCost/k,2);                                /* Computes the baseAvg that each value in sub array will hold */

        /* k * baseAvg gives the sum of all the baseAvgs in this array
         * Depending on if the split was clean, this may not be equal to totalCost,
         * So, we get the place of the least significant digit in the baseAvg, and 
         * increment that place by one until the totalCost is hit. remainder is the 
         * number of times this incrementation must be performed.
         */
        double remainder = roundTo(totalCost - (k * baseAvg),2);
        double remainderSplit = getDivisor(baseAvg, 2);

        for (int i = 0; i < k; i++) {                                               /* Fills expectedValues with the respective expected values */
            expectedValues.add(roundTo((remainder/remainderSplit > 0)? baseAvg + remainderSplit : baseAvg, 2));
            remainder -= remainderSplit;
        }
        return expectedValues;
    }

    /* Functionality:   Generates 'k' sub arrays such that the sum of all values in each 
                        sub array approaches allCosts / k.
     * Implementation:  
     * Pre-Condition:   
     * Post-Condition:  
     */
    private List<List<Double>> generateSubArrays(List<Double> allCosts, int k) {
        List<List<Double>> subArrays = new ArrayList<>();
        HashSet<Integer> added = new HashSet<>();
        
        Collections.sort(allCosts);
        for (double d : allCosts) {
            System.out.print(d + ",\t");
        }
        System.out.println();

        double totalCost = sumList(allCosts);
        List<Double> kExpected = expected(totalCost, k);

        int upperEnd = allCosts.size() - 1, lowerEnd = 0;
        
        for (int i = 0; i < k; i++) {                                /* O(k) */
            List<Double> sub = new ArrayList<>();
            sub.add(allCosts.get(upperEnd));
            added.add(upperEnd);

            double minDiff = Math.abs(kExpected.get(i) - sumList(sub));

            for (int h = 0; h < upperEnd; h++) {
                int potential = upperEnd;
                for (int j = 0; j < upperEnd; j++) {
                    if (!added.contains(j)) {
                        double diff = Math.abs(kExpected.get(i) - sumList(sub) - allCosts.get(j));
                        if (diff < minDiff) {
                            minDiff = diff;
                            potential = j;
                        } else {
                            break;
                        }
                    }
                }
                if (potential != upperEnd) {
                    sub.add(allCosts.get(potential));
                    added.add(potential);
                }
            }
            upperEnd--;
            subArrays.add(sub);
        }
        return subArrays;
    }

    public String printSubArrays(List<Double> allCosts, int k) {
        List<List<Double>> list = generateSubArrays(allCosts, k);
        StringBuilder sb = new StringBuilder();
        list.add(expected(sumList(allCosts),k));
        for (List<Double> l : list) {
            sb.append("[");
            for (Double d : l) {
                sb.append(d + ",\t");
            }
            sb.replace(sb.length() - 1, sb.length(), "]");
            sb.append("\tSum =\t" + sumList(l));
            sb.append("\n");
        }
        return sb.toString();
    }



}
