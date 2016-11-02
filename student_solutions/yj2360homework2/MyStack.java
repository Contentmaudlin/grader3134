
import java.util.LinkedList;

public class MyStack<T> {
	private LinkedList<T> list;
	public MyStack(){
		list = new LinkedList<T>();
	}
	
	public void push(T item){
		list.addFirst(item);
	}
	
	public T pop(){
		T data = list.getFirst();
		list.removeFirst();
		return data;
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return(size()==0);
	}
	
	
}
