import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;

public class written1 {
	
	public static void printLots( List<Integer> l, List<Integer> p){
		try{int a=0; //the variable to store number in list p
		    int b=0; //the variable to store number next to the one of a
		Iterator<Integer> l1=l.iterator(); //create two iterator for l and p separately
		Iterator<Integer> p1=p.iterator();				
		for(Integer x:p) {	//go thru the element in list p
			a=p1.next()-1;    //store the element in p at variable a, the reason to -1 is because next() method need to move and return, and hence i move to the previous element instead in order for the later next() to move to the right place
			for(int i=1;i<=a-b;i++){ //try to find the element in l that p refers to
				l1.next();
			}			
			System.out.println(l1.next());		
			  b=a+1;		            //add one back to get the correct index for the element
		}}catch (Exception e){ 
		System.out.println("The length of L is smaller than the index that been give in P");
		}		
	}
	public static void main (String[] arg){
		List<Integer> L= new LinkedList<Integer>();
		List<Integer> P= new LinkedList<Integer>() ;
		P.add(1);
		P.add(2);
		P.add(3);
		P.add(9);
		for(int i=1;i<=18;i++)
		{L.add(i);}
		printLots(L,P);
		
	}

}
