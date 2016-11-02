/*Ziyi Sun
 *zs2293
 */
//implements Queue with MyStack

public class TwoStackQueue<E> implements MyQueue<E>{
	
	private MyStack<E> s1;
	private MyStack<E> s2;
	
	public TwoStackQueue(){
		s1 = new MyStack<E>();
		s2 = new MyStack<E>();
	}
	
	public void enqueue(E x) {
		s1.push(x);
		
	}

	public E dequeue() {
		
		//pop all of s1 elements onto s2 so they are reversed
		while (!s1.isEmpty()){
			s2.push(s1.pop());
		}
		
		//first element for dequeue was last pushed s2
		E x = s2.pop();
		
		//pop all of s2 elements onto s1 so they are back in order
		while (! s2.isEmpty()){
			s1.push(s2.pop());
		}
		
		return x;
	}

	public boolean isEmpty() {
		return s1.isEmpty();
	}

	public int size() {
		return s1.size();
	}

}



