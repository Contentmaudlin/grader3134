package drs2176_HW2;
import java.util.ArrayList;
/*********************************************
 * author: Dan Sendik
 * Uni: drs2176
 * class: Data Strucures
 * HW submission: 2
 ********************************************/
import java.util.NoSuchElementException;
/**
 * This is the interface that your TwoStackQueue class must implement.
 */
public interface MyQueue<AnyType> {

	public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
		private int currentSize;
		private int head_S1;
		private int head_S2;
		private int tail;
		private ArrayList<AnyType> s1 = new ArrayList<AnyType>();
		private ArrayList<AnyType> s2= new ArrayList<AnyType>();
		private Node first;
		private int dequeue_count;


		public TwoStackQueue() {
			currentSize = 0;
			head_S1 = 0;
			head_S2 = 0;
			tail = 0;
			first = null;
			dequeue_count = 0;
		}

		class Node {
			public Object data;
			public Node next; 

		}
		// Adds elements to stack1
		public AnyType push_to_Stack1(AnyType element) {
			Node newNode = new Node(); 
			newNode.data = element; 
			newNode.next = first; 
			first = newNode;
			return element;
		}
		// Removes elements from stack 2. Doesn't actually remove them. just overwrites
		// the last element. This stack will have the last removed element at the top
		public void pop_from_Stack2(int head_S2) {
			if (first == null) { 
				throw new NoSuchElementException(); 
			} 
			first = first.next;
								}
		// Empties Stack1 of all values
		public void empty_Stack1() {
			s1.clear();
		}

		public boolean empty_Stack2() {
			return first == null; 
		}
		// Performs the enqueue operation
		public void enqueue(AnyType newElement) {
			currentSize++;
			s1.add(push_to_Stack1(newElement));
			tail = (tail + 1) % s1.size();
		}

		// Performs the dequeue operation. For this assignment, if you
		// attempt to dequeue an already empty queue, you should return
		// null
		public AnyType dequeue() {
			s2.add(head_S2, s1.get(head_S1));
			//s2[head_S2] = s1[head_S1];
			if (isEmpty())
				return null;
			Object removed = s2.get(head_S2);
			pop_from_Stack2(head_S2);
			head_S1 = (head_S1 + 1);
			dequeue_count++;
			currentSize--;
			// Because the MyQueue was provided and to be used as is,
			// I cast the rreturn to Anytype. This warning could be removed
			// if this method used Object instead of AnyType.
			return (AnyType) removed;
		}
		// Checks the size of s1, and if there is no more space,
		// the first 10 elements are copied over to a new array with
		// two times the space


		// Checks if the Queue is empty
		public boolean isEmpty() {
			return currentSize == 0;
		}

		// Returns the number of elements currently in the queue
		public int size() {
			return currentSize;
		}
	}
}