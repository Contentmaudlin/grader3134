/***********************************************
/ SymbolBalance.java
/ By Sungmin An (UNI: sa3333)
/ To check whether all []'s {}'s /*'s & "'s are
/ properly balanced. 
************************************************/

import java.io.*;

public class SymbolBalance{

	/* Method that checks whether elements are balanced. 
	   @param BufferedReader input.
	*/ 
	private static void checkBalance(BufferedReader input) 
		throws IOException{

		/* Creates a stack to use to hold elements. */ 
		MyStack<Character> stack = new MyStack<>();
		/* Holds each line. */
		String line; 
		/* Boolean to check whether we're inside string literal. */
		boolean isStringLit;
		/* Boolean to check whether we're inside comment. */
		boolean isComment = false; 
		/* Stores error item */ 
		String error = ""; 

		/* Reads each line from the file */ 
		outerloop:
		while ((line = input.readLine()) != null){

			/* For each line, set isStringLit to false. */
			isStringLit = false; 
			/* Reads each char in the line. */ 
			for (int i = 0; i < line.length(); i++){


				/* If " is found, we're ignore everything
				   unless we're inside a comment. 
				*/
				if (line.charAt(i) == '\"' && !isComment){
					/* If already stringLit, " is closing " */
					if (isStringLit){
						isStringLit = false; 
					}
					/* We're inside stringLit if " is 1st " */
					else{
						isStringLit = true; 
					}
				}

				/* If we encounter comment symbol, we ignore
				   everything unless we're inside stringLit. 
				*/ 
				if (line.charAt(i) == '/' && !isStringLit){
					/* Check next element to see if it's *
					   If yes, beginning of comment. Make
					   sure we don't go past last element. 
					*/ 
					if (i + 1 < line.length()){
						if (line.charAt(i+1) == '*'){
							isComment = true; 
						}
					}
				}

				/* Handles case in which we encounter closing
				   comment symbol. Close comment if inside 
				   comment & unless inside string literal. 
				*/
				if (line.charAt(i) == '*' && !isStringLit 
					&& isComment){
					/* Check next element to see if it's 
					/ given that it's not null.
					*/
					if (i+1 < line.length()){
						if (line.charAt(i+1) == '/'){
							isComment = false; 
						}
					}
				}
				/* If closing symbol is found alone, error! */
				else if (line.charAt(i) == '*' && !isStringLit
					&& !isComment){
					error = "/*";
					break outerloop; 
				}

				/* Checks the rest to see if they are unbalanced if we
				   are currently not in string literal or comment. 
				*/ 
				if (!isComment && !isStringLit){
					/* If opening symbols are found, always 
					push them into the stack. 
					*/ 
					if (line.charAt(i) == '[' || 
						line.charAt(i) == '{' || 
						line.charAt(i) == '('){
						stack.push(line.charAt(i));
					}
					/* If closing symbols are found, check stack to 
					see if it's not empty. If not, pop out the top 
					element and check if they match. If no match or 
					stack empty, give error.
					*/  
					else if (line.charAt(i) == ']'){
						if (!stack.empty()){
							if (stack.pop() != '['){
								error = "[";
								break outerloop;
							}
						}
						else{
							error = "[";
							break outerloop;
						}
					} 
					else if (line.charAt(i) == '}'){
						if (!stack.empty()){
							if (stack.pop() != '{'){
								error = "{";
								break outerloop;
							}
						}
						else{
							error = "{"; 
							break outerloop;
						}
					}
					else if (line.charAt(i) == ')'){
						if (!stack.empty()){
							if (stack.pop() != '('){
								error = "(";
								break outerloop;
							}
						}
						else{
							error = "(";
							break outerloop; 
						}
					}
				}

				/* Checks if " is balanced at the end. If not, 
				   give error message and break outerloop. 
				*/ 
				if (i == line.length()-1 && isStringLit && 
					!isComment){
					error= "\"";
					break outerloop;
				}
			}
		}
		/* If comment is not closed by the end, give error */
		if (isComment){
			error = "/*";
		}

		/* If there are still elements in the stack after 
		   the loop & no error has been found, set the first
		   unmatched element as error. 
		*/
		if (!stack.empty() && error.isEmpty()){
			String remainder = "";
			while (!stack.empty()){
				remainder = Character.toString(stack.pop());
			}
			error = remainder; 
		}

		/* Prints error message. */ 
		if (!error.isEmpty()){
			System.out.println("Unbalanced! " + error
				+ " is mismatched");
		}
		else{
			System.out.println("Congratz! Your file is " 
				+ "free of errors!");
		}
	}

	/* Main method with try/catch statements. */
	public static void main(String[] args) throws IOException{

		/* Creates new BufferedReader and set it equal to null
		   so br.close() can be in finally() statement. 
		*/ 
		BufferedReader br = null; 

		/* try/catch statements to catch exceptions. 
		*/ 
		try{
			/* Attempts to read text from input stream and 
			   pass in the BufferedReader as argument. 
			*/ 
			br = new BufferedReader(new FileReader(args[0]));
			checkBalance(br);

		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Input a file you idiot!");
		}catch (FileNotFoundException e){
			System.out.println("Input the correct file name "
				+ "you idiot!");
		}catch (IOException e){
			throw new IOException();
		}finally{
			/* Closes the stream */
			if (br != null){
				br.close(); 
			}
		}
	}
}