/*
 * Angela Zhang
 * amz2132
 * COMS 3134 Data Structures
 * SymbolBalance class for Homework 2
 * This class checks to see if all special symbols specified in the homework instructions are properly balanced. This
 * class uses an exception class UnbalancedSymbolException that is included in the zip file.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SymbolBalance <AnyType> extends MyStack<AnyType>
{
	//String that the inputed file will be scanned into
	String text="";
	
	public SymbolBalance(String fileName) throws FileNotFoundException, IOException
	{
		//read in a file into a string
		File inputFile = new File(fileName);
		Scanner in = new Scanner(inputFile);
		while (in.hasNextLine())
		{
			text+=in.nextLine();//read the entire file into a string
		}
		in.close();
	}
	

	public boolean scan(String x)
	{
		MyStack<Character> stack = new MyStack<Character>();
		
		//read every character in the file (converted to a string)
		for (int i=0; i<x.length();i++)
		{
			Character c= x.charAt(i);
			//if the character is an opening brace, it is pushed to the stack
			if (c=='{' || c=='(' || c=='[')
			{
				stack.push(c);
			}
			//if the character is a quotation mark, then search for the closing quotation mark and ignore all symbols
			//between the two quotation marks. if a 2nd quotation mark is not found, then the first one is unbalanced
			//and the exception occurs
			else if (c=='\"')
			{
				boolean found=false;
				for (int k=i+1; k<x.length(); k++)
				{
					if (x.charAt(k)=='\"')
					{
						i=k;
						found = true;
						break;
					}
				}
				if (!found)
				{
					System.out.println("Unbalanced! Symbol \" is unbalanced");
					return false;
				}
				
				
			}
			
			//if the character marks the beginning of a comment block, then search for the closing comment block
			//symbol and ignore all symbols between the /* and */. If the */ is not found, then the first one is
			//unbalanced and the exception occurs
			else if (c=='/' && x.charAt(i+1)=='*')
			{
				boolean found=false;
				for (int k=i+2; k<x.length()-2; k++)
				{
					if (x.charAt(k)=='*'&&x.charAt(k+1)=='/')
					{
						i=k+1;
						found=true;
						break;
						//if the closing symbol is found, then change the index i to the location of the closing brace
						//so when it is incremented by one in the beginning for loop the file is being scanned at
						//the end of the comment block
					}
				}
				if (!found)
				{
					System.out.println("Unbalanced! Symbol /* is unbalanced");
					return false;
				}
			}
			
			//If the character is a closing brace, then search for the corresponding opening brace in the top of the
			//stack. If it is not found, then return an error.
			else if (c=='}' || c==')' || c==']')
			{
				if (c=='}')
				{
					//if stack.pop() does not work, then that means the stack is empty and that the closing brace is
					//mismatched. If it does work and the symbols don't match, then the first mismatched symbol is 
					//the opening brace on the top of the stack.
					try
					{
						if (stack.top()=='{')
						{
							stack.pop();
						}
						else
						{
							System.out.println("Unbalanced! Symbol "+ stack.top() + " is unbalanced");
							return false;
						}
					}
					catch(UnbalancedSymbolException e)
					{
						System.out.println("Unbalanced! Symbol " + c + " is unbalanced");
						return false;
					}
				}
				
				else if (c==')')
				{
					//same logic as try statement above
					try
					{
						if (stack.top()=='(')
						{
							stack.pop();
						}
						else
						{
							System.out.println("Unbalanced! Symbol "+ stack.top() + " is unbalanced");
							return false;
						}
					}
					catch(UnbalancedSymbolException e)
					{
						System.out.println("Unbalanced! Symbol " + c + " is unbalanced");
						return false;
					}
				}
				
				else if (c==']')
				{
					//same logic as try statement above
					try
					{
						if (stack.top()=='[')
						{
							stack.pop();
						}
						else
						{
							System.out.println("Unbalanced! Symbol "+ stack.top() + " is unbalanced");
							return false;
						}
					}
					catch(UnbalancedSymbolException e)
					{
						System.out.println("Unbalanced! Symbol " + c + " is unbalanced");
						return false;
					}
				}
				}
			}

			//if the stack is not empty at the end, then the symbol at the top of the stack is unbalanced
			if(!stack.isEmpty())
			{
				System.out.println("Unbalanced! Symbol " + stack.top() + " is unbalanced");
			}
				
			return stack.isEmpty();
	}
	
	
	public static void main (String[] args)
	{
		//if the user inputs a file name
		if (args.length>0)
		{
			try
			{
				@SuppressWarnings("rawtypes")//the warnings were annoying me so I suppressed them :)
				SymbolBalance<?> a = new SymbolBalance(args[0]);
				
				//if the stack is empty
				if (a.scan(a.text))
				{
					System.out.println("All symbols are balanced!");
				}
			}
			catch(FileNotFoundException e)
			{
				System.out.println(e);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		//if there is no file name specified
		else
		{
			System.out.println("Please provide the file name in the command line");
		}

	}
	
}
