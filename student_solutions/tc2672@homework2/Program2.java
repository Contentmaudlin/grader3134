/***************************************************************
 * Problem2.java
 * By: Tahiya Chowdhury 
 * Homework 2
 ***************************************************************/

public class Problem2 {
	/** If implemented correctly, this code should output:      
	  *   6
      * Rachel
      * Chandler
      * Ross
      * Pheobe
      * Joey
      * Monica
      * null
	  **/    
	public static final void main(String[] args) {
		TwoStackQueue<String> myQueue = new TwoStackQueue<String>();
		
		myQueue.enqueue("Rachel"); 
		myQueue.enqueue("Chandler"); 
		myQueue.enqueue("Ross"); 
		myQueue.enqueue("Pheobe"); 
		myQueue.enqueue("Joey"); 
		myQueue.enqueue("Monica"); 

		//Checks if the size method has been implemented correctly. 
		System.out.println(myQueue.size()); 
		
		
		while(!myQueue.isEmpty()) {
			System.out.println(myQueue.dequeue());
		}
		
		//Checks if the program returns null if both stack1 and stack2 are empty
		System.out.println(myQueue.dequeue());
		
	}
}