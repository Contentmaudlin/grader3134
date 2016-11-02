/* Name : Peter Drake
 * UNI : pjd2132
 *  
 *  Program2.java - Tests all methods of TwoStacksQueue.java to see 
 *  if the two stacks really do work like a queue. 
 */
public class Program2 {
    public static void main(String[] args){
    //Creates two Queues, one of Integers and the other Characters
    //and tests if these two queues behave as they should.
        
        TwoStackQueue<Integer> test1 = new TwoStackQueue<Integer>();
        
        System.out.println(test1.size());  //Should output 0
        test1.enqueue(1);
        test1.enqueue(2);
        System.out.println(test1.dequeue());  //Should output 1
        test1.enqueue(3);
        System.out.println(test1.dequeue());  //Should output 2
        test1.enqueue(4);
        test1.enqueue(5);
        System.out.println(test1.size());     //Should output 3
        
        //Tests the isEmpty method
        while(!test1.isEmpty()){              //Should output 4, 5
            System.out.println(test1.dequeue());
        }
        
        
        System.out.println("Outputs above should be: 0, 1, 2 ,3, 4, 5");
        
        TwoStackQueue<Character> test2 = new TwoStackQueue<Character>();
        
        test2.enqueue('a');
        test2.enqueue('b');
        test2.enqueue('c');
        test2.enqueue('d');
        System.out.println(test2.size());     //Should output 4
        System.out.println(test2.dequeue());  //Should output a
        System.out.println(test2.dequeue());  //Should output b
        System.out.println(test2.dequeue());  //Should output c 
        System.out.println(test2.dequeue());  //Should output d
        
        System.out.println("The five outputs above should be: 4, a, b, c, d");
    }
}
