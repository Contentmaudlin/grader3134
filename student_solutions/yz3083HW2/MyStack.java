import java.util.Iterator;
import java.util.LinkedList;//http://math.hws.edu/javanotes/c10/s5.html

public class MyStack<AnyType> {	
	private LinkedList<AnyType> a = new LinkedList<AnyType>();	
	private Object b;
	public void push(AnyType x){ //push an element into stack
		a.add(x);		
	}
	public AnyType pop(){   //pop the last element in stack
	    if(a.size()!=0){
		return a.remove(a.size()-1);}
	    else
	    	return null;		
	}
	public AnyType peek(){   //get the last element in stack

		return a.get(a.size()-1);
	}
	
	public boolean IsEmpty(){ //check whether the stack is empty
		if(a.size()==0)
		return  true;
		else 
			return false;
	}
	public int size(){  //get the size of the stack
		return a.size();
	}
}
