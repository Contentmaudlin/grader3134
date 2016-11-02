/* Boya Wang
 * bw2462
 * MyStack.java
 */
import java.util.LinkedList;
	
public class MyStack<AnyType> {

	public LinkedList<AnyType> list;   //Using linked list to implement stacks. 

	public MyStack() {
		list = new LinkedList<AnyType>();
	}

	public AnyType pop() {
		AnyType popItem = list.removeLast();
		return popItem;
	}

	public void push(AnyType item) {
		list.add(item);
	}

	public Boolean isEmpty() {   //To check if the stack is empty. 
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size(){
		return list.size();
	}
	       
	   
}
