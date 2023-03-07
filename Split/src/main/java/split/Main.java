package split;

class Main {

    /** BRANCH MANAGEMENT
     *  1) git checkout -b "name of branch" origin/main
     *  - check what branch i'm on: git branch -a
     *  - see differences: git diff "File name"
     *  2) Make changes
     *  3) git add
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

        /* Create JUnit tests */

        /** 
         * Home class
         * Change database
         * Remove extensions, events are not trips 
         */

        User user1 = new User("joshua jerome");
        User user2 = new User("jerome purushotham");

        /* Testing addUser in Database */
        System.out.println("Testing addUser in Contacts:\n");
        user1.addContact(user2);
        user1.printContacts();
        
        /* Testing deleteUser in Database */
        System.out.println("Testing deleteUser in Contacts:\n");
        user1.deleteContact(user2);
        user1.printContacts();

        /* Testing addField in User */
        System.out.println("Testing addField in User:\n");
        user1.addField("email", "joshua.jerome@gmail.com");
        user1.printContacts();

        /* Testing editField in User */
        System.out.println("Testing editField in User:\n");
        user1.editField("email", "sherwinjjerome@gmail.com");
        user1.printContacts();

        /* Testing deleteField in User */
        System.out.println("Testing deleteField in User:\n");
        user1.deleteField("email");
        user1.printContacts();

        /* Testing Trip */
        Event event1 = new Event("groceries");
        Event event2 = new Event("Dinner on Friday");
        event1.addMember(user2);

        Trip trip1 = new Trip("Disney World");
        trip1.addParticipant(user1);
        trip1.addParticipant(user2);
        trip1.addAllParticipantsToEvent(event2);

        trip1.addEvent(event1);
        trip1.addEvent(event2);

        trip1.printTripDetails();

        user1.setBalance(-100.0);
        user1.request(user2, 100.0, "Friday Dinner");
        user2.send(user1, 100.0, "Friday Dinner");
        System.out.println(user1.printBalances());
        System.out.println(user2.printBalances());

        System.out.println(user1.getTransactionHistory());
        System.out.println(user2.getTransactionHistory());

        // Calculator c = new Calculator();
        // Double array1[] = new Double[] {7.0,11.0,13.0,9.0,41.0,37.0,23.0,29.0,43.0}; // 53.25 split by 4
        // Double array2[] = new Double[] {5.0,7.0,11.0,14.0,22.0,39.0,50.0}; // 49.33 split by 3
        // Double array3[] = new Double[] {5.0,10.0,20.0,8.0,15.0}; // 19.33 split by 3
        // Double array4[] = new Double[] {10.0,15.0,20.0,1.0,35.0,20.0}; // 33.66 split by 3
        // Double array5[] = new Double[] {2.0,5.0,7.0,1.0,9.0,8.0,3.0,6.0}; // 13.33 split by 3
        // Double array6[] = new Double[] {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0}; // 11.0 split by 5
        // List<Double> totalCost = Arrays.asList(array1);
        // System.out.println(c.printSubArrays(totalCost,4));
    }
}