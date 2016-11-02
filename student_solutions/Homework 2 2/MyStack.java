import java.util.LinkedList;
public class MyStack<AnyType extends Comparable<AnyType>>{
	
	private LinkedList<AnyType> list;
	
	public MyStack(){
		list =  new LinkedList<AnyType>();
	}
	
	public void push( AnyType item){
		list.addFirst(item);
	}
	
	
	public AnyType pop(){
		AnyType x = list.removeFirst();
		return x;
	}
	
	public boolean isEmpty(){
		if (list.size() <= 0)
			return true;
		else
			return false;
	}
	
	public String toString(){
		String s = new String();
		for( int i = 0; i <list.size();i++){
			s +=  list.get(i) + "\t";
		}
		return s;
	}
	
	//this helper method will help with problem 2's size method
	public int getSize(){
		return list.size();
	}
}
