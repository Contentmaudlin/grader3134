/*Francisco Fernandez De Ybarra
 * FF2311
 * Symbol Balance Class: Checks the java file for any unbalanced or mismatched symbols and outputs the first symbol with an error. 
 */


import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class SymbolBalance{
	
	public static void main (String[] args) throws IOException {
		
		
		MyStack stack = new MyStack();
		char character;
		char compare;
		boolean errorFound = false;
		
		//Read file with a scanner, make sure scanner only reads characters by using
		//a single space as a delimiter
		
		File inputfile = new File(args[0]);
		
		//try statement in order to handle IOexception
		try{
		
		Scanner scan = new Scanner(inputfile);
		scan.useDelimiter("");
		
		
		//put entire class into a while loop, that iterates through the characters
		//until the java file is finished
		while(scan.hasNext()==true && errorFound == false){
			character = scan.next().charAt(0);
		
			//if statements checking for open brackets, if they are open they
			//are pushed on to the stack
			if(character=='{'||character =='('||character =='['){
				stack.push(character);
			}
			
			
			//if statements checking for mismatch or no opening symbol error
			if(character=='}'||character ==')'||character ==']'){
				if(stack.isEmpty()==true){
					System.out.println("Error, the closing symbol " + character
										+ " does not have a corresponding opening"
										+ " symbol");
					errorFound = true;
				}
				else{
					compare = (char) stack.pop();
				
					if(character=='}' && compare!='{'){
						System.out.println("Mismatch between closing and"
								+" opening symbol, Symbol } is mismatched");
						errorFound = true;
					}
				
					if(character==')' && compare!='('){
						System.out.println("Mismatch between closing and"
								+" opening symbol, Symbol ) is mismatched");
						errorFound = true;
					}
				
					if(character==']' && compare!='['){
						System.out.println("Mismatch between closing and"
								+" opening symbol, Symbol ] is mismatched");
						errorFound = true;
					}
				}
			}
			
			
			/*if statement for the special case of quotation marks
			if a quotation mark is read it will iterate through the file until 
			either the file finishes or another quotation mark is found, ignoring
			unbalanced symbols within quotation marks and indicating an error if
			unclosed expression is not closed*/
			
			if(character == '"'){
				
				boolean quoteComplete = false;
				stack.push(character);
				character = scan.next().charAt(0);
			
				while(character!='"'&& scan.hasNext()){
					character = scan.next().charAt(0);
				}
				
				if(character == '"'){
					stack.pop();
					quoteComplete = true;
				}
				
				if(quoteComplete!=true){
					System.out.println("Error, unclosed \" expression");
					errorFound = true;
				}
			}
			
			
			
			
			/* if statement for the special case of block quotations. Similar to quotation mark method but 
			 * includes a boolean which checks for the completion of the figures since they are two characters
			 * rather than one
			 */
			
			if(character == '/'){
				character = scan.next().charAt(0);
				if(character=='*'){
					
					stack.push('/');
					stack.push(character);
					boolean complete = false;
	
					while(complete == false && scan.hasNext()){
						
						character = scan.next().charAt(0);
						
						if(character=='*'){
							character = scan.next().charAt(0);
							
							if(character=='/'){
								complete = true;
								stack.pop();stack.pop();								
							}
						}				
					}
					
					if(stack.isEmpty()!=true && complete==false){
						System.out.println("Error, Unclosed /* expression");
						errorFound = true;
					}
					
					complete = false;
				}					
			}
			
			//checks if you have a close */ block expression without a corresponding opening
			//block expression
			if(character == '*'){
				if(scan.next().charAt(0)=='/'){
					System.out.println("Error, the closing symbol */ does"
										+" not have a corresponding opening symbol");
					errorFound = true;
				}
			}
			
			
			
		}
		
		//Outside the while loop, checks if any expressions have been opened that haven't
		//been closed 
		if(stack.isEmpty()==false && errorFound == false){
			character = (char) stack.pop();
			System.out.println("Error unclosed " + character + " expression");
			
		}
		
		scan.close();
		
		}
		
		//Catch statement for IO exception
		catch (IOException e){
			System.out.println("File not found");
		}
	}		
}
