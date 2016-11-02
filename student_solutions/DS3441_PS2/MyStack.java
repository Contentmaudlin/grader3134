import java.util.LinkedList;

//*****************************
//Class SymbolBalance  
//
//
//Name: Dengyuan Shi 
//UNI: DS3441
//This is a generic class 
//that simulates stack ADT
//using LinkedList. 
//*****************************
public class MyStack<AnyType>{

	private LinkedList<AnyType> ll;		
	public MyStack(){
		ll = new LinkedList<AnyType>();
	}
	
	public void push(AnyType a){
		ll.add(a); 
		}
	
	public AnyType pop(){
			AnyType popped = ll.removeLast();
			return popped;
		}
		
	public boolean isEmpty(){
		if(ll.size()==0)
			return true; 
		else 
			return false;
	}
	
}
