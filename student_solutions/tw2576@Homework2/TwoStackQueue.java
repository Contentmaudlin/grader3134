/* Tianwu Wang
 * tw2576
 * TwoStackQueue.java
 * provide the Queue ADT by using two stacks
 * provide dequeue and enqueue 
 */

public class TwoStackQueue<AnyType>{
	
	MyStack<AnyType> s1 = new MyStack<>(); //create 2 new stacks
	MyStack<AnyType> s2 = new MyStack<>();
	
	public void enqueue(AnyType data) {   //push data into the stack s1
		s1.push(data);
	}
	
	public AnyType dequeue() { 
        if (s2.isEmpty()) {               //when s2 is empty 
            while (s1.isEmpty()==false) { //and s1 is not empty 
               s2.push(s1.pop());         //push all elements in s1 into s2
            }
        } 
        return s2.pop();                  //pop the top element in s2
    }    

	public int size() { 				  //size of the queue
		return (s1.size() + s2.size());
	}

	public boolean isEmpty() {            //check if the queue is empty
		if(s1.isEmpty() && s2.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}