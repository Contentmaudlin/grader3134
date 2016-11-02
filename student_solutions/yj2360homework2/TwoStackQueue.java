public class TwoStackQueue<T> implements MyQueue<T> {
	
	private MyStack<T> s1;
	private MyStack<T> s2;
	private int theSize;
	
	public TwoStackQueue(){
		s1 = new MyStack<T>();
		s2 = new MyStack<T>();
		theSize = 0;
	}
	
	@Override
	public void enqueue(Object x) {
		s1.push((T) x);
		theSize ++;
	}

	@Override
	public T dequeue() {
		if(s1.isEmpty()) {
			System.out.println("Underflow.");
			return null;
		}
		else {
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			T result = s2.pop();
			while(!s2.isEmpty()){
				s1.push(s2.pop());
			}
			theSize--;
			return result;
			
		} 
	}

	@Override
	public boolean isEmpty() {
		return (s1.size()<1);

	}

	@Override
	public int size() {
		return theSize;
	}
	public static void Main(String[] args){}
}
