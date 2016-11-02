/* SiLin Huang
 * UNI: sh3334
 * Homework 1: Problem 2
 * Due September 23, 2016
 */

import java.util.Arrays;

public class Problem2 {

	public static <AnyType extends Comparable<AnyType>> int binarySearch(
			AnyType[] a, AnyType x) {

		// Uses binaryHelper to search for the location of a specific object in
		// an ordered array
		int low = 0;
		int high = a.length - 1;
		return binaryHelper(a, x, low, high);

	}

	private static <AnyType extends Comparable<AnyType>> int binaryHelper(
			AnyType[] a, AnyType x, int low, int high) {

		// Recursively uses binarySearch to find a specific object in an ordered
		// way
		int mid = (low + high) / 2;

		if (low > high) {
			return -1;

		} else if (a[mid].compareTo(x) < 0) {
			return binaryHelper(a, x, mid + 1, high);

		} else if (a[mid].compareTo(x) > 0) {
			return binaryHelper(a, x, mid - 1, low);

		} else if (a[mid].compareTo(x) == 0) {
			return mid;

		}

		return -1;

	}

	public static void main(String[] args) {

		// Tests the binarySearch method using a hard-coded array of rectangles.
		Rectangle[] manyRectangles = new Rectangle[5];

		Rectangle a = new Rectangle(5, 9);
		Rectangle b = new Rectangle(15, 6);
		Rectangle c = new Rectangle(8, 7);
		Rectangle d = new Rectangle(1, 13);
		Rectangle e = new Rectangle(2, 16);
		Rectangle f = new Rectangle(100, 100);

		manyRectangles[0] = a;
		manyRectangles[1] = b;
		manyRectangles[2] = c;
		manyRectangles[3] = d;
		manyRectangles[4] = e;

		Arrays.sort(manyRectangles);

		int index = binarySearch(manyRectangles, f);

		if (index == -1) {
			System.out.println("This rectangle is not in this array.");

		} else {
			System.out.println("This rectangle is found at index " + index
					+ ".");

		}

	}

}