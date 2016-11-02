
// ***********************************
// Homework 2, TwoStackQueue.java
// Written by Jennifer Bi
// jb3495
// ***********************************



public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{

	MyStack<AnyType> s1;
	MyStack<AnyType> s2;
	private int size;
	private boolean empty = false;

    // constructor
    public TwoStackQueue(){
    	s1 = new MyStack<>();
    	s2 = new MyStack<>();
    	size = 0;
    }


    // Performs the enqueue operation for s1
    public void enqueue(AnyType x){
    	s1.push(x);

    }

    // enqueue operation for s2
    public void enqueue2(AnyType x){
    	s2.push(x);

    }

    // Performs the dequeue operation, returns null for empty queue
    public AnyType dequeue(){
    	if (isEmpty()){
    		return null;
    	}

    	if (s2.top()==0){
    	while (s1.top()!=0){
    		enqueue2(s1.pop());
    	}
    	}

    	return s2.pop();
   
    	

    }

    // Checks if the Queue is empty
    public boolean isEmpty(){
    	if (size() == 0)
    		empty = true;

    	return empty;
    }

    // Returns the number of elements currently in the queue
    public int size(){
    	size = s1.top() + s2.top();

    	return size;
    }


}