import java.util.*;
import java.io.*;

public class SymbolBalance {
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(args[0]));
		MyStack<Character> stack = new MyStack<Character>();
		String line = "";
		boolean commented = false; //marks if a /* was found and hasn't been matched
		boolean quoted = false;  //marks if a " was found and hasn't been matched
		boolean blockQuoteStart = false; //marks if last character may have begun a /* or */
		while (f.ready()) {
			line = f.readLine();
			char c;
			for (int i = 0; i < line.length(); i++) {
				c = line.charAt(i);

				if (!commented && !quoted) { //If a comment or quote has not been started

					//Parses for opening symbols
					if ((c == '{') || (c == '(') || (c == '[')) {
						stack.push(c);
					}

					//Pasrsing for closing symbols }, ), ] and checks if they are unbalanced
					if (c == '}') {
						if (stack.isEmpty()) {
							System.out.println("Unbalanced! Symbol } never matched");
							System.exit(0);
						}
						if (stack.pop() != '{') { //Removes top symbol and compares it to {
							System.out.println("Unbalanced! Symbol } is mismatched");
							System.exit(0);
						}
					}
					if (c == ')') {
						if (stack.isEmpty()) {
							System.out.println("Unbalanced! Symbol ) never matched");
							System.exit(0);
						}
						if (stack.pop() != '(') { //Removes top symbol and compares it to (
							System.out.println("Unbalanced! Symbol ) is mismatched");
							System.exit(0);
						}
					}
					if (c == ']') {
						if (stack.isEmpty()) {
							System.out.println("Unbalanced! Symbol ] never matched");
							System.exit(0);
						}
						if (stack.pop() != '[') { //Removes top symbol and compares it to [
							System.out.println("Unbalanced! Symbol ] is mismatched");
							System.exit(0);
						}
					}
					
					//Determining if a comment is starting
					if (c == '"') {
						quoted = true;
					}
					if ((c == '*') && (blockQuoteStart)) {
						commented = true;
					}
					if (c == '/') {
						blockQuoteStart = true;
					}
					else {
						blockQuoteStart = false;
					}
				}

				else { //If a comment or quote has not been started
					//Determining if a comment has ended
					if (c == '"') {
						quoted = false;
					}
					if ((c == '/') && (blockQuoteStart)) {
						commented = false;
					}
					if (c == '*') {
						blockQuoteStart = true;
					}
					else {
						blockQuoteStart = false;
					}
				}
			}
		}
		if (quoted) { //If a quote was not ended
			System.out.println("Unbalanced! Symbol \" never matched");
			System.exit(0);
		}
		if (!stack.isEmpty()) { //If an opening symbol wasn't matched
			System.out.println("Unbalanced! Symbol " + stack.pop() + " never matched");
			System.exit(0);
		}
		if (commented) {  //If a comment wasn't ended
			System.out.println("Unbalanced! Symbol /* never matched");
			System.exit(0);
		}
		System.out.println("Balanced!");
	}
}