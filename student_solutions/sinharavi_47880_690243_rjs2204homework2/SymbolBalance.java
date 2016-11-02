//rjs2204, Ravi Sinha

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SymbolBalance {


	  public static void main(String[] args) {

		    // Takes in the first command line argument
		    String filename = args[0];

		  //the buffered reader reads each string line from the txt file
	    try {
	      BufferedReader reader = new BufferedReader(new FileReader(filename));
	      String line;
              String entireText = "";

	    //while the file has lines, take each line into a string
	      while ((line = reader.readLine()) != null) {
                entireText += line + "\r\n";	        
	      }
              reader.close();

                // Call isBalanced() to determine if the program is balanced
                String c = isBalanced(entireText);
	        if (c.length()!=0) {
                  System.out.println("Unbalanced! Symbol " + c + " is mismatched");

                } else
  	          System.out.println(String.format("%s is a balanced", filename+" file"));
	      
	      
	    } catch (FileNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }


        public static String isBalanced(String line) {

            MyStack<Character> stack = new MyStack<Character>();

            boolean quoted = false;
            boolean commented = false;
        
            //check if is empty 
            if (line.length()>0) {
                for(int i=0; i<line.length(); i++) {

   	           //method boolean for */, "", as we want to ignore anything that comes between comments
                   if (!commented && line.charAt(i)=='\"')
                        quoted = !quoted;

                   if (i<line.length()-1) {
                       if (!quoted && line.charAt(i)=='/' && line.charAt(i+1)=='*')
                           commented = true;

                       if (!quoted && line.charAt(i)=='*' && line.charAt(i+1)=='/')
                            commented = false;
                   }

    	           //if open symbol 
                   if (!quoted && !commented && isOpenSymbol(line, i)) {
                       //
      	               //push open
                       stack.push(line.charAt(i));           
                   }
                   else if (!quoted && !commented && isClosedSymbol(line, i)) {
                       if (stack.isEmpty()) 
                            return "" + line.charAt(i);
                       //pop closed
                       char c = stack.pop();
                       if ((c=='(' && line.charAt(i)!=')') || (c=='[' && line.charAt(i)!=']') || (c=='{' && line.charAt(i)!='}')) 
                           return "" + line.charAt(i);
                   }	
	        //
               }
            }
            if (quoted)
                return "\"";
            if (commented)
               return "/*";

            if (!stack.isEmpty())
                return "" + stack.pop();
            else
                return "";
        }

	
        //method for knowing if closed symbols
        public static boolean isOpenSymbol(String line, int index){
            char c = line.charAt(index);
            return c=='[' || c=='{' || c=='(';
        }

        //method for open symbols	
        public static boolean isClosedSymbol(String line, int index){
            char c = line.charAt(index);
            return c==']' || c=='}' || c==')';
        }	

}

	    
	  
				