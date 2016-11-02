/*********************************************
 * author: Dan Sendik
 * Uni: drs2176
 * class: Data Strucures
 * HW submission: 2
 ********************************************/

package drs2176_HW2;

import java.util.LinkedList;


public class MyStack<AnyType> {
	LinkedList<Character> fileList = new LinkedList<Character>();
	LinkedList<Character> symbolStack = new LinkedList<Character>();
	int quote = 0;
	
	public void checkParity(StringBuilder fileIn) {
		String comment = "";
		for (int i = 0; i < fileIn.length(); i++) {
			fileList.add(fileIn.charAt(i));	

			if (fileList.getLast().equals('/') || fileList.getLast().equals('*')) {
				comment += fileList.getLast();
			}	
			else if (comment.startsWith("/*")) {
				fileList.removeLast();
			}	
							
			else if (fileList.getLast().equals('{') || 
					fileList.getLast().equals('(') || 
					fileList.getLast().equals('[') ||
					fileList.getLast().equals('"') 
					)
			{
				symbolStack.add(fileList.getLast());
			} 

			if (fileList.getLast().equals('"')) {
				if (matchesLastQuote(symbolStack, quote)) {
					System.out.println("Unbalance, Symbol \" is missing.");
					symbolStack.removeLast();
				}
			}
			/* The three if blocks below checks to see if the last element added to fileList was a
			 * a closing symbol. Then, if it was and the stack is empty, that means there was never
			 * a corresponding opening symbol added to the stack. If the stack is not empty, it calls
			 * the compareWithX method, which removes and returns the last element in the stack. If this
			 * last element in the stack is NOT the corresponding opening symbol, then it is imbalanced.
			 */
			if (fileList.getLast().equals('}'))
				if (symbolStack.isEmpty()) {
					System.out.println("Unbalance, Symbol { is missing.");
				} else if (matchesLastCurly(symbolStack,fileList))
					System.out.println("Unblanace, symbol { is missing.");

			if (fileList.getLast().equals(')'))
				if (symbolStack.isEmpty()) {
					System.out.println("Unbalance, Symbol ( is missing.");
				} else if (matchesLastParenth(symbolStack,fileList))
					System.out.println("Unblanace, symbol ( is missing.");

			if (fileList.getLast().equals(']'))
				if (symbolStack.isEmpty()) {
					System.out.println("Unbalance, Symbol [ is missing.");
				} else if (matchesLastBracket(symbolStack,fileList))
					System.out.println("Unblanace, symbol [ is missing.");
		}

	}

/* I created the following four methods (matchesLastX) to simplify the code above and compartmentalize
 *  the check parity methods above. */
	
	/* when quote symbol is found, it is added to quoteCount, if quoteCount is divisible by two, 
	 * meaning it is a pair, this will return true. there will be a quote match.
	 */
	public boolean matchesLastQuote(LinkedList<Character> symbolStack, int quoteCount) {
		quoteCount++;
			if (quoteCount % 2 == 0) {
				symbolStack.remove();
				symbolStack.remove();
			return true;
			}
			else
			return false;
	}
	
	/* for the next three methods: if symbol is found, this method is called, it simultaneously 
	 * checks if there is a symbol match and removes the symbol from the stack.
	 */
	public boolean matchesLastCurly(LinkedList<Character> symbolStack, 
			LinkedList<Character> fileList) {
		if (symbolStack.removeLast().equals('{'))
			return false;
		else
			return true;
	}
	
	public boolean matchesLastParenth(LinkedList<Character> symbolStack, 
			LinkedList<Character> fileList) {
		if (symbolStack.removeLast().equals('('))
			return false;
		else
			return true;
	}
	
	public boolean matchesLastBracket(LinkedList<Character> symbolStack, 
			LinkedList<Character> fileList) {
		if (symbolStack.removeLast().equals('['))
			return false;
		else
			return true;
	}

	}
