import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SymbolBalance {

	public static void main(String[] args) throws FileNotFoundException{
		 
		//create file input from command line
		File inFile = null;
		if (args.length > 0){
			inFile = new File(args[0]);
		}

		Scanner scn = new Scanner(inFile);
		String file = scn.useDelimiter("\\Z").next();
		
		String balance = checkBalance(file);
		System.out.println(balance);
	}
	
	//checks if the characters are balanced
	private static String checkBalance(String str){
		
		String s = str;
		
		MyStack<Character> stack = new MyStack<Character>();
		
		//iterate through every character in s
		int i = 0;

		while (i < s.length()){
			
			char c = s.charAt(i);
	
			
			//if /* is found
			if (i < s.length() - 3 && c == '/' && s.charAt(i+1) == '*'){		
				i = blockFound(i,s);
			}
			
			//String literal detected
			else if (c == '"'){	
				i = quoteFound(i,s);
			}
			
			//if c is a starting brace
			else if (c == '{' || c == '[' || c == '(' ){	
				stack.push(c);
				i++;
			}
			
			else if (c == '}' || c == ']' || c == ')' ){
				if (stack.isEmpty() || stack.peek() != c){
					return ("Unbalanced! Symbol " + c + " is mismatched");
				}
				else{
					stack.pop();
					i++;
				}			
			}
					
			//if c is none of these characters
			else{
				i++;
			}		
		}
		
		//if after iterating through the file characters, the stack is empty,
		//the file is balanced
		if (stack.isEmpty()){
			return "Balanced!";
		}
		else{
			char b = stack.peek();
			return ("Unbalanced! Symbol " + b + " is mismatched");
		}
	}
	
	//if beginning block comment is found
	private static int blockFound(int i, String s){
		
		//iterate through until closing */ found
		while (i + 3 < s.length() && 
			(s.charAt(i+2) != '*' || s.charAt(i+3) != '/')){
			i++;
		}
		
		//if no */ if found until the end, /* is mismatched
		if (i + 3 >= s.length()){
			System.out.println("Unbalanced! Symbol /* is mismatched"); 
			System.exit(0);
		}
		
		//if */ is found, continue iterating through remaining chars
		if (s.charAt(i+2) == '*' && s.charAt(i+3) == '/'){
			i += 4;
		}
		return i;
	}
	
	//if quote beginning is found
	private static int quoteFound(int i, String s){
		
		//iterate through until closing " found
		while (i+1 < s.length() && s.charAt(i+1) != '"' && s.charAt(i) != '\n'){
			i++;
			
			if (s.charAt(i) == '\n'){
				i++;
				}
		}
		
		//if no closing " found until the end, " is mismatched
		//" cannot be over 2 lines
		if (i + 1 >= s.length() || s.charAt(i) == '\n'){
			System.out.println("Unbalanced! Symbol \" is mismatched");
			System.exit(0);
		}
		
		//if " is found, continue iterating through remaining chars
		if (s.charAt(i+1) == '"'){
			i += 2;
		}
		return i;
	}
	
}
