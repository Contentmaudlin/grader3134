///*Yu Zheng
// * yz2978
// * the java file solving problem 1
// */
import java.io.File;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class SymbolBalance {
    public static void main(String [] args) {
    	MyStack<Character> MyStack= new MyStack<>();
		//a variable to store a previous symbol
    	char previous;
    	boolean hasprint=false;
    	File file = new File("Test.java");   //change the file name here
        Reader reader = null;
        //testcomment becomes 1 when we encounter'/*' and back to 0 when we encounter'*/'
        int testcomment=0;
        //teststring change its value when encounters '"'
        boolean teststring=false;
        try {
            // one char at a time
            reader = new InputStreamReader(new FileInputStream(file));
            int temp;
            while ((temp = reader.read()) != -1) {
            	char tempchar=(char) temp;
            	//check if there is a '/*'
            	if (tempchar=='/'){
            		temp=reader.read();
            		tempchar=(char) temp;
            		if (tempchar=='*'){
            			testcomment=1;
            			continue;
            		}
            	}
            	//check if there is a '*/'
            	if (tempchar=='*'){
            		temp=reader.read();
            		tempchar=(char) temp;
            		if (tempchar=='/'){
            			if (testcomment==0){
            				System.out.println("Unbalanced! There should be a '/*' before '*/'");
            				hasprint=true;
            				break;
            			}
            			else{
                			testcomment=0;
                			continue;
            			}
            		}
            	}
            	//check if there is a '"' outside comment blocks
            	if (testcomment==0){
                	if (tempchar== '"'){
                		teststring=!teststring;
                	}
            	}

            	//if characters are not in a comment block or a string,check the balance of brackets
            	if (testcomment==0 & !teststring){
            		if (tempchar=='{' | tempchar=='[' | tempchar=='('){
            			MyStack.push(tempchar);
            		}
            		//check the balance of{}
            		if (tempchar=='}'){
            			if (MyStack.isEmpty()){
            				System.out.println("Unbalanced! there is an extra symbol of "+tempchar);
            				hasprint=true;
            				break;
            			}
            			else{
            				previous=MyStack.pop();
            				if (previous=='{'){
            					continue;
            				}
            				else{
            					System.out.println("Unbalanced! mismatch of "+previous+" and }");
            					hasprint=true;
            					break;
            				}
            			}
            		}
            		//check the balance of[]
               		if (tempchar==']'){
            			if (MyStack.isEmpty()){
            				System.out.println("Unbalanced! there is an extra symbol of "+tempchar);
            				hasprint=true;
            				break;
            			}
            			else{
            				previous=MyStack.pop();
            				if (previous=='['){
            					continue;
            				}
            				else{
            					System.out.println("Unbalanced! mismatch of "+previous+" and ]");
            					hasprint=true;
            					break;
            				}
            			}
            		}
               		//check the balance of()
               		if (tempchar==')'){
            			if (MyStack.isEmpty()){
            				System.out.println("Unbalanced! there is an extra symbol of "+tempchar);
            				hasprint=true;
            				break;
            			}
            			else{
            				previous=MyStack.pop();
            				if (previous=='('){
            					continue;
            				}
            				else{
            					System.out.println("Unbalanced! mismatch of "+previous+" and )");
            					hasprint=true;
            					break;
            				}
            			}
            		}
            	}

            }
            reader.close();
        	 if (testcomment==1 & !hasprint){
 				System.out.println("Unbalanced! There should be a '*/' after '/*'");
 				hasprint=true;
             }
             if (teststring & !hasprint){
 				System.out.println("Unbalanced! '\"' is unmatched");
 				hasprint=true;
             }
             if (!MyStack.isEmpty() &!hasprint){
 				System.out.println("Unbalanced! there is an extra symbol of "+MyStack.pop());
 				hasprint=true;
             }
            
            if (!hasprint){
            	System.out.println("The code is well balanced");
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

