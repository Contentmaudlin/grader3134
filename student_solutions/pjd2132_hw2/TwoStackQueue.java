/* Name : Peter Drake
 * UNI : pjd2132
 *  
 *  TwoStackQueue.java - Builds a queue using two stacks and follows
 *  assignment details for programming project 2, HW2.
 */
import java.util.NoSuchElementException;

public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
    
    //These two stacks will act as the queue. Enqueueing pushes to stack1.
    //Dequeueing pops froms stack2.
    private MyStack<AnyType> stack1 = new MyStack<AnyType>();
    private MyStack<AnyType> stack2 = new MyStack<AnyType>();
    
    public void enqueue(AnyType x){
    //To enqueue, all elements currently in stack2 get sequentially put
    //to stack1 before pushing the desired element to stack1.

        while(!(stack2.isEmpty())){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }
    
    public AnyType dequeue(){
        //To dequeue, all elements are sequentially put to stack2 (to flip
        //the order) and then the top of stack2 is popped. Returns popped.
        if(this.isEmpty()){
            System.out.println("Error! Cannot dequeue an empty queue.");
            throw new NoSuchElementException();
        }
        
        while(!(stack1.isEmpty())){
            stack2.push(stack1.pop());
        }
        return (stack2.pop());
    }
    
    public boolean isEmpty(){
    //Returns a boolean that determines if the queue is empty by checking
    //if both stacks are empty.
        
        return (stack1.isEmpty() && stack2.isEmpty());
    }
    
    public int size(){
        //Returns the size of the queue by summing all elements in both stacks.
        
        return(stack1.getSize() + stack2.getSize());
    }
}