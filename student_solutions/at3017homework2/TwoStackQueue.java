/**
 * Akbota Toxanbayeva
 * at3017
 */

public class TwoStackQueue <E>{
	private MyStack<E> inbox = new MyStack<E>();
	private MyStack<E> outbox = new MyStack<E>();

	public void enqueue(E item){
		inbox.push(item);	
	}
	
	public E dequeue(){
		if (outbox.isEmpty()){
			while (!inbox.isEmpty()){
				outbox.push(inbox.pop());
			}
		}
		
		return outbox.pop();
	}
	
	public int size(){
		return inbox.size() + outbox.size();
	}
	
	public boolean isEmpty() {
		return size() <= 0;
	}
}
