/* Yuncheng Jiang
 *  UNI:yj2433
 *Construct the stack by linked list
 */
import java.util.*;
public class MyStack<T>  {
	// implementing stack using linked list
	
	// declaring linked list that will be used as stack
	private LinkedList<T> slist;
	public MyStack(){
		slist = new LinkedList<T>();
		
		
	}

	public T push(T obj){//push obj into the stack
		slist.add(obj);
		return obj;
	}
	
	public T pop(){//pop the first element of the stack
		if(slist.size()==0){
			throw new EmptyStackException();
		}else{
			return slist.remove(slist.size()-1);
		}
	}
	    
	public Boolean isEmpty(){//declare whether is empty
		if(slist.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	public T peek(){//get the peek value of the stack
		if(slist.size()==0){
			throw new EmptyStackException();
		}else{
			return slist.get(slist.size());
		}
	}
	
	public int size(){//return the size of the stack
		return slist.size(); 
	}
}