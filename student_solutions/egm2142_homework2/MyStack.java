import java.util.LinkedList;

public class MyStack <AnyType> {
	LinkedList<AnyType> stack;
	
	public MyStack(){
		stack = new LinkedList <AnyType>();
	}
	
	public void push(AnyType x){
		stack.addFirst(x);
	}
	
	public AnyType pop(){
		return stack.remove();
	}

	public AnyType top(){
		return stack.get(0);
	}
	
	public boolean isEmpty(){
		return stack.size() == 0;
	}
	
	public int size(){
		return stack.size();
	}
	
}
	
	
