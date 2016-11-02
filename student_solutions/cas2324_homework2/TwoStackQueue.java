/**
 * Created by alexscott on 10/7/16.
 */
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
    private MyStack<AnyType> S1 = new MyStack<>();
    private MyStack<AnyType> S2 = new MyStack<>();

    // Performs the enqueue operation by pushing to S1.
    public void enqueue(AnyType x) {
        S1.push(x);
    }

    // Performs the dequeue operation by popping from S2.
    public AnyType dequeue() {
        if (this.isEmpty()) {
            // Return null if our queue is empty.
            return(null);
        } else if (S2.size() == 0) {
            // If S2 is empty, pop off everything from S1 and push it into S2 to reverse its order so the top of S2 will
            // be the first element added into S1.
            int stackSize = S1.size();
            for (int i = 0; i < stackSize; i++) {
                S2.push(S1.pop());
            }
        }
        // Return the top of S2
        return((AnyType) S2.pop());
    }

    // Checks if the Queue is empty
    public boolean isEmpty() {
        return(this.size() == 0);
    }

    // Returns the number of elements currently in the queue
    public int size() {
        return(S1.size() + S2.size());
    }
}
