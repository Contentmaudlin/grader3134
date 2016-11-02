/*********************
Sunand Iyer
sri2117
This is a file for 
checking if an input
file is balanced in 
terms of {,(,[, ", and 
comments.
**********************/

import java.util.Scanner; 
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SymbolBalance{
	public static void main(String[] args){
		
        try{
		  
            //read in files
			String fileName = args[0];
			File inFile = new File(fileName);
        	Scanner input = new Scanner(inFile);
        	String line = null;
           //create the stack
        	MyStack<Character> x = new MyStack<Character>();
            //initialize variables that will be used
        	char popped;
        	boolean matched = true;
        	char peek;
        	boolean inComment = false;
            boolean inQuotes = false;
            //int doubleSlash = 0;

            //read through each line
        	while(input.hasNext()){

            	line = input.nextLine();
                //iterate through all characters in line
            	for (int i = 0; i < line.length(); i++){
            		

                    char curr = line.charAt(i);
            		//System.out.println(curr);

                    if (i < line.length() - 1){
            			//see if I hit a comment
            			String checkComment = line.substring(i, i+2);
                       // System.out.println(checkComment);
            			if (checkComment.equals("/*")){
            				
                            inComment = true;
                            
            				
            		    } else if (checkComment.equals("*/") && inComment){
            				
                            if (i > 0 && !(line.charAt(i-1) == '/')){

                                inComment = false;
                                
                            } else if (i == 0){

                                //leaving part in comment
                                inComment = false;

                            }
                            
            				
            			} else if (checkComment.equals("*/") && !inComment){

                            System.out.println("*/ matched with no /*");
                            matched = false;
                        }
            		}
                    //see if I hit a quote
                    if (curr == '\"' && !inQuotes && !inComment){

                        inQuotes = true;

                    } else if (curr == '\"' && inQuotes && !inComment){

                        inQuotes = false;
                    }
                    
                    //alert while loop that not in quote or comment
                    //and still matched
            		if (!inComment && !inQuotes && matched){
                        //System.out.println(x.stack);
                        //System.out.println(curr);
                        //look at character to see what it is
            			switch (curr){
            				case '{': x.push('{');
            					break;
            				case '(': x.push('(');
            					break;
            				case '[': x.push('[');
            					break;
            				//testing } case
            				case '}': 
            					if (x.isEmpty()){
            						System.out.println("Unbalanced! Symbol }" +
                                    " with no {");
            						matched = false;
            						break;
            					} else {
	            					popped = x.pop();
	            					if (popped != '{'){
	            						matched = false;
	            						System.out.println("Unbalanced! Symbol "
                                        + popped + " is mismatched");
	            						
	            						break;
	            					}
	            					break;
	            				}
                            //testing ) case
            				case ')': 
								if (x.isEmpty()){
            						System.out.println("Unbalanced! Symbol )" +
                                    "with no (");
            						matched = false;
            						break;
            					} else {
	            					popped = x.pop();
	            					if (popped != '('){

	            						matched = false;
	            						System.out.println("Unbalanced! Symbol "
                                        + popped + " is mismatched");
	            						
	            						break;
	            					}
	            					break;
	            				}
                            //testing ] case
            				case ']': 
            					if (x.isEmpty()){
            						System.out.println("Unbalanced! Symbol ]" + 
                                    " with no [");
            						matched = false;
            					} else {
	            					popped = x.pop();
	            					if (popped != '['){
	            						matched = false;
	            						System.out.println("Unbalanced! Symbol "
                                        + popped + " is mismatched");
                                        
	            						break;
	            					}
	            					break;
	            				}
	            			 
            					
            			}
                        
            			
            		}
            		
                    //doubleSlash += 1;
            	}


            }


            
            if (inQuotes && matched){

                System.out.println("\" not matched");

            } else if (inComment && matched){

                System.out.println("/* not matched");

            } else if (x.isEmpty() && matched){

                System.out.println("Balanced");

            } else if (!x.isEmpty() && matched){

                System.out.println(x.pop() + " is not matched");
            }

            
            
            	
              
        	

		}catch(FileNotFoundException e){
				System.out.println("File not found");
			}catch(ArrayIndexOutOfBoundsException e){
	       		System.out.println("Please enter 1 file to test");
	       	}	


	}
}

