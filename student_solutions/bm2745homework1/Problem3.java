
public class Problem3 {




	public static void main(String[] args){
		for(int i = 1; i < 1000000; i*= 10){
			
			System.out.println("\nn = " + i);
			
			long startA = System.nanoTime();
			runProgA(i);
			long endA = System.nanoTime();
			System.out.println("The time for program a with n = " + i + " is " + (endA-startA) + " ns");
			
			long startB = System.nanoTime();
			runProgB(i);
			long endB = System.nanoTime();
			System.out.println("The time for program b with n = " + i + " is " + (endB-startB) + " ns");
			
			long startFoo = System.nanoTime();
			foo(i,2);
			long endFoo = System.nanoTime();
			System.out.println("The time for program foo with n = " + i + " is " + (endFoo-startFoo) + " ns");			
		}
	}


	public static int runProgA(int n){

		int sum = 0;
		for ( int i = 0; i < 23; i ++){
			for ( int j = 0; j < n ; j ++){
				sum = sum + 1;
			}
		}
		return sum;
	}	

	public static int runProgB(int n){

		int sum = 0;
		for ( int i = 0; i < n ; i ++){
			for ( int k = i ; k < n ; k ++){
				sum = sum + 1;
			}
		}
		return sum;
	}

	public static int foo(int n, int k) {
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(n<=k){
			return 1;
		}else{
			return foo(n/k,k) + 1;
		}
	}

}
