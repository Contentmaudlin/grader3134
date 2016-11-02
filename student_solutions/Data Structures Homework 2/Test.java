//*************************************************************
//Test.java
//
//by Sophie Ishak
//*************************************************************
/* this is to test whether the program can deal with an imbalance of ] */

public class Test1 { 
    public static final void main(String[] args) {
    	
    	int ]values={1,2,3,4,5,6,7,8,9};
		int min=values[0];
		int max=values[0];
		
		for(int i = 0 ; i<values.length; i++) { 
			
			if( min > values[i]) 
			min = values[i]; 
			if(max < values[i]) 
			max = values[i]; 
		
		}
		System.out.println("Minimum = " + min); 
		System.out.println("Maximum = " + max); 
    } 
} 