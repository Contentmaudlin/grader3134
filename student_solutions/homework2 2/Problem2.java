//Homework2 - Problem2
//Kehan Lu - kl2858

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());
		q.enqueue("Peter"); 
		q.enqueue("Paul"); 
		q.enqueue("Mary"); 
		System.out.println(q.dequeue()); 
		System.out.println(q.size()); 
		q.enqueue("Simon"); 
		q.enqueue("Alvin"); 
		System.out.println(q.dequeue()); 
		q.enqueue("Theodore");
		while(!q.isEmpty())     
			System.out.println(q.dequeue());

	}

}
