
public class Problem2 {
	public static final void main(String[] args) {
		TwoStackQueue<String> q = new TwoStackQueue<String>();{
			

			q.enqueue("Hello");
			q.enqueue("1");
			q.enqueue("2"); 
			q.enqueue("3");
			System.out.println("The element: "+q.dequeue()+" is dequeued"); 
			System.out.println("The size is: "+ q.size()); 
			q.enqueue("4"); 
			q.enqueue("5"); 
			System.out.println("The element: "+q.dequeue()+" is dequeued"); ;
			q.enqueue("end");
			while(!q.isEmpty()) 
				System.out.println("The element: "+q.dequeue()+" is dequeued"); 
			}
		
		}

}
