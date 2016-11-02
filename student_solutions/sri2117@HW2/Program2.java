/*********************
Sunand Iyer
sri2117
This is a class for 
testing a queue with 
2 stacks
**********************/


public class Program2 {

    /** If implemented correctly, this code should output: 
     * 3
     * 2
     * false
     * Paul
     * Mary
     * null
     */
    
    public static final void main(String[] args) {

		TwoStackQueue<String> q = new TwoStackQueue<String>();
		
		q.enqueue("Peter");
		q.enqueue("Paul");
		q.enqueue("Mary");
		System.out.println(q.size());
		q.dequeue();
		System.out.println(q.size());
		System.out.println(q.isEmpty());

		while(!q.isEmpty())
		    System.out.println(q.dequeue());

		System.out.println(q.dequeue());
		
    }

}