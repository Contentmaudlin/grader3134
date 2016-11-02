public class Node <AnyType> {
  private AnyType data;
  private Node next;

  public Node(AnyType data, Node next) {
    this.data = data;
    this.next = next;
  }

  public AnyType getData() {
    return this.data;
  }

  public Node getNext() {
    return this.next;
  }

  public void setData(AnyType data) {
    this.data = data;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
