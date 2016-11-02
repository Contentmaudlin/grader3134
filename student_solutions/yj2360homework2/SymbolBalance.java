import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;



public class SymbolBalance {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Input File Name:");
		String fileName = in.next();
		Scanner file = new Scanner (new File(fileName));
		
		String theString = file.nextLine();
		while (file.hasNextLine())   {
			theString = theString + "\n" + file.nextLine();

		}
		

		char[] target = {'\"','/','*','[',']','(',')','{','}'};
		char[] target1 = {'\"','/','*'};
		ArrayList<Character> result = new ArrayList<Character>();
		
		
		MyStack<Character> stack1 = new MyStack<Character>();
		
	
		char[] charArray = theString.toCharArray();
		System.out.println(charArray);
		
		for (int i = 0; i < charArray.length;i++){
			for(int j = 0;j < target.length;j++){
				if (charArray[i]==target[j]) {
					result.add(charArray[i]);
				}
			}
		}

		
		
		int i = 0;
		int action = 0;
		while (i < result.size()){
			if (action !=0){
				if(action == 1 & result.get(i)==target1[0]){
					action = 0;
					i++;
				}
				else if(action==2 && result.get(i)==target1[2] && result.get(i+1)==target1[1]){
					action = 0;
					i=i+2;
				}
				result.remove(i);
			}
			else{
				if(result.get(i)==target1[0]){
					action = 1;
					result.remove(i+1);
					i++;
				}
				else if(result.get(i)==target1[1] && result.get(i+1)==target1[2]){
					action = 2;
					result.remove(i+2);
					i=i+2;
				}
				else i++;
			}
		}

		System.out.println(result);
		for(int k = 0; k < result.size(); k++) {
            char c = result.get(k);
            if(c == '[' || c == '(' || c == '{'|| c == '\"' ) {
                stack1.push(c);
                System.out.println(c);
            }else if(c == ']') {
                if(stack1.isEmpty()) {
                	System.out.println("Unbalanced! Symbol"+ c +"is mismatched");
                	break;
                }
                if(stack1.pop() != '[') {
                	System.out.println("Unbalanced! Symbol"+ c +"is mismatched");
                	break;
            	}

            }else if(c == ')') {
                if(stack1.isEmpty()) {
                	System.out.println("Unbalanced! Symbol"+ c +"is mismatched");
                	break;
            	}
                if(stack1.pop() != '(') {
                	System.out.println("Unbalanced! Symbol"+ c +"is mismatched");
                	break;
            	}

            }else if(c == '}') {
                if(stack1.isEmpty()) {
                	System.out.println("Unbalanced! Symbol"+ c +"is mismatched");
                	break;
            	}
                if(stack1.pop() != '{') {
                	System.out.println("Unbalanced! Symbol"+ c +"is mismatched");
                	break;
            	}
            }

        }

        if(!stack1.isEmpty()) {
                	System.out.println("Unbalanced! Symbol"+ stack1.pop() +"is mismatched");
    
        }
	        
		
		
	}
}
