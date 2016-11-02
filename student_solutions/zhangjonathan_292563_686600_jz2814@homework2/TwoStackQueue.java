/**
 *
 * Solves TwoStackQueue Problem
 *
 * Refer to Program2.txt for explanation of methods
 */
public class TwoStackQueue<T> implements MyQueue<T> {

    private myStack<T> stack1;
    private myStack<T> stack2;


    public TwoStackQueue(){
        stack1 = new myStack<>();
        stack2 = new myStack<>();
    }

    public void enqueue(T elem){
        stack1.push(elem);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (stack2.size() == 0 && stack1.size() > 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty(){
        return this.size() ==0;
    }
    public int size(){
        return stack1.size() + stack2.size();
    }

}
