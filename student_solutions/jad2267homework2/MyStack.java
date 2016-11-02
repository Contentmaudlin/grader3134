import java.util.LinkedList;

public class MyStack<AnyType>{

	LinkedList<AnyType> stack = new LinkedList<AnyType>();

	public void myPush(AnyType x){
		stack.add(x);
	};

	public AnyType myPop(){
		if (stack.size() == 0){
			System.out.println("Error: attempted to pop an empty stack.");
			System.exit(1);
		}
		AnyType popped = stack.get((stack.size())-1);
		stack.remove((stack.size())-1);
		return popped;
	};

	public AnyType myPeek(){
		if (stack.size() == 0){
			System.out.println("Error: attempted to peek an empty stack.");
			System.exit(1);
		}
		AnyType peeked = stack.get((stack.size())-1);
		return peeked;
	}

	public int size(){
		return stack.size();
	};

}


