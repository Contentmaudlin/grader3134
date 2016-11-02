/********************************************
* Ben Arbib - ba2490
* SybolBalance class checks java files for 
* balanced opening and closing brackets
* as well as opening " and /* using a stack.
* it uses MyStack class as its stack
*********************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SymbolBalance{
	public static void main(String [] args){

		char l = 0;
		MyStack<Character> stack = new MyStack<>();
		boolean flag = true; 	// once there is a problem found 
							 	// a flag will be raised

		try{
			File fileIn = new File(args[0]);
			FileInputStream check = new FileInputStream(fileIn);
				
			// loop run as long as there are still letters in file and
			// as long as the flag hasn't been raised
			while (check.available()>0 && flag){
				l = (char) check.read(); 

				// if the next char is an opening bracket of any king
				// we push it into stack without checking first
				if ( (l=='{' || l=='(' || l=='[') )
					stack.push(l);
				
				/*	
				*  	in the next 3 if statements we compare a closing
				*	bracket to the top of the stack. if they don't
				*	complete eachother we raise a flag to indicate that 
				*	something is missing.
				*/

				// checking for a closing }
				else if (l=='}' ){
					if (stack.peek() == '{'){	
						stack.pop();
					}
					else
						flag = false;
				}
				
				// checking for a closing )
				else if (l==')' ) {
					if (stack.peek() == '(')
						stack.pop();
					else
						flag = false;
				}

				// checking for a closing ]
				else if (l==']' ) {
					if (stack.peek() == '[')
						stack.pop();
					else
						flag = false;
				}

				/*
				* checking for an open ". if a quotation mark comes
				* a loop starts going through the line until 
				* it sees another quotation or it reaches the end
				* of the line. If it reaches the end of the line
				* without finding a qoutation mark it raises a flag. 
				*/
				else if (l=='"' ){
					int c = check.read();
					while ((c != 34 && c != 10) && check.available()>0)
						c=check.read();
					if (c == 10){
						flag = false;
						stack.push('"');
					} 	
				}

				/*
				* checkes to see if the comment input is 
				* balanced. if it finds a /* it runs a loop 
				* until it finds a closing comment.
				* if no closing comment was found it raises a flag
				*/
				else if (l=='/' ){
					l = (char) check.read();
					if (l == '*'){
						boolean comm = false;
						while (!comm && check.available()>0){
							l = (char) check.read();
							while (l == '*'){
								l = (char) check.read();
								if (l == '/') comm = true;
							}
						}
						if (!comm) {
							flag = false;
							stack.push('*');
						}
					}
				}
			}
			/*
			* output message - if a flag was raised it
			* outputs the last element in the stack and 
			* indicates it is the unbalanced element
			*/
			if (stack.isEmpty() ) 
					System.out.println("You're Good!");
			
			else{
				System.out.println("Not Good!");
				char t = stack.pop();
				if (t=='*') System.out.println("Unbalaced */");
				else System.out.println("Unbalanced "+l);
			} 
		}

		catch (FileNotFoundException e){
			System.out.println("File "+args[0]+" Was Not Found");
		}

		catch (ArrayIndexOutOfBoundsException c){
			System.out.println("Something is wrong"  
				+"- Array Index Out Of Bounds");
		}

		catch (IndexOutOfBoundsException c){
			System.out.println("Index out of bound!");
		}

		catch (NullPointerException e){
			System.out.println("Not Good!");
			System.out.println("Unbalanced "+l);
		}

		catch (Exception e){
			System.out.println("Something is wrong - please try again");
		}
	}
}
