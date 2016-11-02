/*
 * Shaquan Nelson
 * sdn2115
 * 
 * This class works as it is supposed to.
 *  
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SymbolBalance{
	
	private MyStack<String> list;
	private BufferedReader reader;
	
	//need a reader to read the file
	public SymbolBalance(String args) throws IOException{
		list = new MyStack<String>();
		try{
			reader = new BufferedReader(new FileReader(args));
		}  catch(IOException exception){
			throw new IOException(exception);
		}
		finally{
			//do nothing...just needed a finally statement
		}
		}
	
	
	public void checkBalance() throws IOException{
		String line;
		//isBalanced will be used to check if the file was completely balanced by the end of the file
		boolean isBalanced = true;
		//this while loop will check each character in the test file
		while( (line = reader.readLine()) != null){
			for( char character : line.toCharArray()){
				String x; 
				int quotations = 0;
				boolean commented = false;
				if( character == '(' || character == '{' || character == '['|| character == '"'){
					//this handles the special case for quotation marks.
					if(character == '"'){
						commented = true;
						quotations++;
						if( quotations % 2 == 0){
							x = list.pop();
							if( !x.equals("\"")){
								System.out.println( " \nUnbalanced! Symbol " + x + " is mismatched");
								isBalanced = false;
							}
							else
								commented = false;
						}
					}
					else if( commented == false)
						list.push( (String.valueOf(character)));
				}
				else if(character == '/' && character++ == '*'){
					commented = true;
					list.push( "/*");
					
				}
				else if( character == ')' && commented == false ){
					x = list.pop();
					if( !x.equals("(") ){
						System.out.println( " \nUnbalanced! Symbol " + x + " is  mismatched");
						isBalanced = false;
					}
				}
				else if( character == '}' && commented == false){
					x = list.pop();
					if( !x.equals("{")){
						System.out.println( " \nUnbalanced! Symbol " + x + " is mismatched");
						isBalanced = false;
					}
				}
				else if(character == ']' && commented == false){
					x = list.pop();
					if( !x.equals("[")){
						System.out.println( " \nUnbalanced! Symbol " + x + " is  mismatched");
						isBalanced = false;
					}
				}
				else if(character == '*'){
					character++;
					if(character == '/'){
						x = list.pop();
						if(!x.equals("/*")){
							System.out.println( "\nUnbalanced! Symbol " + x + " is mismatched");
							isBalanced = false;
						}
						else
							commented = false;
					}	
				}
			}			
			}

		if(isBalanced){
			System.out.println("System is balanced.");
		}
	}


public static void main(String[] args) throws IOException {
	
	String arg = args[0];
	SymbolBalance tester = new SymbolBalance(arg);
	tester.checkBalance();
	
	}
}



