//rjs2204, Ravi Sinha

public class Program2 {


	public static void main(String[] args) { 
		
		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>(); 
		//enqueueing a number of objects and then dequeueing and printing them in the correct order

                System.out.println("Size = "+q.size());
                System.out.println("IsEmpty = "+q.isEmpty());

		q.enqueue(1); 
		q.enqueue(2); 
		q.enqueue(3); 
		q.enqueue(4); 
		q.enqueue(5);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(6);

                System.out.println("Size = "+q.size());
                System.out.println("IsEmpty = "+q.isEmpty());

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

                System.out.println("Size = "+q.size());
                System.out.println("IsEmpty = "+q.isEmpty());

	}

}
