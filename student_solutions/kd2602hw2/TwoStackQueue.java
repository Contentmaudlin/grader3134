/*
    Kendall Dabaghi
    kd2602
*/
public class TwoStackQueue<T extends Comparable<? super T>> implements MyQueue<T> {

    // s1 and s2 are two stacks that together simulate a queue.  s1 mirrors the natural
    // order of the queue, so when you 'enqueue' you push an item onto the end of the
    // s1 stack.  s2 enables you to show the queue in reverse, so when you pop the last item,
    // you are actually dequeuing the first.

    // To implement, you keep all the items in either s1 or s2 depending on what operation
    // is called for, and then you either enqueue/dequeue O(1) if they're in the right stack,
    // or you move them to the other stack in O(N) and then perform the operation.

    MyStack<T> s1;
    MyStack<T> s2;
    private int size;

    public TwoStackQueue() {
        s1 = new MyStack<>();
        s2 = new MyStack<>();
        size = 0;
    }

    // When a dequeue operation is called, pop all of the items from s1 (if there are any),
    // push each of them onto s2, and then dequeue the first item in the queue by popping
    // the last item from s2.  If there are no items in s1, then just pop the last item
    // in s2 if it exists.

    // Decrement size accordingly

    public T dequeue() {

        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        if(size > 0) {
            size--;
        }

        return s2.pop();
    }

    // When enqueue is called, pop all of the items from s2 (if there are any), push each
    // of them onto s1, and then enqueue another value by pushing a value onto s1.  If there
    // is nothing in s2, then just push the value onto s1.

    public void enqueue(T x) {

        while(!s2.empty()) {
            s1.push(s2.pop());
        }

        s1.push(x);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
