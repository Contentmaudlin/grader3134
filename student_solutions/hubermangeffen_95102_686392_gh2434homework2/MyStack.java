import java.util.LinkedList;

public class MyStack <AnyType>{

	final LinkedList<AnyType> myLinkedList;
	
	public MyStack() {

		myLinkedList = new LinkedList<AnyType>();
	}
	public void push(AnyType j){
		myLinkedList.add(j);
	}
	
	public void pop(){
		myLinkedList.removeLast();
	}
	
	public AnyType top(){
		//element method returns first element of the list
		return myLinkedList.getLast();
	}
	
	public boolean isEmpty(){
		if (myLinkedList.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){		
		return myLinkedList.toString();
	}
	
	public int getSize(){
		
		return myLinkedList.size();
	}

}
