import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	MyStack<AnyType> stackinput=new MyStack<>();
	MyStack<AnyType> stackoutput=new MyStack<>();
	

	
	public void enqueue(AnyType object){
		stackinput.push(object);
		}
	
    public AnyType dequeue(){
		if(stackoutput.isEmpty()&&!stackinput.isEmpty())
			while(!stackinput.isEmpty()){
				stackoutput.push(stackinput.pop());
			}
		else if(stackoutput.isEmpty()&&stackinput.isEmpty()){
			System.out.println("Empty");}
		//System.out.println("The number "+stackoutput.pop()+" is dequeued.");
		return stackoutput.pop();
	}

    public boolean isEmpty(){
     if (stackoutput.isEmpty()&&stackinput.isEmpty()){
    	 return true;
     }
     else{
    	 return false;
     }
    }
    public int size(){
        int size=0;
        size= size+ stackinput.size();
        size= size+ stackoutput.size();
        return size;
        
       }
}

