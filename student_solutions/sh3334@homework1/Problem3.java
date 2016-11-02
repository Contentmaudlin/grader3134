/* SiLin Huang
 * UNI: sh3334
 * Homework 1: Problem 3
 * Due September 23, 2016
 */

public class Problem3 {

	public static void functionA(int n) {

		// Implements the code function A.
		double sum = 0.0;
		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < n; j++)
				sum += Math.random();
		}

	}

	public static void functionB(int n) {

		// Implements the code function B.
		double sum = 0.0;
		for (int i = 0; i < n; i++) {
			for (int k = i; k < n; k++)
				sum += Math.random();
		}

	}

	public static int foo(int n, int k) {
		try {
			Thread.sleep(100);
		}

		catch (Exception e) {
			System.out.println(e);
		}

		// Implements the code foo.
		if (n <= k)
			return 1;
		else
			return foo(n / k, k) + 1;

	}

	public static void main(String[] args) {
		// Runs one of the functions 1000 times, measuring the runtime for a
		// range of N.

		// Starting point
		int t = 2;

		// A
		for (int n = 0; n < 5; n++) {
			long startTime = System.nanoTime();
			functionA(t);
			long endTime = System.nanoTime();

			long runTime = endTime - startTime;

			System.out.println("Function A Run " + (n + 1) + ": " + runTime);
			t = 2 * t;

		}

		System.out.println("");

		// B
		for (int n = 0; n < 5; n++) {
			long startTime = System.nanoTime();
			functionB(t);
			long endTime = System.nanoTime();

			long runTime = endTime - startTime;

			System.out.println("Function B Run " + (n + 1) + ": " + runTime);
			t = 2 * t;

		}

		System.out.println("");

		// C
		for (int n = 0; n < 5; n++) {
			long startTime = System.nanoTime();
			foo(t, 2);
			long endTime = System.nanoTime();

			long runTime = endTime - startTime;

			System.out.println("foo Run " + (n + 1) + ": " + runTime);
			t = 2 * t;

		}

	}

}