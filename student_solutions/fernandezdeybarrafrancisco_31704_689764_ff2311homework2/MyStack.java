/*Francisco Fernandez De Ybarra 
 * FF2311
 * MyStack class which creates a generic stack with methods to push and pop
 * 
 */
	import  java.util.ArrayList;

	public class MyStack<AnyType>{
		
		private ArrayList<AnyType> stack;
		private int topOfStack;
		
		public MyStack(){
			topOfStack = -1;
			stack = new ArrayList<>();
		}
		
		public void push(AnyType x){
			topOfStack++;
			stack.add(topOfStack, x);
			
		}
		
		public AnyType pop(){
			
			AnyType poppedValue = stack.get(topOfStack);
			topOfStack--;
			return poppedValue;
				
		}
		
				
		public boolean isEmpty(){
			if(topOfStack==-1){
				return true;
			}
			else{
				return false;
			}
		}
		
		public AnyType getTop(){
			return stack.get(topOfStack);
		}
		
		
		public int size(){
			return (topOfStack+1);
		}
	
	}


