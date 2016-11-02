import java.util.LinkedList;

public class MyStack<AnyType>{
	private LinkedList<AnyType> theList;
	int size;
	
	public MyStack (){
		theList = new LinkedList<AnyType>();
		size = theList.size();
	}
	
	public void push(AnyType x){
		theList.add(x);
		size ++;
//		System.out.println("push " + x);
	}
	
	public AnyType top(){
		if(theList.isEmpty()){
			return null;
		}else{
			return theList.get(size-1);
		}
	}
	
	public AnyType pop(){
		if(theList.isEmpty()){
			throw new java.util.NoSuchElementException();
		}else{
			AnyType result = theList.get(size - 1);
			theList.remove(size-1);
			size --;
//			System.out.println("pop " + result);
			return result;
		}
	}
	
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public int size(){
		return size;
	}
}
