/* Kelly Ryu
 * hr2362
 * TwoStackQueue.java - defines queue class using two stacks
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
    MyStack<AnyType> stack1;
    MyStack<AnyType> stack2;
    
    public TwoStackQueue(){
        stack1 = new MyStack<AnyType>();
        stack2 = new MyStack<AnyType>();
    }
    
    public void enqueue(AnyType x){
        
        // push all of stack2 onto stack1: last in is on top of stack1
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        
        // push all of stack 1 onto stack2: first in is on top of stack2
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }
    
    public AnyType dequeue(){
        return stack2.pop();
    }
    
    public boolean isEmpty(){
        // all data is stored in stack2
        return stack2.empty();
    }

    public int size(){
        return stack2.size();
    }
}
