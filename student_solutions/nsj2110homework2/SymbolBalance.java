import java.io.*;

public class SymbolBalance {

	// declare the stack we will use to store opening symbols
	MyStack<Character> openStack = new MyStack<>();

/* SymbolCheck takes in the content of a file as a String 
and prints the proper error message if a symbol isn't balaned,
also prints a message if all symbols are balanced.
*/
	public void SymbolCheck(String c) {
		// initialize ints that will keep count of quotes and comment symbols that we come across
		int q = 0;
		int s = 0;

		// Set our content to the intake parameter
		String content = c;

		// boolean storing whether we are in a comment
		boolean inComment = false;

		// initialize char will store the character at our next position
		char next = 0;

		// boolean storing whether our symbols are balanced
		boolean balanced = true;

		/* iterate through content of file (a String) by looking at the character at a position in the String, 
		prints an error messahe if we come across a closing symbol but haven't seen any opening symbols
		*/ 
		for (int i = 0; i < content.length(); i++) {
			char current = content.charAt(i);
			if(i != content.length() - 1)
				next = content.charAt(i+1);
			// this is for skipping content that's inside a comment
			if(current == '/' && next == '*') {
				s++;
				inComment = true;
			} else if(current == '*' && next =='/') {
				s++;
				inComment = false;
			}
			if(inComment == false) {
				// if we come across a quote symbol, increments our count for that 
				if(current == '"') 
					q++;
				// adds opening symbols to stack
				else if(current == '{' || current == '(' || current == '[')
					openStack.push(current);
				/* prints error if we come across closing symbol and openStack is empty, 
				exits the for loop if we come across an imbalance, 
				pops symbols that are balanced */
				else if(current == '}' || current == ')' || current == ']') {
					if(openStack.isEmpty()) {
						System.out.println("Unbalanced! The symbol " + current + " is  missing corresponding opening symbol.");
						balanced = false;
						break;
					} else {
						if((current == '}' && openStack.peek() != '{') || (current == '[' && openStack.peek() != ']') || (current == ')' && openStack.peek() != '('))
							break;
						else 
							openStack.pop();
					}
				}
			}
		}

		// prints error message if we still have opening symbols in our stack
		if(!openStack.isEmpty()) {
			System.out.println("Unbalanced! The symbol " + openStack.peek() + " is missing corresponding closing symbol.");
			openStack.pop();
			balanced = false;
		}

		// if we have an uneven count of comment symbols, prints error
		if((s % 2) != 0) {
			System.out.println("Unbalanced! The comment symbol is mismatched.");
			balanced = false;
		}
		
		// if we have uneven count of quote symbols, prints error	
		if((q % 2) != 0) {
			System.out.println("Unbalanced! The symbol " + '"' + " is mismatched.");
			balanced = false;
		}

		// prints message if all of the symbols are balanced
		if(balanced == true) 
			System.out.println("Balanced! You're all good.");
	}

/* In the main method, we read in a file from the command line, create a string 
containing everything in the file,
we create a new instance of SymbolBalance and
call the SymbolCheck method on our file content*/
	public static void main(String[] args) {		
		try {
			String fileContent = null;
			String cLine;
			BufferedReader r = new BufferedReader(new FileReader(args[0]));
			try {
				while((cLine = r.readLine()) != null) {
					String f = fileContent;
					fileContent = f + cLine;
				}
				SymbolBalance sb = new SymbolBalance();
				sb.SymbolCheck(fileContent);
			} catch(IOException i) {
			} 
		} catch(FileNotFoundException e) {
			System.out.println("ERROR: Couldn't find file!");
		}
	}
}