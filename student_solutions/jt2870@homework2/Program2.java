
public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println("the current size is "+q.size());

		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		System.out.println(q.dequeue());
		System.out.println("the current size is "+q.size());
		q.enqueue("4");
		q.enqueue("5");
		System.out.println(q.dequeue());
		q.enqueue("6");
		q.enqueue("7");
		System.out.println(q.dequeue());
		System.out.println("the current size is "+q.size());
		while(!q.isEmpty())
		    System.out.println(q.dequeue());

	}

}
