/*Francisco Fernandez De Ybarra
 * Tester class for TwoStackQueue, expected output should be 1, 2, 3, 2
 */


public class Program2{
	
    public static final void main(String[] args) {
	
    	TwoStackQueue<Integer> queue = new TwoStackQueue<>();
    	queue.enqueue(1);
    	queue.enqueue(2);
    	queue.enqueue(3);
		queue.enqueue(4);
		System.out.println(queue.dequeue());
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.size());

    }
    
    
}