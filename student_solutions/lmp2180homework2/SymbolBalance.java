/*
      Loie Plautz
      lmp2180
      Homework 2
*/
import java.util.Scanner; 
import java.io.File; 
import java.io.FileNotFoundException;
//importing these allows me to work with reading files

public class SymbolBalance
{
	private File file;

	public SymbolBalance(String fileName)
	{
		file = new File(fileName);
	}

	public char[] characterArray () throws FileNotFoundException
	{
		//this method turns the entire file into a string
		//then the string is broken into an array of characters
		//so each symbol can be analyzed 
		Scanner in = new Scanner(file);
		char charArray[];
		String charString = ""; 
		while(in.hasNext())
		{
			charString = charString + in.next(); 
		}
		charArray = charString.toCharArray();
		return charArray;
	}

	public String checkFile() throws FileNotFoundException
	{
		char[] chars = characterArray();
		MyStack<Character> stack = new MyStack<Character>();
		//this stack will hold the symbols others than /* */ and ""
		char symbol = ' '; 
		//this will hold symbols that are popped off the stack
		boolean comment = false;
		boolean literal = false;
		//these two booleans keep track of when a comment or quote is opened
		for(int n = 0; n<chars.length; n++)
		{
			if(chars[n]=='/' && chars[n+1]=='*' && comment == false 
					&& literal == false)
			{
				comment = true; //this is the start of a comment
			}
			else if(chars[n]=='*' && chars[n+1]=='/' && literal == false)
			{
				if(comment==true)
				{
					comment = false; 
			//this is the end of a comment if there was a starting symbol
				}
				else
				{
//if the closing appears without an opening, the file is unbalanced
					return "Unbalanced! Closing symbol without opening: */";
				}
			}
			else if(chars[n]=='"' && literal == false && comment == false)
			{
				literal=true;
				//a quote is started
			}
			else if(chars[n]=='"' && literal == true && comment == false)
			{
				literal = false;
				//if a quote has started and another quote is reached
				//the quote is ended
			}
			else if(chars[n]=='{' && comment == false && literal == false)
			{
				stack.push('{');
				//starting symbols are held in the stack
			}
			else if(chars[n]=='}' && comment == false && literal == false)
			{
				if(stack.isEmpty())
				{
					//if a closing symbol appears and there is no opening
					//an error message is generated
					return "Unbalanced! Closing symbol without opening: }";
				}
				else
				{
					//if there is an opening symbol, it is popped off
					//and checked to see if it is a match
					symbol = stack.pop();
					if (symbol == '[') 
					{
						return "Unbalanced! Mismatched symbols: [}";
					}
					else if(symbol == '(')
					{
						return "Unbalanced! Mismatched symbols: (}";
					}
				}	
			}
			//the process is repeated for the other symbols
			else if(chars[n]=='[' && comment == false && literal == false)
			{
				stack.push('[');
			}
			else if(chars[n]==']' && comment == false && literal == false)
			{
				if(stack.isEmpty())
				{
					return "Unbalanced! Closing symbol without opening: ]";
				}
				else
				{
					symbol = stack.pop();
					if (symbol == '{') 
					{
						return "Unbalanced! Mismatched symbols: {]";
					}
					else if(symbol == '(')
					{
						return "Unbalanced! Mismatched symbols: (]";
					}
				}
			}
			else if(chars[n]=='(' && comment==false && literal==false)
			{
				stack.push('(');
			}
			else if(chars[n]==')' && comment==false && literal==false)
			{
				if(stack.isEmpty())
				{
					return "Unbalanced! Closing symbol without opening: )";
				}
				else
				{
					symbol = stack.pop();
					if (symbol == '[') 
					{
						return "Unbalanced! Mismatched symbols: [)";
					}
					else if(symbol == '{')
					{
						return "Unbalanced! Mismatched symbols: {)";
					}
				}
			}
		}
//if every symbol has been popped off, matches
//and there is no unclosed comments or strings, 
//then and only then is the file completely balanced 
		if(stack.isEmpty() && comment == false && literal == false)
		{
			return "The file is symbolically balanced";
		}
		else if(comment==true)
		{
			//if comment is true at the end, there's an unclosed comment
			return "Ubalanced! Opening symbol without closing: /*";
		}
		else if(literal==true)
		{
			//if literal is true at the end, there's an unclosed string
			return "Unbalanced! Opening symbol without closing: \" ";
		}
		else if(stack.isEmpty()==false)
			while(stack.isEmpty()==false)
			{
				symbol = stack.pop(); //all the remaining symbols are popped
				//in order to get the first opening symbol without closing
			}
			if(symbol == '{')
			{
				return "Unbalanced! Opening symbol without closing: {";
			}
			else if(symbol == '[')
			{
				return "Unbalanced! Opening symbol without closing: [";
			}
			else if(symbol == '(')
			{
				return "Unbalanced! Opening symbol without closing: (";
			}
		return "Finished Checking"; 
		//just in case none of the coniditions are met
	}
	public static void main(String[] args) throws FileNotFoundException{
		if(args.length==0) 
//allows user to input a file if they forget to put it in the commandline 
		{
			System.out.println("Please enter a filename: ");
			Scanner input = new Scanner(System.in);
			String testFile = input.next();
			SymbolBalance test = new SymbolBalance(testFile);
			System.out.println(test.checkFile());
		}
		else //otherwise, the file is checked and result printed
		{
			SymbolBalance test = new SymbolBalance(args[0]);
			System.out.println(test.checkFile());
		}
	}
	
}