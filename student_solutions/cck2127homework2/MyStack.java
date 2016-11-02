import java.util.ArrayList;

public class MyStack<AnyType> {

	private ArrayList<AnyType> list = new ArrayList<AnyType>();
	
	public void push(AnyType x){
		
		list.add(x);
		
	}
	
	public AnyType pop(){
		
		int t = list.size();
		AnyType r = list.get(t-1);
		list.remove(t-1);
		
		return r;
		
	}
	
	public AnyType peak(){
		
		int t = list.size();
		AnyType r = list.get(t-1);
		return r;
		
	}
	
	public boolean isEmpty(){
		
		if(list.size() == 0){
			return true;
			
		}
		else{ return false; } 
		
	}
	
	public int size(){
		
		int size = list.size();
		return size;
		
	}
	
}
