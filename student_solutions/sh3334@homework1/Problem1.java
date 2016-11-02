/* SiLin Huang
 * UNI: sh3334
 * Homework 1: Problem 1
 * Due September 23, 2016
 */

public class Problem1 {

	public static <AnyType extends Comparable<AnyType>> AnyType findMax(
			AnyType[] arr) {

		// Finds and returns the largest object in an array.
		int maxIndex = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i].compareTo(arr[maxIndex]) > 0) {
				maxIndex = i;
				
			}

		}

		return arr[maxIndex];

	}

	public static void main(String[] args) {

		// Tests the findMax method using a hard-coded array of rectangles.
		Rectangle[] manyRectangles = new Rectangle[5];

		Rectangle a = new Rectangle(5, 9);
		Rectangle b = new Rectangle(15, 6);
		Rectangle c = new Rectangle(8, 7);
		Rectangle d = new Rectangle(1, 13);
		Rectangle e = new Rectangle(2, 16);

		manyRectangles[0] = a;
		manyRectangles[1] = b;
		manyRectangles[2] = c;
		manyRectangles[3] = d;
		manyRectangles[4] = e;

		Rectangle largest = findMax(manyRectangles);

		System.out.println("The largest rectangle is " + largest.getLength()
				+ " by " + largest.getWidth() + ".");

	}

}