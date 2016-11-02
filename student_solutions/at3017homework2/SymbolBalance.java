/**
 * Akbota Toxanbayeva
 * at3017
 */
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SymbolBalance {
    public static boolean balanced =true;
	public static void main(String[] args){
		if (args.length < 1){
    		System.out.println("Usage: java SymbolBalance < fileName >");
    		System.exit(-1);
    		
    	}
		try {
            
    		Path path = FileSystems.getDefault().getPath(args[0]);
    		byte [] encoded  = Files.readAllBytes(path);
    		String  fileData = new String(encoded); 
    		
    		balancedSymbols(fileData);
    		
    		if (!balanced){
    			System.out.println("File is not balanced");
    			//System.out.println(fileData.substring(Math.max(0,balanced - 20),Math.min(fileData.length() - 1, balanced + 20)));
    		}
    		else{
    			System.out.println("File is balanced");
    		}
    		
		}
        catch(Exception e){
        	System.err.format("IOException : %s%n", e);	
        }	
	}
	
	public static void balancedSymbols(String s){
		MyStack<Character> stack = new MyStack<Character>();
		Boolean insideComment = false;
		Boolean insideSingleQuote = false;
		Boolean insideDoubleQuote = false;
		
		char endOfCommentFlag = 0;
		
		for(int i = 0; i< s.length(); i++){
			char c = s.charAt(i);
			//Checking for start comment
			if ( c== '/'){
				char d = s.charAt(i+1);
				if( d == '*'){
					// change state to inside comment
					insideComment = true;
					endOfCommentFlag = '*';
					i++;
					continue;
				}
				else if (d == '/' ){
					// change state to inside comment
					insideComment = true;
					endOfCommentFlag = '\n';
					continue;
				}
			}
			// Windows uses \r\n to endline, but all systems use \n
			// so if we see a \r just ignore it.
			if (c == '\r') continue;
			
			// if we are inside comment ignore other characters 
			if (insideComment){
				//Check for endOfCommentFlag 
				if (c == endOfCommentFlag){
					//Handle multi line comments
					if (endOfCommentFlag == '*'){
						//Do not increment so we do not lose character
						char d = s.charAt(i + 1);
						if( d == '/'){
						    // change state to outside comment
							insideComment = false;
							i++;
							continue;
						}
					}
				    //Handle Single line comment
					else if (endOfCommentFlag == '\n') {
						insideComment = false;
						continue;
					}
				}
		
				continue;
			}
			
			if (c == '\'') {
				insideSingleQuote = !insideSingleQuote;
			}
			if (c == '"') {
				insideDoubleQuote = !insideDoubleQuote;
			}
			
			if (insideDoubleQuote || insideSingleQuote) {
				continue;
			}
						
			if( c == '[' || c == '(' || c == '{'){
				stack.push(c);
				continue;
			}
			
			else if( c== ']'){
				if(stack.isEmpty()) {
					//System.out.println("Symbol Underflow");
					System.out.println("Unexpected ]");
					balanced = false;
					System.out.println(s.substring(Math.max(0,i - 20),Math.min(s.length() - 1, i + 20)));
					//return i;
				}
				
				char d = stack.pop();
				
				if(d != '[') {
					//System.out.printf("Found %c but expected '['\n", d);
					System.out.println("Unexpected ]");
					balanced = false;
					System.out.println(s.substring(Math.max(0,i - 20),Math.min(s.length() - 1, i + 20)));
					//return i;
				}
					
			}
			else if (c == ')'){
				if(stack.isEmpty()) {
					//System.out.println("Symbol Underflow");
					System.out.println("Unexpected )");
					balanced = false;
					
					System.out.println(s.substring(Math.max(0,i - 20),Math.min(s.length() - 1, i + 20)));
					
					//return i;
				}
				
				char d = stack.pop();
				
				if(d !=  '(') {
					//System.out.printf("Found %c but expected '('\n", d);
					System.out.println("Unexpected )");
					System.out.println(s.substring(Math.max(0,i - 20),Math.min(s.length() - 1, i + 20)));
					balanced = false;
					//return i;
				}
			}
			else if (c == '}'){
				if(stack.isEmpty()) {
					//System.out.println("Symbol Underflow");
					System.out.println("Unexpected }");
					System.out.println(s.substring(Math.max(0,i - 20),Math.min(s.length() - 1, i + 20)));
					balanced = false;
					//return i;
				}
				
				char d = stack.pop();
				
				if(d != '{') {
					//System.out.printf("Found %c but expected '{'\n", d);
					System.out.println("Unexpected }");
					System.out.println(s.substring(Math.max(0,i - 20),Math.min(s.length() - 1, i + 20)));
					balanced = false;
					//return i;
				}
		    }	
		}
		
		/*if (stack.isEmpty()) {
			return s.length();
		}*/
		
		
	}

}
