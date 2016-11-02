import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;

public class SymbolBalance{

   public static void main(String args[]) throws IOException {

      String fileName = new String();

      if (args.length == 0){
         System.out.println("Error: no file to read given on command line");
         System.exit(-1);
      } else {
         fileName = args[0];
      }

      Scanner reader = new Scanner(new FileInputStream(fileName));

      MyStack<Character> stack = new MyStack<Character>();

      // Declaring these variables casted to characters so I don't run into trouble/errors comparing strings to chars
      Character openP = new Character('('); 
      Character openB = new Character('{');
      Character openSB = new Character('[');
      Character closeP = new Character(')'); 
      Character closeB = new Character('}');
      Character closeSB = new Character(']');
      Character slash = new Character('/');
      Character star = new Character('*');
      Character quote = new Character('"');

      Boolean commentIgnore = false;
      Boolean stringIgnore = false;

      while(reader.hasNext()){

         String holder = reader.next();

         for (int i = 0; i < holder.length(); i++){

            /* For detecting comment blocks it's helpful to have a char2 variable of the character ahead
            of char1. This code snippet here makes sure there is a char2 available to assign to the
            variable. */
            Character char1 = new Character(holder.charAt(i));
            if (i < holder.length() - 1){
               Character char2 = new Character(holder.charAt(i+1));
            }

            /* I use this boolean to deal with the unique case of quote symbols being the same symbol
            (open and close symbol) for strings. This boolean allows me to ensure I don't 'process' 
            the single symbol in both my "open symbol" and "close symbol" checks. Because it is in the 
            while loop, it will reset to false in every new token*/
            Boolean processedQuoteAlready = false; 

            /* ----- DEALING WITH OPEN SYMBOLS ----- */

            // Open symbols (parenthesis and brackets)
            if ( (char1.compareTo(openP) == 0) || (char1.compareTo(openB) == 0) || (char1.compareTo(openSB) == 0) ){
               if (stringIgnore || commentIgnore){
                  // inside a comment block or string, do nothing
               } else {
                  stack.myPush(char1);
               }
            };

            // Comment block opening symbols
            if ((char1.compareTo(slash) == 0) && (i < holder.length() - 1)){
               Character char2 = new Character(holder.charAt(i+1));
               if (char2.compareTo(star) == 0){
                  if (stringIgnore || commentIgnore){
                  // if inside a string, do nothing
                  } else {
                     stack.myPush(char1);
                     stack.myPush(char2);
                     commentIgnore = true;
                  }
               }
            }

            // 1st quote

            if (char1.compareTo(quote) == 0){
               if (commentIgnore){
                  // if inside a comment block, do nothing
               } else {
                  if (stringIgnore || commentIgnore){ 
                  /* if this is true, that mean's were already in the string 
                  and looking for a closing quote, so don't do anything here.
                  */
                  } else {
                     stack.myPush(char1);
                     stringIgnore = true; // mark that now inside a string 
                     processedQuoteAlready = true; 
                  }  
               }  
            }
          
         
            /* ----- DEALING WITH CLOSE SYMBOLS ----- */

            // Closed Parenthesis (closeP)
            if ( char1.compareTo(closeP) == 0 ){
               if (stringIgnore || commentIgnore){
                  // if inside a comment block or string, do nothing
               } else {
                  if (stack.size() > 0){
                     if (stack.myPeek().compareTo(openP) == 0){
                     stack.myPop();
                     } else {
                        System.out.println("Error: mismatched symbol " + closeP);
                        System.exit(0);
                     }  
                  } else {
                     System.out.println("Error: imbalanced symbol: " + closeP);
                     System.exit(0);
                  }
               }    
            }
            

            // Closed Bracket (closeB)
            if ( char1.compareTo(closeB) == 0 ){
               if (stringIgnore || commentIgnore){
                  // if inside a comment block or string, do nothing
               } else {
                  if (stack.size() > 0){
                     if (stack.myPeek().compareTo(openB) == 0){
                        stack.myPop();
                     } else {
                        System.out.println("Error: mismatched symbol " + closeB);
                        System.out.println(reader.next());
                        System.out.println(reader.next());
                        System.out.println(stack.myPop());
                        System.out.println(stack.myPop());
                        System.out.println(stack.myPop());
                        System.exit(0);
                     } 
                  } else {
                     System.out.println("Error: imbalanced symbol: " + closeB);
                     System.exit(0);
                  }
               }    
            }
            

            // Closed Square Bracket (closeSB)
            if ( char1.compareTo(closeSB) == 0 ){
               if (stringIgnore || commentIgnore){
                  // if inside a comment block or string, do nothing
               } else {
                  if (stack.size() > 0){
                     if (stack.myPeek().compareTo(openSB) == 0){
                        stack.myPop();
                     } else {
                        System.out.println("Error: mismatched symbol " + closeSB);
                        System.exit(0);
                     } 
                  } else {
                     System.out.println("Error: imbalanced symbol: " + closeSB);
                     System.exit(0);
                  }
               }    
            }

            // Closed comment block

            if ((char1.compareTo(star) == 0) && (i < holder.length() - 1)){
               Character char2 = new Character(holder.charAt(i+1));
               if (char2.compareTo(slash) == 0){
                  if (stringIgnore){
                  // if inside a string, do nothing
                  } else {
                     if (stack.size() > 0){
                       if (stack.myPeek().compareTo(star) == 0){
                        stack.myPop();
                        stack.myPop();
                        commentIgnore = false;
                        } else {
                           System.out.println("Error: unmatched closing comment block: */");
                           System.exit(0);
                        } 
                     } else {
                        System.out.println("Error: imbalanced closing comment block: */");
                        System.exit(0);
                     } 
                  }
               }
            }

            if (char1.compareTo(quote) == 0){
               if (commentIgnore){
                  // if inside a comment block, do nothing
               } else {
                  if (stringIgnore && (!processedQuoteAlready)){ /* (!procsessedQuoteAlready) ensures I'm not treating same quote as both opening and closing symbol.*/
                     if (stack.myPeek().compareTo(quote) == 0){
                        stack.myPop();
                        stringIgnore = false;
                     } else {
                        /* System.out.println("error in close quote check"); // helpful for locating error when debugging */
                     }
                  } else {
                     /* do nothing. Strings are tricky because their opening and closing
                     symbols are the same symbol. The stringIgnore boolean is serving a
                     double purpose here as a differentiator b/w the "opening" quote and
                     the "closing quote." stringIgnore will only ever be true after the 
                     opening quote occurs, so that's how we can keep track of quotes. */
                  } 
               }  
            }

         };
      }; 

      if (stack.size()!=0){
         if (stack.myPeek().compareTo(star) == 0){
            System.out.println("Error: comment block (/*) remains unclosed throughout file.");
            System.exit(0);
         } else {
            if (stack.myPeek().compareTo(quote) == 0){
               System.out.println("Error: quote indicating string (\") remains unclosed throughout the file.");
               System.exit(0);
            } else {
               System.out.println("Error: file ends with unclosed opening symbols. First unmatched symbol: " + stack.myPop());
               System.exit(0);
            }
         }
      } else {
         System.out.println("Checked symbols are properly balanced.");
         System.exit(0); 
      }
   };

}

