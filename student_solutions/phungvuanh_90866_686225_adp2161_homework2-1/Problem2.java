//*************************************
//
//  Problem2.java
//
//  Class to test TwoStackQueue.java
//
//  Anh Phung
//  adp2161
//**************************************

public class Problem2 {

	public static void main(String[] args) {

		TwoStackQueue<String> test = new TwoStackQueue<String>();
		System.out.println(test.size());

		test.enqueue("a");
		test.enqueue("b");

		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());

		test.enqueue("c");
		test.enqueue("d");
		test.enqueue("e");
		test.enqueue("f");
		
		System.out.println(test.size());

		while (!test.isEmpty())
		{
			System.out.println(test.dequeue());
		}



	}
}