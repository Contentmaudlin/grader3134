/* Chiara Vallini 
 * cfv2111
 * SymbolBalance.java
 * This class takes in the name of a java file as a command line argument and reads the file. It then
 * checks to make sure that all { }'s, ( )'s, [ ]'s, " "'s, '*//*'s are properly balanced. It ignores characters 
 * within literal strings and comment blocks.  
 */
import java.io.*;


public class SymbolBalance {

	// Main method 
	public static void main(String[] args) throws IOException{
		
		// tries and catches exceptions 
		try
		{
			// read the file given in the command line using a buffer 
			BufferedReader buff = new BufferedReader (new FileReader(args[0])); 
			
			
			// Print what the check method returns 
			System.out.println(checkText(buff));
			
			// close the buffer
			buff.close();
		}
		catch (Exception e)
		{
			System.out.println("File not found");
		}
	}	
	
	// check method 
	public static String checkText (BufferedReader b) throws IOException{
		
		// create a stack of characters 
		MyStack<Character> balancedst  = new MyStack<Character>();
		// initialize the string to null 
		String text= null; 
		// booleans to indicate if the iterator is within a comment or a quotation 
		boolean commentFlag = false;
		boolean stringFlag = false;
		
		// read the buffer line by line and store it in the string text 
		while ((text = b.readLine()) != null){
			
			
			int j;
			
			// Iterate through the string text for the length of it 
			for(j = 0; j < text.length(); j++) {
				// get ever character of the string 
				char charat = text.charAt(j);
				
				// if j is not the before last character of the string 
				if(j !=  text.length()-1 ){
					// at the start of the comment change the boolean to true 
					if (text.charAt(j) == '/'){
						if (text.charAt(j+1) == '*')
							commentFlag = true;	

					}
					// at the end of the comment change the boolean to false 
					if (text.charAt(j) == '*'){
						if (text.charAt(j+1) == '/' && text.charAt(j-1) != '/')
							commentFlag = false;

					}
					// at the start of the quotes change the boolean to true 
					if (text.charAt(j) == '"' && commentFlag == false && stringFlag == false){
						stringFlag = true;	
					}
					// at the end of the quotes change the boolean to true 
					else if (text.charAt(j) == '"' && commentFlag == false && stringFlag == true) {
						stringFlag = false;
					}
				}
				
				// if the character is not within comments or quotes
				if (commentFlag ==false && stringFlag == false) {

					// if the character is one of the opening parenthesis 
					// push the character into the stack 
					if(charat == '{' || charat == '(' || charat == '[' ) {
						balancedst.push(charat);
					}
					// if the character is a closing } parenthesis, if the stack is empty or the element that is 
					// popped from the stack is not the opening { parenthesis, return imbalanced parenthesis error 
					if(charat == '}' ) {
							
						if(balancedst.empty()){
							return "The stack is empty " + charat + " parenthesis";
						}
	
						if(balancedst.pop() != '{' ){
							return "The file has imbalanced {} parenthesis";
						}
					}
					// if the character is a closing ] parenthesis, if the stack is empty or the element that is 
					// popped from the stack is not the opening [ parenthesis, return imbalanced parenthesis error 
	
					else if(charat == ']') {
	
						
						if(balancedst.empty()){
							return "The stack is empty " + charat + " parenthesis";
						}
						if(balancedst.pop() != '['){
							
	
							return"The file has imbalanced [] parenthesis";
						}
					}
					
					// if the character is a closing ) parenthesis, if the stack is empty or the element that is 
					// popped from the stack is not the opening ( parenthesis, return imbalanced parenthesis error 
					else if (charat == ')') {
	
						if(balancedst.empty()){
							return "The stack is empty and has imbalanced " + charat + " parenthesis";
						}
						if(balancedst.pop() != '('){
	
	
							return"The file has imbalanced () parenthesis";
						}
					}
				}
				
			}
			// check if the quotation within the same line are balanced 
			if (stringFlag == true){
				return "The file has imbalanced quotations";
		
			}
		}
		// check if the are extra parenthesis in the stack that are mismatched 
		if (balancedst.empty() == false ){
			
			Character lastElement = balancedst.pop(); 
			return "The file has imbalanced " + lastElement.toString() + " parenthesis";
		}
		// check if the comments are balanced 
		if (commentFlag == true){
			return "The file has imbalanced comments";
	
		}
		// return no mismatches! 
		return "There are no mismatches!!!"; 
	}
}


