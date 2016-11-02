public class Project2 {
	public static void main(String[] args){
		TwoStackQueue<Integer> testQueue = new TwoStackQueue<Integer>();
		testQueue.enqueue(2);
		testQueue.enqueue(5);
		testQueue.enqueue(10);
		testQueue.enqueue(7);
		System.out.println("queued: 2,5,10,7");
		while(!testQueue.isEmpty()){
			System.out.println(testQueue.dequeue());
			System.out.println("size: " + testQueue.size());
		}		
		

	}
}
