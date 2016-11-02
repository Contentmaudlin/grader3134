/***************************************************************
 * MyStack.java
 * By: Tahiya Chowdhury 
 * Homework 2
 ***************************************************************/

import java.util.NoSuchElementException;

public class MyStack<AnyType> {
	
	private Node head;
	private int totalElements;
	
	// The node class
	public class Node {
		public AnyType dataInNode; //data inside node
		public Node next; // Next node
	}
	
	
	public MyStack() {
		totalElements = 0;
		head = null;
	}
	
	//Adding element to the top of the stack
	public void push(AnyType element) {
		
		Node temp = new Node();
		temp.dataInNode = element;
		temp.next = head;
		head = temp;
		totalElements++; /*increments the total number of elements by 1 after
		 adding new element*/
	}
	
	//Removing element from the top of the stack
	public AnyType pop(){
		//Checks if the head node is empty
		if (head == null){
			throw new NoSuchElementException();
		}
		/*If not, transfers the data from the current head to variable element
		 * and returns it and makes the next node the new head
		*/
		AnyType element = head.dataInNode;
		head = head.next;
		totalElements--; /*Decrements the total number of elements by 1 after  
		removing an element from the stack*/
        
		return element;
	}
	
	//Checks if the stack is empty
	public boolean isEmpty(){
		if(totalElements==0)
			return true;
		else
			return false;
	}
	
}
