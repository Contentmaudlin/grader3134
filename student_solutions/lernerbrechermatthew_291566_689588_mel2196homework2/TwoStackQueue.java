public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	MyStack<AnyType> s1;
	MyStack<AnyType> s2;
	int size;

	public TwoStackQueue() {
		s1 = new MyStack<AnyType>();
		s2 = new MyStack<AnyType>();
		size = 0;
	}

	public void enqueue(AnyType x) {
		//Loop moves elements of s2 to s1 so that bottom element becomes top and vice versa
		while (!s2.isEmpty()) { 
			s1.push(s2.pop());
		}
		s1.push(x);
		size += 1;
	}

	public AnyType dequeue() {
		//Loop moves elements of s2 to s1 so that bottom element becomes top and vice versa
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		if (s2.isEmpty()) { //If there are no elements in queue
			return null;
		}
		size -= 1;
		return s2.pop();
	}

	public boolean isEmpty() {
		return (s1.isEmpty() && s2.isEmpty());
	}

	public int size() {
		return size;
	}
}