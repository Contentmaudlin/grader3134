/*
 * Angela Zhang
 * amz2132
 * COMS 3134 Data Structures
 * Problem2 class for Homework 2
 * This class is a tester for the TwoStackQueue class. The output should be:
 * jet
 * 5
 * fuel
 * doesn't
 * melt
 * steel
 * beams
 */

public class Program2 
{
	public static void main(String [] args)
	{
		TwoStackQueue<String> tester = new TwoStackQueue<String>();
		
		tester.enqueue("jet");
		tester.enqueue("fuel");
		tester.enqueue("doesn't");
		tester.enqueue("melt");
		System.out.println(tester.dequeue());
		tester.enqueue("steel");
		tester.enqueue("beams");
		System.out.println(tester.size());
		
		while (!tester.isEmpty())
		{
			System.out.println(tester.dequeue());
		}
		
	}
}
