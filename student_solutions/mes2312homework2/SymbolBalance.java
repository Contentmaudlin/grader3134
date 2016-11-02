//************************************************************************************************
// Marco Starger
// mes2312
// SymbolBalance Class
//************************************************************************************************

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SymbolBalance {
	public static void main(String args[]) {
		
		try
		{
			//System.out.println(args[0]);
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			System.out.println(symbolBalanced(br));
			br.close();
		}
		
		catch (IOException e)
		{
			System.out.println("ERROR: IOException");
		}
		

	}
	
	
	private static boolean symbolBalanced(BufferedReader x) throws IOException {
		MyStack<Character> newStack = new MyStack<Character>();
		MyStack<Character> quoteStack = new MyStack<Character>();
		
		//ensures that you don't peek an empty stack
		newStack.push('0');
		quoteStack.push('0');
		
		String line;
		
		while ((line = x.readLine()) != null)
		{
		
			for (int i = 0; i < line.length(); i++)
			{
				char check = line.charAt(i);
				char checkNext = '0';
				if (i < line.length()-1)
				{
					checkNext = line.charAt(i+1);
				}
				
				//check for open comment blocks
				if (check == '/' && checkNext == '*' && newStack.peek() != '*')
				{
					newStack.push(check);
					newStack.push(checkNext);
				}
				
				//check for closed comment blocks
				else if (check == '*' && checkNext == '/' && newStack.peek() == '*')
				{
					//pop the '/*'
					newStack.pop();
					newStack.pop();
				}
				
				//check for ""
				else if (check == '"' && newStack.peek() != '*')
				{
					quoteStack.push(check);
				}
				
				else if (check == '"' && quoteStack.peek() == '"')
				{
					quoteStack.pop();
				}
				
				
				//check for { [ and ( brackets to make sure they are closed correctly
				else if ((check == '{' || check == '(' || check == '[') && newStack.peek() != '*')
				{
					newStack.push(check);
				}
			
				else if (check == '}' && newStack.peek() != '*')
				{
					if (newStack.pop() != '{')
					{
						System.out.println("Symbol } is mismatched");
						return false;
					}
				}
			
				else if (check == ')' && newStack.peek() != '*')
				{
					if (newStack.pop() != '(')
					{
						System.out.println("Symbol ) is mismatched");
						return false;
					}
				}
			
				else if (check == ']' && newStack.peek() != '*')
				{
					if (newStack.pop() != '[')
					{
						System.out.println("Symbol ] is mismatched");
						return false;
					}
				}
			}
			
			//checks to make sure that quotes are matched up on each line
			if (quoteStack.peek() != '0')
			{
				System.out.println("Symbol \" is mismatched");
				return false;
			}
		}
		
		if (newStack.peek() == '0')
		{
			return true;
		}
		else
		{
			System.out.println("Symbol " + newStack.peek() + " is mismatched");
			return false;
		}
	}
}

