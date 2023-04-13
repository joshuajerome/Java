package split;

import java.util.*;

class Main {
    //a
    /** BRANCH MANAGEMENT
     *  1) git checkout -b "name of branch" origin/main
     *  - check what branch i'm on: git branch -a
     *  - see differences: git diff "File name"
     *  2) Make changes
     *  3) git add -A
     *  4) git commit -m "message"
     *  5) git push origin "branch name"
     *  6) create pull request
     *  7) Get approval
     *  8) create merge request
     *  9) Then locally...
     * 10) git checkout main
     * 11) git fetch
     * 12) git rebase 
     * 13) git branch -D "branch name"
     */

    public static void main(String[] args) {
        run();
    }

    private static void run() {

        Calculator c = new Calculator();
        List<Double> totalCost;

        System.out.println("Test Case 1:");
        Double array1[] = new Double[] {7.0,11.0,13.0,9.0,41.0,37.0,23.0,29.0,43.0}; // 53.25 split by 4
        totalCost = Arrays.asList(array1);
        System.out.println(c.printSubArrays(totalCost,9));
        System.out.println(c.printSubArraysOLD(totalCost,9));

        System.out.println("Test Case 2:");
        Double array2[] = new Double[] {5.0,7.0,11.0,14.0,22.0,39.0,50.0}; // 49.33 split by 3
        totalCost = Arrays.asList(array2);
        System.out.println(c.printSubArrays(totalCost,3));
        System.out.println(c.printSubArraysOLD(totalCost,3));

        System.out.println("Test Case 3:");
        Double array3[] = new Double[] {5.0,10.0,20.0,8.0,15.0}; // 19.33 split by 3
        totalCost = Arrays.asList(array3);
        System.out.println(c.printSubArrays(totalCost,3));
        System.out.println(c.printSubArraysOLD(totalCost,3));

        System.out.println("Test Case 4:");
        Double array4[] = new Double[] {10.0,15.0,20.0,1.0,35.0,20.0}; // 33.66 split by 3
        totalCost = Arrays.asList(array4);
        System.out.println(c.printSubArrays(totalCost,3));
        System.out.println(c.printSubArraysOLD(totalCost,3));

        System.out.println("Test Case 5:");
        Double array5[] = new Double[] {2.0,5.0,7.0,1.0,9.0,8.0,3.0,6.0}; // 13.33 split by 3
        totalCost = Arrays.asList(array5);
        System.out.println(c.printSubArrays(totalCost,3));
        System.out.println(c.printSubArraysOLD(totalCost,3));

        System.out.println("Test Case 6:");
        Double array6[] = new Double[] {1.0,2.0,3.0,4.0,5.0,6.0}; // 21.0 split by 3 = 7.0
        totalCost = Arrays.asList(array6);
        System.out.println(c.printSubArrays(totalCost,3));
        System.out.println(c.printSubArraysOLD(totalCost,3));

        System.out.println("Test Case 7:");
        Double array7[] = new Double[] {15.0,49.0,17.49,21.22,18.30,18.35,19.1,20.21}; // split by 3 
        totalCost = Arrays.asList(array7);
        System.out.println(c.printSubArrays(totalCost,3));
        System.out.println(c.printSubArraysOLD(totalCost,3));
        
        
        UserManager userManager = UserManager.getInstance();
        TransactionHistoryManager transactionHistoryManager = TransactionHistoryManager.getInstance();
        TransactionManager transactionManager = TransactionManager.getInstance();
        
        // higher order create user function
        User user1 = userManager.addUser("Joshua");
        User user2 = userManager.addUser("Suvass");
        User user3 = userManager.addUser("Raghav");

        // higher order function that creates a transaction
        Transaction transaction1 = new Transaction(TransactionType.REQUEST, 100.0, "food");
        Transaction transaction2 = new Transaction(TransactionType.REQUEST, 50.0, "dinner");

        transactionManager.transact(user1.getID(), user2.getID(), transaction1);
        transactionManager.transact(user1.getID(), user3.getID(), transaction2);

        System.out.println(transactionHistoryManager.toString());

    }
}