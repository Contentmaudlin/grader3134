import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A program that checks and displays symbol balance.
 * @author Sharon Chen syc2138
 * @since 10/1/16
 */
public class SymbolBalance
{
	public static void main(String[] args)
	{
		String filename = args[0];
		System.out.println(filename);
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			MyStack<Character> characters = new MyStack<>();
			int character = br.read();
			boolean foundMismatch = false;

			while (character != -1 && !foundMismatch) // loop, no mismatch yet
			{
				System.out.print((char) character);
				boolean gottenCharacter = false; // tracks next loop char presence
				
				if ((char) character == '{' || (char) character == '('
						|| (char) character == '[')
				{
					characters.push((char) character); // push open char to stack
					System.out.println(characters);
				}
				else if ((char) character == '\"') // the start of a string
				{
					while ((character = br.read()) != -1 &&
							(char) character != '\"')
					{
						System.out.print((char) character);
					}
					if (character == -1) // code has string that doesn't close
					{
						System.out.println("\nUnbalanced! Symbol \" is mismatched.");
						foundMismatch = true;
					}
				}
				else if ((char) character == '/')
				{
					if ((char) (character = br.read()) == '*')
					{
						System.out.print((char) character); // prints an asterisk
						boolean endComment = false;
						while ((character = br.read()) != -1 && endComment == false)
						{
							System.out.print((char) character); // text in comment

							if ((char) character == '*')
							{
								if ((character = br.read()) != -1
										&& (char) character == '/')
								{
									System.out.print((char) character); //end of comment
									character = br.read(); // first char outside comment
									endComment = true;
								}
							}
						}
						if (endComment == false)
						{
							System.out.println("\nUnbalanced! "
									+ "Symbol /* is mismatched.");
							foundMismatch = true;
						}
					}
					gottenCharacter = true;
				}
				else if ((char) character == '}')
				{
					Character top = characters.pop();
					if (top == null || (char) top != '{')
					{
						System.out.println(characters);
						System.out.println("\nUnbalanced! Symbol } is mismatched.");
						foundMismatch = true;
					}
				}
				else if ((char) character == ')' && (char) characters.pop() != '(')
				{
					Character top = characters.pop();
					if (top == null || (char) top != '(')
					{
						System.out.println(characters);
						System.out.println("\nUnbalanced! Symbol ) is mismatched.");
						foundMismatch = true;
					}
				}
				else if ((char) character == ']' && (char) characters.pop() != '[')
				{
					Character top = characters.pop();
					if (top == null || (char) top != '[')
					{
						System.out.println(characters);
						System.out.println("\nUnbalanced! Symbol ] is mismatched.");
						foundMismatch = true;
					}
				}
				else if ((char) character == '*')
				{
					if ((character = br.read()) != -1 && (char) character == '/')
					{
						System.out.println("\nUnbalanced! Symbol */ is mismatched.");
						foundMismatch = true;
					}
					gottenCharacter = true;
				}
				
				// now, if the next character has to be read...
				if (!gottenCharacter)
				{
					character = br.read();
				}
			}
			if (!foundMismatch)
			{
				System.out.println(characters);
				if (characters.size() > 0) // more open than closed symbols
				{
					System.out.println("\nUnbalanced! Symbol " +
							characters.pop() + " is mismatched.");
				}
				else // reached end without finding mismatch
				{
					System.out.println("Balanced! Yay for success!");	
				}
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
