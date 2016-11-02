public class Problem2 {
	public static final void main(String[] args) {
		TwoStackQueue<String> q = new TwoStackQueue<String>();
		TwoStackQueue<Integer> a = new TwoStackQueue<Integer>(); 
		TwoStackQueue<Object> b = new TwoStackQueue<Object>(); 
			
		System.out.println(q.size());      // the first test is given by the problem instruction
		q.enqueue("Peter"); 
		q.enqueue("Paul"); 
		q.enqueue("Mary"); 
		System.out.println(q.dequeue());
		System.out.println(q.size()); 
		q.enqueue("Simon"); 
		q.enqueue("Alvin"); 
		System.out.println(q.dequeue()); 
		q.enqueue("Theodore");
		while(!q.isEmpty()){     
			System.out.println(q.dequeue());}
		
		System.out.println("the size of a is"+a.size());//A second test
		for(int i=0;i<=5;i++){
			a.enqueue((Integer)i);            //enqueue an array of integer
			System.out.print(i);
		}
		System.out.println();             //change a line
		while(a.isEmpty()!=true){			
			System.out.print(a.dequeue());    //dequeue the integer array until its empty
		}
		System.out.println("the size of a is"+a.size());
		
		
		System.out.println("the size of b is "+b.size());//A third test
		b.enqueue((Integer)1); 
		b.enqueue("Sophia"); 
		b.enqueue("Serena");
		b.enqueue('M');
		System.out.println(b.dequeue()); 
		System.out.println(b.dequeue());
		System.out.println("The size of b is "+b.size()); 
		b.enqueue("Fiona"); 
		b.enqueue("Lisa"); 
		System.out.println("The size of b is "+b.size());
		while(!b.isEmpty()){ 
			System.out.print(b.dequeue()+" ");//dequeue everything until it is emplty
			
		}
		
		
	
	
	
	
	
	
	
	
	
	
	}

}
