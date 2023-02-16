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

    /* Functionality:   Round a given number to the nth decimal place 
     * Implementation:  For a cost with recurring decimal values, round it
     * Pre-Condition:   Number is a double with at least n+1 decimal values
     * Post-Condition:  Return the rounded number 
    */
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
                        sub array approaches allCosts / k
     * Implementation:  Places each cost from allCosts in one of the k subarrays such that 
     *                  the sum of each subarray is approximately allCosts/k
     *                  
     *                  Steps:
     *                  1. Instantiate:
     *                      a. List<List<Double>> subArrays; in which all sub arrays are stored
     *                      b. List<Double> sub; to which each element is added, stored into subArray, then cleared
     *                      c. HashSet<Integer> added; to track which elements from allCosts have 
     *                         been stored in subArrays
     *                  2. Sort allCosts and determine the totalCost by accumulating allCosts
     *                  3. Instantiate List<Double> kExpected; which creates a list of the expected costs per subarray
     *                  4. Intialize an upperEnd to keep track of the last (greatest) element in allCosts
     *                  For the rest of the steps, see comments within generateSubArrays(); 
     * 
     * Pre-Condition:   allCosts is a non-null non-empty list of double vales; k is a positive integer
     * Post-Condition:  returns subarrays from allCosts that fulfills the functionality.
     */
    private List<List<Double>> generateSubArrays(List<Double> allCosts, int k) {
        List<List<Double>> subArrays = new ArrayList<>();
        HashSet<Integer> added = new HashSet<>();

        Collections.sort(allCosts);
        double totalCost = sumList(allCosts);
        List<Double> kExpected = expected(totalCost, k);

        int upperEnd = allCosts.size() - 1;
        
        for (int i = 0; i < k; i++) {                                                               /* For each subArray... */                            
            List<Double> sub = new ArrayList<>();
            sub.add(allCosts.get(upperEnd));                                                        /* Add the greatest value from allCosts to subArray */
            added.add(upperEnd);                                                                    /* Add the index of the greatest value into 'added' hashSet 
                                                                                                       to ensure it's only used once */
            double minDiff = Math.abs(kExpected.get(i) - sumList(sub));                             /* Calculate the min difference by taking the absolute value of 
                                                                                                       the difference between the expected value of the current subarray 
                                                                                                       and the sum of the current subarray (which is just upperEnd at this point) */
            for (int h = 0; h < upperEnd; h++) {                                                    /* Loop through each value in allCosts */
                int potential = upperEnd;                                                           /* Create a potential value and assign it to upperEnd. Will revisit potential later */
                for (int j = 0; j < upperEnd; j++) {                                                /* Loop through each value in allCosts again! See bottom of function for explanation */
                    if (!added.contains(j)) {                                                       
                        double diff = Math.abs(kExpected.get(i) - sumList(sub) - allCosts.get(j));  /* calculate the current difference which is absolute value of 
                                                                                                       the expected sum - sum of the current subArray - the cost being compared */
                        if (diff < minDiff) {                                                      
                            minDiff = diff;                                                         
                            potential = j;                                                          /* The value at index 'j' is now a potential target to add into the current subarray */
                        } else {
                            break;                                                                  /* Otherwise, I don't care about this value, just move on to next value */
                        }
                    }
                }
                if (potential != upperEnd) {                                                        /* If my potential is not UpperEnd, then I have compared all remaining values and
                                                                                                       found one such that the sum of the current list is closer to my expected sum */
                    sub.add(allCosts.get(potential));                                               
                    added.add(potential);
                }
            }
            upperEnd--;
            subArrays.add(sub);
        }
        return subArrays;
    }
    /* The values in total cost is looped through twice creating a time complexity of O(n^2). The inner-most loop is to find a new value to add to my current subarray 
     * The outer-loop that increment h from h = 0 while h < upperEnd, is to check if any MORE values can be added into the same sub array. Without this nested check,
     * each subarray would only have a max size of 2 - as one potential would be added, and then the subarray would be stored then cleared.
    */

    /* Prints all the generated subarrays */
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
