import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem1 {
	
	public static <AnyType> void main(String[] args){
		List<AnyType> L = new ArrayList<AnyType>();

		
		List <Integer> P = new ArrayList <Integer> (); 
		P.add(2);
		P.add(7);
		PrintLots(L,P);
	}

	public static <AnyType> void PrintLots(List<AnyType> L, List<Integer> P) {

		if (P.size() > L.size())
			throw new IndexOutOfBoundsException();

		Iterator<AnyType> itL = L.iterator();
		Iterator<Integer> itP = P.iterator();

		int i = 0;
		AnyType l = null;
		if (itL.hasNext()) {
			l = itL.next();
		}
		int p = -1;
		while (itL.hasNext() && itP.hasNext()) {
			p = itP.next();
			while (i != p && itL.hasNext()) {
				i++;
				l = itL.next();
			}
			System.out.println(l);
		}
	}
}

