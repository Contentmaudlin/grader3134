//*******************************************************************
//Christian Cruz Godoy
//COMSW 3134: SymbolBalance Class
//This class checks a file to make sure that the characters
//() {} [] " and /* /* are balanced
//*******************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SymbolBalance
{
	
	public static void main(String[] args) throws FileNotFoundException
	{	
		//This scans the file that the user inputs on the command line. After
		//scanning the file it saves the whole file into a string. Since I use
		//a delimeter, I use "YOULLNEVERFIND" as the condition. Since that
		//would probably never occur in a file, it saves the whole file as a string.

		File userInputFile = new File(args[0]);
		Scanner fileScanner = new Scanner(userInputFile);
		String fileCharacters = fileScanner.useDelimiter("YOULLNEVERFIND").next();
		
		//I initialize an empty string so that I can return it later to know
		//specefically which character is unbalanced. I then create an arraylist
		//of the characters I am checking for balance.
		String error = "";
		ArrayList<Character> theKarakters = new ArrayList<Character>();
		MyStack<Character> stack = new MyStack<Character>();
		System.out.println(" I am representing /* and */ by <>! ");
		//This iterates through the string that I saved. It includes the whole file.
		//If the character at the index I am looking at is one of the ones I want to 
		//find I add it to my arraylist.
		for(int i=0; i<fileCharacters.length(); i++)
		{
			char symbol = fileCharacters.charAt(i);
								
			if(symbol=='{' || symbol=='}')
			{
				theKarakters.add(symbol);
			}
				
			if(symbol=='[' || symbol==']')
			{
				theKarakters.add(symbol);
			}
				
			if(symbol=='(' || symbol==')')
			{
				theKarakters.add(symbol);
			}
				
			if(symbol=='"')
			{
				theKarakters.add(symbol);
			}
			
		}
		
		//This one does the same thing as the loop above, but since the comment block
		// */ has two characters I needed to make a seperate loop that would check both
		//the index i am looking at and the index that is right in front of it. It then
		//adds an arbitrary character < or > that represents these comment blocks. 
		for(int m=0; m<fileCharacters.length(); m++)
		{
			if(fileCharacters.charAt(m)=='/' && fileCharacters.charAt(m+1)=='*')
			{
				theKarakters.add('<');
			}
			if(fileCharacters.charAt(m)=='*' && fileCharacters.charAt(m+1)=='/')
			{
				theKarakters.add('>');
			}
		}
			
		
		//I print out the arraylist to show that it did in fact scan the file
		System.out.println(theKarakters);
		
		
		//This loop is a bit more complex. It iterates through the arraylist and 
		//actually checks whether they are balanced.
		for(int i=0; i<theKarakters.size(); i++ )
		{
			char symbol2 = theKarakters.get(i);
			
			//This if statement checks if the character is an opening symbol and then if
			//it satisfies the condition it adds it to the stack that I created. It then
			//sets the string error equal to whatever type of character i added just in case
			//it is not balanced i can return this string.
			if(symbol2=='[' || symbol2=='{' || symbol2=='(' || symbol2=='"' || symbol2=='<')
			{
				stack.add(symbol2);
				error = "" + symbol2;
			}
			
			//These next if statements check that the closing brackets all have an opening 
			//bracket that corresponds to it. If the character is a closing bracket and the
			//stack is empty, it's an error so it prints out an error statement each time
			//this happens so that the user knows how many times it is unbalanced. However
			//if the stack is not empty, it pops the stack and sets a character equal to 
			//the return value of whatever it popped. If then the removed character does 
			//not correspond to its paired bracket, it prints out an error message.
			if(symbol2==']')
			{
				if(stack.empty())
				{
					System.out.println("the characters [] are unbalanced! ");
				}
			
				if(!stack.empty())
				{				
					Character removed = stack.remove();		
					if(removed != '[')
					{
						System.out.println("the characters [] are unbalanced! ");
					}		
				}
			}
			
			if(symbol2=='}')
			{
				if(stack.empty())
				{
					System.out.println("the characters {} are unbalanced! ");
				}
			
				if(!stack.empty())
				{			
					Character removed = stack.remove();
				
					if(removed != '{')
					{
						System.out.println("the characters {} are unbalanced! ");
					}
				}
			}
			
			if(symbol2==')')
			{
				if(stack.empty())
				{
					System.out.println("the characters () are unbalanced! ");
				}
			
				if(!stack.empty())
				{			
					Character removed = stack.remove();		
					if(removed != '(')
					{
						System.out.println("the characters () are unbalanced! ");
					}
				}
			}
		
			if(symbol2=='"')
			{
				if(stack.empty())
				{
					System.out.println("the quotation marks are unbalanced! ");	
				}
			
				if(!stack.empty())
				{				
					Character removed = stack.remove();		
					if(removed != '"')
					{
						System.out.println("the characters quotation marks are unbalanced! ");
					}		
				}
			}
			if(symbol2=='>')
			{
				if(stack.empty())
				{
					System.out.println("the characters /* */ are unbalanced! ");
				}
			
				if(!stack.empty())
				{				
					Character removed = stack.remove();		
					if(removed != '<')
					{
						System.out.println("the characters /* */ are unbalanced! ");
					}		
				}
			}
		}
		
		
			if(!stack.empty() && error == "<")
			{
				System.out.println("the characters /* */ are unbalanced! ");
			}
	        if(!stack.empty())
	        {
					System.out.println(" the characters " + error + " are unbalanced! ");
			}
		
	
	}
}



	


