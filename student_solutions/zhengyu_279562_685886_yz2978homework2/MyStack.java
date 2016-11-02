/*Yu Zheng
 * yz2978
 * creating my own stack class using linked list
 */
import java.util.LinkedList;
public class MyStack<AnyType> {
	private LinkedList<AnyType> list;
	public MyStack() {
		list = new LinkedList<>();		
	}
	//provide the function of push
	public void push(AnyType item) {
		list.addFirst(item); 
	}
	//provide the function of pop
	public AnyType pop() {
		AnyType data = list.getFirst();
		list.removeFirst();
		return data; 
	}
	public int size() {
		return list.size();
	}
	//check if the stack is empty
	public boolean isEmpty(){
		return list.size()==0;
	}

}
