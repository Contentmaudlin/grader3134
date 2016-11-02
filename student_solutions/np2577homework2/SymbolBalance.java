import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
/* Nishant Puri
 * np2577
 * HW2 Problem1: SymbolBalance.java
 */

public class SymbolBalance {

	//takes in two characters and checks if they match
	public static boolean match(Character ch, Character ch2) {
		boolean match = false;
		if (ch.equals('{') & ch2.equals('}')) {
			match = true;
		} else if (ch.equals('(') & ch2.equals(')')) {
			match = true;
		} else if (ch.equals('[') & ch2.equals(']')) {
			match = true;
		}
		return match;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		MyStack<Character> s = new MyStack<Character>();
		BufferedReader br=null;
		try{
		br = new BufferedReader(new FileReader(args[0]));
		}
		catch(Exception e){
			System.out.println("Invalid Filename");
		}
		
		String line;
		boolean inCommentBlock = false;
		while ((line = br.readLine()) != null) {
			int i = 0;
			while (i < line.length()) {
				boolean inQuotes = false; 

				
				// if we are in comment block then keep moving till we encounter a '*/'
				if (inCommentBlock) {
					if(i < line.length()-1 && line.charAt(i) == '*' && line.charAt(i+1) == '/'){
						inCommentBlock = false;
						i++;
					}
						i++;
						continue;
				}

				// if " keep moving till end ". Finds before end of line
				if (i < line.length() && line.charAt(i) == '"') {
					inQuotes = true;
					i++;
					while (i < line.length() && inQuotes) {
						if (line.charAt(i) == '"') inQuotes = false;
						i++;
					}
					//if we have reached end of line before quotation block is closed then throw error
					if (inQuotes) {
						System.out.println("Unbalanced quotations");
						return;
					}
				}

				//checks to see if we have reached end of comment block. If yes set inCommentBlock to false
				if (i < line.length() && line.charAt(i) == '/') {
					i++;
					if (i < line.length() && line.charAt(i) == '*') {
						inCommentBlock = true;
						i++;
						continue;
					}

				}

				if (i >= line.length())	continue;
				Character ch = line.charAt(i);
				//if we encounter a starting symbol then we push it onto the stack
				if (ch.equals('{') || ch.equals('(') || ch.equals('[')) {
					s.push(ch);
				//if we encounter a closing symbol we pop stack and compare to see if they match
				} else if (ch.equals('}') || ch.equals(')') || ch.equals(']')) {
					if (s.isEmpty()) {
						System.out.println("Unbalanced! Symbol " + ch + " has no opening symbol");
						return;
					}
				// if they don't match we print an error
					Character ch_top = s.pop();
					if (!match(ch_top, ch)) {
						System.out.println("Unbalanced! Symbol " + ch_top + " is mismatched");
						return;
					}
				}
				i++;
			}
		}
		//still in comment block - error!!
		if(inCommentBlock) {
			System.out.println("Comment block not closed");
			return;
		}
		br.close();
		
		//check to see if stack is empty. if yes then there is an unlcosed symbol
		if (!s.isEmpty()) {
			System.out.println("Unbalanced! Symbol " + s.pop() + " has no closing symbol");
		} else {
			System.out.println("File is balanced");
		}
	}
}