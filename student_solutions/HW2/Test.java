public class Test{
	public static void printLots(int[] L, int[] P){
		for(int i : P){
			if (i < L.length){
				System.out.println(L[i]);
			}
		}
	}
	public static void main(String[] args){
		int[] L = {1, 2, 3, 4};
		int[] P = {1, 5};
		printLots(L, P);
	}
}