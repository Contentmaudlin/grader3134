import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SymbolBalance 
{
	// static variables 
	private static MyStack<Character> mystack;
	private static boolean isBalance;
	private static boolean isComment;
	private static boolean isString;


	public static void main(String[] args) 
	{

		// initiate variables 
		mystack = new MyStack<Character>();
		isBalance = true;
		isComment = false;
		isString = false;
		BufferedReader br;

		try
		{
			// open file
			br = new BufferedReader(new FileReader(args[0]));

			// check error in file and print message afterwards
			checkFile(br);
			printError();

			// close file
			br.close();
		}
		catch(Exception e)
		{
			// Can't open file with given name
			System.out.println("Can't open file.");
		}
	}


	private static void checkFile(BufferedReader br) throws IOException
	{
		// check the file line by line

		String line;
		while((line = br.readLine()) != null) 
		{
			// check given line
			checkLine(line);

			// check if string spans multiple lines
			if(isString)
			{
				isBalance = false;
				System.out.println("Symbol \" has no closing symbol.");
				break;
			}
		}
	}


	private static void printError()
	{
		// print out error after checking

		// comment block without */ ending
		if (isComment && isBalance)
		{
			isBalance = false;
			System.out.println("Symbol /* has no closing symbol.");
		}


		// extra symbols remaning
		if (!mystack.isEmpty() && isBalance)
		{
			char a = mystack.pop();
			System.out.println("Symbol " + a + " has no closing symbol.");
			isBalance = false;
		}
			
		// file is balance
		if (isBalance)
		{
			System.out.println("Balance.");
		}
	}
	

	private static void checkLine(String line)
	{
		// check a given line character by character

		int i = 0;
		while (i < line.length() && isBalance)
		{
			// get current characer
			char a = line.charAt(i);

			if (isString)
			{
				// check for string ending
				isString = checkString(a);
			}
			else if (isComment)
			{
				// check for block comment ending
				isComment = checkCloseComment(line, i);
				if (!isComment)
				{
					i += 1;
				}
			}
			else if(!isComment && !isString)
			{
				// check in line // comment
				if (checkInLineComment(line, i))
					break;

				// check all possible symbols
				checkSymbol(line, i);
				if(isComment)
					i += 1;
			}

			// advance to next character
			i++;
		}
	}



	private static void checkSymbol(String line, int index)
	{
		// get current symbol
		char a = line.charAt(index);

		if (a == '{' || a == '(' || a == '[')
		{
			// push open symbol to stack
			mystack.push(a);
		}
		else if (a == '}' || a == ')' || a == ']')
		{
			// pop stack when seeing close symbol
			isBalance = checkCloseSymbol(a);
		}
		else if (a == '/')
		{
			// check if next is comment block
			isComment = checkOpenComment(line, index);
		}
		else if (a == '*')
		{
			// check if close comment block
			isBalance = checkCloseComment(line, index);
			if(!isBalance)
			{
				System.out.println("Symbol */ has no opening symbol.");
			}
		}
		else if (a == '\"')
		{
			// check if a string starts
			isString = true;
		}
	}
	

	private static boolean checkCloseSymbol(char a)
	{
		// close symbol 1
		if (a == '}')
		{
			if (mystack.isEmpty())
			{
				System.out.println("Symbol } has no opening symbol.");
				return false;
			}
			if (mystack.pop() != '{')
			{
				System.out.println("Symbol } is mismatched with opening.");
				return false;
			}
		}

		// close symbol 2
		if (a == ')')
		{
			if (mystack.isEmpty())
			{
				System.out.println("Symbol ) has no opening symbol.");
				return false;
			}

			if (mystack.pop() != '(')
			{
				System.out.println("Symbol ) is mismatched with opening.");
				return false;
			}
		}

		// close symbol 3 
		if (a == ']')
		{
			if (mystack.isEmpty())
			{
				System.out.println("Symbol ] has no opening symbol.");
				return false;
			}

			if (mystack.pop() != '[')
			{
				System.out.println("Symbol ] is mismatched with opening.");
				return false;
			}
		}

		// otherwise return true
		return true;
	}


	private static boolean checkString(char current)
	{
		// check if current char is ""
		if (current == '\"')
			return false;
		else
			return true;
	}


	private static boolean checkOpenComment(String line, int index)
	{
		// check if current char starts comment block
		char current = line.charAt(index);
		if (current == '/')
		{
			if (index < line.length()-1)
			{
				if(line.charAt(index+1) == '*')
				{
					return true;					
				}
			}
		}
		return false;
	}


	private static boolean checkInLineComment(String line, int index)
	{
		// check if current char starts in line comment
		char current = line.charAt(index);
		if (current == '/')
		{
			if (index < line.length()-1)
			{
				if(line.charAt(index+1) == '/')
				{
					return true;					
				}
			}
		}
		return false;
	}


	private static boolean checkCloseComment(String line, int index)
	{
		// check if current char closes comment block
		char current = line.charAt(index);
		if (current == '*')
		{
			if (index < line.length()-1)
			{
				if(line.charAt(index+1) == '/')
				{
					return false;
				}
			}
		}
		return true;
	}
}