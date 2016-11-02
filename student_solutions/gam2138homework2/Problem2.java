
public class Problem2 {

	
	
		public static final void main(String[] args) {
			TwoStackQueue<String> blah = new TwoStackQueue<String>();
			
			
			
			
			blah.enqueue("Alexander");
			blah.enqueue("Hamilton");
			blah.enqueue("Peggy");
			blah.enqueue("Angelica");
			blah.enqueue("Eliza");
			System.out.println(blah.size());
			System.out.println(blah.dequeue());
			System.out.println(blah.dequeue());
			System.out.println(blah.size());
			blah.enqueue("Aaron Burr");
			while (!blah.isEmpty())
				System.out.println(blah.dequeue());
		}
	}

