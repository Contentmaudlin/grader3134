import java.io.*;


public class SymbolBalance<AnyType> 
{
	public static int stringLength = 0;
	public static StringBuilder testString = new StringBuilder();
	public static char[] charArray; 

	//a helper function defining Symbol rules
	// will return a matching closing bracket. 
	public static char rules(char close)
	{
		if(close == ')')
			return '(';
		else if(close == ']')
			return '[';
		else if(close == '}')
			return '{';
		else
			return '0';
	}

	public static void SymbolBalance(String myString)
	{
		MyStack<Character> myStack = new MyStack<>();
		MyStack<Character> quoteStack = new MyStack<>();
		MyStack<Character> commentStack = new MyStack<>();
		boolean quoted = false; 
		boolean commented = false;
		boolean allBalanced = true;

		for(int i = 0; i< myString.length(); i++)
		{
			char c = myString.charAt(i);
			if(c == '/')
			{
				boolean empty = commentStack.isEmpty();

				if(!empty)
				{
					char d = myString.charAt(i-1);	
					if(d == '*')				// checkes an element before to see if we closed a comment block.
					commentStack.pop(); 		// pops '/'
					commentStack.pop(); 		// pops '*'
					commented = false; 			// comment mode off
				}			
				else
				{
					commentStack.push(c); // pushes '/'
				}
			}
			else if(c == '*')
			{
				boolean empty = commentStack.isEmpty();
				if(empty)
				{
					System.out.println("that doesn't make sense. You can't close comment without opening it.");
					allBalanced = false;
				}
				else if(!empty)
				{
					char d = commentStack.peek();
					if(d == '/')
					{
						commentStack.push(c);
					}
				}
				commented = true; 				// comment mode on
			}
			else if(c == '"')
			{
				if(!commented)
				{
					if(!quoted)
					{
						quoteStack.push(c);
						quoted = true; 				// quote literal mode on
					}
					else if(quoted)
					{
						quoteStack.pop();
						quoted = false; 			// quote literal off
					}
				}
			}
			else if(!commented && !quoted)
			{
				if(c == '[' || c == '{' || c == '(')
				{
					myStack.push(c);
				}
				else if(c == ']' || c == '}' || c == ')')
				{
					if(myStack.isEmpty())
					{
						System.out.println("not balanced - you must balance '" + c + "'.");
						allBalanced = false;
					}
					else if(!myStack.isEmpty())
					{
						char open = myStack.pop(); 	// open is the corresponding opening bracket for c
						if (open != rules(c)) 		// if 'open' does not equal the required opening bracket
						{
							System.out.println("unbalanced! You must balance '" + c + "'.");
							allBalanced = false;
							return;
						}
					}
				}	
			}				
		}
	
		if(!myStack.isEmpty())
		{
			System.out.println("not balanced! You must deal with '" + myStack.peek() + "'.");
			allBalanced = false;
		}
		if(quoted)
		{
			System.out.println("Quotes not balanced");
			allBalanced = false;
		}

		if(commented)
		{
			System.out.println("comment block not closed");
			allBalanced = false;
		}
		if(allBalanced)
		{
			System.out.println("all's good.");
		}
	}

	public static String readFile(String args) throws IOException, FileNotFoundException
	{
		String line;
		BufferedReader br = new BufferedReader(new FileReader(args));
		try
		{
			while((line = br.readLine()) != null)
			{
				testString.append(line);
			}
		}
		catch(IOException ex) 
		{
			System.out.println("IO error. Try again.");
		}
		finally
		{
			br.close();
		}
		stringLength = testString.length();

		return testString.toString(); // change to actual String before returning.
	}


	public static void main(String[] args) throws IOException
	{

		String myString = ""; 

		if(args.length > 0)
		{
			myString = readFile(args[0]);
		}

		SymbolBalance(myString);
	}
}
