
public class Problem1 {



	public static void main(String[] args){

		Rectangle [] rectArr = new Rectangle [] {
				new Rectangle(1.0,1.0),
				new Rectangle(100.0,2.0),
				new Rectangle(43.5,2.5),
				new Rectangle(52.5,50.0),
				new Rectangle(11.0,12.0)
		};

		//Print the array for convenience
		System.out.println(("The array consists of rectangles with dimensions: "));
		for(int i = 0; i < rectArr.length; i++){
			System.out.println("(" + rectArr[i] + ") ");

		}
		//Find the max rectangle in the array
		Rectangle maxR = findMax(rectArr);
		System.out.println("The largest rectangle in this array is that of (" + maxR + ")");

	}





	//Given in the problem
	public static <AnyType extends Comparable<AnyType>> AnyType findMax(AnyType[] arr) {
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++)
			if ( arr[i].compareTo(arr[maxIndex]) > 0 )
				maxIndex = i;
		return arr[maxIndex];
	}

}
