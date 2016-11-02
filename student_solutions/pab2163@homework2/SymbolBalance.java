/* Paul Bloom
* pab2163
* Symbol Balance Class reads in a java file from the command line, and checks
* to make sure that all [], {}, (), "", and block comments are balanced. 
* 
*/



import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



public class SymbolBalance {

	/*Main method -- takes command line argument as file name to check
	*throws exception if can't find the file */
	public static void main (String [] args)  throws FileNotFoundException, IOException{

		try{
			File myFile = new File(args[0]);
			FileReader reader = new FileReader(myFile);
			// BufferedReader buffer = new BufferedReader(reader);
			BufferedReader br = new BufferedReader(new FileReader(myFile)); 
			/*I looked up some information on how to read a file character 
			*by character on stack overflow and got a crucial bit of code from 
			*here: 
			http://stackoverflow.com/questions/811851/how-do-i-read-input-character-by-character-in-java
			*/



			// instance variables, including the MyStack object
			int value = 0;
			MyStack <Character> open = new MyStack<Character>();
			boolean balanced = true;
			boolean comment = false;
			boolean quote = false;
			char mistake = 'a';
			char save = '\0'; // save is the previous character that was read
			// when checking for block comments


			/* while no errors have been detected yet,
			* iterate through every character in the file */
			while ((value = br.read()) != -1 & balanced){

				char c = (char) value; // character being checked currently
				

				/* this chunk of code is for checking for comments. if
				* a comment is started, then the comment boolean is flipped to 
				* 'true' no symbols will be checked for other than closing the 
				*comment. If a comment is ended, te comment boolean is flipped 
				* to 'false' and the program will start checking again. */
				if(save == '/' & c == '*'){
					comment = true;
					System.out.println("COMMENT ON");
				}

				if(save == '*' & c == '/'){
					comment = false;
					System.out.println("COMMENT OFF");
				}
				save = c;


				/* this chunk of code is for checking quotes. If a quote is 
				* the current character, and the top of the stack isn't already 
				* a quote, it is added to the stack. If a quote is found and the
				* top of the stack is a quote, the stack is popped */
				if(!comment & c == '"' & !open.isEmpty()){
					if(c != open.peek()){
						open.push(c);
						System.out.println("QUOTE ON");
					}
					else{
						open.pop();
						System.out.println("QUOTE OFF");
					}
				}
				else if(!comment & c == '"' & open.isEmpty()){
					open.push(c);
					System.out.println("QUOTE ON");
				}



				/* this chunk is for checking the three type of brackets, and is
				* only run if currently not in a comment. This code is also only
				* run if either a) the stack is empty or b) the top of the stack
				* is not a quote (meaning that the characters being read are
				* part of a quote). This chunk pushes all opening brackets,
				* and pops them when their matching closing bracket is checked.
				* The iteration across the file
				* is ended if an incorrect match shows up between a 
				* closing bracket and the previous opening bracket. */
				if(!comment){
					if(open.isEmpty()){ // brackets is stack is empty
						if(c == '(' || c == '[' || c == '{') {
							open.push(c);
							System.out.println("OPEN" + c);
						}
						else if(c == ')' || c == ']' || c == '}'){	
							balanced = false;
							mistake = c;
						}			
					}
					else if(open.peek() != '"'){ 
						if(c == '(' || c == '[' || c == '{') {
							open.push(c);
							System.out.println("OPEN" + c);
						}
						else if(c == ')' || c == ']' || c == '}'){
							System.out.println("CLOSE" + c);
							// if(open.isEmpty()){
							// 	balanced = false;
							// 	mistake = c;
							// }
							System.out.println("PEEK" + open.peek());
							if(c == ')'){
								if(open.pop() != '('){	
									balanced = false;
									mistake = c;
								}
							}
							else if(c == '}'){
								if(open.pop() != '{'){	
									balanced = false;
									mistake = c;
								}
							}
							else if(c == ']'){
								if(open.pop() != '['){	
									balanced = false;
									mistake = c;
								}
							}				
						}
					}
				}
			}

			br.close(); // stop parsing the file

			/* if the stack is not empty, or if the file has been entirely 
			* parsed and is still in the middle of a quote or comment,
			* then it is not balanced */
			if(!open.isEmpty() & balanced)
			{
				balanced = false;
				mistake = open.pop();
			}
			else if(quote){
				balanced = false;
				mistake = '"';
			}
			else if(comment){
				balanced = false;
				mistake = '*';
			}

			// print the output
			if(balanced){
				System.out.println("Your file is balanced! Good for you!");
			}
			else{
				System.out.println("Shame on you! Symbol " + mistake + 
					" is unbalanced!");
			}
		}

		// exception handling here
		catch(FileNotFoundException e)
		{
			System.out.println("File not found! Make sure file" + 
				" name is entered correctly");
		}
		catch(IOException e)
		{
			System.out.println("File not found!");
		}
	}

}