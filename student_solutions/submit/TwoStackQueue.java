public class TwoStackQueue <AnyType> implements MyQueue<AnyType> {
  private MyStack<AnyType> input;
  private MyStack<AnyType> output;
  private int size;

  public TwoStackQueue() {
    this.input = new MyStack<AnyType>();
    this.output = new MyStack<AnyType>();
    this.size = 0;
  }

  public void enqueue(AnyType x) {
    input.push(x);
    size++;
  }

  /*
    Since all new elements are pushed onto the input stack. Pushing the popped elements into
    the output stack would give the order that the elements were added. As a result, a pop on the
    output stack gives the FIFO element. Then the output stack is popped in reverse order
    into the input stack to preserve the order for future dequeue() calls.
  */
  public AnyType dequeue() {
    if (size == 0) {
      return null;
    }
    while (input.canPop()) {
      output.push(input.pop());
    }
    AnyType toReturn = output.pop();
    while (output.canPop()) {
      input.push(output.pop());
    }
    size--;
    return toReturn;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public int size() {
    return this.size;
  }
}
