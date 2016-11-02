import java.io.BufferedReader;
import java.io.FileNotFoundException;//http:stackoverflow.com/questions/23187539/java-balanced-expressions-check
import java.io.FileReader;//http://www.tutorialspoint.com/java/io/bufferedreader_read_char.htm

public class SymbolBalance {
	public static void main(String arg[]) {
		try {
			System.out.println(arg[0]); // print the name of the file you want to check
									
			BufferedReader br = new BufferedReader(new FileReader(arg[0]));
			MyStack<Character> stackp = new MyStack<Character>();
			stackp.push('0');// push a element in case of nothing to peek when empty;
			Character popi;
			char c;
			String thisline;

			while ((thisline = br.readLine()) != null) {   // read each line until the end of the file															
				int index = 0;
							
				while (index < thisline.length()) {        // read each character until the end of the line
					c = (Character) (char) thisline.charAt(index);	//set a variable for the character to store
				 if(stackp.peek()!='*'){// check if the last element on stack is *, if not then check whether the rest of the symbols match					
					 if (c == (Character) '(' || c == (Character) '{'  // push every ( or[ or{ into stack
							|| c == (Character) '[') {
						stackp.push(c);
					} 
					else if (c == ')') { //if encountered a ), pop the last element in stack, if it is not  (, there is an unbalanced error
					  if(stackp.IsEmpty()==true){
						  System.out.println("Error, imbalance of )");
					  }
					  else{
						popi = (Character) stackp.pop();
						if (popi == (Character) '(') {
							System.out.println("match");
						} 
						 else {
							System.out.println("Error, in imbalance of )");
						}
					}} 
					else if (c == ']') { //if encountered a ], pop the last element in stack, if it is not [,there is an unbalanced error
						if(stackp.IsEmpty()==true){
							  System.out.println("Error, imbalance of ]");
						  }
						else{popi = (Character) stackp.pop();
						if (popi == (Character) '[') {
							System.out.println("match");
						} else {
							System.out.println("Error, in imbalance of ]");
						}
					}} 
					else if (c == '}') {                    //if encountered a }, pop the last element in stack, if it is not  {, there is an unbalanced error
						if(stackp.IsEmpty()==true){
							  System.out.println("Error, imbalance of }");
						  }
						else{popi = (Character) stackp.pop();
						if (popi == (Character) '{') {
							System.out.println("match");
						} else {
							System.out.println("Error, in imbalance of }");
						}

					}} 
					else if (c == '"') {                   // if encountered a ", loop until you find another " for the same line, otherwise return an unbalanced error
						index++;
						c = (Character) (char) thisline.charAt(index);
						while (c != (Character) '"'
								&& index < thisline.length()) {
							c = (Character) (char) thisline.charAt(index);
							index++;
						}
						if (index <= thisline.length() && c == (Character) '"') {
							index--;
						} else {
							System.out.println("missing \" ");
							index--;
						}
					}
					
					 else if(c=='/'&&++index<thisline.length()&&(Character) (char) thisline.charAt(index)=='*'){ //if encountered an /*,push them to stack						     
							 stackp.push('/');
							 stackp.push('*');							 
						 }}						 					  
				 else{ 			     
					 if(c=='*'&&index<thisline.length()-1){//if encountered and */, pop them out from the stack						 						 
						 index=index+1;
						 c = (char) thisline.charAt(index);
						 if(c=='/'){
						 stackp.pop();
						 stackp.pop();}
					 }					 
				}
				 index++;}
			}
			if (stackp.IsEmpty()==false) {   // check if anything left in stack, if yes then anything pop() out from the stack is unbalanced 
				while(stackp.peek()!='0'){
				System.out.println( stackp.pop()+ " is unbalanced");				
				}
			}else {
				System.out.println("match");
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("File not found");
		}

	}

}
