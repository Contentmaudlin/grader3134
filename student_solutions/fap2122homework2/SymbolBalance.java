//Fernando A. Pascual
//fap2122
//Data Structures Homework 2

import java.io.*;
import java.util.Scanner;

public class SymbolBalance
{
	public static void main(String[] args) throws FileNotFoundException
	{

			boolean mismatch = false; //will be true when there is a mismatch
			boolean ignore = false; //for ignoring block comments
			boolean quote = false; //for double quotes
			boolean sQuote = false; //for single quotes
			String line;
			MyStack<Character> stack = new MyStack<>();
			File inFile = new File(args[0]); //reading file in as a file object
			Scanner input = new Scanner(inFile); //using scanner to read line by line

			while(input.hasNext())
			{  
				line = input.nextLine();
				System.out.println(line); //delete this

				for (int i = 0; i < line.length(); i++)
				{
					//case for single line comments
					if (i < line.length()-1)
						if (line.charAt(i) == '/' && line.charAt(i+1) == '/')
							break;

					else if (line.charAt(i) == '\"')
					{
						if (quote)
						{
							if (stack.peek() == '\"')
							{
								System.out.println("popping " + line.charAt(i)); //delete this

								System.out.println(stack.pop());			
								quote = false;	
							}
							else
							{
								System.out.println("Symbol '\"' is mismatched");
								mismatch = true;
							}		
							
						}
						else
						{
							stack.push(line.charAt(i));
							System.out.println("pushing " + line.charAt(i)); //delete this
							quote = true;	
						}
						
					}

					else if (line.charAt(i) == '\'')
					{
						if (sQuote)
						{
							if (stack.peek() == '\'')
							{
								System.out.println("popping " + line.charAt(i)); //delete this

								System.out.println(stack.pop());			
								sQuote = false;	
							}
							else
							{
								System.out.println("Symbol '\'' is mismatched");
								mismatch = true;
							}		
							
						}
						else
						{
							stack.push(line.charAt(i));
							System.out.println("pushing " + line.charAt(i)); //delete this
							sQuote = true;	
						}
						
					}
					//case for single characters	
					else if (line.charAt(i) == '{' || 
						line.charAt(i) == '[' ||
						line.charAt(i) == '(')
					{
						if (quote || sQuote)
						{
							System.out.println("quote break");
						}
						else
						{
							stack.push(line.charAt(i));
							System.out.println("pushing " + line.charAt(i)); //delete this
						}
					}
					//case for multicharacters (block comments)
					else if (line.charAt(i) == '*')
					{
						if (line.charAt(i-1) == '/')
						{
							stack.push(line.charAt(i));
							ignore = true;
							System.out.println("pushing " + line.charAt(i)); //delete this
						}
						
					}			

					//checking the end symbols
					else
					{
						if (line.charAt(i) == '/')
						{
							if (line.charAt(i-1) == '*')
								if (stack.peek() == '/')
								{
									stack.pop();
									ignore = false;
								}
								else
								{
									System.out.println("Symbol '*/' is mismatched");
									mismatch = true;
								}	
						}

						//will break out of else if the symbol is in a block comment or quote
						else if (ignore)
						{
							ignore = false;
							break;
						}

						else if (line.charAt(i) == '}')
						{
							if (stack.peek() == '{')
							{
								System.out.println("popping " + line.charAt(i)); //delete this

								System.out.println(stack.pop());				
							}
							else
							{
								System.out.println("Symbol '}' is mismatched");
								mismatch = true;
							}
						}

						else if (line.charAt(i) == ']')
						{
							if (stack.peek() == '[')
							{
								System.out.println("popping " + line.charAt(i)); //delete this
								System.out.println(stack.pop());
							}
							else
							{
								System.out.println("Symbol ']' is mismatched");
								mismatch = true;
							}
						}

						else if (line.charAt(i) == ')')
						{
							if (stack.peek() == '(')
							{
								System.out.println("popping " + line.charAt(i)); //delete this
								System.out.println(stack.pop());
							}
							else
							{
								System.out.println("Symbol ')' is mismatched");
								mismatch = true;
							}
						}			
						
						if (mismatch)
							break;								
					}
				}
				if (mismatch)
					break; //stop the loop when an imbalance is detected
							System.out.println("next line:");//delete				
			}
			if (!mismatch)
				System.out.println("All Symbols Balanced!");

		
	
	}
}