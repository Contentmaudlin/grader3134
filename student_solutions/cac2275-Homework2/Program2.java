
public class Program2 
{
	    /** If implemented correctly, this code should output:      
	     * *      
	     * *        
	     * *        
	     * *        
	     * *        
	     * *    
	     * *       
	     * *       
	     * */     
	
		public static final void main(String[] args) 
		{
			TwoStackQueue<String> q = new TwoStackQueue<String>();
			
			q.enqueue("first"); 
			q.enqueue("second"); 
			q.enqueue("third"); 
			System.out.println(q.dequeue()); 
			System.out.println(q.dequeue()); 
			System.out.println(q.dequeue()); 
			q.enqueue("fourth"); 
			q.enqueue("fifth"); 
			System.out.println(q.dequeue()); 
			q.enqueue("sixth");
	
			while(!q.isEmpty())     
				System.out.println(q.dequeue());
	    }


}



