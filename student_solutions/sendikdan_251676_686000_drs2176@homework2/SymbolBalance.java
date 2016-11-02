/*********************************************
 * author: Dan Sendik
 * Uni: drs2176
 * class: Data Strucures
 * HW submission: 2
 ********************************************/

package drs2176_HW2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SymbolBalance {
	public static void main(String[] args) throws IOException {
		readInFile(args);
	}
	static void readInFile(String[] args) throws IOException {
	String line;
	
	BufferedReader br = new BufferedReader(new FileReader
			//this is the filepath to the test file, will have to change it for running my code on other computers.
			("/Users/Dan/Documents/workspace/drs2176_HW2/Test.java")); 
	
	MyStack<Object> lineStack = new MyStack<Object>();
	while((line = br.readLine()) != null) {
				lineStack.checkParity(fileContents(line));
	} 
	br.close(); // closes bufferedReader
	
	// while loop that returns any unresolved pairings in the symbol stack
	while (!lineStack.symbolStack.isEmpty()) {
		System.out.println("Unbalanced! symbol " + lineStack.symbolStack.getLast() + " is missing");
		lineStack.symbolStack.remove();
	}
}
	static StringBuilder fileContents(String lineIn) {
		StringBuilder sbLine = new StringBuilder();
		sbLine.append(lineIn);
		return sbLine;
	}
}
