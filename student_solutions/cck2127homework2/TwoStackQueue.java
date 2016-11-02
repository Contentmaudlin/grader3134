
public class TwoStackQueue<AnyType> {

	private MyStack<AnyType> stack1 = new MyStack<AnyType>();
	private MyStack<AnyType> stack2 = new MyStack<AnyType>();
	
	public void enqueue(AnyType x){
		
		stack1.push(x);
		
	}
	
	public AnyType dequeue(){
		
		if(stack1.isEmpty() && stack2.isEmpty()){
			
			return null;
			
		}
		
		if(stack2.isEmpty()){
			
			while(!stack1.isEmpty()){
				
				stack2.push(stack1.pop());
				
			}
		}
		
		return stack2.pop();
		
	}
	
	public boolean isEmpty(){
		
		if(stack1.isEmpty() && stack2.isEmpty()){
			
			return true;
		
		}
		else{ return false; }
		
		
	}
	
	public int size(){
		
		int size = stack1.size() + stack2.size();
		
		return size;
		
	}
	
	
}
