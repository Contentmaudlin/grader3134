public class MyStack <AnyType> {
  private Node<AnyType> head;
  private int count;

  public MyStack() {
    this.head = null;
    this.count = 0;
  }

  public boolean canPop() {
    if (count == 0) {
      return false;
    }
    return true;
  }

  public void push(AnyType newChar) {
    Node newNode = new Node(newChar, null);
    Node tmp = head;
    head = newNode;
    newNode.setNext(tmp);
    count++;
  }

  public AnyType pop() {
    AnyType removed = head.getData();
    head = head.getNext();
    count--;
    return removed;
  }

  public AnyType peek() {
    return head.getData();
  }

  public String toString() {
    String toRet = "";
    Node tmp = head;
    while (tmp != null) {
      toRet += String.valueOf(tmp.getData()) + " ";
      tmp = tmp.getNext();
    }
    return toRet;
  }
}
