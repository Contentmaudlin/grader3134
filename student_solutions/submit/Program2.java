public class Program2 {
  public static final void main(String[] args) {
    /*
      Correct order of output:
      true
      null
      5
      a
      4
      false
      5
      c
      d
      e
      f
      b
      null
    */
    TwoStackQueue<String> q = new TwoStackQueue<String>();
    System.out.println(q.isEmpty());
    System.out.println(q.dequeue());

    q.enqueue("a");
    q.enqueue("b");
    q.enqueue("c");
    q.enqueue("d");
    q.enqueue("e");
    System.out.println(q.size());
    System.out.println(q.dequeue());
    System.out.println(q.size());
    q.enqueue("f");
    System.out.println(q.isEmpty());
    q.enqueue(q.dequeue());
    System.out.println(q.size());
    int i = 0;
    while (i < 6) {
      System.out.println(q.dequeue());
      i++;
    }

  }
}
