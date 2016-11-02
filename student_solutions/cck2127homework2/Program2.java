
public class Program2 {
	
	public static void main(String[] args){
		
		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
		System.out.println(q.size());
		
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(6);
		q.enqueue(6);
		
		
		System.out.println(q.dequeue()); //prints 4
		System.out.println(q.size()); //prints 3
		
		while(!q.isEmpty()){
			
			System.out.print(q.dequeue()); //prints 666
			
		}
		
		System.out.println(" Size is now: " + q.size()); //prints 0
		
	}

}
