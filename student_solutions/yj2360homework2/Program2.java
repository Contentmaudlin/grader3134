public class Program2 {
	   public static final void main(String[] args) {


			TwoStackQueue<String> q = new TwoStackQueue<String>();
			System.out.println(q.size());

			q.enqueue("a");
			q.enqueue("d");
			q.enqueue("b");
			System.out.println(q.dequeue());
			System.out.println(q.size());
			q.enqueue("a");
			q.enqueue("c");
			System.out.println(q.dequeue());
			q.enqueue("g");
			
			TwoStackQueue<String> t = new TwoStackQueue<String>();

			t.enqueue("apple");
			t.enqueue("apple2");
			t.enqueue("apple3");
			System.out.println(t.dequeue());
			System.out.println(t.size());
			t.enqueue("apple4");
			t.enqueue("apple5");
			System.out.println(t.dequeue());
			t.enqueue("apple6");

			
		}
}
