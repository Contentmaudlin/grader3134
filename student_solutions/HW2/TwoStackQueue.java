import java.util.*;
public class TwoStackQueue<T> implements MyQueue<T>{

	MyStack<T> stack1 = new MyStack<T>();
	MyStack<T> stack2 = new MyStack<T>();

	public void enqueue(T x){
		stack1.push(x);
	}

	public int size(){
		return stack1.size() + stack2.size();
	}

	public boolean isEmpty(){
		return (stack1.isEmpty() && stack2.isEmpty());
	}

	public T dequeue(){
		if (!isEmpty()){
			if (stack2.isEmpty()){
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
		return null;
	}

	

}