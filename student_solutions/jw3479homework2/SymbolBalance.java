import java.io.*;

public class SymbolBalance {
	public static int checkChar(char x){ // 0:left brackets, 1: right brackets, 
										 // 2: normal char
		if(x == '(' || x == '[' || x == '{'){
			return 0;
		}
		if(x == ')' || x == ']' || x == '}'){
			return 1;
		}else{
			return 2;
		}
		
	}
	public static boolean checkMatch (char first, char second){
		if(first == '(' && second == ')'){
			return true;
		}
		if(first == '[' && second == ']'){
			return true;
		}
		if(first == '{' && second == '}'){
			return true;
		}
		return false;
	}

	public static char balanceSymbol(String theFile){
		int length = theFile.length();
		MyStack<Character> theStack = new MyStack<Character>();
		boolean flag = false;// flag to mark literal string 
		boolean markComment = false;
		for (int i = 0; i < length; i++){
			char theChar = theFile.charAt(i);
			
			
			//special case for comments
			if(markComment){
				markComment = false;
				continue;
			}
	
			// closing comment
			if(theChar == '*' && i+1 < length && theFile.charAt(i+1) == '/' && flag == false){
				markComment = true; // ignore the next char
				if(!theStack.isEmpty() && theStack.top() == '/'){
					theStack.pop();
				}else{
					return '*'; // mark unbalance of closing comment
				}
			}
			if(theChar == '/' && i+1 < length && theFile.charAt(i+1) == '*' && flag == false){
				markComment = true;
				theStack.push('/');
			}
			if(!theStack.isEmpty() && theStack.top()=='/'){
				continue;
			}

			//special case for string	
			if (flag == true && theChar == '\n'){	// flag not down after finishing line
				return '\"';
			}
  			if(flag == true && theChar =='\"'){ // check string closing
				flag = false;
			}else if(flag == false && theChar == '\"'){
				flag = true;
			}	
			if(flag == true){	// ignore string literal
				continue;
			}
			
			if(checkChar(theChar) == 0){
				theStack.push(theChar);
			}else if (checkChar(theChar) == 1){
				// case 1, the stack empty, error, return
				if(theStack.isEmpty()){
					return theChar;
				}
				// not empty, first check match
				boolean check = checkMatch(theStack.top(),theChar);
				if(check){
					theStack.pop();
				}else{
					return theStack.pop();
				}
			}
		}
		if(flag == true){	// flag not put down
			return '\"';
		}else if(theStack.isEmpty() == false){
			return theStack.pop();
		}else{
			return 'A'; // pass the test
		}
	}
	
	
	public static void main (String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String theFile = "";
		String line;
		while((line = br.readLine()) != null){
			theFile = theFile + line+ '\n';
		}
		br.close();
		char result = balanceSymbol(theFile);

		if(result == 'A'){
			System.out.println("Balanced!");
		}else if(result == '/'){
			System.out.println("/* mismatched");
		}else if(result == '*'){
			System.out.println("*/ mismatched");
		}else {
			System.out.println(result + " mismatched");
		}
	}
}