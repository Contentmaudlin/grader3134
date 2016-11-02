public class Program2 {

    public static final void main(String[] args) {
		/** If implemented correctly, this code should output:
		 *  0
		 *  true
		 *  Cannot dequeue an empty queue
		 *  22
		 *  65
		 *  41
		 *  Cannot dequeue an empty queue
		 *  0
		 *  19
		 *  28
		 *  36
		 *  91
		 *  11
		 *  55
		 */

		System.out.println("Integers test: ");
		TwoStackQueue<Integer> intQueue = new TwoStackQueue<Integer>();
		System.out.println(intQueue.size());
		System.out.println(intQueue.isEmpty());

		intQueue.dequeue(); //Error message
		intQueue.enqueue(22);
		intQueue.enqueue(65);
		intQueue.enqueue(41);
		System.out.println(intQueue.dequeue()); //22
		System.out.println(intQueue.dequeue()); //65
		System.out.println(intQueue.dequeue()); //41
		intQueue.dequeue(); //error message
		System.out.println(intQueue.size()); //0
		intQueue.enqueue(19);
		intQueue.enqueue(28);
		System.out.println(intQueue.dequeue()); //19
		intQueue.enqueue(36);
		intQueue.enqueue(91);
		intQueue.enqueue(11);
		intQueue.enqueue(55);

		while(!intQueue.isEmpty()) {
			System.out.println(intQueue.dequeue()); // 28, 36, 91, 11, 55
		}

/** If implemented correctly, this code should output:
 *  0
 *  Peter
 *  2
 *  Paul
 *  Mary
 *  Simon
 *  Alvin
 *  Theodore
 */

	System.out.println();
	System.out.println("Strings test: ");

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

	while(!q.isEmpty()){
			System.out.println(q.dequeue());
	}
    }

}