import java.util.Arrays;

public class Problem2 {


	public static void main(String[] args){

		Rectangle [] rectArr = new Rectangle [] {
				new Rectangle(1.0,1.0),
				new Rectangle(100.0,2.0),
				new Rectangle(43.5,2.5),
				new Rectangle(52.5,50.0),
				new Rectangle(11.0,12.0)
		};
		Arrays.sort(rectArr);
		//CHeck the location of every rectangle in the array
		for(int i = 0; i < rectArr.length; i++){
			System.out.print("The rectangle defined by (" + rectArr[i] + ") is found in the array at index ");
			int index = binarySearch(rectArr,rectArr[i]);
			System.out.println(index + "\n");
		}
		//Check for a rectangle which is not in the array
		Rectangle newRect = new Rectangle(100.0,100.0);
		System.out.print("The rectangle defined by (" + newRect + ") is found in the array at index ");
		int index = binarySearch(rectArr,newRect);
		System.out.println(index + "\n");
		
		//Lets the user add their own input
		if(args.length == 2){
			//Make sure a number is passed
			if(Integer.parseInt(args[0])!= 0 && Integer.parseInt(args[1]) != 0){
				Rectangle rectInput = new Rectangle(Integer.parseInt(args[0]),Integer.parseInt(args[1])) ;
				System.out.print("The rectangle defined by (" + rectInput + ") is found in the array at index ");
				int index2 = binarySearch(rectArr,rectInput);
				System.out.println(index2 + "\n");
			}
		}
	}

	public static <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){

		// call the helper method 
		return binSearchHelper(a,x,0, a.length - 1);

	}


	private static <AnyType extends Comparable<AnyType>> int binSearchHelper(AnyType[] a, AnyType x, int start, int stop){

		//Base case: start > stop (the value was not found)
		if(start > stop){
			return(-1);
		}else{
			//the array still has nonzero length, so we must check its midpoint
			int mid = start + (stop - start)/2;
			if(a[mid].compareTo(x) == 0){
				return mid;
			}else if(a[mid].compareTo(x) < 0){
				//x is larger than the mid -> pass the second half of the array. Exclude mid because we've already checked it
				return binSearchHelper(a, x, mid + 1, stop);
			}else{
				//x is smaller than the mid -> pass the first half of the array. Exclude mid because we've already checked it
				return binSearchHelper(a, x, start, mid - 1);
			}
		}
	}


}
