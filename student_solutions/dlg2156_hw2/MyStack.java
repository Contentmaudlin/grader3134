
import java.util.LinkedList;

public class MyStack<AnyType> {
	
	private int listLength;
	private LinkedList<AnyType> l = new LinkedList<AnyType>();
	
	public void push(AnyType item) {
		l.add(item);
		listLength++;
	}
	public AnyType pop() {	
		AnyType top = l.get(l.size()-1);
		l.removeLast();
		listLength --;
		return top;
		} 
	
	public AnyType top() {
		return l.peekLast();
	}
	
	public Boolean isEmpty() {
		return l.size() == 0;
	}
	
	public int size() {
		return l.size();
	}
	
}
