//Name: Yiwei Lian
//UNI: yl3434
//Date: 10/10
//Assignment: HW2

import java.util.LinkedList;
import java.util.*;

public class MyStack<AnyType> {

	public LinkedList<AnyType> stack;
	public int counter;
	
	//constructor
	public MyStack(LinkedList<AnyType> list){
		stack = list;
		counter = 0;
	}
	
	//default constructor
	public MyStack(){
		stack = new LinkedList<AnyType>();
		counter = 0;
	}

	// make push method with .add
	public void push(AnyType x) {
		stack.add(size(), x);
		counter++;
	}

	// make pop method
	public AnyType pop() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		counter--;
		return stack.get(size());
		
	}

	// make peek method
	public AnyType top() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		else
			return stack.get(stack.size()-1);
	}

	//make isEmpty method
	public boolean isEmpty() {
		return size()==0;
	}

	//make size method
	public int size() {
		return counter;
	}
}
