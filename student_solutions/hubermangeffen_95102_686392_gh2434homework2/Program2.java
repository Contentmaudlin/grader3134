public class Program2 {

  public static final void main(String[] args) {


	TwoStackQueue<String> q = new TwoStackQueue<String>();
	System.out.println(q.size());

	q.enqueue("Te");
	q.enqueue("di");
  q.enqueue("Scordato");
	q.enqueue("Son");
	System.out.println(q.size());
	q.enqueue("mi");
	System.out.println(q.dequeue());
  System.out.println(q.dequeue());
  System.out.println(q.dequeue());
  System.out.println(q.dequeue());
	q.enqueue("Eppur");
  System.out.println(q.dequeue());
  q.enqueue("T'ho");
  q.enqueue("Fatto");
  q.enqueue("Piangere");
  q.enqueue("Tanto");
  q.enqueue("Per che");
  q.enqueue("I sono");
  q.enqueue("Un brutto");
  q.enqueue("Lo so");
	while(!q.isEmpty())
	    System.out.println(q.dequeue());
  System.out.println(q.size());

  }





}
