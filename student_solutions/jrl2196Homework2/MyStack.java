//Joshua Learn
//stack class
import java.util.LinkedList;

public class MyStack<AnyType>{
	private LinkedList<AnyType> list;
	private int mySize;

	public MyStack(){
		list = new LinkedList<AnyType>();
		mySize = list.size();
	}

	public void push(AnyType item){
		list.add(item);
		mySize++;
	}

	public AnyType pop(){
		if(mySize<1){
			return null;
		}
		else{
			mySize--;
			return list.removeLast();
		}
	}
	public AnyType peek(){
		if(mySize<1){
			return null;
		}
		else{
			return list.getLast();
		}
	}
	public boolean isEmpty(){
		return mySize==0;
	}
	public int size(){
		return mySize;
	}
}