/*
 * Name: Pranav Arora
 * UNI: pa2450
 * Description: It takes in a files are command line arguments and checks
 * if the symbols like {, [, (, " are balanced. 
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SymbolBalance {
	
	public static void main(String[] args) throws IOException{
		
		MyStack<Character> symbol = new MyStack<Character>();
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String file = "";
		String line;
		
		// making the file in a string, which can be iterated through
		while((line = br.readLine()) != null) {
			file = file + line;
		}
		
		br.close();

		
		// iterating through the file
		for (int i = 0; i < file.length(); i++) {
			char c = file.charAt(i);
			
			// pushing opening symbols onto the stack
			if (c == '(' || c == '{' || c == '['){
				symbol.push(c);
			}
			
			// if closing symbol is encountered 
			else if (c == ')' || c == '}' || c == ']'){
				
				
				if (symbol.size() == 0){
					System.out.println("Closing symbol without opening "
					+ "symbol: \n" + c);
				}
				
				// the last element in the stack must be equal to new closing
				// symbol encountered
				else {
					char check = symbol.pop();
					
					// using ascii value difference to identify the similarity
					// between symbols
					if (Math.abs(c - check) > 2){
						
						System.out.print("There seems to be a mismatch: " +
						check + " and "  + c);
						return;
					}
				}
			}
				
			// to ignore stuff inside quotation marks and check for balance
			else if (c == '\"'){
				
				if (i == file.length() - 1){
					System.out.println("Quotation marks (\") started but"
							+ " not ended");
					return;
				}
				
				i++;
				
				// iterating through the stuff inside quotation marks
				while (file.charAt(i) != '\"'){
					i++;
					// System.out.println(file.length());
					
					if (i >= file.length()){
						System.out.println("Quotation marks (\") started but"
								+ " not ended");
						return;
					}
				}
			}
			
			if (i + 1 < file.length()){
				
				// to ignore stuff inside comment blocks
				if (c == '/' && file.charAt(i+1) == '*'){
					
					i=i+2;
					
					if (i == file.length()){
						System.out.println("File has ended but comment block"
								+ "did not finish");
						return;
					}
					
					// iterating through the stuff inside comment blocks
					while (!(file.charAt(i) == '*' && file.charAt(i+1) == '/')){
						i++;
					}
				}
			}
		}
		
		// if stack is not empty by the end of the loop, there are opening 
		// symbols inside it
		if (symbol.size() != 0){
			System.out.println("There are more opening symbol(s):");
			
			// printing remaining opening symbols
			while (symbol.size() != 0){
				System.out.println(symbol.pop() + " ");
			}
		}
	}
}
