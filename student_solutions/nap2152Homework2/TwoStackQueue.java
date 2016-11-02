
public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
	//Creates two stacks to use in this queue
	MyStack<AnyType> s1 = new MyStack<AnyType>();
	MyStack<AnyType> s2 = new MyStack<AnyType>();
	
	//Adds an item to one of the stacks in the queue
	public void enqueue(AnyType x) {
		//If the second stack is empty, adds the item to the first stack
		if (s2.isEmpty()) {
			s1.push(x);
		} else {
			//Otherwise moves everything from stack 2 to stack one in reverse
			//order and then adds the item to the top of stack 1
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			s1.push(x);
		}
	}

	//Removes the first enqueued item from the two stack queue and returns it
	public AnyType dequeue() {
		// If both stacks are empty returns null
		if (this.isEmpty()) {
			return null;
		}
		
		//If stack 1 is empty, returns and removes the top of stack 2
		if (s1.isEmpty()) {
			return s2.pop();
		} else {
			//Otherwise moves everything from stack 1 to stack 2 but the last 
			//item and returns and removes the last item
			while (s1.size() != 1) {
				s2.push(s1.pop());
			}
			return s1.pop();
		}
	}

	//Returns if the two stack queue is empty
	public boolean isEmpty() {
		//Two stack queue is empty if and only if both stack 1 and 2 are empty
		if(s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		return false;
	}

	//Returns the size of the two stack queue
	public int size() {
		//Size of two stack queue is size of stack 1 and 2 combined
		return (s1.size() + s2.size());
	}

}
