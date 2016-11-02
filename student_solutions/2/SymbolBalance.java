//Code by Or Aboodi, oda2102
//Data Structures Fall 2016 Hw 2 problem 1
//Symbol Balancing in a java text file

import java.io.*;

public class SymbolBalance{
	
	public static void main(String[] args) throws IOException{
		if (args[0] == null) {
			throw new IndexOutOfBoundsException();
		}
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		StringBuilder sb = new StringBuilder();
		String newLine = br.readLine();
		
		//read the file and put the entire file into a string builder
		while (newLine != null) {
			sb.append(newLine);
			sb.append(" \n ");
			newLine = br.readLine();
		}
			
		br.close();
		
		//move the stringbuilder into a string
		String fileToCheck = sb.toString();
		
		//create a few stacks to check the file validity
		MyStack<Character> squareBracket = new MyStack<Character>(); //check []
		MyStack<Character> parenth = new MyStack<Character>(); //check ()
		MyStack<Character> curlyBracket = new MyStack<Character>(); //check []
		MyStack<Character> quotes = new MyStack<Character>(); //will check ""
		MyStack<Character> comments = new MyStack<Character>(); //will check */
		
		//booleans to ignore inside comments and quotes
		boolean inAComment = false;
		boolean inAQuote = false;
		//a boolean to make sure quotes aren't added twice
		boolean quoteAdded = false;

		for (int i = 0; i < fileToCheck.length(); i++) {
		//iterating over the string checking each character
			
			Character x = fileToCheck.charAt(i);
			//character being checked is x
			Character x2;
			//assign a variable to the next character to check if its a comment
			if (i == fileToCheck.length()-1)
				x2 = 'z'; //a non-important char if its at the end
			else //only if its not the end of the string add the actual char
				x2 = fileToCheck.charAt(i + 1);
			
			if (!inAComment & !inAQuote) {
			//only check objects if they are outside of a comment/quote block
				
				if (x.equals('"')) {
					inAQuote = true;
					if (!quoteAdded){
						quoteAdded=true;
						quotes.push(x);
					}
				}//add to the quote stack and enter a quote block condition

				if (x.equals('[') || x.equals(']'))
					squareBracket.push(x);

				if (x.equals('(') || x.equals(')'))
					parenth.push(x);
				
				if (x.equals('{') || x.equals('}'))
					curlyBracket.push(x);
				

				if (x.equals('/') & x2.equals('*')) {
						comments.push(x);
						comments.push(x2);
						inAComment = true;
						i++;
				}//add both symbols to the comment stack
				//enter a comment block
				//and increment i(since x2 was added as well
			}
			
			//only if we are in a block quote that was not initiated
			//in this loop increment
			if (!quoteAdded & inAQuote & x.equals('"')){
				inAQuote = false;
				quotes.push(x);
			}//the way to get out of a quote block
			
			if (inAComment & x.equals('*') & x2.equals('/')){
				inAComment = false;
				comments.push(x);
				comments.push(x2);
				i++; }//getting out of a comment block
			
			//reset the quote added condition at the end of each loop
			quoteAdded=false;
			
		}

		//checking if the quotes are balanced
		boolean quoteBalance = true;
		//the quotes are balanced if there is an even number
		if (quotes.size() % 2 != 0){
			System.out.println("your code is unbalanced with a quote missing");
			quoteBalance = false;}
			
		
		
		//checking if the square brackets are balanced
		boolean squareBalance = true;
		//count of balanced brackets
		int rightSquare = 0;
		int leftSquare = 0;
		
		if (squareBracket.size() != 0) {
			//if there were no square brackets, balance remains
			
			if (squareBracket.size() % 2 != 0) {
				squareBalance = false;} 
			//if there are an uneven number, balance is off
			
			else if (!squareBracket.peek().equals(']')) {
				squareBalance = false;}
			// the last one must always be a right bracket
			
			else {
				int sizeOfLoop = squareBracket.size();
				//need to store the size now since it gets smaller after pop
				for (int i = 0; i < sizeOfLoop; i++) {
					if (squareBracket.pop().equals(']')) {
						rightSquare++;}
					else
						leftSquare++;
					if (leftSquare > rightSquare) {
						squareBalance = false;}}}
			// if the left brackets ever go above the right brackets
			// there must be an imbalance

			if (rightSquare != leftSquare) {
				squareBalance = false;
			} // the balance must be intact
			if (!squareBalance) {
				System.out.println("code is unbalanced in []");
			}
		}
		
		
		//checking if the parentheses are balanced
		boolean parenthBalance = true;
		int rightParenth = 0;
		int leftParenth = 0;
		
		//same exact conditions as square brackets
		if (parenth.size() != 0) {
			if (parenth.size() % 2 != 0) {
				parenthBalance = false;}
			else if (!parenth.peek().equals(')')) {
				parenthBalance = false;
			}
			// the last one must always be a right bracket
			else {
				int sizeOfLoop = parenth.size();
				for (int i = 0; i <sizeOfLoop; i++) {
					if (parenth.pop().equals(')')) {
						rightParenth++;}
					else
						leftParenth++;
					if (leftParenth > rightParenth) {
						parenthBalance = false;}}}
			// if the left brackets ever go above the right brackets
			// there must be an imbalance
			
			if (rightParenth != leftParenth) {
				parenthBalance = false;
			} // the balance must be even
			if (!parenthBalance) {
				System.out.println("code is unbalanced ()");
			}
		}
		
	
		
		//checking if the curly brackets are balanced
		boolean curlyBalance = true;
		// count of balanced brackets
		int rightCurly = 0;
		int leftCurly = 0;
		//same conditions as square brackets
		if (curlyBracket.size() != 0) {
			if (curlyBracket.size() % 2 != 0) {
				curlyBalance = false;}
			else if (!curlyBracket.peek().equals('}')) {
				curlyBalance = false;}
			// the last one must always be a right bracket
			else {
				int lengthOfLoop = curlyBracket.size();
				//take the size into an int so the loop won't get smaller
				for (int i = 0; i < lengthOfLoop; i++) {
					Character bracketPopped = curlyBracket.pop();
					if (bracketPopped.equals('}')) {
						rightCurly++;}
					else if (bracketPopped.equals('{')){
						leftCurly++;}
					if (leftCurly > rightCurly) {
						curlyBalance = false;}}}
			// if the left brackets ever go above the right brackets
			// there must be an imbalance
			if (rightCurly != leftCurly) {
				curlyBalance = false;
			} // the balance must be even
			if (!curlyBalance) {
				System.out.println("code is unbalanced in {}");
			}
		}
		
		
		//checking the comment balance 
		boolean commentBalance = true;
		
		if (comments.size() != 0){
			if (comments.size() % 4 != 0){
				commentBalance = false;}
			//comment blocks come in 4 characters, so they must be
			//a multiple of 4 to be balanced
			else if (!comments.peek().equals('/')){
				commentBalance=false;}
			//last character must be a '/'
			else{
				int sizeOfLoop = comments.size();
				for (int i=0;i<sizeOfLoop;i=i+4){
				//go through the stack size/4 times
					if (!comments.pop().equals('/') || 
							!comments.pop().equals('*') || 
							!comments.pop().equals('*') ||
							!comments.pop().equals('/')) {
						commentBalance=false;
					}//the sequence must be /**/ for a balance
				}
			}
			if (!commentBalance) {
				System.out.println("your code is unbalanced in comments");
			}
		}
		
		if (curlyBalance & squareBalance & quoteBalance & 
				parenthBalance & commentBalance){
			System.out.println("your code did not have imbalances!");
		}
	}
		
}