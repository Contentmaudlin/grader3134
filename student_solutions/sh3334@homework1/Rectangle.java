/* SiLin Huang
 * UNI: sh3334
 * Homework 1: Rectangle
 * Due September 23, 2016
 */

public class Rectangle implements Comparable<Rectangle> {

	private int length;
	private int width;

	public Rectangle(int l, int w) {

		// Constructs a new rectangle
		length = l;
		width = w;

	}

	public int getLength() {

		// Returns the length of a rectangle
		return length;

	}

	public int getWidth() {

		// Returns the width of a rectangle
		return width;

	}

	public int getPerimeter() {

		// Returns the perimeter of a rectangle
		return 2 * length + 2 * width;

	}

	public int compareTo(Rectangle r) {
		// Compares two rectangles on the basis of perimeter size.
		int perimA = this.getPerimeter();
		int perimB = r.getPerimeter();

		if (perimA < perimB) {
			return -1;
		} else if (perimA > perimB) {
			return 1;
		} else {
			return 0;
		}

	}

}