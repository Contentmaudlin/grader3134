import java.util.Scanner;
import java.io.*;

public class SymbolBalance {
	
	private static Scanner input;
	private static Scanner fileScan;

	public static void main(String[] args) throws IOException {
		//creates the stack that will be used to test the file
		MyStack<Character> tester = new MyStack<Character>();
		
		//Scanner allows for file directory to be inputed by the user
		input = new Scanner(System.in);
		System.out.println("What file would you like to test? ");
		String fileName = input.next();
		
		//takes the file directory given and scans the file in as one big chunk
		File file = new File(fileName);
		fileScan = new Scanner(file);
		fileScan.useDelimiter("\\Z");
		String B = fileScan.next();
		//prints out the file with the final result
		System.out.println(B);
		//turns the big chunk into an array of characters to be iterated through for testing
		char[] C = B.toCharArray();
		
		//test assumes the code works until one of the symbols is found to be mismatched
		boolean test = true;
		int i = 0;
		int j = 0;
		
		//The whole test operates by iterating through the CharArray one step at a time
		
		while (i<C.length) {
		//This allows for comments within /* and */ to be ignored
		//Works by checking after symbol / for * and then check each subsequent set
		//of symbols for * and then /. Skipping over anything in the comments
			if (C[i] == '/' && C[i+1] =='*') {	
				while (C[i+2] != '*' || C[i+3] != '/' && i<=C.length-3){
					i++;
					if (i == C.length-2) {
						System.out.println("Unbalanced: Symbol /* unmatched");
					}
				}
				i=i+4;
			}
		//Pushes the first symbol onto the stack whenever encountered
			else if (C[i] == '{' || C[i] == '[' || C[i] == '('){
				tester.stackPush(C[i]);
				i++;
			}
		//All 3 checks on the back side	of those symbols to see if the symbol in
		//the stack (if there is one) matches up
			else if (C[i] == '}'){
				if (tester.peek() == null) {
					System.out.println("Unbalanced: Symbol } unmatched");
					test = false;
				}
				else {
					char D = tester.stackPop();
					if (D != '{') {
						System.out.println("Unbalanced: Symbol " + D + " mismatched with }");
						i= C.length;
						test = false;
					}
				}
				i++;
			}
			else if (C[i] == ']'){
				if (tester.peek() == null) {
					System.out.println("Unbalanced: Symbol ] unmatched");
					test = false;
				}
				else {
					char E = tester.stackPop();
					if (E != '[') {
						System.out.println("Unbalanced: Symbol " + E + " mismatched with ]");
						i= C.length;
						test = false;
					}
				}
				i++;
			}
			else if (C[i] == ')'){
				if (tester.peek() == null) {
					System.out.println("Unbalanced: Symbol ) unmatched");
					test = false;
				}
				else {
					char F = tester.stackPop();
					if (F != '(') {
						System.out.println("Unbalanced: Symbol " + F + " mismatched with )");
						i= C.length;
						test = false;
					}
				}
				i++;
			}
			//Since " is the same at the front and back this first checks
			//if it is the first or second " by checking if j/2 has no remainder
			//Once this is done the test runs the same as the other symbols for the 
			//front and back "
			else if (C[i] == '"'){
				j++;
				if (j%2 != 0) {
					tester.stackPush('"');
				}
				if (j%2 == 0 && tester.peek() == null) {
					System.out.println("Unbalanced: Symbol" + '"'  + "unmatched");
					test = false;
				}
				else if (j%2 == 0 && tester.peek() != null) {
					char E = tester.stackPop();
					if (E != '"') {
						System.out.println("Unbalanced: Symbol " + E + " mismatched with " + '"');
						i= C.length;
						test = false;
					}
				}
				i++;
			}
			else {
				i++;
			}
		}
		//This outputs the success statement and does one last check that the stack
		//is empty (which would mean one of the symbols is unclosed and the file
		//failed the test)
		if (test == true)
			if (tester.peek() == null) {
			System.out.println("Success! The code is balanced!");
			}
			else {
			System.out.println("Unbalanced: Symbol " + tester.stackPop() + " unmatched");
			}
	}
			
}		



