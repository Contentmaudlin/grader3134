/* Author: Seungwook Han
 * UNI: sh3264
 * Data Structures
 * MyQueue - This is the interface that the TwoStackQueue class implements
 */

/** This is the interface that your TwoStackQueue class must
 * implement. */
public interface MyQueue<AnyType> {

    // Performs the enqueue operation
    public void enqueue(AnyType x);

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue();

    // Checks if the Queue is empty
    public boolean isEmpty();

    // Returns the number of elements currently in the queue
    public int size();

}