
public class Rectangle implements Comparable<Rectangle> {

	//The length and width of the rectangle
	private double width;
	private double length;
	
	public Rectangle (double l, double w){
		width = w;
		length = l;
	}
	
	public double getLength(){
		return length;
	}
	
	public double getWidth(){
		return width;
	}
	
	
	
	
	@Override
	public int compareTo(Rectangle R){
		double perimeter1 = 2.0 * (length + width);
		double perimeter2 = 2.0 * (R.getLength() + R.getWidth());
		if(perimeter1 > perimeter2){
			//our rectangle's perimeter is larger than the one's we're comparing to
			return 1;
		}else if(perimeter1 < perimeter2){
			//our rectangle's perimeter is smaller than the one's we're comparing to
			return -1;
		}else{
			//unconditional else occurs when the perimeters are equal and returns 0
			return 0;
		}
	}
	
	//a toString method in case we need to print out the dimensions of our rectangle
	@Override
	public String toString(){
		String str = "length = " + length + ",width = " + width;
		return str;
	}
}
