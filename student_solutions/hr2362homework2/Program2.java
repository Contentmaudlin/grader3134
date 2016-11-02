/* Kelly Ryu
 * hr2362
 * Program2.java - tests TwoStackQueue class for accurate model of queue
 */

public class Program2 {
    /** If implemented correctly, this code should output: 
     *  1
     *  8
     *  2
     *  false
     *  3,4,5,6,7,8,9,11
     */
    public static final void main(String[] args) {

        TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
        
        // enqueue integers from 1 to 10 in order
        for (int i = 1; i < 10; i++){
            q.enqueue(i);
        }
 
        System.out.println(q.dequeue()); // dequeue 1
        System.out.println(q.size()); //now size should be 8
        q.enqueue(11); 
        System.out.println(q.dequeue()); // dequeue 2
        System.out.println(q.isEmpty()); // return false
        
        // dequeue remaining elements
        while (!q.isEmpty()){
            System.out.println(q.dequeue());
        }
    }
}
