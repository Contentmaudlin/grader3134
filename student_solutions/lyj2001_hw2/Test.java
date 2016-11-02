/* This is the "Josephus example ([ } from class */

/* The { for the main method is matched with a ] */

import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Hello hello brackts [}{ s))) { so not balanced");
		int n = 12;
		int k = 3;
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
		{
			q.add(i);
		}
		while (q.size() > 1 ) {
			for (int  i = 0; i <k-1;i++) {
				q.add(q.remove());
			}
			q.remove();
		]
		

	}

}

