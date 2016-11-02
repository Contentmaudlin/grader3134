/**
 COMS 3134 Homework 2
 Madeline Wu (mcw2175)
 October 7, 2016

 This class tests the enqueue and dequeue operations of TwoStackQueue.
 */

public class Program2 {

    /*Main method to test enqueue and dequeue methods. */
    public static void main(String[] args) {
        TwoStackQueue test = new TwoStackQueue();
        test.enqueue('A');
        test.enqueue('B');
        test.enqueue('C');
        test.enqueue('D');
        test.enqueue('E');
        /*Should print alphabetically. */
        System.out.println(test.dequeue());
        while (!test.S2.empty()) {
            System.out.println(test.dequeue());
        }
    }

} //end class
