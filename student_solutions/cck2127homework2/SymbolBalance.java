import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SymbolBalance {

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner s = new Scanner(System.in);
		File inputFile = new File(args[0]);
		Scanner in = new Scanner(inputFile);
		
		MyStack<Character> stack = new MyStack<Character>();
		
		while(in.hasNext()){
			
			String x = in.next();
				
				for(int i = 0; i < x.length(); i++){
					
					char y = x.charAt(i);
					
					if(y == '/' && i + 1 < x.length()) {
						
						if(x.charAt(i+1) == '*'){
							
							stack.push(y);
							System.out.println("pushing /");
							stack.push(x.charAt(i+1));
							System.out.println("pushing *");
							
							i++;
						}
						
					}
					
					if(y == '*' && i + 1 < x.length()){
						
						if(x.charAt(i+1) == '/'){
							
							char t = stack.pop();
							System.out.println("popping *");
							
							if(t == '*'){
								
								stack.pop();
								System.out.println("popping /");
								
							}
							else{
								System.out.println("Unbalanced! Symbol */ is mismatched");
							return;
							
							}
						}
						
					}
					
					if(y == '{' || y ==  '(' || y == '['){
						
						stack.push(y);
						
					}
					if(y == '}' || y ==  ')' || y == ']'){
						
						char t = stack.peak();
						
						if(t == '{' && y == '}' || t == '(' && y ==')'
								|| t == '[' && y == ']'){
							
							stack.pop();
							
						}
						else{
							
							System.out.print("Unbalanced! Symbol " + y + " is mismatched");
							return;
						}
						
					}
				
				
					
				}
			
			
		}
		
		if(stack.isEmpty()){
			
			System.out.println("Balanced!!");
			
		}
		else{ 
			
			System.out.println("There are unbalanced symbols!");
			
		}
		
	}
	
	
}
