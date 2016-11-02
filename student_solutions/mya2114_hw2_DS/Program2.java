/* 

If the program works correctly, then we should have an output of 

0
3
3
7
9
12
10
19
33
33

*/

///////////////////////////////////////////////////////////////////////////////////////////////////


public class Program2 {

	public static final void main(String[] args) {

		TwoStackQueue<Integer> test = new TwoStackQueue<Integer>();
		System.out.println(test.size());

		test.enqueue(3);
		test.enqueue(7);
		test.enqueue(9);
		test.enqueue(12);

		System.out.println(test.dequeue());
		System.out.println(test.size());

		test.enqueue(10);
		test.enqueue(19);
		test.enqueue(33);
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		test.enqueue(33);
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());

		while (!test.isEmpty())
			System.out.println(test.dequeue());
	}

}
