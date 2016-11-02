public class TwoStackQueue<AnyType> implements MyQueue<AnyType>{
    MyStack<AnyType> S1 = new MyStack<>();
    MyStack<AnyType> S2 = new MyStack<>();

    /** Performs the enqueue operation
     * Either pushes to stack 1 if all the elements are there
     * or pushes all the elements to stack 1 and then pushes the
     * argument element
     * @param x
     */
    public void enqueue(AnyType x){
        if(S2.isEmpty()){
            S1.push(x);
        }else{
            while(!S2.isEmpty()){
                S1.push(S2.pop());
            }
            S1.push(x);
        }
    };

    /** Performs the dequeue operation.
     * If the queue is empty, returns null
     * Either pops from stack2 if all the elements are there
     * or pushes all the elements to stack 2 and then pops
     * @return
     */
    public AnyType dequeue(){
        if(isEmpty()){
            System.out.println("Cannot dequeue an empty queue");
            return null;
        }else if(S1.isEmpty()){
            return S2.pop();
        }else{
            while(!S1.isEmpty()){
                S2.push(S1.pop());
            }
            return S2.pop();
        }
    };

    // Checks if the Queue is empty
    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }else{
            return false;
        }
    };

    /** Returns the number of elements currently in the queue
     * by summing the sizes of the two stacks
     * @return
     */
    public int size(){
        return S1.getSize() + S2.getSize();
    };
}