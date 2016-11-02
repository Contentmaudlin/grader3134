//*****************************************
//Arjun Mangla
//am4409
//Paul Blaer
// Data Structures
//Fall 2016
//Homework-2
//*****************************************

//importing relevant packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

//creating class
public class SymbolBalance {
	
	//Instance variable: An object of the data type "MyStack"
	//(Stack implementation for LinkedList)
	MyStack <Character> symbolStack = 
			new MyStack <Character> (new LinkedList <Character> ());
	
	//Method to check if symbols are balanced
	//The argument will be the name of the text file to be checked
	public String checkBalance(String input) throws IOException 
	{
		//calling method to read file and return string
		String fileText= readFile(input);
		char open = '!';
		boolean string = false;
		boolean comment = false;
	
		//For loop to iterate through the characters in fileText
		for (int i = 0; i < fileText.length(); i++) 
		{
			//creating variable for current, next character for cleaner code
			char c = fileText.charAt(i);
			char d = '!';
			if (i != fileText.length() - 1)
				d = fileText.charAt(i+1);
			
			//Check for start of comment using booleans
			if (c == '/' && d == '*' && !comment && !string) {  
				comment = true;
				System.out.println("Comment started");
				continue;
			}
			
			//Check for end of comment using booleans
			else if (c == '*' && d == '/' && comment && !string)  {
				comment = false;
				System.out.println("Comment stopped");
				continue;
			}
			
			//Check for start of string using booleans
			else if (c == '"' && !string && !comment) {
				string = true;
				System.out.println("String started");
				continue;
			}
			
			//Check for end of string using booleans
			else if (c == '"' && string && !comment) {
				string = false;
				System.out.println("String stopped");
				continue;
			}
			
			//If not in the middle of a comment or string,
			//we check for brackets, else we skip this block
			if (!comment && !string) 
			{

				//If its open bracket for any of the three,
				//pushing character to stack
				if (c == '{' || c == '(' || c == '[') {
					symbolStack.push(c);
					System.out.println("Pushing " + c);
					continue;
				}

				//If its closed bracket for any of the three,
				//enter this block
				else if (c == '}' || c == ')' || c == ']') 
				{
					//Checking if stack is empty because we
					//don't wanna pop an empty stack
					if (symbolStack.top() != null) {
						open = symbolStack.pop();
						System.out.println("Poping " + open);
					}
					else
						//Giving open a random value we will never push
						//because we can't use null for character
						open = '!';
					
					//If the closed and open brackets don't match
					//we return that the unbalanced symbol
					
					if ((c == '}' && open != '{')
						|| (c == ')' && open != '(')||(c == ']' && open != '['))
						return "Unbalanced! Symbol " + c + " is mismatched.";
					
					else if ((c != '}' && open == '{')||(c != ')' && open == '(') 
						|| (c != ']' && open == '['))
						return "Unbalanced! Symbol " + open + " is mismatched.";
				}
				
			}
			
		}
		
		//If the boolean string is still true, quotation marks are unbalanced
		if(string)
			return "Unbalanced! The quotation marks are mismatched.";
		
		//If the boolean comment is still true, comment
		//block boundaries are unbalanced
		else if(comment)
			return "Unbalanced! The comment indicators are mismatched.";
		
		//If the stack is not empty, there is an unbalanced open bracket
		else if (symbolStack.size != 0){
			return "Unbalanced! Symbol " + symbolStack.pop() + " is mismatched.";
		}
		
		//If it passes all these conditions, text
		//is balanced in terms of given symbols
		else
			return "Balanced! Hooray!";
	}
	
	//Method to read text file and return string
	public String readFile (String input) {
		
		String fileText = "";
		Scanner scan = null;
		
		//Reading text file using scanner
		try {
			scan = new Scanner(new File(input));
			fileText = scan.useDelimiter("\\A").next();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//closing scanner and returning String
		scan.close();
		return fileText;
	}
	
	//Main method that instantiates an object of type SymbolBalance and calls
	//the checkBalance with the argument taken directly from the command line
	public static void main (String [] args) {
		
		SymbolBalance sb = new SymbolBalance();
		try {
			System.out.println(sb.checkBalance(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}