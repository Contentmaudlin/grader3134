//Joshua Learn
//SymbolBalance.java
import java.io.BufferedReader;
import java.io.FileReader;
public class SymbolBalance {
	//These are strings we will use to help us find the symbols we are looking for
	private static final String openers = "({[";
	private static final String closers = ")]}";

	//method hard coded to check if two given symbols complete eachother
	private static boolean isValidMatch(char a, char b){
		if (a=='(' && b==')' || a=='{' && b=='}' || a=='[' && b==']' || a=='"' && b=='"' ) {
			return true;
		}
		else{
			return false;
		}
	}
	//main method
	public static final void main(String[] args) throws Exception {

		//Read in the filename and instantiate the filereader
		String filename = args[0];
		BufferedReader br = new BufferedReader(new FileReader(filename));

		//a bunch of helpers we will use in our code
		MyStack stack = new MyStack<Character>();
		String line = br.readLine();
		char[] array;
		char previousChar = '0';
		boolean keepGoing = true;
		char c;
		boolean skip = false;
		int iter;
		boolean isError = false;

		//keep looping until we hit an error or run out of code to look at
		while(line!=null && keepGoing){
			//pick one line of code and turn it into an array of characters
			array = line.toCharArray();
			iter = 0;
			//parse through every character in the array
			while(iter < array.length){

				//we will call our current character c
				c = array[iter];

				//if we are currently in the middle of a comment block and we found the end, then tell the program that the comment block is over
				if (skip && previousChar=='*'&&c=='/') {
					skip=false;
				}

				//if we arent inside a comment block, then go through the algorithm
				if (!skip) {

					//if we found an opening bracket of some sort, push it on the stack					
					if ( openers.contains( Character.toString(c) ) ) {
						stack.push(c);
					}

					//if we found a closing bracket of some sort, we have to make sure it matches the top of the stack or else we have an error
					else if ( closers.contains( Character.toString(c) ) ) {
						//if we found a closing bracket and the stack is empty, then we have a mismatch
						if (stack.isEmpty()) {
							System.out.println("Error: "+Character.toString(c)+ " does not match.");
							isError=true;
							keepGoing=false;
							break;
						}
						else if (isValidMatch((char)stack.peek(), c)) {
							stack.pop();		
						}
						else{
							System.out.println("Error: "+Character.toString(c)+ " does not match.");
							isError=true;
							keepGoing = false;
							break;
						}
					}

					//if we find a comment block this tells the program to start skipping code until it finds the closing comment block
					else if ( previousChar=='/' && c=='*') {
						skip = true;
					}

					//Handles the case for parens without the stack (no reason to use the stack for this snippet)
					else if ( c=='"' ){
						//if we find a paren then we keep going through the line of text until we find the closing quote
						iter++;
						while(iter<array.length && array[iter]!='"'){
							iter++;
						}

						//if we got to the end of the line and the quotes never closed then we know we have an error
						if (iter>array.length-1) {
							System.out.println("Error: nonclosing quotes.");
							isError = true;
							keepGoing = false;
							break;
						}
					
					}

				}


				//keep track of the previous character to help us with the issue of comment blocks
				previousChar = c;
				//increment the counter
				iter++;

			}
			line = br.readLine();
		}
		//if we havent caught any errors yet, then we check for a few final conditions
		if (!isError) {
			
			//if we still have things in the stack then we didnt close all of our brackets
			if (stack.size() > 0) {
				System.out.println("Error: "+Character.toString((char)stack.peek())+" was never closed!");
				isError = true;
			}
			//if skip is still true then we know we never ended a comment block
			else if (skip) {
				System.out.println("Error: Comment block was never closed!");
				isError = true;
			}
			//otherwise there really is no error :)
			else{
				System.out.println("No error found :)");
			}

		}
		
	}
}